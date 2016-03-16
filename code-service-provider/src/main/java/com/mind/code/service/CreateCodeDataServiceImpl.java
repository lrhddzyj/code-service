package com.mind.code.service;

import com.mind.code.entity.TCodeData;
import org.hashids.Hashids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lrh on 2015/12/30.
 */
@Service
@Configurable
@EnableScheduling
public class CreateCodeDataServiceImpl {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private static final String MIND_SALT = "SZ MIND-MEDIA";

    private static final Hashids hashids = new Hashids(MIND_SALT, 8);

    private static final long BASE_NUM = 12000000;

    private static final long CREATE_NUM_EVERY_TIME = 1000000;

    private static Logger logger = LoggerFactory.getLogger(CreateCodeDataServiceImpl.class);


    @Autowired
    MongoTemplate mongoTemplate;

    public void createCode(long startIndex, long length) {

        List<TCodeData> dataList = new ArrayList<TCodeData>();

        for (long i = 1; i <= length; i++) {
            long num = ++startIndex;
            String encode = hashids.encode(num);
            dataList.add(new TCodeData(encode));
        }
        mongoTemplate.insertAll(dataList);
    }

    @Scheduled(fixedDelay = 1000 * 60 * 30)
    public void reportCurrentTime() {
        logger.info("#########启动生成code数据任务##############");
        long count = mongoTemplate.count(null, TCodeData.class);
        long balance = BASE_NUM - count;
        long _k = 0;
        if (balance > 0) {
            Boolean hasKey = stringRedisTemplate.hasKey("t_code_index");

            BoundValueOperations<String, String> t_code_index = stringRedisTemplate.boundValueOps("t_code_index");
            Long index = 0l;
            if (hasKey) {
                index = Long.parseLong(t_code_index.get());
            }
            _k = balance;
            logger.info("本次生成的序号从 {} 开始,需要生成 {} 条数据", index,balance);
            long start = System.currentTimeMillis();
            logger.info("开始时间={}", start);
            do {
                if (_k > CREATE_NUM_EVERY_TIME) {
                    createCode(index, CREATE_NUM_EVERY_TIME);
                    _k = _k - CREATE_NUM_EVERY_TIME;
                } else {
                    createCode(index, _k);
                    _k = 0;
                }
            } while (_k > 0);
            index = index + balance;
            t_code_index.set(index.toString());
            long end = System.currentTimeMillis();
            logger.info("结束时间={}", end);
            long consume_time = end - start;
            logger.info("本次生码完成，耗时{}ms", consume_time);
        }

        logger.info("#########生成code数据任务结束##############");

    }


}

package com.mind.code.service;


import com.mind.code.entity.TCode;
import com.mind.code.entity.TCodeData;
import com.mind.code.utils.BeanMapper;
import com.mind.code.vo.TCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiJian on 2015/12/23.
 */
@Service
public class CodeServiceImpl  implements CodeService{


    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BeanMapper beanMapper;

    @Override
    public String getOneTCode() {
        TCodeData one = mongoTemplate.findAndRemove(new Query().limit(1), TCodeData.class);
        String result = one.getCodeData();
        return result;
    }

    @Override
    public List<String> getTCodes(int size) {

        List<String> result = new ArrayList<String>();
        List<TCodeData> codeDatas = mongoTemplate.findAllAndRemove(new Query().limit(size), TCodeData.class);
        for (int i = 0; i < codeDatas.size(); i++) {
            TCodeData codeData = codeDatas.get(i);
            result.add(codeData.getCodeData());
        }
        return result;
    }

    @Override
    public String getOneTCode(TCodeBuilder tCodeBuilder) {
        TCodeData one = mongoTemplate.findAndRemove(new Query().limit(1), TCodeData.class);
        String result = one.getCodeData();
        TCode code = beanMapper.map(tCodeBuilder, TCode.class);
        code.setStatus(1);
        code.setCodeData(result);
        mongoTemplate.insert(code);
        return result;
    }

    @Override
    public List<String> getTCodes(TCodeBuilder tCodeBuilder) {
        List<String> result = new ArrayList<String>();
        List<TCodeData> codeDatas = mongoTemplate.findAllAndRemove(new Query().limit(tCodeBuilder.getCount()), TCodeData.class);
        List<TCode> codes = new ArrayList<TCode>();
        for (int i = 0; i < codeDatas.size(); i++) {
            String  codeData = codeDatas.get(i).getCodeData();
            result.add(codeData);
            TCode code = beanMapper.map(tCodeBuilder, TCode.class);
            code.setStatus(1);
            code.setCodeData(codeData);
            codes.add(code);
        }
        mongoTemplate.insertAll(codes);
        return result;
    }
}

import com.mind.code.Application;

import com.mind.code.service.CodeServiceImpl;
import com.mind.code.service.CreateCodeDataServiceImpl;

import com.mind.code.vo.TCodeBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestSpring {


    @Autowired
    private CodeServiceImpl codeService;

    @Autowired
    private CreateCodeDataServiceImpl createCodeDataService;



    @Test
    public void test() {

//
        long s = System.currentTimeMillis();
        createCodeDataService.createCode(1L,1000000);
        long e = System.currentTimeMillis();
        System.out.println("#########################");
        long h = e - s;
        System.out.println("耗时"+ h +"ms");
        System.out.println("#########################");

//        System.out.println(codeService.getOneTCode());
//       List<String> tCodes = codeService.getTCodes(50000);
//        long e = System.currentTimeMillis();
//        long h = e - s;
//        System.out.println();
//        System.out.println("耗时"+ h +"ms");
//        System.out.println("#########################");
//        System.out.println(tCodes.size());
//        System.out.println("#########################");
//        System.out.println(codeService.getOneTCode());

//        TCodeBuilder tCodeBuilder = new TCodeBuilder();
//        tCodeBuilder.setAppCode("HD");
//        tCodeBuilder.setBusinessKey("ABCDE");
//        tCodeBuilder.setBusinessType("REDPACK");
//        tCodeBuilder.setCompanyId("123");
//        tCodeBuilder.setCount(1000);
//        tCodeBuilder.setNotifyUrl("http://www.baidu.com");
//        tCodeBuilder.setStartTime(new Date());
//        tCodeBuilder.setEndTime(new Date());
      //  String oneTCode = codeService.getOneTCode(tCodeBuilder);

//
//        List<String> tCodes = codeService.getTCodes(tCodeBuilder);
//
//        long e = System.currentTimeMillis();
//        long h = e - s;
//        System.out.println();
//        System.out.println("耗时"+ h +"ms");
//        System.out.println("#########################");
//        System.out.println(tCodes.size());
//        System.out.println("#########################");

    }




}


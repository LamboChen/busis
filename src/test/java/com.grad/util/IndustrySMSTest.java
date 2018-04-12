package com.grad.util;

import com.grad.vo.SmsVo;
import org.junit.Test;

/**
 * @program: busis
 * @description: 短信验证码类测试类
 * @author: Mr.Chen
 * @create: 2018-04-12 15:21
 **/
public class IndustrySMSTest {


    @Test
    public void testExecute() throws Exception{

        SmsVo smsVo = IndustrySMS.execute("13008142306");

        System.out.println("smsContent:" + smsVo.getStatusCode());
    }

}

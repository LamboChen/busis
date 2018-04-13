package com.grad.util;

import com.grad.util.sms.Config;
import com.grad.util.sms.HttpUtil;
import com.grad.vo.SmsVo;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
//	private static String to = "13008142306";
	private static String smsContentHead = "【西华公交信息系统】您的验证码为";
	private static String smsContentTail = "，请于2分钟内正确输入，如非本人操作，请忽略此短信。";

	/**
	 * 验证码通知短信
	 */
	public static SmsVo execute(String to)
	{
		String resultSms = "";
		String smsContent = "";
		SmsVo smsVo = new SmsVo();

		smsContent = smsContentHead;

		for (int i=0;i<6;i++){
			String temp = "" + (int)(Math.random() * 10);
			smsContent += temp;
			resultSms += temp;
		}

		smsContent += smsContentTail;

		//设置短信验证码
		smsVo.setVerificationCode(resultSms);

		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);

	    //需要在此处解析result字符串，得到状态返回码
//		Gson gson = new Gson();
//		MiaoDiReturn miaoDiReturn = gson.fromJson(result,MiaoDiReturn.class);

//		smsVo.setMiaoDiReturn(miaoDiReturn);

	    //设置状态返回码
//	    smsVo.setStatusCode(miaoDiReturn.getRespCode());

	    return smsVo;
	}
}

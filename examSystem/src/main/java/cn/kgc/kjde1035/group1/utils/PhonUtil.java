package cn.kgc.kjde1035.group1.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.zhenzi.sms.ZhenziSmsClient;

public class PhonUtil {
	
	
  public static String getphon(String pho){
	  ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "110214", "f1821afe-a875-4c09-864d-3dbec9a4bad8");
	  Map<String, Object> params = new HashMap<String, Object>();
	   params.put("number",pho);
	   params.put("templateId", "7076");
	   String[] templateParams = new String[2];
	   String ra= getRond();
	   templateParams[0] =ra ;
	   templateParams[1] = "5∑÷÷”";
	   params.put("templateParams", templateParams);
	   try {
		String result = client.send(params);
		System.out.println(result);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return ra;
  }
  public static String getRond() {
	   
	  Random rd=new Random();
	  int dom=rd.nextInt(9999);
	  
	  return dom+"";
  }

  

  
  
}

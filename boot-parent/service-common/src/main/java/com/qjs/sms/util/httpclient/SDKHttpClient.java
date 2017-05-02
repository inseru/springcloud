//package com.qjs.sms.util.httpclient;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.qjs.sms.util.bean.Mo;
//import com.qjs.sms.util.bean.StatusReport;
//
//
//
//
//public class SDKHttpClient {
//	static Logger logger =LoggerFactory.getLogger(SDKHttpClient.class);
//	public static String softwareSerialNo = "9SDK-EMY-0229-JCSQK";// 软件序列号,请通过亿美销售人员获取
//	public static String key = "632786";// 序列号首次激活时自己设定
//	public static String password = "632786";// 密码,请通过亿美销售人员获取
//	public static String baseUrl = "http://sdk229ws.eucp.b2m.cn:8080/sdkproxy/";
//	public static String sendMethod = "post";// 发送请求方式get / post
//	// 注册、注销
//	public static String registAndLogout(String url, String param) {
//		String ret = "失败";
//		url = url + "?" + param;
//		System.out.println("【SDKHttpClient】发送请求到SDK->" + url);
//		String responseString = HttpClientUtil.getInstance().doGetRequest(url);
//		responseString = responseString.trim();
//		if (null != responseString && !"".equals(responseString)) {
//			ret = xmlResponseForRegist(responseString);
//		}
//		return ret;
//	}
//
//	// 解析注册注销响应
//	public static String xmlResponseForRegist(String response) {
//		String result = "失败";
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(response);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//		Element root = document.getRootElement();
//		result = root.elementText("error");
//		return result;
//	}
//
//	// 获取mo
//	public static List<Mo> getMos(String url, String sn, String key) {
//		List<Mo> _Mos = new ArrayList<Mo>();
//
//		if ("".equals(url)) {
//			return _Mos;
//		}
//		String param = "cdkey=" + sn + "&password=" + key;
//		url = url + "?" + param;
//		System.out.println("【SDKHttpClient】Request-Url:" + url);
//		HttpClientUtil.getInstance();
//		String responseString = HttpClientUtil.getInstance().doGetRequest(url);
//
//		responseString = responseString.trim();
//		if (null != responseString && !"".equals(responseString)) {
//			List<Element> elements = xmlDoc(responseString);
//			for (Element element : elements) {
//				if (null != element) {
//					logger.debug("【SDKHttpClient】上行请求->" + responseString);
//					Mo mo = new Mo();
//					mo.setMobileNumber(element.elementText("srctermid"));
//					mo.setSmsContent(element.elementText("msgcontent"));
//					mo.setAddSerial(element.elementText("addSerial"));
//					mo.setAddSerialRev(element.elementText("addSerialRev"));
//					mo.setSentTime(element.elementText("sendTime"));
//					_Mos.add(mo);
//				}
//			}
//		}
//		return _Mos;
//	}
//
//	// 获取report
//	public static List<StatusReport> getReports(String url, String sn, String key) {
//		List<StatusReport> _Reports = new ArrayList<StatusReport>();
//		if ("".equals(url)) {
//			return _Reports;
//		}
//		String param = "cdkey=" + sn + "&password=" + key;
//		url = url + "?" + param;
//		logger.debug("【SDKHttpClient】Request-Url:" + url);
//		String responseString = HttpClientUtil.getInstance().doGetRequest(url);
//		responseString = responseString.trim();
//		if (null != responseString && !"".equals(responseString)) {
//			List<Element> elements = xmlDoc(responseString);
//			for (Element element : elements) {
//				if (null != element) {
//					logger.debug("【SDKHttpClient】REPORT->" + element.elementText("seqid"));
//					StatusReport report = new StatusReport();
//					report.setMobile(element.elementText("srctermid"));
//					report.setErrorCode(element.elementText("state"));
//					report.setSeqID(Long.parseLong(element.elementText("seqid")));
//					report.setReceiveDate(element.elementText("receiveDate"));
//					report.setSubmitDate(element.elementText("submitDate"));
//					report.setServiceCodeAdd(element.elementText("addSerialRev"));
//					System.out.println("收到一条报告：手机号码=" + report.getMobile() + "|消息id=" + report.getSeqID() + "|状态=" + report.getErrorCode() + "|报告时间=" + report.getReceiveDate());
//					_Reports.add(report);
//				}
//			}
//
//		}
//		return _Reports;
//	}
//
//	// 下发
//	public static String sendSMS(String url, String param) {
//		String ret = "";
//		url = url + "?" + param;
//		System.out.println("【SDKHttpClient】发送MT到SDK->" + url);
//		String responseString = HttpClientUtil.getInstance().doGetRequest(url);
//		responseString = responseString.trim();
//		if (null != responseString && !"".equals(responseString)) {
//			ret = xmlMt(responseString);
//		}
//		return ret;
//	}
//
//	// 下发Post
//	public static String sendSMSByPost(String url, String param) {
//		String ret = "";
//		url = url + "?" + param;
//		System.out.println("【SDKHttpClient】发送MT到SDK By Post->" + url);
//		String responseString = HttpClientUtil.getInstance().doPostRequest(url);
//		responseString = responseString.trim();
//		if (null != responseString && !"".equals(responseString)) {
//			ret = xmlMt(responseString);
//		}
//		return ret;
//	}
//
//	// 获取余额
//	public static String getBalance(String url, String param) {
//		String ret = "失败";
//		url = url + "?" + param;
//		logger.info("【SDKHttpClient】Balance->" + url);
//		System.out.println(url);
//		String responseString = HttpClientUtil.getInstance().doGetRequest(url);
//		responseString = responseString.trim();
//		if (null != responseString && !"".equals(responseString)) {
//			ret = xmlResponse(responseString);
//		}
//		return ret;
//	}
//
//	// 统一解析格式
//	public static String xmlResponse(String response) {
//		String result = "失败";
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(response);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//		Element root = document.getRootElement();
//		result = root.elementText("message");
//		return result;
//	}
//
//	// 解析状态、上行
//	private static List<Element> xmlDoc(String response) {
//		boolean result = false;
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(response);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//			return null;
//		}
//		Element root = document.getRootElement();
//		List<Element> list = root.elements();
//		List<Element> elemets = new ArrayList();
//		// 增强for循环来遍历所有的U8ArrivalVouch节点
//		for (Element element : list) {
//			String message = element.getName();
//			if ("message".equalsIgnoreCase(message)) {
//				if (element.elements().size() > 0) {
//					// System.out.println("--------------------"+element.elements().size());
//					elemets.add(element);
//				}
//			}
//
//		}
//		return elemets;
//	}
//
//	// 解析下发response
//	public static String xmlMt(String response) {
//		String result = "0";
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(response);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//			result = "-250";
//		}
//		Element root = document.getRootElement();
//		result = root.elementText("error");
//		if (null == result || "".equals(result)) {
//			result = "-250";
//		}
//		return result;
//	}
//	
//	public static int sendSMS(String[] mobiles, String smsContent) {		
//		Properties p = GetProperties.getProperties("/config.properties");
//		baseUrl = p.getProperty("baseUrl") != null ? p.getProperty("baseUrl") : baseUrl;
//		softwareSerialNo = p.getProperty("softwareSerialNo") != null ? p.getProperty("softwareSerialNo") : softwareSerialNo;
//		key = p.getProperty("key") != null ? p.getProperty("key") : key;
//		password = p.getProperty("password") != null ? p.getProperty("password") : password;
//		sendMethod = p.getProperty("sendMethod") != null ? p.getProperty("sendMethod") : sendMethod;
////		System.out.println("baseUrl=" + baseUrl + "|softwareSerialNo=" + softwareSerialNo + "|key=" + key + "|password=" + password);
//		String ret="0";
//		try{
//			String message = URLEncoder.encode(smsContent, "UTF-8");
//			String param="";
//			String mdn="";
//			
//			if(mobiles.length>200){
//				List<String[]> subAry = splitAry(mobiles, 200);//分割后的子块数组
//				for(String[] obj: subAry){
//					String[] aryItem = (String[]) obj;
//					for(String mobile:aryItem){
//						mdn+=mobile+",";		
//					}
//					mdn=mdn.substring(0, mdn.length()-1);
//					String code = "";
//					long seqId = System.currentTimeMillis();
//					param = "cdkey=" + softwareSerialNo + "&password=" + key + "&phone=" + mdn + "&message=" + message + "&addserial=" + code + "&seqid=" + seqId+"&smspriority=3";
//					String url = baseUrl + "sendsms.action";
//					
//					if ("get".equalsIgnoreCase(sendMethod)) {
//						ret = SDKHttpClient.sendSMS(url, param);
//					} else {
//						ret = SDKHttpClient.sendSMSByPost(url, param);
//					}
//				}
//			}else{			
//				for(String mobile:mobiles){
//					mdn+=mobile+",";		
//				}
//				mdn=mdn.substring(0, mdn.length()-1);
//				String code = "";
//				long seqId = System.currentTimeMillis();
//				param = "cdkey=" + softwareSerialNo + "&password=" + key + "&phone=" + mdn + "&message=" + message + "&addserial=" + code + "&seqid=" + seqId;
//				String url = baseUrl + "sendsms.action";
//				
//				if ("get".equalsIgnoreCase(sendMethod)) {
//					ret = SDKHttpClient.sendSMS(url, param);
//				} else {
//					ret = SDKHttpClient.sendSMSByPost(url, param);
//				}
//			}			
//		}catch(Exception e){
//			ret="-117";
//			logger.error(e.getMessage());
//		}	
//		return Integer.parseInt(ret);
//	}
//	
//	 public static List<String[]> splitAry(String[] ary, int subSize) {
//		  int count = ary.length % subSize == 0 ? ary.length / subSize: ary.length / subSize + 1;
//
//		  List<List<String>> subAryList = new ArrayList<List<String>>();
//
//		  for (int i = 0; i < count; i++) {
//		   int index = i * subSize;
//		   
//		   List<String> list = new ArrayList<String>();
//		   int j = 0;
//		   while (j < subSize && index < ary.length) {
//		    list.add(ary[index++]);
//		    j++;
//		   }
//
//		   subAryList.add(list);
//		  }
//		  
//		  List<String[]> subAry = new ArrayList<String[]>();
//		  
//		  for(int i = 0; i < subAryList.size(); i++){
//		   List<String> subList = subAryList.get(i);
//		   
//		   String[] subAryItem = new String[subList.size()];
//		   for(int j = 0; j < subList.size(); j++){
//		    subAryItem[j] = subList.get(j);
//		   }
//		   
//		   subAry.add(subAryItem);
//		  }
//		  
//		  return subAry;
//		 }
//	
//	public static void main(String[] args) {
////		String url = "http://sdk4report.eucp.b2m.cn:8080/sdkproxy/querybalance.action";
////		String param = "cdkey=6SDK-EKF-6687-KHQPL&password=795836";
////		String result = SDKHttpClient.getBalance(url, param);
////		System.out.println(result);
//		String[] strs = new String[1000];
//		for(int i=0;i<1000;i++){
//			strs[i]=String.valueOf((13312345000l+i));
//		}
//		List<String[]> objs = splitAry(strs, 200);
//		for(String[] obj:objs){
//			String[] s = (String[])obj;
//			String a="";
//			for(String t:s){
//				a+=t+",";
//			}
//			a=a.substring(0, a.length()-1);
//			System.out.println(a);
//		}
//	}
//}

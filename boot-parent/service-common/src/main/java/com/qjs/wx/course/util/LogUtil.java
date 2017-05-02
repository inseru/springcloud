// package com.qjs.wx.course.util;
//
// import org.apache.log4j.Logger;
// import org.apache.log4j.PropertyConfigurator;
//
// public class LogUtil {
// public static Logger logger = null;
// private static String className;
//
// public static Logger getLogger(String Name) {
// if (!Name.equals(className)) {
// className = Name;
// if (logger == null) {
// logger = Logger.getLogger(className);
// String path = LogUtil.class.getResource("/").getPath();
// PropertyConfigurator.configure(path + "/conf/log4j.properties");
// }
//
// }
// return logger;
// }
//
// }

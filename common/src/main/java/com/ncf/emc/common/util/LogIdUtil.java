package com.ncf.emc.common.util;

import lombok.extern.log4j.Log4j2;

/**
 * 类LogIdUtil.java的实现描述：LOG id
 *
 * @author lixiaoyong 2017/1/23 16:41
 */
@Log4j2
public class LogIdUtil {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void setLogId(String logId) {
        threadLocal.set(logId);
    }

    public static String getlogId() {
        if (threadLocal.get() == null) {
            return null;
        }
        return threadLocal.get();
    }


}

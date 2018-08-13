package com.example.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FrameworkLog {
    private final static Log logger = LogFactory.getLog(FrameworkLog.class);

    public static void info(Object msg){
        logger.info(msg);
    }
}

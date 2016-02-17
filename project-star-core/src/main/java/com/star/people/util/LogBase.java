package com.star.people.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zuhai.jiang on 2016/2/16.
 */
public class LogBase {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void logInfo(String s, Object... args) {
        logger.info(s, args);
    }

    protected void logDebug(String s, Object... args) {
        logger.debug(s, args);
    }

    protected void logError(String s, Object... args) {
        logger.error(s, args);
    }

    protected void logWarn(String s, Object... args) {
        logger.warn(s, args);
        logger.trace("");
    }
}

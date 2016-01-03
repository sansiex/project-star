package com.star.people.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by zuhai.jiang on 2016/1/3.
 */
public class ConfigUtil {
    private Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

    private static Properties config = new Properties();

    static {
        InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream("config/config.properties");

        try {
            config.load(in);
            System.out.println(config.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return config.getProperty(key);
    }
}

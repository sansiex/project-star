package com.star.people.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zuhai.jiang on 2015/10/30.
 */
@Service
public class ImgService {
    private Logger logger = LoggerFactory.getLogger(ImgService.class);

    private final static String IMG_DIR = System.getenv("IMG_DIR");

    @PostConstruct
    private void init(){
    }

    public String getImgPath(String relativePath){
        return IMG_DIR+"/"+relativePath;
    }
}

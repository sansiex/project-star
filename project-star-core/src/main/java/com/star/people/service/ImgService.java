package com.star.people.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zuhai.jiang on 2015/10/30.
 */
@Service
public class ImgService {
    private Logger logger = LoggerFactory.getLogger(ImgService.class);

    private final static String IMG_DIR = System.getenv("IMG_DIR");
    private final static String IMG_URL_PREFIX ="/resource/img/";

    @PostConstruct
    private void init(){
        logger.info("img directory:"+IMG_DIR);
    }

    public String getImgPath(String relativePath){
        return IMG_DIR+"/"+relativePath;
    }

    public String save(MultipartFile file, String name) throws IOException {
        String path = IMG_DIR+"/"+name;
        File img = new File(path);
        if (img.exists()) {
            logger.info("delete img:{}", path);
            img.delete();
        }
        logger.info("save img:{}", path);
        file.transferTo(img);
        return getUrl(name);
    }

    public String getImgName(String user, String ext, String theme) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        return theme+"_"+user.replace('.','_')+df.format(new Date())+"."+ext;
    }

    public String getUrl(String name){
        return IMG_URL_PREFIX+name;
    }

    public String getExt(String name){
        int i = name.lastIndexOf(".");
        return name.substring(i+1);
    }
}

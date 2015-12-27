package com.star.people.controller.view;

import com.star.people.service.ImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zuhai.jiang on 2015/12/20.
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    private Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    ImgService imgService;

    @RequestMapping(value = "/img/{id}.{ext}", method = RequestMethod.GET)
    public ModelAndView getImg(HttpServletResponse response
            , @PathVariable("id") String id
            , @PathVariable("ext") String ext) throws IOException {
        String name = id+"."+ext;
        logger.info("img:{}", name);
        String path = imgService.getImgPath(name);
        File img = new File(path);
        if (!img.exists()) {
            logger.error("图片{}不存在", path);
        }

        response.setContentType("image/jpeg");
        ServletOutputStream os = response.getOutputStream();
        BufferedImage bi = ImageIO.read(img);
        ImageIO.write(bi, ext, os);

        try {
            os.flush();
        } finally {
            os.close();
        }

        return null;
    }

}

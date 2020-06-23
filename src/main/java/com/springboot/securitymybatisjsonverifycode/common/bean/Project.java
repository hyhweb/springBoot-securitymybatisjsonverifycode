package com.springboot.securitymybatisjsonverifycode.common.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "project")
public class Project {
    private String imagesPath;
    private String imagesOriginPath;

    public String getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    public String getImagesOriginPath() {
        return imagesOriginPath;
    }

    public void setImagesOriginPath(String imagesOriginPath) {
        this.imagesOriginPath = imagesOriginPath;
    }
}

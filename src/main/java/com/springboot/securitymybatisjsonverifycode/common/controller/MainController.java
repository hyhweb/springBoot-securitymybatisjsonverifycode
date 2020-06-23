package com.springboot.securitymybatisjsonverifycode.common.controller;

import com.alibaba.fastjson.JSON;

import com.springboot.securitymybatisjsonverifycode.common.bean.Project;
import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import com.springboot.securitymybatisjsonverifycode.common.utils.VerifyCodeUtil;
import com.springboot.securitymybatisjsonverifycode.sys.dao.UserDao;
import com.springboot.securitymybatisjsonverifycode.sys.entity.User;
import com.springboot.securitymybatisjsonverifycode.sys.req.UserReq;
import com.springboot.securitymybatisjsonverifycode.sys.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

  // private static String UPLOAD_FOLDER = "D://uploadFile//";
  @Autowired Project project;

  @Autowired private UserService userService;

  @Autowired private UserDao userDao;

  @GetMapping("/vercode")
  public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    VerifyCodeUtil vc = new VerifyCodeUtil();
    BufferedImage image = vc.getImage();
    String text = vc.getText();
    HttpSession session = req.getSession();
    session.setAttribute("login_code", text);
    System.out.println("code:"+text);
    VerifyCodeUtil.output(image, resp.getOutputStream());
  }

  @GetMapping("/sessionInvalid")
  // @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  @ApiOperation(value = "登录过时", notes = "登录过时接口")
  public ApiResult sessionInvalid() {

    return ApiResult.fail("登录过时", "802");
  }

  @PostMapping("/register")
  @ApiOperation(value = "注册", notes = "注册接口")
  public ApiResult register(@RequestBody String json) {
    // return userService.add(JSON.parseObject(json, UserReq.class));
    return userService.register(JSON.parseObject(json, UserReq.class));
  }

  @PostMapping("/upload")
  @ApiOperation(value = "图片上传", notes = "图片上传接口")
  public ApiResult upload(@RequestParam MultipartFile file, Authentication authentication) {
    try {
      if (file.isEmpty()) {
        return ApiResult.fail("请选择要上传的文件");
      }
      System.out.println(file);
      byte[] bytes = file.getBytes();
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      User user = (User) principal;
      String dateString = DateFormatUtils.format(new Date(), "yyyy-MM-dd-hh-mm-ss");
      String filePath = user.getId() + "_" + dateString + "_" + file.getOriginalFilename();
      Path path = Paths.get(project.getImagesPath() + filePath);
      Files.write(path, bytes);
      Map map = new HashMap<String, String>();
      map.put("path", project.getImagesPath());
      map.put("allPath", project.getImagesOriginPath() + filePath);
      map.put("filePath", filePath);
      return ApiResult.success(map);
    } catch (Exception e) {
      e.printStackTrace();
      return ApiResult.fail("上传失败");
    }
  }
}

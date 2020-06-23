package com.springboot.securitymybatisjsonverifycode.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.securitymybatisjsonverifycode.common.bean.BufferedServletRequestWrapper;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class VerifyCodeFilter extends GenericFilterBean {
    private String  defaultFilterProcessUrl = "/login";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException,AuthenticationServiceException {
        //HttpServletRequest request = (HttpServletRequest) servletRequest;
       HttpServletRequest request = new BufferedServletRequestWrapper((HttpServletRequest) servletRequest);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if("POST".equalsIgnoreCase(request.getMethod())&&defaultFilterProcessUrl.equals(request.getServletPath())){
      //String code = request.getParameter("code");
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = request.getInputStream();
            Map<String, String> map = mapper.readValue(is, Map.class);
      String code = map.get("code");
                    String loginCode = (String) request.getSession().getAttribute("login_code");
      if (StringUtils.isEmpty(code)) {
        response.setContentType("application/json;charset=utf-8");
          Map map1 = new HashMap();
          map1.put("code", 0);
          map1.put("message", "验证码不能为空");
          ObjectMapper mappers = new ObjectMapper();
          PrintWriter out = response.getWriter();
          out.print(mappers.writeValueAsString(map1));
          out.flush();
          out.close();
       // throw new AuthenticationServiceException("验证码不能为空");

      }else if(!loginCode.toLowerCase().equals(code.toLowerCase())) {
          response.setContentType("application/json;charset=utf-8");
          Map map2 = new HashMap();
          map2.put("code", 0);
          map2.put("message", "验证码错误");
          ObjectMapper mappers = new ObjectMapper();
          PrintWriter out = response.getWriter();
          out.print(mappers.writeValueAsString(map2));
          out.flush();
          out.close();
          //throw new AuthenticationServiceException("验证码错误");
      }
        }
        filterChain.doFilter(request, response);
    }
}

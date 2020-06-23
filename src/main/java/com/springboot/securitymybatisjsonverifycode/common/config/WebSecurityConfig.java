package com.springboot.securitymybatisjsonverifycode.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.springboot.securitymybatisjsonverifycode.common.filter.VerifyCodeFilter;
import com.springboot.securitymybatisjsonverifycode.sys.entity.User;
import com.springboot.securitymybatisjsonverifycode.sys.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    VerifyCodeFilter verifyCodeFilter;

    @Autowired
    UserServiceImpl userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
       // return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    RoleHierarchy roleHierarchy(){
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
       // String hierarchy = "ROLE_dba> ROLE_admin \n ROLE_admin > ROLE_user";
        String hierarchy = "ROLE_admin > ROLE_user";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception{
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
                Object principal = auth.getPrincipal();
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                resp.setStatus(200);
                Map<String, Object> map = new HashMap<>();
                map.put("code", "1");
                map.put("success", true);
                map.put("message", "登录成功");
                User user = (User) principal;
                user.setPassword(null);
                map.put("data", user);
                ObjectMapper om = new ObjectMapper();
                out.write(om.writeValueAsString(map));
                out.flush();
                out.close();
               /* resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("message", "登录成功");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();*/

            }
        });
        filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                resp.setStatus(401);
                Map<String, Object> map = new HashMap<>();
                map.put("status", 401);
                if (e instanceof LockedException) {
                    map.put("msg", "账号被锁定，登录失败");
                } else if (e instanceof BadCredentialsException) {
                    map.put("msg", "账号或密码输入错误，请重新登录");
                } else if (e instanceof DisabledException) {
                    map.put("msg", "账号被禁用，登录失败");
                } else if (e instanceof AccountExpiredException) {
                    map.put("msg", "账号过期，登录失败");
                } else if (e instanceof CredentialsExpiredException) {
                    map.put("msg", "密码过期，登录失败");
                } else {
                    map.put("msg", "登录失败");
                }
                ObjectMapper om = new ObjectMapper();
                out.write(om.writeValueAsString(map));
                out.flush();
                out.close();
                /*resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("message", "登录失败");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();*/
            }
        });
        filter.setAuthenticationManager(authenticationManagerBean());
        return  filter;

    }

    @Bean
    public AccessDeniedHandler getAccessDeniedHandler() {
        return new RestAuthenticationAccessDeniedHandler();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/sessionInvalid", "/register","/vercode","/app/**")
                .antMatchers("/index.html", "/static/**", "/favicon.ico")
                // 给 swagger 放行；不需要权限能访问的资源
                .antMatchers("/swagger-ui.html","/doc.html", "/swagger-resources/**", "/images/**", "/webjars/**", "/v2/api-docs", "/configuration/ui", "/configuration/security");

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
      /*  http.authorizeRequests().antMatchers("/*").permitAll()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll(); //设置跨域*/
        http. // 开启跨域
             cors().and().authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
              //  .antMatchers("/**")
              //  .hasRole("admin")
//                .antMatchers("/dba/**")
//                .hasRole("dba")
                //.antMatchers("/**")
                //.hasRole("user")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .invalidSessionUrl("/session/invalid")
                .and()
                .formLogin()
                .loginPage("/login_page")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                /*.successHandler(
                        new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(
                                    HttpServletRequest req, HttpServletResponse resp, Authentication auth)
                                    throws IOException, ServletException {
                                Object principal = auth.getPrincipal();
                                resp.setContentType("application/json;charset=utf-8");
                                PrintWriter out = resp.getWriter();
                                resp.setStatus(200);
                                Map<String, Object> map = new HashMap<>();
                                map.put("status", 200);
                                map.put("msg", principal);
                                ObjectMapper om = new ObjectMapper();
                                out.write(om.writeValueAsString(map));
                                out.flush();
                                out.close();
                            }
                        })
                .failureHandler(
                        new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(
                                    HttpServletRequest req, HttpServletResponse resp, AuthenticationException e)
                                    throws IOException, ServletException {
                                resp.setContentType("application/json;charset=utf-8");
                                PrintWriter out = resp.getWriter();
                                resp.setStatus(401);
                                Map<String, Object> map = new HashMap<>();
                                map.put("status", 401);
                                if (e instanceof LockedException) {
                                    map.put("msg", "账号被锁定，登录失败");
                                } else if (e instanceof BadCredentialsException) {
                                    map.put("msg", "账号或密码输入错误，请重新登录");
                                } else if (e instanceof DisabledException) {
                                    map.put("msg", "账号被禁用，登录失败");
                                } else if (e instanceof AccountExpiredException) {
                                    map.put("msg", "账号过期，登录失败");
                                } else if (e instanceof CredentialsExpiredException) {
                                    map.put("msg", "密码过期，登录失败");
                                } else {
                                    map.put("msg", "登录失败");
                                }
                                ObjectMapper om = new ObjectMapper();
                                out.write(om.writeValueAsString(map));
                                out.flush();
                                out.close();
                            }
                        })*/
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication auth) {

                    }
                })
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                       // httpServletResponse.setStatus(200);
                        Map<String,Object> map = new HashMap<>();
                        map.put("message","操作成功");
                        map.put("code","1");
                        map.put("success",true);
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                       // httpServletResponse.sendRedirect("/logout_page");
                    }
                })
                .permitAll()
                .and()
                .csrf()
                .disable()
        .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());
    }
}

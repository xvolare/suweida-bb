package com.example.fastreachserve.interceptor;

import com.alibaba.fastjson.JSONObject;
import io.netty.util.internal.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import result.Result;
import utils.JwtUtils;

//拦截器
@Slf4j
@Component//要被配置类WebConfigure设置拦截路径，要放到IOC容器中
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("开始拦截");
        log.info("请求的url:{}",request.getRequestURL().toString());
        //获取请求头中的token
        String jwt=request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头没有携带令牌");
            //手动将对象转换到JSON，并相应给前端
            Result error=Result.error("NOT_LOGIN");
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌错误");
            //手动将对象转换到JSON，并相应给前端
            Result error=Result.error("NOT_LOGIN");
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        //true为放行，false为不放行
        log.info("令牌合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

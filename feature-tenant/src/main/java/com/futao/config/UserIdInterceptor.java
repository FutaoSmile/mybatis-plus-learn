package com.futao.config;

import com.futao.util.CurrentUserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;

/**
 * @author futao
 * @date 2020/12/15
 */
@Slf4j
public class UserIdInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = req.getHeader("user-id");
        if (header == null || "".equals(header)) {
            throw new NullPointerException("header user-id 不可为空");
        }
        Long userId = Long.valueOf(header);
        log.info("当前用户ID:{}", userId);
        CurrentUserId.set(userId);
        return true;
    }
}

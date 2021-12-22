package com.example.bms.aop;

import com.alibaba.fastjson.JSON;
import com.example.bms.utils.HttpContextUtils;
import com.example.bms.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.lang.reflect.Method;


@Slf4j
@Component
@Aspect //切面  定义了切点和通知之间的关系
public class LogAspect {
    @Pointcut("@annotation(com.example.bms.aop.LogAnnotation)")
    public void pt() {

    }

//    环绕通知
    @Around("pt()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
//        执行方法
        Object result = joinPoint.proceed();
//        执行时长
        long time = System.currentTimeMillis()-beginTime;
//        保存日志
        recordLog(joinPoint,time);
        return result;
    }

    private void recordLog(ProceedingJoinPoint joinPoint,long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        log.info("============log start==============");
        log.info("module:{}",logAnnotation.module());
        log.info("operator:{}",logAnnotation.operator());

//        请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("request method:{}",className+"."+methodName+"()");
//        请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args);
        log.info("params:{}",params);

//        获取request的地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.info("ip:{}", IpUtils.getIpAddr(request));
        log.info("excute time:{}",time);
        log.info("===========log end==================");
    }
}

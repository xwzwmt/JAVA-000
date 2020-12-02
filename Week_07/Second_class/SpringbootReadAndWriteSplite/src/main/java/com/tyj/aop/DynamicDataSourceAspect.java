package com.tyj.aop;

import com.tyj.annotation.Database;
import com.tyj.constants.DataSourceConstants;
import com.tyj.context.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

@Aspect
@Component
public class DynamicDataSourceAspect {
    @Pointcut("@annotation(com.tyj.annotation.Database)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        Database db = getDatabaseAnnotation(joinPoint);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

//        Database db = method.getAnnotation(Database.class);
        // todo:这里死活都拿不到代理对象的注解，不知道为什么。
        Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(),
                method.getParameterTypes());
        Database db = realMethod.getAnnotation(Database.class);
        // 只读
        if (db != null) {
            if (db.readOnly()) {
                // 走slave
                DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_SLAVE);
            } else {
                // 走master
                DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_MASTER);
            }
        }

        try{
            return joinPoint.proceed();
        }finally {
            DynamicDataSourceContextHolder.removeContextKey();
        }
    }

    /**
     * 根据类或方法获取数据源注解
     * @param joinPoint
     * @return
     */
    private Database getDatabaseAnnotation(ProceedingJoinPoint joinPoint){
        Class<?> targetClass = joinPoint.getTarget().getClass();
        Database dbAnnotation = targetClass.getAnnotation(Database.class);
        // 先判断类的注解，再判断方法注解
        if(Objects.nonNull(dbAnnotation)){
            return dbAnnotation;
        }else{
            MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
            return methodSignature.getMethod().getAnnotation(Database.class);
        }
    }
}

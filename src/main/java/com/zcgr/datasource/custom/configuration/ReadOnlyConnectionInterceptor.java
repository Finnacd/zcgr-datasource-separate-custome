package com.zcgr.datasource.custom.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author kevin
 */

@Aspect
@Configuration
public class ReadOnlyConnectionInterceptor implements Ordered {

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {

        try {
            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.SLAVE);
            return proceedingJoinPoint.proceed();
        }
        finally {
            DataBaseContextHolder.clearDataBaseType();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

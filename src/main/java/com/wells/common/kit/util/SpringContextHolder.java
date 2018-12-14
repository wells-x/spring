package com.wells.common.kit.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring的ApplicationContext的持有者,可以用静态方法的方式获取spring容器中的bean
 *
 * @author fengshuonan
 * @date 2016年11月27日 下午3:32:11
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        assertApplicationContext();
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {

        if (SpringContextHolder.applicationContext == null) {
            //  throw new RuntimeException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
        } else {
            return (T) applicationContext.getBean(beanName);
        }
        return null;
    }

    public static <T> T getBean(Class<T> requiredType) {
        if (SpringContextHolder.applicationContext == null) {
            //  throw new RuntimeException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
        } else {
            return applicationContext.getBean(requiredType);
        }
        return null;
    }

    private static void assertApplicationContext() {
        if (SpringContextHolder.applicationContext == null) {
            //  throw new RuntimeException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
        }
    }

}

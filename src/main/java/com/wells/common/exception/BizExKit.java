package com.wells.common.exception;

import com.wells.common.kit.support.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.util.Collection;

/**
 * 参数校验工具
 *
 * @author sheng
 * @date 18/3/19.
 */
public class BizExKit {

    private static Logger log = LoggerFactory.getLogger(BizExKit.class);

    public static <T extends Exception> void error(T e) throws T {
        throw e;
    }

    public static <T extends Exception> void error(BizExceptionEnum exceptionEnum) throws T {
        throw (T) create(exceptionEnum);
    }

    public static <T extends Exception> void isEmpty(String authorization, BizExceptionEnum exceptionEnum) throws T {
        if (StrKit.isEmpty(authorization)) {
            throw (T) create(exceptionEnum);
        }
    }

    public static <T extends Exception, R> void isNotEmpty(R r, BizExceptionEnum exceptionEnum) throws T {
        if (r != null) {
            throw (T) create(exceptionEnum);
        }
    }

    public static <T extends Exception> void emptyThrow(Collection collection) throws T {
        isEmpty(collection, BizExceptionEnum.PAGE_NULL);
        if (collection.size() <= 0) {
            throw (T) create(BizExceptionEnum.PAGE_NULL);
        }
    }

    public static <T> void queryEmpty(T t) {
        isEmpty(t, BizExceptionEnum.SUCCESS);
    }

    public static <T extends Exception, R> void isEmpty(R r, BizExceptionEnum exceptionEnum) throws T {
        if (r == null) {
            throw (T) create(exceptionEnum);
        }
    }

    public static void isEmpty(int i, BizExceptionEnum exceptionEnum) throws Exception {
        if (i == 0) {
            throw create(exceptionEnum);
        }
    }

    private static Exception create(BizExceptionEnum exceptionEnum) {
        try {
            Constructor constructor = exceptionEnum.getEx().getConstructor(BizExceptionEnum.class);
            if (constructor != null) {
                return (Exception) constructor.newInstance(exceptionEnum);
            } else {
                return (Exception) exceptionEnum.getEx().newInstance();
            }
        } catch (Exception e) {
            try {
                return (Exception) exceptionEnum.getEx().newInstance();
            } catch (InstantiationException | IllegalAccessException e1) {
                log.error("生成对象错误", e);
                e1.printStackTrace();
            }
        }
        return new BusinessException(BizExceptionEnum.SERVER_ERROR);
    }

    public static <T extends Exception> void isFalse(boolean flag, BizExceptionEnum bizExceptionEnum) throws T {
        if (!flag) {
            throw (T) create(bizExceptionEnum);
        }
    }

    public static <T extends Exception> void isTrue(boolean flag, BizExceptionEnum bizExceptionEnum) throws T {
        if (flag) {
            throw (T) create(bizExceptionEnum);
        }
    }

}

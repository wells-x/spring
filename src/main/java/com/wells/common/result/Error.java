package com.wells.common.result;


import com.wells.common.exception.BizExceptionEnum;
import com.wells.common.exception.BusinessException;

/**
 * Created by
 *
 * @author sheng
 * @date 18/3/16.
 */
public class Error extends AbstractResult {

    public Error(BusinessException ex) {
        this.code = ex.getCode();
        this.msg = ex.getMsg();
    }

    public Error(BizExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    @Override
    public String toString() {
        String s = "{\"code\":" + this.code + ",\"msg\":\"" + this.msg + "\"}";
        return s;
    }
}

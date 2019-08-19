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
    private String details;

    public Error(BusinessException ex) {
        this.code = ex.getCode();
        this.msg = ex.getMsg();
    }

    public Error(BizExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "{\"code\":" + this.code + ",\"msg\":\"" + this.msg + "\"}";
    }
}

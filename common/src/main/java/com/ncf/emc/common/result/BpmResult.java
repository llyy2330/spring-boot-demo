package com.ncf.emc.common.result;

import lombok.Data;

/**
 * 类BpmResult.java的实现描述：
 *
 * @author lixiaoyong 2017/5/16 15:03
 */
@Data
public class BpmResult extends BaseResVo {

    private Integer errorCode=0;
    private String errorMsg="OK";
    private Object data;


}

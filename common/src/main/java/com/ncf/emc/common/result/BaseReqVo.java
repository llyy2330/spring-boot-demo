package com.ncf.emc.common.result;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 类BaseVo.java的实现描述：
 *
 * @author lixiaoyong 2016/10/11 9:34
 */

@Data
public class BaseReqVo implements java.io.Serializable {
    private Integer pageNum;
    private Integer pageSize;
    @NotBlank
    private String logId;
    @NotBlank
    private String source;
    public String sign;



}

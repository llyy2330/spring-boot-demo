package com.ncf.emc.domain.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 类TestVo.java的实现描述：
 *
 * @author lixiaoyong 2017/8/3 17:07
 */
@Data
public class TestReqVo {
    @NotBlank
    private String name;
    private String code;

}

package com.ncf.emc.dao.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 类TestPo.java的实现描述：
 *
 * @author lixiaoyong 2017/8/3 17:34
 */
@Data
@Table(name = "city")
public class CityPo {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date update_time;


}

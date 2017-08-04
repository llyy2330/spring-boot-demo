package com.ncf.emc.common.util;

/**
 * 类SimpleBeanCopier.java的实现描述：
 *
 * @author lixiaoyong 2016/10/11 10:37
 */
public class BaseBeanCopier<F,T> extends BeanCopier<F,T> {


    public BaseBeanCopier(Class<F> sourceClass, Class<T> targetClass){
        setSourceClass(sourceClass);
        setTargetClass(targetClass);
        init();
    }

}
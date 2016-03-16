package com.mind.code.service;

import com.mind.code.vo.TCodeBuilder;

import java.util.List;

/**
 * Created by lrh on 2015/12/30.
 */
public interface CodeService {


    /**
     * 获取单个无验证业务码
     * @return
     */
     String getOneTCode() ;


    /**
     * 批量获取无验证业务码 一次不能超过 5W
     * @param size
     * @return
     */
    List<String> getTCodes(int size);


    /**
     * 获取单个业务验证码（TCodeBuilder的count字段在这里不生效）
     * @param tCodeBuilder
     * @return
     */
    String getOneTCode(TCodeBuilder tCodeBuilder);


    /**
     * 批量获取验证业务码
     * @param tCodeBuilder
     * @return
     */
    List<String> getTCodes(TCodeBuilder tCodeBuilder);



}

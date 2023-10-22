package com.aircore.hermes.service.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author aircore@belink.com
 */
@Getter
@ToString
@AllArgsConstructor
public enum BusinessCode {

    /**
     * 普通发送流程
     */
    COMMON_SEBD("send", "普通发送"),

    /**
     * 撤回流程
     */
    RECALL("recall", "撤回消息");

    /**
     * code 关联责任链的模板
     */
    private String code;

    /**
     * 类型说明
     */
    private String description;


}

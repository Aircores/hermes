package com.aircore.hermes.common.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 微信小程序
 * @author aircore@belink.com
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MiniProgramContentModel extends ContentModel {

    /**
     * 模板消息发送的数据
     */
    Map<String, String> miniProgramParam;

    /**
     * 模板Id
     */
    private String templateId;

    /**
     * 跳转链接
     */
    private String page;


}

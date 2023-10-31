package com.aircore.hermes.service.api.impl.domain;

import com.aircore.hermes.common.domain.TaskInfo;
import com.aircore.hermes.service.api.domain.MessageParam;
import com.aircore.hermes.support.domain.MessageTemplate;
import com.aircore.hermes.support.pipeline.ProcessModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发送消息任务模型
 * @author aircore@belink.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendTaskModel implements ProcessModel {

    /**
     * 消息模板Id
     */
    private Long messageTemplateId;

    /**
     * 请求参数
     */
    private List<MessageParam> messageParamList;

    /**
     * 发送任务的信息
     */
    private List<TaskInfo> taskInfo;

    /**
     * 撤回任务的信息
     */
    private MessageTemplate messageTemplatel;

}

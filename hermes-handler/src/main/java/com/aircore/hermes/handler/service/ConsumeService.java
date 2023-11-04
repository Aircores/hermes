package com.aircore.hermes.handler.service;

import com.aircore.hermes.common.domain.TaskInfo;
import com.aircore.hermes.support.domain.MessageTemplate;

import java.util.List;

/**
 * 消费消息服务
 *
 * @author aircore@belink.com
 */
public interface ConsumeService {

    /**
     * 从MQ拉到消息进行消费，发送消息
     *
     * @param taskInfoLists
     */
    void consume2Send(List<TaskInfo> taskInfoLists);

    /**
     * 从MQ拉到消息进行消费，撤回消息
     *
     * @param messageTemplate
     */
    void consume2recall(MessageTemplate messageTemplate);

}

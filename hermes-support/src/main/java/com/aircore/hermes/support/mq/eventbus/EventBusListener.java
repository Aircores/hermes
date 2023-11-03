package com.aircore.hermes.support.mq.eventbus;

import com.aircore.hermes.common.domain.TaskInfo;
import com.aircore.hermes.support.domain.MessageTemplate;

import java.util.List;

/**
 * @author
 * 监听器
 */
public interface EventBusListener {


    /**
     * 消费消息
     * @param lists
     */
    void consume(List<TaskInfo> lists);

    /**
     * 撤回消息
     * @param messageTemplate
     */
    void recall(MessageTemplate messageTemplate);
}

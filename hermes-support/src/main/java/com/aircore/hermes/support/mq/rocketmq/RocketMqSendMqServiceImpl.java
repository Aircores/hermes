package com.aircore.hermes.support.mq.rocketmq;

import com.aircore.hermes.support.constans.MessageQueuePipeline;
import com.aircore.hermes.support.mq.SendMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author elpsycongroo
 * create date: 2022/7/15
 */
@Slf4j
@Service
@ConditionalOnProperty(name = "austin.mq.pipeline", havingValue = MessageQueuePipeline.ROCKET_MQ)
public class RocketMqSendMqServiceImpl implements SendMqService {

//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void send(String topic, String jsonValue, String tagId) {
//        if (StringUtils.isNotBlank(tagId)) {
//            topic = topic + ":" + tagId;
//        }
//        send(topic, jsonValue);
    }

    @Override
    public void send(String topic, String jsonValue) {
//        rocketMQTemplate.send(topic, MessageBuilder.withPayload(jsonValue).build());
    }
}

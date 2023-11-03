package com.aircore.hermes.service.api.impl.action;

import cn.hutool.core.collection.CollUtil;
import com.aircore.hermes.common.enums.RespStatusEnum;
import com.aircore.hermes.common.vo.BasicResultVO;
import com.aircore.hermes.service.api.enums.BusinessCode;
import com.aircore.hermes.service.api.impl.domain.SendTaskModel;
import com.aircore.hermes.support.mq.SendMqService;
import com.aircore.hermes.support.pipeline.BusinessProcess;
import com.aircore.hermes.support.pipeline.ProcessContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author aircore@belink.com
 * 将消息发送到mq
 */
@Slf4j
@Service
public class SendMqAction implements BusinessProcess<SendTaskModel> {

    @Autowired
    private SendMqService sendMqService;

    @Value("${austin.business.topic.name}")
    private String sendMessageTopic;

    @Value("${austin.business.recall.topic.name}")
    private String austinRecall;
    @Value("${austin.business.tagId.value}")
    private String tagId;

    @Value("${austin.mq.pipeline}")
    private String mqPipeline;

    @Override
    public void process(ProcessContext<SendTaskModel> context) {
        SendTaskModel sendTaskModel = context.getProcessModel();
        try{
            if (BusinessCode.COMMON_SEBD.getCode().equals(context.getCode())){
                String message = JSON.toJSONString(sendTaskModel.getTaskInfo(), new SerializerFeature[]{SerializerFeature.WriteClassName});
                sendMqService.send(sendMessageTopic, message, tagId);
            } else if (BusinessCode.RECALL.getCode().equals(context.getCode())){
                String message = JSON.toJSONString(sendTaskModel.getMessageTemplatel(), new SerializerFeature[]{SerializerFeature.WriteClassName});
                sendMqService.send(austinRecall, message, tagId);
            }
        } catch (Exception e){
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.SERVICE_ERROR));
            log.error("send {} fail! e:{},params:{}", mqPipeline, Throwables.getStackTraceAsString(e)
                    , JSON.toJSONString(CollUtil.getFirst(sendTaskModel.getTaskInfo().listIterator())));
        }


    }
}

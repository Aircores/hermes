package com.aircore.hermes.service.api.service;

import com.aircore.hermes.service.api.domain.BatchSendRequest;
import com.aircore.hermes.service.api.domain.SendRequest;
import com.aircore.hermes.service.api.domain.SendResponse;

/**
 * 发送接口
 * @author aircore@belink.com
 */
public interface SendService {

    /**
     * 单文案发送接口
     * @param sendRequest
     * @return
     */
    SendResponse send(SendRequest sendRequest);

    /**
     * 多文案发送接口
     * @param batchSendRequest
     * @return
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);

}

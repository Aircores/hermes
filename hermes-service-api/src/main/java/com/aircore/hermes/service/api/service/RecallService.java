package com.aircore.hermes.service.api.service;

import com.aircore.hermes.service.api.domain.SendRequest;
import com.aircore.hermes.service.api.domain.SendResponse;

/**
 * 撤回接口
 * @author aircore@belink.com
 */
public interface RecallService {

    /**
     * 根据模板ID撤回消息
     * @param sendRequest
     * @return
     */
    SendResponse recall(SendRequest sendRequest);

}

package com.aircore.hermes.handler.deduplication.limit;


import com.aircore.hermes.common.domain.TaskInfo;
import com.aircore.hermes.handler.deduplication.DeduplicationParam;
import com.aircore.hermes.handler.deduplication.service.AbstractDeduplicationService;

import java.util.Set;

/**
 * @author cao
 * @date 2022-04-20 11:58
 */
public interface LimitService {


    /**
     * 去重限制
     *
     * @param service  去重器对象
     * @param taskInfo
     * @param param    去重参数
     * @return 返回不符合条件的手机号码
     */
    Set<String> limitFilter(AbstractDeduplicationService service, TaskInfo taskInfo, DeduplicationParam param);

}

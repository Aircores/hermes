package com.aircore.hermes.handler.deduplication.build;

import com.aircore.hermes.common.domain.TaskInfo;
import com.aircore.hermes.handler.deduplication.DeduplicationParam;

/**
 * @author aircore@belink.com
 */
public interface Builder {

    String DEDUPLICATION_CONFIG_PRE = "deduplication";

    /**
     * 根据配置构建去重参数
     * @param deduplication
     * @param taskInfo
     * @return
     */
    DeduplicationParam build(String deduplication, TaskInfo taskInfo);

}

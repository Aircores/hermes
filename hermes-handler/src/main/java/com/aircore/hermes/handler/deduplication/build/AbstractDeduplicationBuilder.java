package com.aircore.hermes.handler.deduplication.build;

import com.aircore.hermes.common.domain.TaskInfo;
import com.aircore.hermes.handler.deduplication.DeduplicationHolder;
import com.aircore.hermes.handler.deduplication.DeduplicationParam;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @author aircore@belink.com
 */
public abstract class AbstractDeduplicationBuilder implements Builder {

    protected Integer deduplicationType;
    @Autowired
    private DeduplicationHolder deduplicationHolder;

    @PostConstruct
    public void init(){
        deduplicationHolder.putBuilder(deduplicationType, this);
    }

    public DeduplicationParam getParamsFromConfig(Integer key, String duplicationConfig, TaskInfo taskInfo) {
        JSONObject object = JSONObject.parseObject(duplicationConfig);
        if (Objects.isNull(object)) {
            return null;
        }
        DeduplicationParam deduplicationParam = JSONObject.parseObject(object.getString(DEDUPLICATION_CONFIG_PRE + key), DeduplicationParam.class);
        if (Objects.isNull(deduplicationParam)) {
            return null;
        }
        deduplicationParam.setTaskInfo(taskInfo);
        return deduplicationParam;
    }


}

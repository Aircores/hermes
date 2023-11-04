package com.aircore.hermes.handler.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.aircore.hermes.common.domain.TaskInfo;
import com.aircore.hermes.handler.pending.Task;
import com.aircore.hermes.handler.pending.TaskPendingHolder;
import com.aircore.hermes.handler.service.ConsumeService;
import com.aircore.hermes.handler.utils.GroupIdMappingUtils;
import com.aircore.hermes.support.domain.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aircore@belink.com
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {
    private static final String LOG_BIZ_TYPE = "Receiver#consumer";
    private static final String LOG_BIZ_RECALL_TYPE = "Receiver#recall";
    @Autowired
    private ApplicationContext context;

    @Autowired
    private TaskPendingHolder taskPendingHolder;

    @Override
    public void consume2Send(List<TaskInfo> taskInfoLists) {
        String topicGroupId = GroupIdMappingUtils.getGroupIdByTaskInfo(CollUtil.getFirst(taskInfoLists.iterator()));
        for (TaskInfo taskInfo : taskInfoLists){
            Task task = context.getBean(Task.class).setTaskInfo(taskInfo);
            taskPendingHolder.route(topicGroupId).execute(task);
        }

    }

    @Override
    public void consume2recall(MessageTemplate messageTemplate) {

    }
}

/*
 * Copyright 2016-present the IoT DC3 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.pnoker.center.data.entity.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.github.pnoker.common.entity.ext.JsonExt;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 报警规则表
 * </p>
 *
 * @author pnoker
 * @since 2022.1.0
 */
@Getter
@Setter
@TableName("dc3_alarm_rule")
public class AlarmRuleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 报警规则名称
     */
    @TableField("alarm_rule_name")
    private String alarmRuleName;

    /**
     * 报警规则编号
     */
    @TableField("alarm_rule_code")
    private String alarmRuleCode;

    /**
     * 位号ID
     */
    @TableField("point_id")
    private Long pointId;

    /**
     * 报警通知模板ID
     */
    @TableField("alarm_notify_profile_id")
    private Long alarmNotifyProfileId;

    /**
     * 报警信息模板ID
     */
    @TableField("alarm_message_profile_id")
    private Long alarmMessageProfileId;

    /**
     * 报警类型标识
     */
    @TableField("alarm_type_flag")
    private Byte alarmTypeFlag;

    /**
     * 报警规则
     */
    @TableField(value = "alarm_rule_ext", typeHandler = JacksonTypeHandler.class)
    private JsonExt alarmRuleExt;

    /**
     * 使能标识
     */
    @TableField("enable_flag")
    private Byte enableFlag;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private Long tenantId;

    /**
     * 描述
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建者ID
     */
    @TableField("creator_id")
    private Long creatorId;

    /**
     * 创建者名称
     */
    @TableField("creator_name")
    private String creatorName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 操作者ID
     */
    @TableField("operator_id")
    private Long operatorId;

    /**
     * 操作者名称
     */
    @TableField("operator_name")
    private String operatorName;

    /**
     * 操作时间
     */
    @TableField("operate_time")
    private LocalDateTime operateTime;

    /**
     * 逻辑删除标识,0:未删除,1:已删除
     */
    @TableLogic
    @TableField("deleted")
    private Byte deleted;
}

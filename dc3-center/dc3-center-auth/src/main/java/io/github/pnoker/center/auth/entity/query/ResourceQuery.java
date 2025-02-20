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

package io.github.pnoker.center.auth.entity.query;

import io.github.pnoker.common.entity.common.Pages;
import io.github.pnoker.common.enums.EnableFlagEnum;
import io.github.pnoker.common.enums.ResourceTypeFlagEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * @author linys
 * @since 2022.1.0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "ResourceQuery", description = "资源-查询")
public class ResourceQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "分页")
    private Pages page;

    /**
     * 租户ID
     */
    @Schema(description = "使能标识", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long tenantId;

    // 查询字段

    /**
     * 权限资源名称
     */
    @Schema(description = "权限资源名称")
    private String resourceName;

    /**
     * 权限资源编号
     */
    @Schema(description = "权限资源编号")
    private String resourceCode;

    /**
     * 权限资源类型标识
     */
    @Schema(description = "权限资源类型标识")
    private ResourceTypeFlagEnum resourceTypeFlag;

    /**
     * 权限资源范围标识，参考：ResourceScopeFlagEnum
     * <ul>
     *     <li>0x01：新增</li>
     *     <li>0x02：删除</li>
     *     <li>0x04：更新</li>
     *     <li>0x08：查询</li>
     * </ul>
     * 具有多个权限范围可以累加
     */
    @Schema(description = "权限资源范围标识")
    private Byte resourceScopeFlag;

    /**
     * 使能标识
     */
    @Schema(description = "使能标识")
    private EnableFlagEnum enableFlag;
}

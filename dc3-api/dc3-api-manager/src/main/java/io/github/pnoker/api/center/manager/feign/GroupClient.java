/*
 * Copyright 2016-present Pnoker All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.pnoker.api.center.manager.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.pnoker.api.center.manager.fallback.GroupClientFallback;
import io.github.pnoker.common.bean.R;
import io.github.pnoker.common.constant.common.RequestConstant;
import io.github.pnoker.common.constant.service.ManagerServiceConstant;
import io.github.pnoker.common.dto.GroupDto;
import io.github.pnoker.common.model.Group;
import io.github.pnoker.common.valid.Insert;
import io.github.pnoker.common.valid.Update;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 分组 FeignClient
 *
 * @author pnoker
 * @since 2022.1.0
 */
@FeignClient(path = ManagerServiceConstant.GROUP_URL_PREFIX, name = ManagerServiceConstant.SERVICE_NAME, fallbackFactory = GroupClientFallback.class)
public interface GroupClient {

    /**
     * 新增 Group
     *
     * @param group    Group
     * @param tenantId 租户ID
     * @return Group
     */
    @PostMapping("/add")
    R<Group> add(@Validated(Insert.class) @RequestBody Group group, @RequestHeader(value = RequestConstant.Header.X_AUTH_TENANT_ID, defaultValue = "-1") String tenantId);

    /**
     * 根据 ID 删除 Group
     *
     * @param id 分组ID
     * @return 是否删除
     */
    @PostMapping("/delete/{id}")
    R<Boolean> delete(@NotNull @PathVariable(value = "id") String id);

    /**
     * 修改 Group
     *
     * @param group    Group
     * @param tenantId 租户ID
     * @return Group
     */
    @PostMapping("/update")
    R<Group> update(@Validated(Update.class) @RequestBody Group group, @RequestHeader(value = RequestConstant.Header.X_AUTH_TENANT_ID, defaultValue = "-1") String tenantId);

    /**
     * 根据 ID 查询 Group
     *
     * @param id 分组ID
     * @return Group
     */
    @GetMapping("/id/{id}")
    R<Group> selectById(@NotNull @PathVariable(value = "id") String id);

    /**
     * 模糊分页查询 Group
     *
     * @param groupDto Group Dto
     * @param tenantId 租户ID
     * @return Page Of Group
     */
    @PostMapping("/list")
    R<Page<Group>> list(@RequestBody(required = false) GroupDto groupDto, @RequestHeader(value = RequestConstant.Header.X_AUTH_TENANT_ID, defaultValue = "-1") String tenantId);

}

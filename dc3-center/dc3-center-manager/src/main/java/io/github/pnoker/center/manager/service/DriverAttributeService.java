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

package io.github.pnoker.center.manager.service;

import io.github.pnoker.center.manager.entity.bo.DriverAttributeBO;
import io.github.pnoker.center.manager.entity.query.DriverAttributeQuery;
import io.github.pnoker.common.base.service.BaseService;

import java.util.List;

/**
 * DriverAttribute Interface
 *
 * @author pnoker
 * @since 2022.1.0
 */
public interface DriverAttributeService extends BaseService<DriverAttributeBO, DriverAttributeQuery> {


    /**
     * 根据 驱动ID 查询
     *
     * @param driverId 驱动ID
     * @return DriverAttribute Array
     */
    List<DriverAttributeBO> selectByDriverId(Long driverId);

    /**
     * 根据 驱动配置属性名称 和 驱动ID 查询
     *
     * @param name     属性名称
     * @param driverId 驱动ID
     * @return DriverAttribute
     */
    DriverAttributeBO selectByNameAndDriverId(String name, Long driverId);
}

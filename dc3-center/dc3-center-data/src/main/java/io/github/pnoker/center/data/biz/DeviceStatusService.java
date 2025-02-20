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

package io.github.pnoker.center.data.biz;

import io.github.pnoker.center.data.entity.bo.DeviceRunBO;
import io.github.pnoker.center.data.entity.query.DeviceQuery;

import java.util.Map;

/**
 * Device Interface
 *
 * @author pnoker
 * @since 2022.1.0
 */
public interface DeviceStatusService {

    /**
     * 分页查询 Device 服务状态，同设备分页查询配套使用
     *
     * @param deviceQuery 设备和分页参数
     * @return Map String:String
     */
    Map<Long, String> device(DeviceQuery deviceQuery);

    /**
     * 根据 模板ID 查询 Device 服务状态
     *
     * @param profileId 位号ID
     * @return Map String:String
     */
    Map<Long, String> deviceByProfileId(Long profileId);

    DeviceRunBO selectOnlineByDeviceId(Long deviceId);

    DeviceRunBO selectOfflineByDeviceId(Long deviceId);
}

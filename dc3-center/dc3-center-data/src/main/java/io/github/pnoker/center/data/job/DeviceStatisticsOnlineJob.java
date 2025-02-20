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

package io.github.pnoker.center.data.job;


import io.github.pnoker.center.data.biz.DeviceStatisticsOnlineService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Slf4j
@Component
public class DeviceStatisticsOnlineJob extends QuartzJobBean {

    @Resource
    private DeviceStatisticsOnlineService deviceStatisticsOnlineService;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        deviceStatisticsOnlineService.deviceStatisticsOnline();

    }
}

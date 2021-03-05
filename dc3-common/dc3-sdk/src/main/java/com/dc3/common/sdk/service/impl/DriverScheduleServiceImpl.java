/*
 * Copyright 2018-2020 Pnoker. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dc3.common.sdk.service.impl;

import com.dc3.common.sdk.bean.DriverProperty;
import com.dc3.common.sdk.service.DriverScheduleService;
import com.dc3.common.sdk.service.job.DriverCustomScheduleJob;
import com.dc3.common.sdk.service.job.DriverReadScheduleJob;
import com.dc3.common.sdk.service.job.DriverStatusScheduleJob;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author pnoker
 */
@Slf4j
@Service
@EnableConfigurationProperties({DriverProperty.class})
public class DriverScheduleServiceImpl implements DriverScheduleService {
    @Resource
    private Scheduler scheduler;
    @Resource
    private DriverProperty driverProperty;

    @Override
    public void initial() {
        Optional.ofNullable(driverProperty.getSchedule()).ifPresent(property -> {
            // driver heartbeat
            createScheduleJob("DriverScheduleGroup", "StatusScheduleJob", "0/10 * * * * ?", DriverStatusScheduleJob.class);

            // driver read
            if (property.getRead().getEnable()) {
                createScheduleJob("DriverScheduleGroup", "ReadScheduleJob", property.getRead().getCorn(), DriverReadScheduleJob.class);
            }

            // driver custom schedule
            if (property.getCustom().getEnable()) {
                createScheduleJob("DriverScheduleGroup", "CustomScheduleJob", property.getCustom().getCorn(), DriverCustomScheduleJob.class);
            }

            try {
                if (!scheduler.isShutdown()) {
                    scheduler.start();
                }
            } catch (SchedulerException e) {
                log.error(e.getMessage(), e);
            }
        });
    }

    /**
     * 创建调度任务
     *
     * @param group    group
     * @param name     name
     * @param corn     corn
     * @param jobClass class
     */
    @SneakyThrows
    public void createScheduleJob(String group, String name, String corn, Class<? extends Job> jobClass) {
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(name, group).build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(name, group)
                .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                .withSchedule(CronScheduleBuilder.cronSchedule(corn))
                .startNow().build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

}

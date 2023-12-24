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

package io.github.pnoker.center.data.entity.builder;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.pnoker.center.data.entity.bo.AlarmNotifyProfileBO;
import io.github.pnoker.center.data.entity.model.AlarmNotifyProfileDO;
import io.github.pnoker.center.data.entity.vo.AlarmNotifyProfileVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * AlarmNotifyProfile Builder
 *
 * @author pnoker
 * @since 2022.1.0
 */
@Mapper(componentModel = "spring")
public interface AlarmNotifyProfileBuilder {

    /**
     * VO to BO
     *
     * @param entityVO EntityVO
     * @return EntityBO
     */
    AlarmNotifyProfileBO buildBOByVO(AlarmNotifyProfileVO entityVO);

    /**
     * VOList to BOList
     *
     * @param entityVOList EntityVO Array
     * @return EntityBO Array
     */
    List<AlarmNotifyProfileBO> buildBOListByVOList(List<AlarmNotifyProfileVO> entityVOList);

    /**
     * BO to DO
     *
     * @param entityBO EntityBO
     * @return EntityDO
     */
    @Mapping(target = "alarmNotifyExt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    AlarmNotifyProfileDO buildDOByBO(AlarmNotifyProfileBO entityBO);

    /**
     * BOList to DOList
     *
     * @param entityBOList EntityBO Array
     * @return EntityDO Array
     */
    List<AlarmNotifyProfileDO> buildDOListByBOList(List<AlarmNotifyProfileBO> entityBOList);

    /**
     * DO to BO
     *
     * @param entityDO EntityDO
     * @return EntityBO
     */
    AlarmNotifyProfileBO buildBOByDO(AlarmNotifyProfileDO entityDO);

    /**
     * DOList to BOList
     *
     * @param entityDOList EntityDO Array
     * @return EntityBO Array
     */
    List<AlarmNotifyProfileBO> buildBOListByDOList(List<AlarmNotifyProfileDO> entityDOList);

    /**
     * BO to VO
     *
     * @param entityBO EntityBO
     * @return EntityVO
     */
    AlarmNotifyProfileVO buildVOByBO(AlarmNotifyProfileBO entityBO);

    /**
     * BOList to VOList
     *
     * @param entityBOList EntityBO Array
     * @return EntityVO Array
     */
    List<AlarmNotifyProfileVO> buildVOListByBOList(List<AlarmNotifyProfileBO> entityBOList);

    /**
     * DOPage to BOPage
     *
     * @param entityPageDO EntityDO Page
     * @return EntityBO Page
     */
    @Mapping(target = "optimizeJoinOfCountSql", ignore = true)
    Page<AlarmNotifyProfileBO> buildBOPageByDOPage(Page<AlarmNotifyProfileDO> entityPageDO);

    /**
     * BOPage to VOPage
     *
     * @param entityPageBO EntityBO Page
     * @return EntityVO Page
     */
    @Mapping(target = "optimizeJoinOfCountSql", ignore = true)
    Page<AlarmNotifyProfileVO> buildVOPageByBOPage(Page<AlarmNotifyProfileBO> entityPageBO);
}
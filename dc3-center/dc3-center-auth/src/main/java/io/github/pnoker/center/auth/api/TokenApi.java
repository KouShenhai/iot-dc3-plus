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

package io.github.pnoker.center.auth.api;


import cn.hutool.core.util.ObjectUtil;
import io.github.pnoker.api.center.auth.GrpcLoginQuery;
import io.github.pnoker.api.center.auth.GrpcRTokenDTO;
import io.github.pnoker.api.center.auth.TokenApiGrpc;
import io.github.pnoker.api.common.GrpcR;
import io.github.pnoker.center.auth.biz.TokenService;
import io.github.pnoker.center.auth.entity.bean.TokenValid;
import io.github.pnoker.common.enums.ResponseEnum;
import io.github.pnoker.common.utils.TimeUtil;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

/**
 * Token Api
 *
 * @author pnoker
 * @since 2022.1.0
 */
@Slf4j
@GrpcService
public class TokenApi extends TokenApiGrpc.TokenApiImplBase {

    @Resource
    private TokenService tokenService;

    @Override
    public void checkValid(GrpcLoginQuery request, StreamObserver<GrpcRTokenDTO> responseObserver) {
        GrpcRTokenDTO.Builder builder = GrpcRTokenDTO.newBuilder();
        GrpcR.Builder rBuilder = GrpcR.newBuilder();
        TokenValid select = tokenService.checkValid(request.getName(), request.getSalt(), request.getToken(), request.getTenant());
        if (ObjectUtil.isNull(select)) {
            rBuilder.setOk(false);
            rBuilder.setCode(ResponseEnum.NO_RESOURCE.getCode());
            rBuilder.setMessage(ResponseEnum.NO_RESOURCE.getText());
        } else if (!select.isValid()) {
            rBuilder.setOk(false);
            rBuilder.setCode(ResponseEnum.TOKEN_INVALID.getCode());
            rBuilder.setMessage(ResponseEnum.TOKEN_INVALID.getText());
        } else {
            String expireTime = TimeUtil.completeFormat(select.getExpireTime());
            rBuilder.setOk(true);
            rBuilder.setCode(ResponseEnum.OK.getCode());
            rBuilder.setMessage(ResponseEnum.OK.getText());
            builder.setData(expireTime);
        }

        builder.setResult(rBuilder);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

}

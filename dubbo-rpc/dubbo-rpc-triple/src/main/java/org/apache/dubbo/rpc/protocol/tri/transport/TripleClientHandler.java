/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.rpc.protocol.tri.transport;

import org.apache.dubbo.remoting.api.connection.ConnectionHandler;
import org.apache.dubbo.rpc.model.FrameworkModel;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2GoAwayFrame;
import io.netty.util.ReferenceCountUtil;

public class TripleClientHandler extends ChannelDuplexHandler {

    private final FrameworkModel frameworkModel;

    private static final String CONNECTION_HANDLER_NAME = "connectionHandler";

    public TripleClientHandler(FrameworkModel frameworkModel) {
        this.frameworkModel = frameworkModel;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Http2GoAwayFrame) {
            final ConnectionHandler connectionHandler = (ConnectionHandler) ctx.pipeline().get(CONNECTION_HANDLER_NAME);
            connectionHandler.onGoAway(ctx.channel());
        }
        ReferenceCountUtil.release(msg);
    }
}

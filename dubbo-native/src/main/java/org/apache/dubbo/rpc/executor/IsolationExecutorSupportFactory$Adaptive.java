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
package org.apache.dubbo.rpc.executor;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;
public class IsolationExecutorSupportFactory$Adaptive implements org.apache.dubbo.rpc.executor.IsolationExecutorSupportFactory {
public org.apache.dubbo.rpc.executor.ExecutorSupport createIsolationExecutorSupport(org.apache.dubbo.common.URL arg0)  {
if (arg0 == null) throw new IllegalArgumentException("url == null");
org.apache.dubbo.common.URL url = arg0;
String extName = ( url.getProtocol() == null ? "adaptive" : url.getProtocol() );
if(extName == null) throw new IllegalStateException("Failed to get extension (org.apache.dubbo.rpc.executor.IsolationExecutorSupportFactory) name from url (" + url.toString() + ") use keys([protocol])");
ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), org.apache.dubbo.rpc.executor.IsolationExecutorSupportFactory.class);
org.apache.dubbo.rpc.executor.IsolationExecutorSupportFactory extension = (org.apache.dubbo.rpc.executor.IsolationExecutorSupportFactory)scopeModel.getExtensionLoader(org.apache.dubbo.rpc.executor.IsolationExecutorSupportFactory.class).getExtension(extName);
return extension.createIsolationExecutorSupport(arg0);
}
public org.apache.dubbo.rpc.executor.ExecutorSupport getIsolationExecutorSupport(org.apache.dubbo.common.URL arg0)  {
throw new UnsupportedOperationException("The method public static org.apache.dubbo.rpc.executor.ExecutorSupport org.apache.dubbo.rpc.executor.IsolationExecutorSupportFactory.getIsolationExecutorSupport(org.apache.dubbo.common.URL) of interface org.apache.dubbo.rpc.executor.IsolationExecutorSupportFactory is not adaptive method!");
}
}

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

package org.apache.shenyu.common.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

/**
 * Test case for WebsocketData.
 */
public class WebsocketDataTest {
    
    @Test
    public void testGetterSetter() {
        WebsocketData<AppAuthData> websocketData = new WebsocketData<>(
                "groupType", "eventType", Arrays.asList(new AppAuthData()));
        
        websocketData.setGroupType("groupType1");
        websocketData.setEventType("eventType1");
        websocketData.setData(Arrays.asList(new AppAuthData(), new AppAuthData()));
        
        assertThat(websocketData.getGroupType(), is("groupType1"));
        assertThat(websocketData.getEventType(), is("eventType1"));
        assertThat(websocketData.getData(), hasSize(2));
    }
    
    @Test
    public void testEqualsAndHashCode() {
        WebsocketData<AppAuthData> websocketData1 = new WebsocketData<>(
                "groupType", "eventType", Arrays.asList(new AppAuthData()));
        WebsocketData<AppAuthData> websocketData2 = new WebsocketData<>(
                "groupType", "eventType", Arrays.asList(new AppAuthData()));
        
        Set<WebsocketData> set = new HashSet<>();
        set.add(websocketData1);
        set.add(websocketData2);
        
        assertThat(set, hasSize(1));
    }
    
}

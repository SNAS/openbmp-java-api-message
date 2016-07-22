/*
 * Copyright (c) 2015-2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */
package org.openbmp.api.example.spring.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * SinkInput interface
 *      Maps topics to channels.   See application.yml configuration for consumer channel configuration.
 */
public interface SinkInput {

    String COLLECTOR = "collector";
    String ROUTER = "router";
    String PEER = "peer";
    String UNICAST_PREFIX = "unicast_prefix";
    String LS_NODE = "ls_node";
    String LS_LINK = "ls_link";
    String LS_PREFIX = "ls_prefix";

    @Input(COLLECTOR)
    SubscribableChannel collector();

    @Input(ROUTER)
    SubscribableChannel router();

    @Input(PEER)
    SubscribableChannel peer();

    @Input(UNICAST_PREFIX)
    SubscribableChannel unicast_prefix();

    @Input(LS_NODE)
    SubscribableChannel ls_node();

    @Input(LS_LINK)
    SubscribableChannel ls_link();

    @Input(LS_PREFIX)
    SubscribableChannel ls_prefix();
}

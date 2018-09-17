package org.openbmp.api.parsed.message;
/*
 * Copyright (c) 2018 Cisco Systems, Inc. and others.  All rights reserved.
 * Copyright (c) 2018 Tim Evens (tim@evensweb.com).  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

import java.math.BigInteger;

/**
 * POJO for openbmp.parsed.collector record
 */
public class CollectorPojo {

    private String action;
    private BigInteger sequence;
    private String admin_id;
    private String hash;
    private String router_list;
    private Integer router_count;
    private String timestamp;

    public CollectorPojo() {
        sequence = BigInteger.ZERO;
        router_count = 0;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public BigInteger getSequence() {
        return sequence;
    }

    public void setSequence(BigInteger sequence) {
        this.sequence = sequence;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getRouter_list() {
        return router_list;
    }

    public void setRouter_list(String router_list) {
        this.router_list = router_list;
    }

    public Integer getRouter_count() {
        return router_count;
    }

    public void setRouter_count(Integer router_count) {
        this.router_count = router_count;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

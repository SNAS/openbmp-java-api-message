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
 * POJO for openbmp.parsed.router record
 */
public class RouterPojo {

    private String action;
    private BigInteger sequence;
    private String name;
    private String hash;
    private String ip_address;
    private String description;
    private Integer term_code;
    private String term_reason;
    private String init_data;
    private String term_data;
    private String timestamp;
    private String bgp_id;

    public RouterPojo() {
        sequence = BigInteger.ZERO;
        term_code = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTerm_code() {
        return term_code;
    }

    public void setTerm_code(Integer term_code) {
        this.term_code = term_code;
    }

    public String getTerm_reason() {
        return term_reason;
    }

    public void setTerm_reason(String term_reason) {
        this.term_reason = term_reason;
    }

    public String getInit_data() {
        return init_data;
    }

    public void setInit_data(String init_data) {
        this.init_data = init_data;
    }

    public String getTerm_data() {
        return term_data;
    }

    public void setTerm_data(String term_data) {
        this.term_data = term_data;
    }

    public String getBgp_id() {
        return bgp_id;
    }

    public void setBgp_id(String bgp_id) {
        this.bgp_id = bgp_id;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

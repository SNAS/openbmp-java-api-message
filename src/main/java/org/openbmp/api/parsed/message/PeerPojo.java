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
 * POJO for openbmp.parsed.peer record
 */
public class PeerPojo {

    private String action;
    private BigInteger sequence;
    private String hash;
    private String router_hash;
    private String name;
    private String peer_bgp_id;
    private String router_ip;
    private String timestamp;
    private Long peer_asn;
    private String peer_ip;
    private String peer_rd;
    private Integer peer_port;
    private Long local_asn;
    private String local_ip;
    private Integer local_port;
    private String local_bgp_id;
    private String info_data;
    private String advertised_cap;
    private String received_cap;
    private Integer peer_holddown;
    private Integer local_holddown;
    private Integer bmp_down_reason;
    private Integer bgp_error_code;
    private Integer bgp_error_subcode;
    private String bgp_error_text;
    private Boolean isL3VPN;
    private Boolean isPrePolicy;
    private Boolean isIPv4;
    private Boolean isLocRib;
    private Boolean isLocalRibFiltered;
    private String table_name;

    public PeerPojo() {
        sequence = BigInteger.ZERO;
        peer_asn = 0L;
        local_asn = 0L;
        local_port = 0;
        peer_port = 0;
        peer_holddown = 0;
        local_holddown = 0;
        bmp_down_reason = 0;
        bgp_error_code = 0;
        bgp_error_subcode = 0;
        isL3VPN = false;
        isPrePolicy = true;
        isIPv4 = true;
        isLocRib = false;
        isLocalRibFiltered = false;
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

    public String getRouter_hash() {
        return router_hash;
    }

    public void setRouter_hash(String router_hash) {
        this.router_hash = router_hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeer_bgp_id() {
        return peer_bgp_id;
    }

    public void setPeer_bgp_id(String peer_bgp_id) {
        this.peer_bgp_id = peer_bgp_id;
    }

    public String getRouter_ip() {
        return router_ip;
    }

    public void setRouter_ip(String router_ip) {
        this.router_ip = router_ip;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Long getPeer_asn() {
        return peer_asn;
    }

    public void setPeer_asn(Long peer_asn) {
        this.peer_asn = peer_asn;
    }

    public String getPeer_ip() {
        return peer_ip;
    }

    public void setPeer_ip(String peer_ip) {
        this.peer_ip = peer_ip;
    }

    public String getPeer_rd() {
        return peer_rd;
    }

    public void setPeer_rd(String peer_rd) {
        this.peer_rd = peer_rd;
    }

    public Integer getPeer_port() {
        return peer_port;
    }

    public void setPeer_port(Integer peer_port) {
        this.peer_port = peer_port;
    }

    public Long getLocal_asn() {
        return local_asn;
    }

    public void setLocal_asn(Long local_asn) {
        this.local_asn = local_asn;
    }

    public String getLocal_ip() {
        return local_ip;
    }

    public void setLocal_ip(String local_ip) {
        this.local_ip = local_ip;
    }

    public Integer getLocal_port() {
        return local_port;
    }

    public void setLocal_port(Integer local_port) {
        this.local_port = local_port;
    }

    public String getLocal_bgp_id() {
        return local_bgp_id;
    }

    public void setLocal_bgp_id(String local_bgp_id) {
        this.local_bgp_id = local_bgp_id;
    }

    public String getInfo_data() {
        return info_data;
    }

    public void setInfo_data(String info_data) {
        this.info_data = info_data;
    }

    public String getAdvertised_cap() {
        return advertised_cap;
    }

    public void setAdvertised_cap(String advertised_cap) {
        this.advertised_cap = advertised_cap;
    }

    public String getReceived_cap() {
        return received_cap;
    }

    public void setReceived_cap(String received_cap) {
        this.received_cap = received_cap;
    }

    public Integer getPeer_holddown() {
        return peer_holddown;
    }

    public void setPeer_holddown(Integer peer_holddown) {
        this.peer_holddown = peer_holddown;
    }

    public Integer getLocal_holddown() {
        return local_holddown;
    }

    public void setLocal_holddown(Integer local_holddown) {
        this.local_holddown = local_holddown;
    }

    public Integer getBmp_down_reason() {
        return bmp_down_reason;
    }

    public void setBmp_down_reason(Integer bmp_down_reason) {
        this.bmp_down_reason = bmp_down_reason;
    }

    public Integer getBgp_error_code() {
        return bgp_error_code;
    }

    public void setBgp_error_code(Integer bgp_error_code) {
        this.bgp_error_code = bgp_error_code;
    }

    public Integer getBgp_error_subcode() {
        return bgp_error_subcode;
    }

    public void setBgp_error_subcode(Integer bgp_error_subcode) {
        this.bgp_error_subcode = bgp_error_subcode;
    }

    public String getBgp_error_text() {
        return bgp_error_text;
    }

    public void setBgp_error_text(String bgp_error_text) {
        this.bgp_error_text = bgp_error_text;
    }

    public Boolean getL3VPN() {
        return isL3VPN;
    }

    public void setL3VPN(Boolean l3VPN) {
        isL3VPN = l3VPN;
    }

    public Boolean getPrePolicy() {
        return isPrePolicy;
    }

    public void setPrePolicy(Boolean prePolicy) {
        isPrePolicy = prePolicy;
    }

    public Boolean getIPv4() {
        return isIPv4;
    }

    public void setIPv4(Boolean IPv4) {
        isIPv4 = IPv4;
    }

    public Boolean getLocRib() {
        return isLocRib;
    }

    public void setLocRib(Boolean locRib) {
        isLocRib = locRib;
    }

    public Boolean getLocalRibFiltered() {
        return isLocalRibFiltered;
    }

    public void setLocalRibFiltered(Boolean localRibFiltered) {
        isLocalRibFiltered = localRibFiltered;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }
}

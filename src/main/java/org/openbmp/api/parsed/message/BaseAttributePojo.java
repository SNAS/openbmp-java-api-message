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
 * POJO for openbmp.parsed.base_attribute record
 */
public class BaseAttributePojo {

    private Boolean isWithdrawn;             // action
    private BigInteger sequence;
    private String hash;
    private String router_hash;
    private String router_ip;
    private String peer_hash;
    private String peer_ip;
    private Long peer_asn;
    private String timestamp;
    private String origin;
    private String as_path;
    private Integer as_path_len;
    private Long origin_asn;
    private String next_hop;
    private Long med;
    private Long local_pref;
    private String aggregator;
    private String community_list;
    private String ext_community_list;
    private String cluster_list;
    private Boolean isAtomicAggregate;
    private Boolean isNextHopIpv4;
    private String originator_id;
    private String large_community_list;

    public BaseAttributePojo() {
        isWithdrawn = false;
        sequence = BigInteger.ZERO;
        peer_asn = 0L;
        as_path_len = 0;
        origin_asn = 0L;
        med = 0L;
        local_pref = 0L;
        isAtomicAggregate = false;
        isNextHopIpv4 = false;
    }

    public Boolean getWithdrawn() {
        return isWithdrawn;
    }

    public void setWithdrawn(Boolean withdrawn) {
        isWithdrawn = withdrawn;
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

    public String getRouter_ip() {
        return router_ip;
    }

    public void setRouter_ip(String router_ip) {
        this.router_ip = router_ip;
    }

    public String getPeer_hash() {
        return peer_hash;
    }

    public void setPeer_hash(String peer_hash) {
        this.peer_hash = peer_hash;
    }

    public String getPeer_ip() {
        return peer_ip;
    }

    public void setPeer_ip(String peer_ip) {
        this.peer_ip = peer_ip;
    }

    public Long getPeer_asn() {
        return peer_asn;
    }

    public void setPeer_asn(Long peer_asn) {
        this.peer_asn = peer_asn;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAs_path() {
        return as_path;
    }

    public void setAs_path(String as_path) {
        this.as_path = as_path;
    }

    public Integer getAs_path_len() {
        return as_path_len;
    }

    public void setAs_path_len(Integer as_path_len) {
        this.as_path_len = as_path_len;
    }

    public Long getOrigin_asn() {
        return origin_asn;
    }

    public void setOrigin_asn(Long origin_asn) {
        this.origin_asn = origin_asn;
    }

    public String getNext_hop() {
        return next_hop;
    }

    public void setNext_hop(String next_hop) {
        this.next_hop = next_hop;
    }

    public Long getMed() {
        return med;
    }

    public void setMed(Long med) {
        this.med = med;
    }

    public Long getLocal_pref() {
        return local_pref;
    }

    public void setLocal_pref(Long local_pref) {
        this.local_pref = local_pref;
    }

    public String getAggregator() {
        return aggregator;
    }

    public void setAggregator(String aggregator) {
        this.aggregator = aggregator;
    }

    public String getCommunity_list() {
        return community_list;
    }

    public void setCommunity_list(String community_list) {
        this.community_list = community_list;
    }

    public String getExt_community_list() {
        return ext_community_list;
    }

    public void setExt_community_list(String ext_community_list) {
        this.ext_community_list = ext_community_list;
    }

    public String getCluster_list() {
        return cluster_list;
    }

    public void setCluster_list(String cluster_list) {
        this.cluster_list = cluster_list;
    }

    public Boolean getAtomicAggregate() {
        return isAtomicAggregate;
    }

    public void setAtomicAggregate(Boolean atomicAggregate) {
        isAtomicAggregate = atomicAggregate;
    }

    public Boolean getNextHopIpv4() {
        return isNextHopIpv4;
    }

    public void setNextHopIpv4(Boolean nextHopIpv4) {
        isNextHopIpv4 = nextHopIpv4;
    }

    public String getOriginator_id() {
        return originator_id;
    }

    public void setOriginator_id(String originator_id) {
        this.originator_id = originator_id;
    }

    public String getLarge_community_list() {
        return large_community_list;
    }

    public void setLarge_community_list(String large_community_list) {
        this.large_community_list = large_community_list;
    }
}

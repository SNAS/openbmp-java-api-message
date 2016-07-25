package org.openbmp.api.parsed.message;
/*
 * Copyright (c) 2015-2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

import org.openbmp.api.helpers.IpAddr;
import org.openbmp.api.parsed.processor.ParseLongEmptyAsZero;
import org.openbmp.api.parsed.processor.ParseNullAsEmpty;
import org.openbmp.api.parsed.processor.ParseTimestamp;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Format class for ls_link parsed messages (openbmp.parsed.ls_link)
 *
 * Schema Version: 1.2
 *
 */
public class LsLink extends Base {

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param version       Float representation of maximum message bus specification version supported.
     *                          See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details.
     * @param data          TSV data (MUST not include the headers)
     */
    public LsLink(Float version, String data) {
        super();

        spec_version = version;

        if (version >= 1.2) {
            headerNames = new String[]{"action", "seq", "hash", "base_attr_hash", "router_hash", "router_ip", "peer_hash", "peer_ip",
                    "peer_asn", "timestamp", "igp_router_id", "router_id", "routing_id", "ls_id",
                    "ospf_area_id", "isis_area_id", "protocol", "as_path", "local_pref", "med", "nexthop",
                    "mt_id", "local_link_id", "remote_link_id", "intf_ip", "nei_ip", "igp_metric",
                    "admin_group", "max_link_bw", "max_resv_bw", "unresv_bw", "te_default_metric",
                    "link_protection", "mpls_proto_mask", "srlg", "link_name", "remote_node_hash",
                    "local_node_hash", "remote_igp_router_id", "remote_router_id", "local_node_asn",
                    "remote_node_asn", "peer_node_sid"};
        }
        else {
            headerNames = new String[]{"action", "seq", "hash", "base_attr_hash", "router_hash", "router_ip", "peer_hash", "peer_ip",
                    "peer_asn", "timestamp", "igp_router_id", "router_id", "routing_id", "ls_id",
                    "ospf_area_id", "isis_area_id", "protocol", "as_path", "local_pref", "med", "nexthop",
                    "mt_id", "local_link_id", "remote_link_id", "intf_ip", "nei_ip", "igp_metric",
                    "admin_group", "max_link_bw", "max_resv_bw", "unresv_bw", "te_default_metric",
                    "link_protection", "mpls_proto_mask", "srlg", "link_name", "remote_node_hash",
                    "local_node_hash"};
        }

        parse(version, data);
    }

    /**
     * Processors used for each field.
     *
     * Order matters and must match the same order as defined in headerNames
     *
     * @return array of cell processors
     */
    protected CellProcessor[] getProcessors() {

        final CellProcessor[] processors;

        if (spec_version >= 1.2) {
            processors = new CellProcessor[]{
                    new NotNull(),                  // action
                    new ParseLong(),                // seq
                    new NotNull(),                  // hash
                    new NotNull(),                  // base_hash
                    new NotNull(),                  // router_hash
                    new NotNull(),                  // router_ip
                    new NotNull(),                  // peer_hash
                    new NotNull(),                  // peer_ip
                    new ParseLong(),                // peer_asn
                    new ParseTimestamp(),           // timestamp
                    new ParseNullAsEmpty(),         // igp_router_id
                    new ParseNullAsEmpty(),         // router_id
                    new ParseNullAsEmpty(),         // routing_id
                    new ParseLongEmptyAsZero(),     // ls_id
                    new ParseNullAsEmpty(),         // ospf_area_id
                    new ParseNullAsEmpty(),         // isis_area_id
                    new ParseNullAsEmpty(),         // protocol
                    new ParseNullAsEmpty(),         // as_path
                    new ParseLongEmptyAsZero(),     // local_pref
                    new ParseLongEmptyAsZero(),     // med
                    new ParseNullAsEmpty(),         // nexthop
                    new ParseNullAsEmpty(),         // mt_id
                    new ParseLongEmptyAsZero(),     // local_link_id
                    new ParseLongEmptyAsZero(),     // remote_link_id
                    new ParseNullAsEmpty(),         // intf_ip
                    new ParseNullAsEmpty(),         // nei_ip
                    new ParseLongEmptyAsZero(),     // igp_metric
                    new ParseLongEmptyAsZero(),     // admin_group
                    new ParseNullAsEmpty(),         // max_link_bw
                    new ParseNullAsEmpty(),         // max_resv_bw
                    new ParseNullAsEmpty(),         // unresv_bw
                    new ParseLongEmptyAsZero(),     // te_default_metric
                    new ParseNullAsEmpty(),         // link_protection
                    new ParseNullAsEmpty(),         // mpls_proto_mask
                    new ParseNullAsEmpty(),         // srlg
                    new ParseNullAsEmpty(),         // link_name
                    new ParseNullAsEmpty(),         // remote_node_hash
                    new ParseNullAsEmpty(),         // local_node_hash
                    new ParseNullAsEmpty(),         // remote_igp_router_id
                    new ParseNullAsEmpty(),         // remote_router_id
                    new ParseLongEmptyAsZero(),     // local_node_asn
                    new ParseLongEmptyAsZero(),     // remote_node_asn
                    new ParseNullAsEmpty()          // Peer node SID
                };
        }
        else {
            processors = new CellProcessor[]{
                    new NotNull(),                  // action
                    new ParseLong(),                // seq
                    new NotNull(),                  // hash
                    new NotNull(),                  // base_hash
                    new NotNull(),                  // router_hash
                    new NotNull(),                  // router_ip
                    new NotNull(),                  // peer_hash
                    new NotNull(),                  // peer_ip
                    new ParseLong(),                // peer_asn
                    new ParseTimestamp(),           // timestamp
                    new ParseNullAsEmpty(),         // igp_router_id
                    new ParseNullAsEmpty(),         // router_id
                    new ParseNullAsEmpty(),         // routing_id
                    new ParseLongEmptyAsZero(),     // ls_id
                    new ParseNullAsEmpty(),         // ospf_area_id
                    new ParseNullAsEmpty(),         // isis_area_id
                    new ParseNullAsEmpty(),         // protocol
                    new ParseNullAsEmpty(),         // as_path
                    new ParseLongEmptyAsZero(),     // local_pref
                    new ParseLongEmptyAsZero(),     // med
                    new ParseNullAsEmpty(),         // nexthop
                    new ParseNullAsEmpty(),         // mt_id
                    new ParseLongEmptyAsZero(),     // local_link_id
                    new ParseLongEmptyAsZero(),     // remote_link_id
                    new ParseNullAsEmpty(),         // intf_ip
                    new ParseNullAsEmpty(),         // nei_ip
                    new ParseLongEmptyAsZero(),     // igp_metric
                    new ParseLongEmptyAsZero(),     // admin_group
                    new ParseNullAsEmpty(),         // max_link_bw
                    new ParseNullAsEmpty(),         // max_resv_bw
                    new ParseNullAsEmpty(),         // unresv_bw
                    new ParseLongEmptyAsZero(),     // te_default_metric
                    new ParseNullAsEmpty(),         // link_protection
                    new ParseNullAsEmpty(),         // mpls_proto_mask
                    new ParseNullAsEmpty(),         // srlg
                    new ParseNullAsEmpty(),         // link_name
                    new ParseNullAsEmpty(),         // remote_node_hash
                    new ParseNullAsEmpty()         // local_node_hash
            };
        }

        return processors;
    }
}

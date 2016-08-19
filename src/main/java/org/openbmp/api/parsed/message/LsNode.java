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
 * Format class for ls_node parsed messages (openbmp.parsed.ls_node)
 *
 * Schema Version: 1.3
 *
 */
public class LsNode extends Base {

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param version       Float representation of maximum message bus specification version supported.
     *                          See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details.
     * @param data          TSV data (MUST not include the headers)
     */
    public LsNode(Float version, String data) {
        super();

        spec_version = version;

        if (version.compareTo((float) 1.3) >= 0) {
            headerNames = new String[]{"action", "seq", "hash", "base_attr_hash", "router_hash", "router_ip", "peer_hash", "peer_ip",
                                       "peer_asn", "timestamp", "igp_router_id", "router_id", "routing_id", "ls_id", "mt_id",
                                       "ospf_area_id", "isis_area_id", "protocol", "flags", "as_path", "local_pref",
                                       "med", "nexthop", "name", "isPrePolicy", "isAdjRibIn"};
        }
        else {
            headerNames = new String[]{ "action", "seq", "hash", "base_attr_hash", "router_hash", "router_ip", "peer_hash", "peer_ip",
                                        "peer_asn", "timestamp", "igp_router_id", "router_id", "routing_id", "ls_id", "mt_id",
                                        "ospf_area_id", "isis_area_id", "protocol", "flags", "as_path", "local_pref",
                                        "med", "nexthop", "name"};
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

        if (spec_version.compareTo((float) 1.3) >= 0) {
            processors = new CellProcessor[] {
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
                    new ParseNullAsEmpty(),         // mt_id
                    new ParseNullAsEmpty(),         // ospf_area_id
                    new ParseNullAsEmpty(),         // isis_area_id
                    new ParseNullAsEmpty(),         // protocol
                    new ParseNullAsEmpty(),         // flags
                    new ParseNullAsEmpty(),         // as_path
                    new ParseLongEmptyAsZero(),     // local_pref
                    new ParseLongEmptyAsZero(),     // med
                    new ParseNullAsEmpty(),         // nexthop
                    new ParseNullAsEmpty(),         // name
                    new ParseLongEmptyAsZero(),     // isPrePolicy
                    new ParseLongEmptyAsZero()      // isAdjRibIn
            };
        }
        else {
            processors = new CellProcessor[] {
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
                    new ParseNullAsEmpty(),         // mt_id
                    new ParseNullAsEmpty(),         // ospf_area_id
                    new ParseNullAsEmpty(),         // isis_area_id
                    new ParseNullAsEmpty(),         // protocol
                    new ParseNullAsEmpty(),         // flags
                    new ParseNullAsEmpty(),         // as_path
                    new ParseLongEmptyAsZero(),     // local_pref
                    new ParseLongEmptyAsZero(),     // med
                    new ParseNullAsEmpty(),         // nexthop
                    new ParseNullAsEmpty()          // name
            };
        }

        return processors;
    }
}

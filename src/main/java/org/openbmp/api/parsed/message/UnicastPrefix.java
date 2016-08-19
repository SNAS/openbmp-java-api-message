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
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.ArrayList;

/**
 * Format class for unicast_prefix parsed messages (openbmp.parsed.unicast_prefix)
 *
 * Schema Version: 1.3
 *
 */
public class UnicastPrefix extends Base {

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param version       Float representation of maximum message bus specification version supported.
     *                          See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details.
     * @param data          TSV data (MUST not include the headers)
     */
    public UnicastPrefix(Float version, String data) {
        super();

        spec_version = version;

        if (version.compareTo((float) 1.3) >= 0)  {

            headerNames = new String[]{"action", "seq", "hash", "router_hash", "router_ip", "base_attr_hash", "peer_hash",
                    "peer_ip", "peer_asn", "timestamp", "prefix", "prefix_len", "isIPv4",
                    "origin", "as_path", "as_path_count", "origin_as",
                    "nexthop", "med", "local_pref", "aggregator", "community_list", "ext_community_list",
                    "cluster_list", "isAtomicAgg", "isNexthopIPv4", "originator_id",
                    "path_id", "labels", "isPrePolicy", "isAdjRibIn"};

        } else if (version.compareTo((float) 1.1) >= 0)  {

                headerNames = new String[]{"action", "seq", "hash", "router_hash", "router_ip", "base_attr_hash", "peer_hash",
                        "peer_ip", "peer_asn", "timestamp", "prefix", "prefix_len", "isIPv4",
                        "origin", "as_path", "as_path_count", "origin_as",
                        "nexthop", "med", "local_pref", "aggregator", "community_list", "ext_community_list",
                        "cluster_list", "isAtomicAgg", "isNexthopIPv4", "originator_id",
                        "path_id", "labels"};

        } else {
            headerNames = new String[]{"action", "seq", "hash", "router_hash", "router_ip", "base_attr_hash", "peer_hash",
                    "peer_ip", "peer_asn", "timestamp", "prefix", "prefix_len", "isIPv4",
                    "origin", "as_path", "as_path_count", "origin_as",
                    "nexthop", "med", "local_pref", "aggregator", "community_list", "ext_community_list",
                    "cluster_list", "isAtomicAgg", "isNexthopIPv4", "originator_id"};
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

        CellProcessor[] processors;

        if (spec_version.compareTo((float) 1.3) >= 0) {
            processors = new CellProcessor[] {
                    new NotNull(),                      // action
                    new ParseLong(),                    // seq
                    new NotNull(),                      // hash
                    new NotNull(),                      // router hash
                    new NotNull(),                      // router_ip
                    new ParseNullAsEmpty(),             // base_attr_hash
                    new NotNull(),                      // peer_hash
                    new NotNull(),                      // peer_ip
                    new ParseLong(),                    // peer_asn
                    new ParseTimestamp(),               // timestamp
                    new NotNull(),                      // prefix
                    new ParseInt(),                     // prefix_len
                    new ParseInt(),                     // isIPv4
                    new ParseNullAsEmpty(),             // origin
                    new ParseNullAsEmpty(),             // as_path
                    new ParseLongEmptyAsZero(),         // as_path_count
                    new ParseLongEmptyAsZero(),         // origin_as
                    new ParseNullAsEmpty(),             // nexthop
                    new ParseLongEmptyAsZero(),         // med
                    new ParseLongEmptyAsZero(),         // local_pref
                    new ParseNullAsEmpty(),             // aggregator
                    new ParseNullAsEmpty(),             // community_list
                    new ParseNullAsEmpty(),             // ext_community_list
                    new ParseNullAsEmpty(),             // cluster_list
                    new ParseLongEmptyAsZero(),         // isAtomicAgg
                    new ParseLongEmptyAsZero(),         // isNexthopIPv4
                    new ParseNullAsEmpty(),             // originator_id
                    new ParseLongEmptyAsZero(),         // Path ID
                    new ParseNullAsEmpty(),             // Labels
                    new ParseLongEmptyAsZero(),         // isPrePolicy
                    new ParseLongEmptyAsZero()          // isAdjRibIn
            };
        }

        else if (spec_version.compareTo((float) 1.1) >= 0) {
            processors = new CellProcessor[] {
                    new NotNull(),                      // action
                    new ParseLong(),                    // seq
                    new NotNull(),                      // hash
                    new NotNull(),                      // router hash
                    new NotNull(),                      // router_ip
                    new ParseNullAsEmpty(),             // base_attr_hash
                    new NotNull(),                      // peer_hash
                    new NotNull(),                      // peer_ip
                    new ParseLong(),                    // peer_asn
                    new ParseTimestamp(),               // timestamp
                    new NotNull(),                      // prefix
                    new ParseInt(),                     // prefix_len
                    new ParseInt(),                     // isIPv4
                    new ParseNullAsEmpty(),             // origin
                    new ParseNullAsEmpty(),             // as_path
                    new ParseLongEmptyAsZero(),         // as_path_count
                    new ParseLongEmptyAsZero(),         // origin_as
                    new ParseNullAsEmpty(),             // nexthop
                    new ParseLongEmptyAsZero(),         // med
                    new ParseLongEmptyAsZero(),         // local_pref
                    new ParseNullAsEmpty(),             // aggregator
                    new ParseNullAsEmpty(),             // community_list
                    new ParseNullAsEmpty(),             // ext_community_list
                    new ParseNullAsEmpty(),             // cluster_list
                    new ParseLongEmptyAsZero(),         // isAtomicAgg
                    new ParseLongEmptyAsZero(),         // isNexthopIPv4
                    new ParseNullAsEmpty(),             // originator_id
                    new ParseLongEmptyAsZero(),         // Path ID
                    new ParseNullAsEmpty()              // Labels
            };
        }
        else {
            processors = new CellProcessor[] {
                    new NotNull(),                      // action
                    new ParseLong(),                    // seq
                    new NotNull(),                      // hash
                    new NotNull(),                      // router hash
                    new NotNull(),                      // router_ip
                    new ParseNullAsEmpty(),             // base_attr_hash
                    new NotNull(),                      // peer_hash
                    new NotNull(),                      // peer_ip
                    new ParseLong(),                    // peer_asn
                    new ParseTimestamp(),               // timestamp
                    new NotNull(),                      // prefix
                    new ParseInt(),                     // prefix_len
                    new ParseInt(),                     // isIPv4
                    new ParseNullAsEmpty(),             // origin
                    new ParseNullAsEmpty(),             // as_path
                    new ParseLongEmptyAsZero(),         // as_path_count
                    new ParseLongEmptyAsZero(),         // origin_as
                    new ParseNullAsEmpty(),             // nexthop
                    new ParseLongEmptyAsZero(),         // med
                    new ParseLongEmptyAsZero(),         // local_pref
                    new ParseNullAsEmpty(),             // aggregator
                    new ParseNullAsEmpty(),             // community_list
                    new ParseNullAsEmpty(),             // ext_community_list
                    new ParseNullAsEmpty(),             // cluster_list
                    new ParseLongEmptyAsZero(),         // isAtomicAgg
                    new ParseLongEmptyAsZero(),         // isNexthopIPv4
                    new ParseNullAsEmpty()              // originator_id
            };
        }

        return processors;
    }
}

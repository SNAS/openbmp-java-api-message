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

        // Minimum set of headers each Object will have.
        String [] minimumHeaderNames = new String[]{HeaderDefault.action.toString(),HeaderDefault.seq.toString(),HeaderDefault.hash.toString(),HeaderDefault.router_hash.toString(),HeaderDefault.router_ip.toString(),
        		HeaderDefault.base_attr_hash.toString(),HeaderDefault.peer_hash.toString(),HeaderDefault.peer_ip.toString(),HeaderDefault.peer_asn.toString(),HeaderDefault.timestamp.toString(),
        		HeaderDefault.prefix.toString(),HeaderDefault.prefix_len.toString(),HeaderDefault.isIPv4.toString(),HeaderDefault.origin.toString(),HeaderDefault.as_path.toString(),
        		HeaderDefault.as_path_count.toString(),HeaderDefault.origin_as.toString(),HeaderDefault.nexthop.toString(),HeaderDefault.med.toString(),HeaderDefault.local_pref.toString(),
        		HeaderDefault.aggregator.toString(),HeaderDefault.community_list.toString(),HeaderDefault.ext_community_list.toString(),HeaderDefault.cluster_list.toString(),HeaderDefault.isAtomicAgg.toString(),
        		HeaderDefault.isNexthopIPv4.toString(),HeaderDefault.originator_id.toString()};
        
        
        if (version.compareTo((float) 1.3) >= 0)  {

        		//headers specific to v1.3 or greater
        		String versionSpecificHeaders [] = new String[]{HeaderDefault.path_id.toString(),HeaderDefault.labels.toString(),HeaderDefault.isPrePolicy.toString(),HeaderDefault.isAdjRibIn.toString()};
        		
        		headerNames = new String[minimumHeaderNames.length+versionSpecificHeaders.length];
        		System.arraycopy(minimumHeaderNames, 0, headerNames, 0, minimumHeaderNames.length);
        		System.arraycopy(versionSpecificHeaders, 0, headerNames, minimumHeaderNames.length, versionSpecificHeaders.length);

        } else if (version.compareTo((float) 1.1) >= 0)  {
        		
        		// headers specifoc to v1.1 or greater
        		String versionSpecificHeaders [] = new String[]{HeaderDefault.path_id.toString(),HeaderDefault.labels.toString()};
        		
        		headerNames = new String[minimumHeaderNames.length+versionSpecificHeaders.length];
        		System.arraycopy(minimumHeaderNames, 0, headerNames, 0, minimumHeaderNames.length);
        		System.arraycopy(versionSpecificHeaders, 0, headerNames, minimumHeaderNames.length, versionSpecificHeaders.length);

        } else {
        	
            headerNames = minimumHeaderNames;
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

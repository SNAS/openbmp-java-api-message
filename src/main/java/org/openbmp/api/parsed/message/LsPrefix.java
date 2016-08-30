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

/**
 * Format class for ls_prefix parsed messages (openbmp.parsed.ls_prefix)
 *
 * Schema Version: 1.2
 *
 */
public class LsPrefix extends Base {

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param version       Float representation of maximum message bus specification version supported.
     *                          See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details.
     * @param data          TSV data (MUST not include the headers)
     */
    public LsPrefix(Float version, String data) {
        super();

        spec_version = version;
        
        // Minimum set of headers each Object will have.
        String [] minimumHeaderNames = new String[]{HeaderDefault.action.toString(),HeaderDefault.seq.toString(),HeaderDefault.hash.toString(),HeaderDefault.base_attr_hash.toString(),HeaderDefault.router_hash.toString(),
									        		HeaderDefault.router_ip.toString(),HeaderDefault.peer_hash.toString(),HeaderDefault.peer_ip.toString(),HeaderDefault.peer_asn.toString(),HeaderDefault.timestamp.toString(),
									        		HeaderDefault.igp_router_id.toString(),HeaderDefault.router_id.toString(),HeaderDefault.routing_id.toString(),HeaderDefault.ls_id.toString(),HeaderDefault.ospf_area_id.toString(),
									        		HeaderDefault.isis_area_id.toString(),HeaderDefault.protocol.toString(),HeaderDefault.as_path.toString(),HeaderDefault.local_pref.toString(),HeaderDefault.med.toString(),
									        		HeaderDefault.nexthop.toString(),HeaderDefault.local_node_hash.toString(),HeaderDefault.mt_id.toString(),HeaderDefault.ospf_route_type.toString(),HeaderDefault.igp_flags.toString(),
									        		HeaderDefault.route_tag.toString(),HeaderDefault.ext_route_tag.toString(),HeaderDefault.ospf_fwd_addr.toString(),HeaderDefault.igp_metric.toString(),HeaderDefault.prefix.toString(),
									        		HeaderDefault.prefix_len.toString()};

        if (version.compareTo((float) 1.3) >= 0)  {
        	
        	//headers specific to v1.3
        	String versionSpecificHeaders [] = new String[]{HeaderDefault.isPrePolicy.toString(),HeaderDefault.isAdjRibIn.toString()};
    		
    		headerNames = new String[minimumHeaderNames.length + versionSpecificHeaders.length];
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
                    new ParseNullAsEmpty(),         // ospf_area_id
                    new ParseNullAsEmpty(),         // isis_area_id
                    new ParseNullAsEmpty(),         // protocol
                    new ParseNullAsEmpty(),         // as_path
                    new ParseLongEmptyAsZero(),     // local_pref
                    new ParseLongEmptyAsZero(),     // med
                    new ParseNullAsEmpty(),         // nexthop
                    new ParseNullAsEmpty(),         // local_node_hash
                    new ParseNullAsEmpty(),         // mt_id
                    new ParseNullAsEmpty(),         // ospf_route_type
                    new ParseNullAsEmpty(),         // igp_flags
                    new ParseLongEmptyAsZero(),     // route_tag
                    new ParseLongEmptyAsZero(),     // ext_route_tag
                    new ParseNullAsEmpty(),         // ospf_fwd_addr
                    new ParseLongEmptyAsZero(),     // igp_metric
                    new NotNull(),                  // prefix
                    new ParseInt(),                 // prefix_len
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
                    new ParseNullAsEmpty(),         // ospf_area_id
                    new ParseNullAsEmpty(),         // isis_area_id
                    new ParseNullAsEmpty(),         // protocol
                    new ParseNullAsEmpty(),         // as_path
                    new ParseLongEmptyAsZero(),     // local_pref
                    new ParseLongEmptyAsZero(),     // med
                    new ParseNullAsEmpty(),         // nexthop
                    new ParseNullAsEmpty(),         // local_node_hash
                    new ParseNullAsEmpty(),         // mt_id
                    new ParseNullAsEmpty(),         // ospf_route_type
                    new ParseNullAsEmpty(),         // igp_flags
                    new ParseLongEmptyAsZero(),     // route_tag
                    new ParseLongEmptyAsZero(),     // ext_route_tag
                    new ParseNullAsEmpty(),         // ospf_fwd_addr
                    new ParseLongEmptyAsZero(),     // igp_metric
                    new NotNull(),                  // prefix
                    new ParseInt()                  // prefix_len
            };
        }

        return processors;
    }

}

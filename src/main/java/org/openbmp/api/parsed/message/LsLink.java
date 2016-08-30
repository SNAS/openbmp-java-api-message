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
 * Schema Version: 1.3
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
        
        // Minimum set of headers each Object will have. 
        String [] minimumHeaderNames = new String[]{HeaderDefault.action.toString(),HeaderDefault.seq.toString(),HeaderDefault.hash.toString(),HeaderDefault.base_attr_hash.toString(),HeaderDefault.router_hash.toString(),
												   HeaderDefault.router_ip.toString(),HeaderDefault.peer_hash.toString(),HeaderDefault.peer_ip.toString(),HeaderDefault.peer_asn.toString(),HeaderDefault.timestamp.toString(),
												   HeaderDefault.igp_router_id.toString(),HeaderDefault.router_id.toString(),HeaderDefault.routing_id.toString(),HeaderDefault.ls_id.toString(),HeaderDefault.ospf_area_id.toString(),
												   HeaderDefault.isis_area_id.toString(),HeaderDefault.protocol.toString(),HeaderDefault.as_path.toString(),HeaderDefault.local_pref.toString(),HeaderDefault.med.toString(),
												   HeaderDefault.nexthop.toString(),HeaderDefault.mt_id.toString(),HeaderDefault.local_link_id.toString(),HeaderDefault.remote_link_id.toString(),HeaderDefault.intf_ip.toString(),
												   HeaderDefault.nei_ip.toString(),HeaderDefault.igp_metric.toString(),HeaderDefault.admin_group.toString(),HeaderDefault.max_link_bw.toString(),HeaderDefault.max_resv_bw.toString(),
												   HeaderDefault.unresv_bw.toString(),HeaderDefault.te_default_metric.toString(),HeaderDefault.link_protection.toString(),HeaderDefault.mpls_proto_mask.toString(),
												   HeaderDefault.srlg.toString(),HeaderDefault.link_name.toString(),HeaderDefault.remote_node_hash.toString(),HeaderDefault.local_node_hash.toString()};;

        if (version.compareTo((float) 1.3) >= 0)  {
        	
        	// headers unique to version 1.3
        	String versionSpecificHeaders [] = new String[]{HeaderDefault.remote_igp_router_id.toString(),HeaderDefault.remote_router_id.toString(),HeaderDefault.local_node_asn.toString(),HeaderDefault.remote_node_asn.toString(),
            												HeaderDefault.peer_node_sid.toString(),HeaderDefault.isPrePolicy.toString(),HeaderDefault.isAdjRibIn.toString()};
    		
    		headerNames = new String[minimumHeaderNames.length + versionSpecificHeaders.length];
    		System.arraycopy(minimumHeaderNames, 0, headerNames, 0, minimumHeaderNames.length);
    		System.arraycopy(versionSpecificHeaders, 0, headerNames, minimumHeaderNames.length, versionSpecificHeaders.length);
        	
        	
        }else if (version.compareTo((float) 1.2) >= 0)  {
        	
        	
        	// headers unique to version 1.2
        	String versionSpecificHeaders [] = new String[]{HeaderDefault.remote_igp_router_id.toString(),HeaderDefault.remote_router_id.toString(),HeaderDefault.local_node_asn.toString(),HeaderDefault.remote_node_asn.toString(),
            												HeaderDefault.peer_node_sid.toString()};

        	headerNames = new String[minimumHeaderNames.length+versionSpecificHeaders.length];
			System.arraycopy(minimumHeaderNames, 0, headerNames, 0, minimumHeaderNames.length);
			System.arraycopy(versionSpecificHeaders, 0, headerNames, minimumHeaderNames.length, versionSpecificHeaders.length);
            
        }else {
        	
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
                    new ParseNullAsEmpty(),         // Peer node SID
                    new ParseLongEmptyAsZero(),     // isPrePolicy
                    new ParseLongEmptyAsZero()      // isAdjRibIn
            };
        }

        else if (spec_version.compareTo((float) 1.2) >= 0) {
            System.out.println("spec version is >= 1.2: " + spec_version);
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

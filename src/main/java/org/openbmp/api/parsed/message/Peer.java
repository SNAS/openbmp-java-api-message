package org.openbmp.api.parsed.message;
/*
 * Copyright (c) 2015-2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

import org.openbmp.api.parsed.processor.ParseLongEmptyAsZero;
import org.openbmp.api.parsed.processor.ParseNullAsEmpty;
import org.openbmp.api.parsed.processor.ParseTimestamp;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Format class for peer parsed messages (openbmp.parsed.peer)
 *
 * Schema Version: 1.3
 *
 */
public class Peer extends Base {

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param data
     */
    public Peer(String data) {
        super();
        
        headerNames = new String [] { HeaderDefault.action.toString(),HeaderDefault.seq.toString(),HeaderDefault.hash.toString(),HeaderDefault.router_hash.toString(),HeaderDefault.name.toString(),
					        		HeaderDefault.remote_bgp_id.toString(),HeaderDefault.router_ip.toString(),HeaderDefault.timestamp.toString(),HeaderDefault.remote_asn.toString(),
					        		HeaderDefault.remote_ip.toString(),HeaderDefault.peer_rd.toString(),HeaderDefault.remote_port.toString(),HeaderDefault.local_asn.toString(),
					        		HeaderDefault.local_ip.toString(),HeaderDefault.local_port.toString(),HeaderDefault.local_bgp_id.toString(),HeaderDefault.info_data.toString(),HeaderDefault.adv_cap.toString(),
					        		HeaderDefault.recv_cap.toString(),HeaderDefault.remote_holddown.toString(),HeaderDefault.adv_holddown.toString(),HeaderDefault.bmp_reason.toString(),
					        		HeaderDefault.bgp_error_code.toString(),HeaderDefault.bgp_error_sub_code.toString(),HeaderDefault.error_text.toString(),HeaderDefault.isL3VPN.toString(),
					        		HeaderDefault.isPrePolicy.toString(),HeaderDefault.isIPv4.toString()};

        // TODO: Change below to supply version when version is required
        parse(data);
    }

    /**
     * Processors used for each field.
     *
     * Order matters and must match the same order as defined in headerNames
     *
     * @return array of cell processors
     */
    protected CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(),                      // action
                new ParseLong(),                    // seq
                new NotNull(),                      // hash
                new NotNull(),                      // router hash
                new ParseNullAsEmpty(),             // name
                new NotNull(),                      // remote_bgp_id
                new NotNull(),                      // router_ip
                new ParseTimestamp(),               // Timestamp
                new ParseLong(),                    // remote_asn
                new NotNull(),                      // remote_ip
                new ParseNullAsEmpty(),             // peer_rd
                new ParseLongEmptyAsZero(),         // remote_port
                new ParseLongEmptyAsZero(),         // local_asn
                new ParseNullAsEmpty(),             // local_ip
                new ParseLongEmptyAsZero(),         // local_port
                new ParseNullAsEmpty(),             // local_bgp_id
                new ParseNullAsEmpty(),             // info_data
                new ParseNullAsEmpty(),             // adv_cap
                new ParseNullAsEmpty(),             // recv_cap,
                new ParseLongEmptyAsZero(),         // remote_holddown
                new ParseLongEmptyAsZero(),         // local_holddown
                new ParseLongEmptyAsZero(),         // bmp_reason
                new ParseLongEmptyAsZero(),         // bgp_error_code
                new ParseLongEmptyAsZero(),         // bgp_error_sub_code
                new ParseNullAsEmpty(),             // error_text
                new ParseLongEmptyAsZero(),         // isL3VPN
                new ParseLongEmptyAsZero(),         // isPrePolicy
                new ParseLongEmptyAsZero()          // isIPv4
        };

        return processors;
    }
}

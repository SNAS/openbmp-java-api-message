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
 * Schema Version: 1.2
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
        headerNames = new String [] { "action", "seq", "hash", "router_hash", "name", "remote_bgp_id", "router_ip",
                                      "timestamp", "remote_asn", "remote_ip", "peer_rd", "remote_port", "local_asn",
                                      "local_ip", "local_port", "local_bgp_id", "info_data", "adv_cap", "recv_cap",
                                      "remote_holddown", "adv_holddown", "bmp_reason", "bgp_error_code",
                                      "bgp_error_sub_code", "error_text", "isL3VPN", "isPrePolicy", "isIPv4"};

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

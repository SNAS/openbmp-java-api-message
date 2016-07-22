package org.openbmp.api.parsed.message;
/*
 * Copyright (c) 2015-2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

import org.openbmp.api.parsed.processor.ParseTimestamp;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Format class for bmp_stat parsed messages (openbmp.parsed.bmp_stat)
 *
 * Schema Version: 1.2
 *
 */
public class BmpStat extends Base {

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param data
     */
    public BmpStat(String data) {
        super();
        headerNames = new String [] { "action", "seq", "router_hash", "router_ip", "peer_hash", "peer_ip",
                                      "peer_asn", "timestamp", "rejected", "known_dup_updates", "known_dup_withdraws",
                                      "invalid_cluster_list", "invalid_as_path", "invalid_originator",
                                      "invalid_as_confed", "pre_policy", "post_policy"};

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
                new NotNull(),          // action
                new ParseLong(),        // seq
                new NotNull(),          // hash
                new NotNull(),          // router_ip
                new NotNull(),          // peer_hash
                new NotNull(),          // peer_ip,
                new ParseLong(),        // peer_asn
                new ParseTimestamp(),   // Timestamp
                new NotNull(),          // rejected
                new NotNull(),          // known_dup_updates
                new NotNull(),          // known_dup_withdraws
                new NotNull(),          // invalid_cluster_list
                new NotNull(),          // invalid_as_path
                new NotNull(),          // invalid_originator
                new NotNull(),          // invalid_as_confed
                new NotNull(),          // pre_policy
                new NotNull()           // post_policy
        };

        return processors;
    }

}

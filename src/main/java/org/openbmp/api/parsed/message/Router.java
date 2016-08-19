package org.openbmp.api.parsed.message;
/*
 * Copyright (c) 2015-2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */
import org.openbmp.api.parsed.processor.ParseNullAsEmpty;
import org.openbmp.api.parsed.processor.ParseTimestamp;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Format class for router parsed messages (openbmp.parsed.router)
 *
 * Schema Version: 1.2
 *
 */
public class Router extends Base {

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param version       Float representation of maximum message bus specification version supported.
     *                          See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details.
     * @param data          TSV data (MUST not include the headers)
     */
    public Router(Float version, String data) {
        super();

        spec_version = version;

        if (version.compareTo((float) 1.2) >= 0)  {
            headerNames = new String[]{"action", "seq", "name", "hash", "ip_address", "description", "term_code",
                    "term_reason", "init_data", "term_data", "timestamp", "bgp_id"};
        }
        else {
            headerNames = new String[]{"action", "seq", "name", "hash", "ip_address", "description", "term_code",
                    "term_reason", "init_data", "term_data", "timestamp"};
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

        if (spec_version.compareTo((float) 1.2) >= 0)  {
            processors = new CellProcessor[]{
                    new NotNull(),                      // action
                    new ParseLong(),                    // seq
                    new ParseNullAsEmpty(),             // name
                    new NotNull(),                      // hash
                    new NotNull(),                      // IP Address
                    new ParseNullAsEmpty(),             // Description
                    new Optional(new ParseInt()),       // Term code
                    new ParseNullAsEmpty(),             // Term reason
                    new ParseNullAsEmpty(),             // Init data
                    new ParseNullAsEmpty(),             // Term data
                    new ParseTimestamp(),               // Timestamp
                    new ParseNullAsEmpty()              // Global BGP-ID for router
            };
        }
        else {
            processors = new CellProcessor[]{
                    new NotNull(),                      // action
                    new ParseLong(),                    // seq
                    new ParseNullAsEmpty(),             // name
                    new NotNull(),                      // hash
                    new NotNull(),                      // IP Address
                    new ParseNullAsEmpty(),             // Description
                    new Optional(new ParseInt()),       // Term code
                    new ParseNullAsEmpty(),             // Term reason
                    new ParseNullAsEmpty(),             // Init data
                    new ParseNullAsEmpty(),             // Term data
                    new ParseTimestamp()                // Timestamp
            };
        }

        return processors;
    }
}

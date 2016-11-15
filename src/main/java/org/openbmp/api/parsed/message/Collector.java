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
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.Map;
import java.util.TimerTask;

/**
 * Format class for collector parsed messages (openbmp.parsed.collector)
 * <p>
 * Schema Version: 1.4
 */
public class Collector extends Base {

    private static Map<String, TimerTask> heartbeatListeners;

    String[] schemaHeaderNames = new String[]{MsgBusFields.ACTION.getName(), MsgBusFields.SEQUENCE.getName(), MsgBusFields.ADMIN_ID.getName(), MsgBusFields.HASH.getName(),
            MsgBusFields.ROUTERS.getName(), MsgBusFields.ROUTER_COUNT.getName(), MsgBusFields.TIMESTAMP.getName()};


    /**
     * base constructor to support backward compatibility. Will run on the {@link Base.DEFAULT_SPEC_VERSION} version.
     *
     * @param data
     */
    public Collector(String data) {
        super();

        headerNames = schemaHeaderNames;

        // TODO: Change below to supply version when version is required
        parse(data);
    }


    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param data
     */
    public Collector(Float version, String data) {
        super();

        spec_version = version;

        //Headers are same upto version 1.2 for this Object. 
        //TODO:: If needed, add additional headers with later version. Refer to {@link LsLink} constructor.
        headerNames = schemaHeaderNames;


        parse(version, data);
    }


    /**
     * Processors used for each field.
     * <p>
     * Order matters and must match the same order as defined in headerNames
     *
     * @return array of cell processors
     */
    protected CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(),          // action
                new ParseLong(),        // seq
                new NotNull(),          // admin id
                new NotNull(),          // hash
                new ParseNullAsEmpty(), // routers
                new ParseInt(),         // router count
                new ParseTimestamp()    // Timestamp
        };

        return processors;
    }

}

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Format class for ls_node parsed messages (openbmp.parsed.ls_node)
 * <p>
 * Schema Version: 1.4
 */
public class LsNode extends Base {

    String[] schemaHeaderNames = new String[]{MsgBusFields.ACTION.getName(), MsgBusFields.SEQUENCE.getName(), MsgBusFields.HASH.getName(), MsgBusFields.BASE_ATTR_HASH.getName(), MsgBusFields.ROUTER_HASH.getName(),
            MsgBusFields.ROUTER_IP.getName(), MsgBusFields.PEER_HASH.getName(), MsgBusFields.PEER_IP.getName(), MsgBusFields.PEER_ASN.getName(), MsgBusFields.TIMESTAMP.getName(),
            MsgBusFields.IGP_ROUTER_ID.getName(), MsgBusFields.ROUTER_ID.getName(), MsgBusFields.ROUTING_ID.getName(), MsgBusFields.LS_ID.getName(), MsgBusFields.MT_ID.getName(),
            MsgBusFields.OSPF_AREA_ID.getName(), MsgBusFields.ISIS_AREA_ID.getName(), MsgBusFields.PROTOCOL.getName(), MsgBusFields.FLAGS.getName(), MsgBusFields.AS_PATH.getName(),
            MsgBusFields.LOCAL_PREF.getName(), MsgBusFields.MED.getName(),
            MsgBusFields.NEXTHOP.getName(), MsgBusFields.NAME.getName(),
            MsgBusFields.ISPREPOLICY.getName(), MsgBusFields.IS_ADJ_RIB_IN.getName(),
            MsgBusFields.LS_SR_CAPABILITIES.getName()};


    /**
     * base constructor to support backward compatibility.
     *
     * @param data
     */
    public LsNode(String data) {
        super();

        headerNames = schemaHeaderNames;

        parse(data);

    }

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param version Float representation of maximum message bus specification version supported.
     *                See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details.
     * @param data    TSV data (MUST not include the headers)
     */
    public LsNode(Float version, String data) {
        super();

        spec_version = version;

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

        final CellProcessor[] processors;

        final CellProcessor[] defaultCellProcessors = new CellProcessor[]{
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
                new ParseLongEmptyAsZero(),         // ls_id
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

        if (spec_version.compareTo((float) 1.4) >= 0) {

            CellProcessor[] versionSpecificProcessors = new CellProcessor[]{
                    new ParseLongEmptyAsZero(),     // isPrePolicy
                    new ParseLongEmptyAsZero(),     // isAdjRibIn
                    new ParseNullAsEmpty()            // SR Capabilities
            };

            List<CellProcessor> processorsList = new ArrayList();
            processorsList.addAll(Arrays.asList(defaultCellProcessors));
            processorsList.addAll(Arrays.asList(versionSpecificProcessors));

            processors = processorsList.toArray(new CellProcessor[processorsList.size()]);

        } else if (spec_version.compareTo((float) 1.3) >= 0) {

            CellProcessor[] versionSpecificProcessors = new CellProcessor[]{
                    new ParseLongEmptyAsZero(),     // isPrePolicy
                    new ParseLongEmptyAsZero()      // isAdjRibIn
            };

            List<CellProcessor> processorsList = new ArrayList();
            processorsList.addAll(Arrays.asList(defaultCellProcessors));
            processorsList.addAll(Arrays.asList(versionSpecificProcessors));

            processors = processorsList.toArray(new CellProcessor[processorsList.size()]);

        } else {
            processors = defaultCellProcessors;
        }

        return processors;
    }
}

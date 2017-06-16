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
 * Format class for peer parsed messages (openbmp.parsed.peer)
 * <p>
 * Schema Version: 1.6
 */
public class Peer extends Base {


    String[] schemaHeaderNames = new String[]{MsgBusFields.ACTION.getName(), MsgBusFields.SEQUENCE.getName(), MsgBusFields.HASH.getName(), MsgBusFields.ROUTER_HASH.getName(), MsgBusFields.NAME.getName(),
            MsgBusFields.REMOTE_BGP_ID.getName(), MsgBusFields.ROUTER_IP.getName(), MsgBusFields.TIMESTAMP.getName(), MsgBusFields.REMOTE_ASN.getName(),
            MsgBusFields.REMOTE_IP.getName(), MsgBusFields.PEER_RD.getName(), MsgBusFields.REMOTE_PORT.getName(), MsgBusFields.LOCAL_ASN.getName(),
            MsgBusFields.LOCAL_IP.getName(), MsgBusFields.LOCAL_PORT.getName(), MsgBusFields.LOCAL_BGP_ID.getName(), MsgBusFields.INFO_DATA.getName(), MsgBusFields.ADV_CAP.getName(),
            MsgBusFields.RECV_CAP.getName(), MsgBusFields.REMOTE_HOLDDOWN.getName(), MsgBusFields.ADV_HOLDDOWN.getName(), MsgBusFields.BMP_REASON.getName(),
            MsgBusFields.BGP_ERROR_CODE.getName(), MsgBusFields.BGP_ERROR_SUB_CODE.getName(), MsgBusFields.ERROR_TEXT.getName(), MsgBusFields.IS_L3VPN.getName(),
            MsgBusFields.ISPREPOLICY.getName(), MsgBusFields.IS_IPV4.getName(),
            MsgBusFields.IS_LOCRIB.getName(), MsgBusFields.IS_LOCRIB_FILTERED.getName(),
            MsgBusFields.TABLE_NAME.getName()
    };


    /**
     * base constructor to support backward compatibility.
     *
     * @param data
     */
    public Peer(String data) {
        super();

        headerNames = schemaHeaderNames;

        parse(data);
    }

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param data
     */
    public Peer(Float version, String data) {
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

        CellProcessor[] processors;

        final CellProcessor[] defaultCellProcessors = new CellProcessor[]{
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

        if (spec_version.compareTo((float) 1.6) >= 0) {

            CellProcessor[] versionSpecificProcessors = new CellProcessor[]{
                    new ParseLongEmptyAsZero(),         // isLocRib
                    new ParseLongEmptyAsZero(),         // isLocRibFiltered
                    new ParseNullAsEmpty()              // Table/VRF Name
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

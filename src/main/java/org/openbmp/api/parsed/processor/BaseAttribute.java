/*
 * Copyright (c) 2018 Cisco Systems, Inc. and others.  All rights reserved.
 * Copyright (c) 2018 Tim Evens (tim@evensweb.com).  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */
package org.openbmp.api.parsed.processor;


import org.openbmp.api.helpers.split;
import org.openbmp.api.parsed.message.BaseAttributePojo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * TSV Processor class
 *      Produces a list of BaseAttributePojo for each record in the message.
 */
public class BaseAttribute {
    public List<BaseAttributePojo> records;            // Parsed records

    /**
     * Constructor
     *
     * @param data          Ascii/String TSV records delimited by newline
     */
    public BaseAttribute(String data) {
        records = parseData(data);
    }

    List<BaseAttributePojo> parseData(String data) {
        List<String> records = split.getStrings(data, '\n', 5000);
        List<BaseAttributePojo> results = new ArrayList<>();

        for (String record: records) {
            if (record.length() > 3) {
                BaseAttributePojo entry = parseRecord(record);
                results.add(entry);
            }
        }

        return results;
    }

    BaseAttributePojo parseRecord(String data) {

        List<String> fields = split.getStrings(data, '\t', 500);

        BaseAttributePojo ba = new BaseAttributePojo();

        /*
         * Populate pojo
         */
        try {
            ba.setWithdrawn(fields.get(0).equals("add") ? false : true);
            ba.setSequence(BigInteger.valueOf(Long.valueOf(fields.get(1))));
            ba.setHash(fields.get(2));
            ba.setRouter_hash(fields.get(3));
            ba.setRouter_ip(fields.get(4));
            ba.setPeer_hash(fields.get(5));
            ba.setPeer_ip(fields.get(6));
            ba.setPeer_asn(Long.parseLong(fields.get(7)));
            ba.setTimestamp(fields.get(8));
            ba.setOrigin(fields.get(9));
            ba.setAs_path(fields.get(10));
            ba.setAs_path_len(fields.get(11).length() != 0 ? Integer.parseInt(fields.get(11)) : 0);
            ba.setOrigin_asn(fields.get(12).length() != 0 ? Long.parseLong(fields.get(12)) : 0L);
            ba.setNext_hop(fields.get(13));
            ba.setMed(fields.get(14).length() != 0 ? Long.parseLong(fields.get(14)) : 0L);
            ba.setLocal_pref(fields.get(15).length() != 0 ? Long.parseLong(fields.get(15)) : 0L);
            ba.setAggregator(fields.get(16));
            ba.setCommunity_list(fields.get(17));
            ba.setExt_community_list(fields.get(18));
            ba.setCluster_list(fields.get(19));
            ba.setAtomicAggregate(fields.get(20).length() != 0 || fields.get(20).equals(0) ? false : true);
            ba.setNextHopIpv4(fields.get(21).length() == 0 || fields.get(21).equals(0) ? false : true);
            ba.setOriginator_id(fields.get(22));
            ba.setLarge_community_list(fields.get(23));

        } catch (Exception ex) {
            ex.printStackTrace();
            // ignore - support backwards compatibility
        }

        return ba;
    }
}

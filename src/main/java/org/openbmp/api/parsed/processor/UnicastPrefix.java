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
import org.openbmp.api.parsed.message.UnicastPrefixPojo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * TSV Processor class
 *      Produces a list of UnicastPrefixPojo for each record in the message.
 */
public class UnicastPrefix {
    public List<UnicastPrefixPojo> records;            // Parsed records

    /**
     * Constructor
     *
     * @param data          Ascii/String TSV records delimited by newline
     */
    public UnicastPrefix(String data) {
        records = parseData(data);
    }

    List<UnicastPrefixPojo> parseData(String data) {
        List<String> records = split.getStrings(data, '\n', 5000);
        List<UnicastPrefixPojo> results = new ArrayList<>();

        for (String record: records) {
            if (record.length() > 3) {
                UnicastPrefixPojo entry = parseRecord(record);
                results.add(entry);
            }
        }

        return results;
    }

    UnicastPrefixPojo parseRecord(String data) {

        List<String> fields = split.getStrings(data, '\t', 500);

        UnicastPrefixPojo ucast = new UnicastPrefixPojo();

        /*
         * Populate pojo
         */
        try {
            ucast.setWithdrawn(fields.get(0).equals("add") ? false : true);
            ucast.setSequence(BigInteger.valueOf(Long.valueOf(fields.get(1))));
            ucast.setHash(fields.get(2));
            ucast.setRouter_hash(fields.get(3));
            ucast.setRouter_ip(fields.get(4));
            ucast.setBase_attr_hash(fields.get(5));
            ucast.setPeer_hash(fields.get(6));
            ucast.setPeer_ip(fields.get(7));
            ucast.setPeer_asn(Long.valueOf(fields.get(8)));
            ucast.setTimestamp(fields.get(9));
            ucast.setPrefix(fields.get(10));
            ucast.setPrefix_len(Integer.valueOf(fields.get(11)));
            ucast.setIPv4(fields.get(12).equals("1") ? true : false);
            ucast.setOrigin(fields.get(13));
            ucast.setAs_path(fields.get(14));
            ucast.setAs_path_len(fields.get(15).length() != 0 ? Integer.valueOf(fields.get(15)) : 0);
            ucast.setOrigin_asn(fields.get(16).length() != 0 ? Long.valueOf(fields.get(16)) : 0L);
            ucast.setNext_hop(fields.get(17));
            ucast.setMed(fields.get(18).length() != 0 ? Long.valueOf(fields.get(18)) : 0L);
            ucast.setLocal_pref(fields.get(19).length() != 0 ? Long.valueOf(fields.get(19)) : 0L);
            ucast.setAggregator(fields.get(20));
            ucast.setCommunity_list(fields.get(21));
            ucast.setExt_community_list(fields.get(22));
            ucast.setCluster_list(fields.get(23));
            ucast.setAtomicAggregate(fields.get(24).length() != 0 || fields.get(24).equals(0) ? false : true);
            ucast.setNextHopIpv4(fields.get(25).length() == 0 || fields.get(25).equals(0) ? false : true);
            ucast.setOriginator_id(fields.get(26));
            ucast.setPath_id(Long.valueOf(fields.get(27)));
            ucast.setLabels(fields.get(28));
            ucast.setPrePolicy(fields.get(29).equals(1) ? true : false);
            ucast.setAdjRibIn(fields.get(30).equals(1) ? true : false);
            ucast.setLarge_community_list(fields.get(31));

        } catch (Exception ex) {
            ex.printStackTrace();
            // ignore - support backwards compatibility
        }

        return ucast;
    }
}

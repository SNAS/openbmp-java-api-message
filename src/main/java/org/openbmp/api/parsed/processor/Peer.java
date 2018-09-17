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
import org.openbmp.api.parsed.message.PeerPojo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * TSV Processor class
 *      Produces a list of PeerPojo for each record in the message.
 */
public class Peer {
    public List<PeerPojo> records;            // Parsed records

    /**
     * Constructor
     *
     * @param data          Ascii/String TSV records delimited by newline
     */
    public Peer(String data) {
        records = parseData(data);
    }

    List<PeerPojo> parseData(String data) {
        List<String> records = split.getStrings(data, '\n', 5000);
        List<PeerPojo> results = new ArrayList<>();

        for (String record: records) {
            if (record.length() > 3) {
                PeerPojo entry = parseRecord(record);
                results.add(entry);
            }
        }

        return results;
    }

    PeerPojo parseRecord(String data) {

        List<String> fields = split.getStrings(data, '\t', 500);

        PeerPojo pojo = new PeerPojo();

        /*
         * Populate pojo
         */
        try {
            pojo.setAction(fields.get(0));
            pojo.setSequence(BigInteger.valueOf(Long.valueOf(fields.get(1))));
            pojo.setHash(fields.get(2));
            pojo.setRouter_hash(fields.get(3));
            pojo.setName(fields.get(4));
            pojo.setPeer_bgp_id(fields.get(5));
            pojo.setRouter_ip(fields.get(6));
            pojo.setTimestamp(fields.get(7));
            pojo.setPeer_asn(Long.parseLong(fields.get(8)));
            pojo.setPeer_ip(fields.get(9));
            pojo.setPeer_rd(fields.get(10));
            pojo.setPeer_port(fields.get(11).length() > 0 ? Integer.parseInt(fields.get(11)) : 0);
            pojo.setLocal_asn(fields.get(12).length() > 0 ? Long.parseLong(fields.get(12)) : 0L);
            pojo.setLocal_ip(fields.get(13));
            pojo.setLocal_port(fields.get(14).length() > 0 ? Integer.parseInt(fields.get(14)) : 0);
            pojo.setLocal_bgp_id(fields.get(15));
            pojo.setInfo_data(fields.get(16));
            pojo.setAdvertised_cap(fields.get(17));
            pojo.setReceived_cap(fields.get(18));
            pojo.setPeer_holddown(fields.get(19).length() > 0 ? Integer.valueOf(fields.get(19)) : 0);
            pojo.setLocal_holddown(fields.get(20).length() > 0 ? Integer.valueOf(fields.get(20)) : 0);
            pojo.setBmp_down_reason(fields.get(21).length() > 0 ? Integer.valueOf(fields.get(21)) : 0);
            pojo.setBgp_error_code(fields.get(22).length() > 0 ? Integer.valueOf(fields.get(22)) : 0);
            pojo.setBgp_error_subcode(fields.get(23).length() > 0 ? Integer.valueOf(fields.get(23)) : 0);
            pojo.setBgp_error_text(fields.get(24));
            pojo.setL3VPN(fields.get(25).equals("1") ? true : false);
            pojo.setPrePolicy(fields.get(26).equals("1") ? true : false);
            pojo.setIPv4(fields.get(27).equals("1") ? true : false);
            pojo.setLocRib(fields.get(28).equals("1") ? true : false);
            pojo.setLocalRibFiltered(fields.get(29).equals("1") ? true : false);
            pojo.setTable_name(fields.get(30));

        } catch (Exception ex) {
            ex.printStackTrace();
            // ignore - support backwards compatibility
        }

        return pojo;
    }
}

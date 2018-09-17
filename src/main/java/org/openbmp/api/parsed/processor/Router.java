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
import org.openbmp.api.parsed.message.RouterPojo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * TSV Processor class
 *      Produces a list of RouterPojo for each record in the message.
 */
public class Router {
    public List<RouterPojo> records;            // Parsed records

    /**
     * Constructor
     *
     * @param data          Ascii/String TSV records delimited by newline
     */
    public Router(String data) {
        records = parseData(data);
    }

    List<RouterPojo> parseData(String data) {
        List<String> records = split.getStrings(data, '\n', 5000);
        List<RouterPojo> results = new ArrayList<>();

        for (String record: records) {
            if (record.length() > 3) {
                RouterPojo entry = parseRecord(record);
                results.add(entry);
            }
        }

        return results;
    }

    RouterPojo parseRecord(String data) {

        List<String> fields = split.getStrings(data, '\t', 500);

        RouterPojo pojo = new RouterPojo();

        /*
         * Populate pojo
         */
        try {
            pojo.setAction(fields.get(0));
            pojo.setSequence(BigInteger.valueOf(Long.valueOf(fields.get(1))));
            pojo.setName(fields.get(2));
            pojo.setHash(fields.get(3));
            pojo.setIp_address(fields.get(4));
            pojo.setDescription(fields.get(5));
            pojo.setTerm_code(fields.get(6).length() > 0 ? Integer.valueOf(fields.get(6)) : 0);
            pojo.setTerm_reason(fields.get(7));
            pojo.setInit_data(fields.get(8));
            pojo.setTerm_data(fields.get(9));
            pojo.setTimestamp(fields.get(10));
            pojo.setBgp_id(fields.get(11));

        } catch (Exception ex) {
            ex.printStackTrace();
            // ignore - support backwards compatibility
        }

        return pojo;
    }
}

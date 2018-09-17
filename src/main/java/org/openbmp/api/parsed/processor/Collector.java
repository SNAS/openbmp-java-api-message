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
import org.openbmp.api.parsed.message.CollectorPojo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * TSV Processor class
 *      Produces a list of CollectorPojo for each record in the message.
 */
public class Collector {
    public List<CollectorPojo> records;            // Parsed records

    /**
     * Constructor
     *
     * @param data          Ascii/String TSV records delimited by newline
     */
    public Collector(String data) {
        records = parseData(data);
    }

    List<CollectorPojo> parseData(String data) {
        List<String> records = split.getStrings(data, '\n', 5000);
        List<CollectorPojo> results = new ArrayList<>();

        for (String record: records) {
            if (record.length() > 3) {
                CollectorPojo entry = parseRecord(record);
                results.add(entry);
            }
        }

        return results;
    }

    CollectorPojo parseRecord(String data) {

        List<String> fields = split.getStrings(data, '\t', 500);

        CollectorPojo pojo = new CollectorPojo();

        /*
         * Populate pojo
         */
        try {
            pojo.setAction(fields.get(0));
            pojo.setSequence(BigInteger.valueOf(Long.parseLong(fields.get(1))));
            pojo.setAdmin_id(fields.get(2));
            pojo.setHash(fields.get(3));
            pojo.setRouter_list(fields.get(4));
            pojo.setRouter_count(Integer.parseInt(fields.get(5)));
            pojo.setTimestamp(fields.get(6));

        } catch (Exception ex) {
            ex.printStackTrace();
            // ignore - support backwards compatibility
        }

        return pojo;
    }
}

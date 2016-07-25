package org.openbmp.api.parsed.message;
/*
 * Copyright (c) 2015-2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

/**
 * Parses raw openbmp.parsed.* message headers and content portion
 *      @See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details on structure of message.
 */
public class Message {
    private Float version;
    private String collector_hash_id;
    private long length;
    private long records;
    private String router_hash_id;
    private String content;

    private Integer content_pos;

    /**
     * Constructor
     *      Parse the data
     *
     * @param data
     */
    public Message(String data) {
        parse(data);
    }

    /**
     * Parse headers and data portion of message
     *
     * @param data
     */
    private void parse(String data) {

        int data_end_pos = data.lastIndexOf("\n\n");
        String header_data = data.substring(0, data_end_pos);
        content_pos = data_end_pos + 2;
        content = data.substring(content_pos);

        String headers[] = header_data.split("\n");

        for(String header : headers) {

            String value = header.split(":")[1].trim();
            String attr = header.split(":")[0].trim();

            /*
             * attribute names are from http://openbmp.org/#!docs/MESSAGE_BUS_API.md headers
             */
            if (attr.equals("V")) {
                this.version = Float.valueOf(value);
            } else if (attr.equals("C_HASH_ID")) {
                this.collector_hash_id = value;
            } else if (attr.equals("L")) {
                this.length = Long.valueOf(value);
            } else if (attr.equals("R")) {
                this.records = Long.valueOf(value);
            } else if (attr.equals("R_HASH_ID")) {
                this.router_hash_id = value;
            }
        }
    }

    /*
     * Getters
     */
    public Float getVersion() {
        return version;
    }
    public String getCollector_hash_id() {
        return collector_hash_id;
    }
    public long getLength() {
        return length;
    }
    public long getRecords() {
        return records;
    }
    public String getRouter_hash_id() {
        return router_hash_id;
    }

    public Integer getContentPos() {
        return content_pos;
    }
    public String getContent() {
        return content;
    }

}

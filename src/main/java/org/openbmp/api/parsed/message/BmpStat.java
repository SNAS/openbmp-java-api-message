package org.openbmp.api.parsed.message;
/*
 * Copyright (c) 2015-2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

import org.openbmp.api.parsed.processor.ParseTimestamp;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Format class for bmp_stat parsed messages (openbmp.parsed.bmp_stat)
 *
 * Schema Version: 1.2
 *
 */
public class BmpStat extends Base {
	
	String [] minimumHeaderNames = new String[]{MsgBusFields.ACTION.getName(),MsgBusFields.SEQUENCE.getName(),MsgBusFields.ROUTER_HASH.getName(),MsgBusFields.ROUTER_IP.getName(),
									    		MsgBusFields.PEER_HASH.getName(),MsgBusFields.PEER_IP.getName(),MsgBusFields.PEER_ASN.getName(),MsgBusFields.TIMESTAMP.getName(),MsgBusFields.REJECTED.getName(),
									    		MsgBusFields.KNOWN_DUP_UPDATES.getName(),MsgBusFields.KNOWN_DUP_WITHDRAWS.getName(),MsgBusFields.INVALID_CLUSTER_LIST.getName(),
									    		MsgBusFields.INVALID_AS_PATH.getName(),MsgBusFields.INVALID_ORIGINATOR.getName(),MsgBusFields.INVALID_AS_CONFED.getName(),MsgBusFields.PRE_POLICY.getName(),
									    		MsgBusFields.POST_POLICY.getName()};

   
	/**
	 * base constructor to support backward compatibility. Will run on the {@link Base.DEFAULT_SPEC_VERSION} version.
	 * @param data
	 */
    public BmpStat(String data) {
        super();
        
        headerNames = minimumHeaderNames;

        parse(data);
    }

    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param data
     */
    public BmpStat(Float version, String data) {
        super();
        
        spec_version = version;
        
        //Headers are same upto version 1.2 for this Object. 
        //TODO:: If needed, add additional headers with later version. Refer to {@link LsLink} constructor.
        headerNames = minimumHeaderNames;

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

        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(),          // action
                new ParseLong(),        // seq
                new NotNull(),          // hash
                new NotNull(),          // router_ip
                new NotNull(),          // peer_hash
                new NotNull(),          // peer_ip,
                new ParseLong(),        // peer_asn
                new ParseTimestamp(),   // Timestamp
                new NotNull(),          // rejected
                new NotNull(),          // known_dup_updates
                new NotNull(),          // known_dup_withdraws
                new NotNull(),          // invalid_cluster_list
                new NotNull(),          // invalid_as_path
                new NotNull(),          // invalid_originator
                new NotNull(),          // invalid_as_confed
                new NotNull(),          // pre_policy
                new NotNull()           // post_policy
        };

        return processors;
    }

}

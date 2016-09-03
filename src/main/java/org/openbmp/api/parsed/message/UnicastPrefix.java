package org.openbmp.api.parsed.message;
/*
 * Copyright (c) 2015-2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */
import org.openbmp.api.helpers.IpAddr;
import org.openbmp.api.parsed.processor.ParseLongEmptyAsZero;
import org.openbmp.api.parsed.processor.ParseNullAsEmpty;
import org.openbmp.api.parsed.processor.ParseTimestamp;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Format class for unicast_prefix parsed messages (openbmp.parsed.unicast_prefix)
 *
 * Schema Version: 1.3
 *
 */
public class UnicastPrefix extends Base {

	// Minimum set of headers each Object will have.
	String [] minimumHeaderNames = new String[]{MsgBusFields.ACTION.getName(),MsgBusFields.SEQUENCE.getName(),MsgBusFields.HASH.getName(),MsgBusFields.ROUTER_HASH.getName(),MsgBusFields.ROUTER_IP.getName(),
									    		MsgBusFields.BASE_ATTR_HASH.getName(),MsgBusFields.PEER_HASH.getName(),MsgBusFields.PEER_IP.getName(),MsgBusFields.PEER_ASN.getName(),MsgBusFields.TIMESTAMP.getName(),
									    		MsgBusFields.PREFIX.getName(),MsgBusFields.PREFIX_LEN.getName(),MsgBusFields.IS_IPV4.getName(),MsgBusFields.ORIGIN.getName(),MsgBusFields.AS_PATH.getName(),
									    		MsgBusFields.AS_PATH_COUNT.getName(),MsgBusFields.ORIGIN_AS.getName(),MsgBusFields.NEXTHOP.getName(),MsgBusFields.MED.getName(),MsgBusFields.LOCAL_PREF.getName(),
									    		MsgBusFields.AGGREGATOR.getName(),MsgBusFields.COMMUNITY_LIST.getName(),MsgBusFields.EXT_COMMUNITY_LIST.getName(),MsgBusFields.CLUSTER_LIST.getName(),MsgBusFields.ISATOMICAGG.getName(),
									    		MsgBusFields.IS_NEXTHOP_IPV4.getName(),MsgBusFields.ORIGINATOR_ID.getName()};
	
	
	/**
	 * base constructor to support backward compatibility. Will run on the {@link Base.DEFAULT_SPEC_VERSION} version.
	 * @param data
	 */
	public UnicastPrefix(String data) {
		super();
		
		String latestVersionHeaders [] =  new String[]{MsgBusFields.PATH_ID.getName(),MsgBusFields.LABELS.getName(),MsgBusFields.ISPREPOLICY.getName(),MsgBusFields.IS_ADJ_RIB_IN.getName()};

		List<String> headerList = new ArrayList<>();
		headerList.addAll(Arrays.asList(minimumHeaderNames));
		headerList.addAll(Arrays.asList(latestVersionHeaders));

		headerNames = (String[]) headerList.toArray();
		
		parse(data);
	}
	
	
    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param version       Float representation of maximum message bus specification version supported.
     *                          See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details.
     * @param data          TSV data (MUST not include the headers)
     */
    public UnicastPrefix(Float version, String data) {
        super();

        spec_version = version;
        
        if (version.compareTo((float) 1.3) >= 0)  {

        		//headers specific to v1.3 or greater
        		String versionSpecificHeaders [] = new String[]{MsgBusFields.PATH_ID.getName(),MsgBusFields.LABELS.getName(),MsgBusFields.ISPREPOLICY.getName(),MsgBusFields.IS_ADJ_RIB_IN.getName()};
        		
        		List<String> headerList = new ArrayList<>();
        		headerList.addAll(Arrays.asList(minimumHeaderNames));
        		headerList.addAll(Arrays.asList(versionSpecificHeaders));
        		
        		headerNames = (String[]) headerList.toArray();
        		
        		
        } else if (version.compareTo((float) 1.1) >= 0)  {
        		
        		// headers specific to v1.1 or greater
        		String versionSpecificHeaders [] = new String[]{MsgBusFields.PATH_ID.getName(),MsgBusFields.LABELS.getName()};
        		
        		List<String> headerList = new ArrayList<>();
        		headerList.addAll(Arrays.asList(minimumHeaderNames));
        		headerList.addAll(Arrays.asList(versionSpecificHeaders));
        		
        		headerNames = (String[]) headerList.toArray();

        } else {
    		
        		headerNames = minimumHeaderNames;
            
        }

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

        CellProcessor[] processors;
        
        final CellProcessor[] defaultCellProcessors = new CellProcessor[]{
        		new NotNull(),                      // action
                new ParseLong(),                    // seq
                new NotNull(),                      // hash
                new NotNull(),                      // router hash
                new NotNull(),                      // router_ip
                new ParseNullAsEmpty(),             // base_attr_hash
                new NotNull(),                      // peer_hash
                new NotNull(),                      // peer_ip
                new ParseLong(),                    // peer_asn
                new ParseTimestamp(),               // timestamp
                new NotNull(),                      // prefix
                new ParseInt(),                     // prefix_len
                new ParseInt(),                     // isIPv4
                new ParseNullAsEmpty(),             // origin
                new ParseNullAsEmpty(),             // as_path
                new ParseLongEmptyAsZero(),         // as_path_count
                new ParseLongEmptyAsZero(),         // origin_as
                new ParseNullAsEmpty(),             // nexthop
                new ParseLongEmptyAsZero(),         // med
                new ParseLongEmptyAsZero(),         // local_pref
                new ParseNullAsEmpty(),             // aggregator
                new ParseNullAsEmpty(),             // community_list
                new ParseNullAsEmpty(),             // ext_community_list
                new ParseNullAsEmpty(),             // cluster_list
                new ParseLongEmptyAsZero(),         // isAtomicAgg
                new ParseLongEmptyAsZero(),         // isNexthopIPv4
                new ParseNullAsEmpty()              // originator_id
        		
        };

        if (spec_version.compareTo((float) 1.3) >= 0) {
        	
        	CellProcessor[] versionSpecificProcessors = new CellProcessor[]{
        			new ParseLongEmptyAsZero(),         // Path ID
                    new ParseNullAsEmpty(),             // Labels
                    new ParseLongEmptyAsZero(),         // isPrePolicy
                    new ParseLongEmptyAsZero()          // isAdjRibIn
        	};
        	
        	List<CellProcessor> processorsList = new ArrayList<>();
        	processorsList.addAll(Arrays.asList(defaultCellProcessors));
        	processorsList.addAll(Arrays.asList(versionSpecificProcessors));
        	
        	processors = (CellProcessor[])processorsList.toArray();
        }

        else if (spec_version.compareTo((float) 1.1) >= 0) {
        	
        	CellProcessor[] versionSpecificProcessors = new CellProcessor[]{
        			new ParseLongEmptyAsZero(),         // Path ID
                    new ParseNullAsEmpty()              // Labels
        	};
        	
        	List<CellProcessor> processorsList = new ArrayList<>();
        	processorsList.addAll(Arrays.asList(defaultCellProcessors));
        	processorsList.addAll(Arrays.asList(versionSpecificProcessors));
        	
        	processors = (CellProcessor[])processorsList.toArray();
        	
        }
        else {
            processors = defaultCellProcessors;
        }

        return processors;
    }
}

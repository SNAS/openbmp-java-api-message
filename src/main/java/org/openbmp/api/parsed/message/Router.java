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
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Format class for router parsed messages (openbmp.parsed.router)
 *
 * Schema Version: 1.2
 *
 */
public class Router extends Base {

	// Minimum set of headers each Object will have.
	String [] minimumHeaderNames =   new String[]{MsgBusFields.ACTION.getName(),MsgBusFields.SEQUENCE.getName(),MsgBusFields.NAME.getName(),MsgBusFields.HASH.getName(),MsgBusFields.IP_ADDRESS.getName(),
										    	  MsgBusFields.DESCRIPTION.getName(),MsgBusFields.TERM_CODE.getName(),MsgBusFields.TERM_REASON.getName(),MsgBusFields.INIT_DATA.getName(),MsgBusFields.TERM_DATA.getName(),
										    	  MsgBusFields.TIMESTAMP.getName()};
	
	/**
	 * base constructor to support backward compatibility. Will run on the {@link Base.DEFAULT_SPEC_VERSION} version.
	 * @param data
	 */
	public Router(String data) {
        super();
        
        headerNames = minimumHeaderNames;
        
        parse(data);
	}
	
	
	
    /**
     * Handle the message by parsing it and storing the data in memory.
     *
     * @param version       Float representation of maximum message bus specification version supported.
     *                          See http://openbmp.org/#!docs/MESSAGE_BUS_API.md for more details.
     * @param data          TSV data (MUST not include the headers)
     */
    public Router(Float version, String data) {
        super();

        spec_version = version;
        
        if (version.compareTo((float) 1.2) >= 0)  {
        	
        	// headers specific to v1.2 or greater
        	String versionSpecificHeaders [] = new String[]{MsgBusFields.BGP_ID.getName()};
    		
        	List<String> headerList = new ArrayList();
    		headerList.addAll(Arrays.asList(minimumHeaderNames));
    		headerList.addAll(Arrays.asList(versionSpecificHeaders));
    		
    		headerNames = headerList.toArray(new String[headerList.size()]);
        }
        else {
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

        final CellProcessor[] processors;

        final CellProcessor[] defaultCellProcessors = new CellProcessor[]{
        		new NotNull(),                      // action
                new ParseLong(),                    // seq
                new ParseNullAsEmpty(),             // name
                new NotNull(),                      // hash
                new NotNull(),                      // IP Address
                new ParseNullAsEmpty(),             // Description
                new Optional(new ParseInt()),       // Term code
                new ParseNullAsEmpty(),             // Term reason
                new ParseNullAsEmpty(),             // Init data
                new ParseNullAsEmpty(),             // Term data
                new ParseTimestamp()                // Timestamp
        };
        
        if (spec_version.compareTo((float) 1.2) >= 0)  {
        	
        	CellProcessor[] versionSpecificProcessors = new CellProcessor[]{
        			new ParseNullAsEmpty()              // Global BGP-ID for router
        	};
        	
        	List<CellProcessor> processorsList = new ArrayList();
        	processorsList.addAll(Arrays.asList(defaultCellProcessors));
        	processorsList.addAll(Arrays.asList(versionSpecificProcessors));
        	
        	processors = processorsList.toArray(new CellProcessor[processorsList.size()]);
        	
           
        }
        else {
           
        	processors = defaultCellProcessors;
        	
        }

        return processors;
    }
}

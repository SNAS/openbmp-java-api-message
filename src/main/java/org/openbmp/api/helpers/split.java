/*
 * Copyright (c) 2018 Cisco Systems, Inc. and others.  All rights reserved.
 * Copyright (c) 2018 Tim Evens (tim@evensweb.com).  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */
package org.openbmp.api.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class split {

    /**
     * Split records
     *
     * @param data          Data to be split
     * @param delimiter     Delimiter character to split on
     * @param max           Max number of splits, 0 is unlimited
     *
     * @return List of strings
     */
    public static List<String> getStrings(String data, char delimiter, int max) {
        List<String> strings = new ArrayList<>();

        if (max <= 0)
            max = Integer.MAX_VALUE;

        int end_index = data.indexOf(delimiter);
        int cur_index = 0;

        if (end_index < 0) {
            // No delimiter found, return single result
            strings.add(data);

        } else {
            // Add all entries
            int i = 0;
            while (end_index > 0 && i < max) {
                max++;

                try {
                    strings.add(data.substring(cur_index, end_index));

                    cur_index = end_index + 1;

                    end_index = data.indexOf(delimiter, cur_index);

                    if (end_index < 0)
                        strings.add(data.substring(cur_index));

                } catch (Exception ex) {
                    end_index = -1;
                }
            }
        }

        return strings;
    }
}

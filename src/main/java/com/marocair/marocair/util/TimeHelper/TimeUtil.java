package com.marocair.marocair.util.TimeHelper;


import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;

public abstract class TimeUtil {
    public static Timestamp stringToTimestamp (String date) {
        if (StringUtils.countMatches(date, ":") == 1) {
            date += ":00";
        }
        Timestamp timestamp = Timestamp.valueOf(date.replace("T", " "));
        return timestamp;
    }

}

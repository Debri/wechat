package com.weixin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Liuqi
 * Date: 2016/11/6.
 */
public class DateUtils {

    /*public static String toMin() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return sdf.format(new Date());
    }*/
    public static String toMin() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(new Date());
    }
}

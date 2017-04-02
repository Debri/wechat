package com.weixin.test;

import com.weixin.util.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Liuqi
 * Date: 2016/11/6.
 */
public class DateUtilsTest {
    @Test
    public void getMin() {
        System.out.println(DateUtils.toMin());
    }

    @Test
    public void get12() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println(System.currentTimeMillis());
    }
}
package com.weixin.test;

import com.weixin.bean.Announce;
import com.weixin.service.AnnounceService;
import org.junit.Test;

/**
 * Created by Liuqi
 * Date: 2016/11/8.
 */
public class AnnounceServiceTest {
    @Test
    public void testAddAnnounce() throws Exception {
        AnnounceService announceService=new AnnounceService();
        announceService.addAnnounce(new Announce("zuixin"));
    }

    @Test
    public void testFindAnnounce() throws Exception {
        AnnounceService announceService=new AnnounceService();
        System.out.println(announceService.findAnnounce().getContent());
    }

}
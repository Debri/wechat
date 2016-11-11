package com.weixin.test;

import com.weixin.bean.Song;
import com.weixin.service.SongService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Liuqi
 * Date: 2016/11/6.
 */
public class SongServiceTest {
/*    SongService songService = null;

    @BeforeClass
    public void setUp() throws Exception {
        songService = new SongService();
    }*/

    @Test
    public void testAddSong() throws Exception {
        SongService songService = new SongService();
        for (int i = 0; i < 10; i++) {
            songService.addSong(new Song());
        }
    }

    @Test
    public void testDoVerify() throws Exception {
        SongService songService = new SongService();
        for (int i = 0; i < 10; i++) {
            songService.doVerify(i,1);
        }
    }

    @Test
    public void testSelectSongByStatus() throws Exception {
        SongService songService = new SongService();
        List<Song> list = new ArrayList<Song>();
        list = songService.masterFind();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Song song = (Song) iterator.next();
            System.out.println(song.toString());
            System.out.println(song.getReceiver());
        }
    }
}
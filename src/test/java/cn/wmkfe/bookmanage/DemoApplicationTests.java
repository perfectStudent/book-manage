package cn.wmkfe.bookmanage;

import cn.wmkfe.bookmanage.model.Reader;
import cn.wmkfe.bookmanage.util.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class DemoApplicationTests {

    @Test
    public void contextLoads() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONDAY,+1);
//        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss SSS");
//        System.out.println(sf.format(calendar.getTime()));
        Reader reader=new Reader();

        System.out.println(reader.getClass());
        System.out.println(Reader.class==reader.getClass());
    }

}

package cn.rangaofei.urltool.tool;

import com.intellij.util.Url;
import com.intellij.util.UrlImpl;
import com.intellij.util.Urls;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class UrlToolTest {

    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("https://blog.csdn.net/PacosonSWJTU/article/details/120904564?k1=v1&k2=v2#anchor=1");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getPath());
        System.out.println(url.getRef());
        System.out.println(url.getQuery());
        System.out.println(url.getUserInfo());
        System.out.println(url.getAuthority());
    }
}
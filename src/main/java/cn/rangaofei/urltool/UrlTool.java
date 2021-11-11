package cn.rangaofei.urltool;

import cn.rangaofei.urltool.UrlModel;
import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

public class UrlTool {

    public static Vector<UrlModel> parseUrl(String str) throws MalformedURLException {
        URL url = new URL(str);
        Vector<UrlModel> result = new Vector<>();
        String scheme = url.getProtocol();
        if (StringUtils.isNotEmpty(scheme)) {
            result.add(createUrlModel("scheme", scheme));
        }
        String host = url.getHost();
        if (StringUtils.isNotEmpty(host)){
            result.add(createUrlModel("host", host));
        }
        int port = url.getPort();
        if (port != -1) {
            result.add(createUrlModel("port", String.valueOf(port)));
        }
        String file = url.getFile();
//        if (StringUtils.isNotEmpty(file)) {
//            result.add(createUrlModel("file", file));
//        }
        String path = url.getFile();
        if (StringUtils.isNotEmpty(path)) {
            result.add(createUrlModel("path", path));
        }
        String ref = url.getRef();
        if (StringUtils.isNotEmpty(ref)) {
            result.add(createUrlModel("ref", ref));
        }
        String query = url.getQuery();
        if (StringUtils.isNotEmpty(query)) {
            result.add(createUrlModel("query", query));
        }
        String userInfo = url.getUserInfo();
        if (StringUtils.isNotEmpty(userInfo)) {
            result.add(createUrlModel("userInfo", userInfo));
        }
//        String authority = url.getAuthority();
//        if (StringUtils.isNotEmpty(authority)) {
//            result.add(createUrlModel("authority", authority));
//        }
        return result;
    }

    private static UrlModel createUrlModel(String key, String value) {
        UrlModel urlModel = new UrlModel();
        urlModel.setKey(key);
        urlModel.setValue(value);
        return urlModel;
    }
}

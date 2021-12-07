package cn.rangaofei.urltool.url;

import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class UrlTool {

    public static List<UrlModel> parseUrl(String str) throws MalformedURLException {
        URL url = new URL(str);
        List<UrlModel> result = new ArrayList<>();
        String scheme = url.getProtocol();
        if (StringUtils.isNotEmpty(scheme)) {
            result.add(createUrlModel("scheme", scheme));
        }
        String host = url.getHost();
        if (StringUtils.isNotEmpty(host)) {
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

    public static List<String> getPathList(String path) {
        List<String> result = new ArrayList<>();
        if (StringUtils.isEmpty(path)) {
            return result;
        }
        List<String> pathSegment = Arrays.asList(path.split("/"));
        result.addAll(pathSegment);
        return result;
    }

    public static List<UrlModel> parseParam(String params) {
        List<UrlModel> result = new ArrayList<>();
        if (StringUtils.isEmpty(params)) {
            return result;
        }
        String[] keyAndValue = params.split("&");
        for (String s : keyAndValue) {
            if (!s.contains("=")) {
                System.out.println("not a param format :" + s);
                continue;
            }
            String[] t = s.split("=");
            String key = t[0];
            String value = "";
            if (t.length == 2) {
                value = t[1];
            }
            result.add(createUrlModel(key, value));
        }
        return result;
    }

    private static UrlModel createUrlModel(String key, String value) {
        UrlModel urlModel = new UrlModel();
        urlModel.setKey(key);
        urlModel.setValue(value);
        urlModel.setSelected(true);
        return urlModel;
    }
}

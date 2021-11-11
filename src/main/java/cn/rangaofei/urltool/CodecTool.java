package cn.rangaofei.urltool;

import com.intellij.util.Base64;
import org.apache.commons.lang3.StringUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CodecTool {
    public static String decodeUrl(String str){
        return URLDecoder.decode(str, StandardCharsets.UTF_8);
    }

    public static String encodeUrl(String str){
        return URLEncoder.encode(str,StandardCharsets.UTF_8);
    }

    public static String decodeBase64(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        byte[] bytes = Base64.decode(str);
        return new String(bytes);
    }

    public static String encodeBase64(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Base64.encode(bytes);
    }
}

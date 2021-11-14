package cn.rangaofei.urltool;

import com.google.zxing.MultiFormatWriter;
import com.intellij.util.Base64;
import org.apache.commons.lang3.StringUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CodecTool {
    public static String decodeUrl(String str) {
        return URLDecoder.decode(str, StandardCharsets.UTF_8);
    }

    public static String encodeUrl(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }

    public static String decodeBase64(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = Base64.decode(str);
        return new String(bytes);
    }

    public static String encodeBase64(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Base64.encode(bytes);
    }

    public static String stringToHex(String s,String sep) {
        if (StringUtils.isEmpty(s)) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str.append(sep).append(s4);
        }
        return str.toString();
    }

    public static String hexToString(String s) {
        if (StringUtils.isEmpty(s)) {
            return "";
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

}

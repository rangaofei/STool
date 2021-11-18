package cn.rangaofei.urltool.codec;

import com.intellij.util.Base64;
import com.intellij.util.ui.UIUtil;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Base64Util {
    public static boolean isImage(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return StringUtils.startsWith(str, "data:image");
    }

    public static BufferedImage decodeBase64ToImage(String str) throws IOException {
        if (!isImage(str)) {
            return null;
        }
        str = str.split("base64,")[1];
        byte[] bytes = decodeBase64ToByte(str);
        return decodeBytesToImage(bytes);
    }

    private static byte[] decodeBase64ToByte(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Base64.decode(str);
    }

    private static BufferedImage decodeBytesToImage(byte[] bytes) throws IOException {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        return ImageIO.read(inputStream);
    }
}

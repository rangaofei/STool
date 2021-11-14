package cn.rangaofei.urltool.bar;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code39Writer;
import org.apache.commons.lang3.StringUtils;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;


public class BarcodeTool {
    private static Map<EncodeHintType, String> hints = new HashMap<>();

    static {
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
    }

    public static BufferedImage generateBarCode39(String content) throws WriterException {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        Code39Writer writer = new Code39Writer();
        BitMatrix matrix = writer.encode(content, BarcodeFormat.CODE_39, 100, 50, hints);
        return MatrixToImageWriter.toBufferedImage(matrix);
    }

    public static BufferedImage generateQrCode(String content) throws WriterException {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}

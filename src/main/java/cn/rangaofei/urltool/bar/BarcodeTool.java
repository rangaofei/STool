package cn.rangaofei.urltool.bar;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
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

    public static BufferedImage generateBarCode39(String content, BarcodeType type) throws WriterException {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        Writer writer = getWriter(type);
        BitMatrix matrix = writer.encode(content, type.getFormat(), 100, 50, hints);
        return MatrixToImageWriter.toBufferedImage(matrix);
    }

    private static Writer getWriter(BarcodeType type) {
        if (type == null) {
            return null;
        }
        switch (type) {
            case CODE_39:
                return new Code39Writer();
            case CODA_BAR:
                return new CodaBarWriter();
            case CODE_128:
                return new Code128Writer();
            default:
                return null;
        }
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

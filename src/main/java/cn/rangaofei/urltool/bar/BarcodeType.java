package cn.rangaofei.urltool.bar;

import com.google.zxing.BarcodeFormat;

/**
 * Code39码（标准39码）、Codabar码（库德巴码）、Code25码（标准25码）、
 * ITF25码（交叉25码）、Matrix25码（矩阵25码）、UPC-A码、UPC-E码、EAN-13码（EAN-13国际商品条码）、EAN-8码（EAN-8国际商品条码）、中国邮政码（矩阵25码的一种变体）、Code-B码、MSI码、Code11码、Code93码、ISBN码、ISSN码、Code128码（Code128码，包括EAN128码）、Code39EMS（EMS专用的39码）等一维条码和PDF417等二维条码。
 */
public enum BarcodeType {
    CODE_39("Code39",0,BarcodeFormat.CODE_39),
    CODA_BAR("CodeBar",1,BarcodeFormat.CODABAR),
    CODE_128("Code128",2, BarcodeFormat.CODE_128),
    ;
    private String name;
    private int id;
    private BarcodeFormat format;

    BarcodeType(String name, int id, BarcodeFormat format) {
        this.name = name;
        this.id = id;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BarcodeFormat getFormat() {
        return format;
    }

    public void setFormat(BarcodeFormat format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return name;
    }
}

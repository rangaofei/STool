package cn.rangaofei.urltool.codec;

public interface CodecButtonListener {
    void encodeClick();
    void decodeClick();

    void base64Decode();
    void base64DecodeImage();
    void base64Encode();

    void hexDecode();
    void hexEncode(String sep);
}

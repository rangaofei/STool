package cn.rangaofei.urltool.codec;

import javax.swing.*;

public class UrlCodecToolbar extends AbstractCodecPanel {

    public UrlCodecToolbar(CodecButtonListener listener) {
        super(listener);
    }

    protected void initView() {
        JButton urlEncodeButton = createButton("UrlEncode");
        urlEncodeButton.addActionListener(e -> {
            if (listener == null) {
                return;
            }
            listener.encodeClick();
        });
        this.add(urlEncodeButton);

        JButton urlDecodeButton = createButton("UrlDecode");
        urlDecodeButton.addActionListener(e -> {
            if (listener == null) {
                return;
            }
            listener.decodeClick();
        });
        this.add(urlDecodeButton);
    }


}

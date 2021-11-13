package cn.rangaofei.urltool.codec;

import cn.rangaofei.urltool.widget.CreateButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Base64CodecToolbar extends AbstractCodecPanel {

    public Base64CodecToolbar(CodecButtonListener listener) {
        super(listener);
    }

    protected void initView() {
        JButton base64EncodeButton = createButton("Base64Encode");
        base64EncodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener == null) {
                    return;
                }
                listener.base64Encode();
            }
        });
        this.add(base64EncodeButton);

        JButton base64DecodeButton = createButton("Base64Decode");
        base64DecodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener == null) {
                    return;
                }
                listener.base64Decode();
            }
        });
        this.add(base64DecodeButton);
    }

}

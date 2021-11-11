package cn.rangaofei.urltool.codec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Base64CodecToolbar extends JPanel {
    private CodecButtonListener listener;

    public Base64CodecToolbar(CodecButtonListener listener) {
        this.listener = listener;
        initView();
    }

    private void initView() {
        this.setLayout(new GridLayout(1, 4));
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

    private JButton createButton(String text) {
        JButton jButton = new JButton();
        jButton.setText(text);
        return jButton;
    }
}

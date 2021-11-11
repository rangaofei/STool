package cn.rangaofei.urltool.codec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UrlCodecToolbar extends JPanel {

    private CodecButtonListener listener;

    public UrlCodecToolbar(CodecButtonListener listener) {
        this.listener = listener;
        initView();
    }

    private void initView(){
        this.setLayout(new GridLayout(1,4));
        JButton urlEncodeButton = createButton("UrlEncode");
        urlEncodeButton.addActionListener(e -> {
            if(listener==null){
                return;
            }
            listener.encodeClick();
        });
        this.add(urlEncodeButton);

        JButton urlDecodeButton = createButton("UrlDecode");
        urlDecodeButton.addActionListener(e -> {
            if(listener==null){
                return;
            }
            listener.decodeClick();
        });
        this.add(urlDecodeButton);
    }

    private JButton createButton(String text){
        JButton jButton = new JButton();
        jButton.setText(text);
        return jButton;
    }
}

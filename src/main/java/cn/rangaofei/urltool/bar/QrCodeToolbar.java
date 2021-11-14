package cn.rangaofei.urltool.bar;

import javax.swing.*;
import java.awt.*;

public class QrCodeToolbar extends JPanel{
    private BarCodeListener listener;

    public QrCodeToolbar(BarCodeListener listener) {
        this.listener = listener;
        initView();
    }

    private void initView() {
        this.setLayout(new GridLayout(1, 4));
        addGenerateButton();
    }

    private void addGenerateButton() {
        JButton button1 = new JButton("Generate");
        button1.addActionListener(e -> {
            if (listener == null) {
                return;
            }
            listener.qrCodeClick();
        });
        this.add(button1);
    }
}

package cn.rangaofei.urltool.bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarCodeToolbar extends JPanel {
    private BarCodeListener listener;

    public BarCodeToolbar(BarCodeListener listener) {
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
            listener.barCodeClick();
        });
        this.add(button1);
    }
}

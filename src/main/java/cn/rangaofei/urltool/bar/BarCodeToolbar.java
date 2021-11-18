package cn.rangaofei.urltool.bar;

import com.intellij.openapi.ui.ComboBox;

import javax.swing.*;
import java.awt.*;

public class BarCodeToolbar extends JPanel {
    private BarCodeListener listener;
    private ComboBox<BarcodeType> comboBox;

    public BarCodeToolbar(BarCodeListener listener) {
        this.listener = listener;
        initView();
    }

    private void initView() {
        this.setLayout(new GridLayout(1, 4));
        addGenerateButton();
        addComboBox();
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

    private void addComboBox() {
        comboBox = new ComboBox<>();
        for (BarcodeType type : BarcodeType.values()) {
            comboBox.addItem(type);
        }
        this.add(comboBox);
    }

    public BarcodeType getBarCodeType() {
        return (BarcodeType) comboBox.getSelectedItem();
    }
}

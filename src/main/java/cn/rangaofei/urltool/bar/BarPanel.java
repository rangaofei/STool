package cn.rangaofei.urltool.bar;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTabbedPane;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BarPanel extends JPanel {
    private JBTabbedPane tabbedPane;
    private JBLabel label;
    private BarCodeToolbar barCodeToolbar;
    private QrCodeToolbar qrCodeToolbar;
    private BarCodeListener listener;

    public BarPanel(BarCodeListener listener) {
        this.listener = listener;
        initView();
    }

    private void initView() {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        addCanvas();
        initBarCodeToolbar();
        initQrCodeToolbar();
        addTabbedPane();
    }

    private void addCanvas() {
        label = new JBLabel("", JBLabel.CENTER);
        this.add(label, BorderLayout.CENTER);
    }

    private void initBarCodeToolbar() {
        barCodeToolbar = new BarCodeToolbar(listener);
    }

    private void initQrCodeToolbar() {
        qrCodeToolbar = new QrCodeToolbar(listener);
    }

    private void addTabbedPane() {
        tabbedPane = new JBTabbedPane();
        tabbedPane.insertTab("BarCode", null, barCodeToolbar, "", 0);
        tabbedPane.insertTab("QrCode", null, qrCodeToolbar, "", 1);
        this.add(tabbedPane, BorderLayout.NORTH);
    }

    public BarcodeType getBarCodeType(){
        return barCodeToolbar.getBarCodeType();
    }

    public void setImage(BufferedImage image) {
        if (image == null) {
            return;
        }
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }
}

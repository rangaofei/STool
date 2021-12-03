package cn.rangaofei.urltool.bar;

import cn.rangaofei.urltool.BaseTextFieldPanel;
import com.google.zxing.WriterException;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTabbedPane;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BarPanel extends BaseTextFieldPanel {
    private JBTabbedPane tabbedPane;
    private JBLabel label;
    private BarCodeToolbar barCodeToolbar;
    private QrCodeToolbar qrCodeToolbar;
    private BarCodeListener listener;

    public BarPanel() {
        super();
        this.listener = new BarCodeListener() {
            @Override
            public void barCodeClick() {
                BufferedImage image = null;
                try {
                    image = BarcodeTool.generateBarCode39(getTextFileText(), getBarCodeType());
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                setImage(image);
            }

            @Override
            public void qrCodeClick() {
                BufferedImage image = null;
                try {
                    image = BarcodeTool.generateQrCode(getTextFileText());
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                setImage(image);
            }
        };
        initView();
    }

    private void initView() {
        addCanvas();
        initBarCodeToolbar();
        initQrCodeToolbar();
        addTabbedPane();
    }

    private void addCanvas() {
        label = new JBLabel("", JBLabel.CENTER);
        this.childAdd(label, BorderLayout.CENTER);
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
        this.childAdd(tabbedPane, BorderLayout.NORTH);
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

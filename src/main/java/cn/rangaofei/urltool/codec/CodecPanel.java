package cn.rangaofei.urltool.codec;

import cn.rangaofei.urltool.widget.ScrollTextArea;
import com.intellij.ui.components.JBTabbedPane;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CodecPanel extends JPanel {
    private ScrollTextArea textArea;
    private JBTabbedPane tabbedPane;

    private CodecButtonListener listener;
    private JPanel outputPanel;
    private ImagePane imagePane;

    public CodecPanel(CodecButtonListener listener) {
        this.listener = listener;
        initData();
    }

    private void initData() {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        addOutPutPane();
        addTabbedPane();
    }

    private void addTabbedPane() {
        tabbedPane = new JBTabbedPane();
        tabbedPane.insertTab("Url", null, new UrlCodecToolbar(listener), "", 0);
        tabbedPane.insertTab("Base64", null, new Base64CodecToolbar(listener), "", 1);
        tabbedPane.insertTab("Hex", null, new HexCodecToolbar(listener), "", 2);
        this.add(tabbedPane, BorderLayout.NORTH);
    }

    private void addOutPutPane(){
        outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        this.add(outputPanel,BorderLayout.CENTER);
        textArea = new ScrollTextArea();
        textArea.setBorder(JBUI.Borders.empty(10));
        imagePane = new ImagePane();
        imagePane.setBorder(JBUI.Borders.empty(10));
    }

    public void setText(String text) {
        textArea.setText(text);
        outputPanel.removeAll();
        outputPanel.add(textArea,BorderLayout.CENTER);
    }

    public void setImage(BufferedImage image){
        outputPanel.removeAll();
        imagePane.setImage(image);
        imagePane.repaint();
        outputPanel.add(imagePane,BorderLayout.CENTER);
    }

}

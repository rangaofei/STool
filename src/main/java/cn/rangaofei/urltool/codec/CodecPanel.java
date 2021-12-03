package cn.rangaofei.urltool.codec;

import cn.rangaofei.urltool.BaseTextFieldPanel;
import cn.rangaofei.urltool.CodecTool;
import cn.rangaofei.urltool.widget.ScrollTextArea;
import com.intellij.ui.components.JBTabbedPane;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CodecPanel extends BaseTextFieldPanel {
    private ScrollTextArea textArea;
    private JBTabbedPane tabbedPane;

    private CodecButtonListener listener;
    private JPanel outputPanel;
    private ImageScrollPane imagePane;

    public CodecPanel() {
        super();
        initData();
    }

    private void initData() {
        listener = new CodecButtonListener() {
            @Override
            public void encodeClick() {
                String str = CodecTool.encodeUrl(getTextFileText());
                setText(str);
            }

            @Override
            public void decodeClick() {
                String str = CodecTool.decodeUrl(getTextFileText());
                setText(str);
            }

            @Override
            public void base64Decode() {
                String inputText = getTextFileText();
                if (Base64Util.isImage(inputText)) {
                    int result = JOptionPane.showConfirmDialog(
                            CodecPanel.this,
                            "检测到当前文本为base64编码图片，是否显示为图片？",
                            "温馨提示",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE
                    );
                    System.out.println(result);
                    if (result == JOptionPane.YES_OPTION) {
                        try {
                            BufferedImage image = Base64Util.decodeBase64ToImage(inputText);
                            System.out.println("image ::" + (image == null));
                            setImage(image);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            String str = CodecTool.decodeBase64(inputText);
                            setText(str);
                        } catch (Exception e) {

                        }
                    }
                } else {
                    try {
                        String str = CodecTool.decodeBase64(inputText);
                        setText(str);
                    } catch (Exception e) {

                    }
                }
            }

            @Override
            public void base64DecodeImage() {

            }

            @Override
            public void base64Encode() {
                String str = CodecTool.encodeBase64(getTextFileText());
                setText(str);
            }

            @Override
            public void hexDecode() {
                String str = CodecTool.hexToString(getTextFileText());
                setText(str);
            }

            @Override
            public void hexEncode(String sep) {
                String str = CodecTool.stringToHex(getTextFileText(), sep);
                setText(str);
            }
        };
        addOutPutPane();
        addTabbedPane();
    }

    private void addTabbedPane() {
        tabbedPane = new JBTabbedPane();
        tabbedPane.insertTab("Url", null, new UrlCodecToolbar(listener), "", 0);
        tabbedPane.insertTab("Base64", null, new Base64CodecToolbar(listener), "", 1);
        tabbedPane.insertTab("Hex", null, new HexCodecToolbar(listener), "", 2);
        this.childAdd(tabbedPane, BorderLayout.NORTH);
    }

    private void addOutPutPane() {
        outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        this.childAdd(outputPanel, BorderLayout.CENTER);
        textArea = new ScrollTextArea();
        textArea.setBorder(JBUI.Borders.empty(10));
    }

    public void setText(String text) {
        textArea.setText(text);
        outputPanel.removeAll();
        outputPanel.add(textArea, BorderLayout.CENTER);
    }

    public void setImage(BufferedImage image) {
        outputPanel.removeAll();
        imagePane = new ImageScrollPane();
        imagePane.setBorder(JBUI.Borders.empty(10));
        imagePane.setImage(image);
        outputPanel.add(imagePane, BorderLayout.CENTER);
    }

}

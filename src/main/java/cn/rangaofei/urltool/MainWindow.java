package cn.rangaofei.urltool;

import cn.rangaofei.urltool.bar.BarCodeListener;
import cn.rangaofei.urltool.bar.BarPanel;
import cn.rangaofei.urltool.bar.BarcodeTool;
import cn.rangaofei.urltool.codec.Base64Util;
import cn.rangaofei.urltool.codec.CodecButtonListener;
import cn.rangaofei.urltool.codec.CodecPanel;
import cn.rangaofei.urltool.time.TimePanel;
import cn.rangaofei.urltool.url.UrlParseListener;
import cn.rangaofei.urltool.url.UrlToolPanel;
import cn.rangaofei.urltool.widget.ScrollTextArea;
import com.google.zxing.WriterException;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBTabbedPane;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainWindow extends JPanel {
    private ScrollTextArea urlEditor;
    private JBTabbedPane tabBar;
    private CodecPanel codecPanel;
    private BarPanel barPanel;
    private UrlToolPanel urlToolPanel;
    private TimePanel timePanel;

    public MainWindow(ToolWindow toolWindow) {
        initView();
    }

    private void initView() {
        this.setLayout(new BorderLayout());
        initEditor();
        initCodecPanel();
        initBarPanel();
        initUrlToolPanel();
        initTimePanel();
        initTab();
    }

    private void initCodecPanel() {
        codecPanel = new CodecPanel(new CodecButtonListener() {
            @Override
            public void encodeClick() {
                String str = CodecTool.encodeUrl(urlEditor.getText());
                codecPanel.setText(str);
            }

            @Override
            public void decodeClick() {
                String str = CodecTool.decodeUrl(urlEditor.getText());
                codecPanel.setText(str);
            }

            @Override
            public void base64Decode() {
                String inputText = urlEditor.getText();
                if (Base64Util.isImage(inputText)) {
                    int result = JOptionPane.showConfirmDialog(
                            MainWindow.this,
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
                            codecPanel.setImage(image);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String str = CodecTool.decodeBase64(inputText);
                        codecPanel.setText(str);
                    }
                } else {
                    String str = CodecTool.decodeBase64(inputText);
                    codecPanel.setText(str);
                }
            }

            @Override
            public void base64DecodeImage() {

            }

            @Override
            public void base64Encode() {
                String str = CodecTool.encodeBase64(urlEditor.getText());
                codecPanel.setText(str);
            }

            @Override
            public void hexDecode() {
                String str = CodecTool.hexToString(urlEditor.getText());
                codecPanel.setText(str);
            }

            @Override
            public void hexEncode(String sep) {
                String str = CodecTool.stringToHex(urlEditor.getText(), sep);
                codecPanel.setText(str);
            }
        });
    }

    private void initBarPanel() {
        barPanel = new BarPanel(new BarCodeListener() {
            @Override
            public void barCodeClick() {
                BufferedImage image = null;
                try {
                    image = BarcodeTool.generateBarCode39(urlEditor.getText(), barPanel.getBarCodeType());
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                barPanel.setImage(image);
            }

            @Override
            public void qrCodeClick() {
                BufferedImage image = null;
                try {
                    image = BarcodeTool.generateQrCode(urlEditor.getText());
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                barPanel.setImage(image);
            }
        });
    }

    private void initUrlToolPanel() {
        urlToolPanel = new UrlToolPanel(new UrlParseListener() {
            @Override
            public void urlParseClick() {
                urlToolPanel.setModelList(urlEditor.getText());
            }
        });
    }

    private void initTimePanel(){
        timePanel = new TimePanel();
    }

    private void initTab() {
        tabBar = new JBTabbedPane();
        tabBar.insertTab("Codec", null, codecPanel, "", 0);
        tabBar.insertTab("BarCode", null, barPanel, "", 1);
        tabBar.insertTab("Time",null,timePanel,"",2);
//        tabBar.insertTab("UrlTool", null, urlToolPanel, "", 2);
        this.add(tabBar, BorderLayout.CENTER);
    }

    private void initEditor() {
        urlEditor = new ScrollTextArea();
        urlEditor.setPreferredSize(new Dimension(this.getWidth(), 100));
        urlEditor.setBorder(JBUI.Borders.empty(10));
        this.add(urlEditor, BorderLayout.NORTH);
        urlEditor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    System.out.println("enter");
                    urlToolPanel.setModelList(urlEditor.getText());
                }
            }
        });
    }

}

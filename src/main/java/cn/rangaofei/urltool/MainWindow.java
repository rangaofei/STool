package cn.rangaofei.urltool;

import cn.rangaofei.urltool.codec.CodecButtonListener;
import cn.rangaofei.urltool.codec.CodecPanel;
import cn.rangaofei.urltool.widget.ScrollTextArea;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBTabbedPane;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JPanel {
    private ScrollTextArea urlEditor;
    private JBTabbedPane tabBar;
    private CodecPanel codecPanel;

    public MainWindow(ToolWindow toolWindow) {
        initView();
    }

    private void initView() {
        this.setLayout(new BorderLayout());
        initEditor();
        initCodecPanel();
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
                String str = CodecTool.decodeBase64(urlEditor.getText());
                codecPanel.setText(str);
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
                String str = CodecTool.stringToHex(urlEditor.getText(),sep);
                codecPanel.setText(str);
            }
        });
    }

    private void initTab() {
        tabBar = new JBTabbedPane();
        tabBar.insertTab("Codec", null, codecPanel, "", 0);
        this.add(tabBar, BorderLayout.CENTER);
    }

    private void initEditor() {
        urlEditor = new ScrollTextArea();
        urlEditor.setPreferredSize(new Dimension(this.getWidth(), 100));
        urlEditor.setBorder(JBUI.Borders.empty(10));
        this.add(urlEditor, BorderLayout.NORTH);
//        urlEditor.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
////                    updateDetail(urlEditor.getText());
//                }
//            }
//        });
    }

}

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
        initCodecPanel();
        initBarPanel();
        initUrlToolPanel();
        initTimePanel();
        initTab();
    }

    private void initCodecPanel() {
        codecPanel = new CodecPanel();
    }

    private void initBarPanel() {
        barPanel = new BarPanel();
    }

    private void initUrlToolPanel() {
        urlToolPanel = new UrlToolPanel(new UrlParseListener() {
            @Override
            public void urlParseClick() {
//                urlToolPanel.setModelList(urlEditor.getText());
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

}

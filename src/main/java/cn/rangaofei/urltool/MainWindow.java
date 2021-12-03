package cn.rangaofei.urltool;

import cn.rangaofei.urltool.bar.BarPanel;
import cn.rangaofei.urltool.codec.CodecPanel;
import cn.rangaofei.urltool.time.TimePanel;
import cn.rangaofei.urltool.url.UrlParseListener;
import cn.rangaofei.urltool.url.UrlToolPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBTabbedPane;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JPanel {
    private UrlToolPanel urlToolPanel;

    public MainWindow(ToolWindow toolWindow) {
        initView();
    }

    private void initView() {
        this.setLayout(new BorderLayout());
        initUrlToolPanel();
        initTab();
    }

    private void initUrlToolPanel() {
        urlToolPanel = new UrlToolPanel(new UrlParseListener() {
            @Override
            public void urlParseClick() {
//                urlToolPanel.setModelList(urlEditor.getText());
            }
        });
    }

    private void initTab() {
        JBTabbedPane tabBar = new JBTabbedPane();
        tabBar.insertTab("Codec", null, new CodecPanel(), "", 0);
        tabBar.insertTab("BarCode", null, new BarPanel(), "", 1);
        tabBar.insertTab("Time", null, new TimePanel(), "", 2);
//        tabBar.insertTab("UrlTool", null, urlToolPanel, "", 2);
        this.add(tabBar, BorderLayout.CENTER);
    }

}

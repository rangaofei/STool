package cn.rangaofei.urltool.url;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Vector;

public class UrlToolPanel extends JPanel {
    private JButton button;
    private UrlQueryParamList urlQueryParamList;
    private UrlParseListener listener;

    public UrlToolPanel(UrlParseListener listener) {
        this.listener = listener;
        initView();
    }

    private void initView() {
        this.setLayout(new BorderLayout());
        initList();
        initParseButton();
    }

    private void initParseButton() {
        button = new JButton("Parse");
        button.addActionListener(e -> {
            if (listener == null) {
                return;
            }
            listener.urlParseClick();
        });
        this.add(button, BorderLayout.NORTH);
    }

    private void initList() {
        urlQueryParamList = new UrlQueryParamList();
        this.add(urlQueryParamList, BorderLayout.CENTER);
    }

    public void setModelList(String url) {
        System.out.println(url);
        DefaultListModel<UrlModel> modelList = new DefaultListModel<>();
        if (StringUtils.isEmpty(url)) {
            urlQueryParamList.setModel(modelList);
            return;
        }
        try {
            Vector<UrlModel> modelVector = UrlTool.parseUrl(url);
            if (!modelVector.isEmpty()) {
                modelList.addAll(modelVector);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(modelList);
        urlQueryParamList.setModel(modelList);
    }
}

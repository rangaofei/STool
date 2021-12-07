package cn.rangaofei.urltool.url;

import cn.rangaofei.urltool.BaseTextFieldPanel;
import cn.rangaofei.urltool.SystemTool;
import cn.rangaofei.urltool.widget.SimpleDialog;
import com.intellij.ui.components.JBScrollPane;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class UrlToolPanel extends BaseTextFieldPanel {
    private JButton parseButton;
    private JButton generateButton;
    private UrlQueryParamList urlQueryParamList;
    private UrlParseListener listener;

    private static final String[] options = new String[]{"确认", "复制"};

    public UrlToolPanel() {
        super();
        this.listener = new UrlParseListener() {
            @Override
            public void urlParseClick() {
                setModelList(getTextFileText());
            }

            @Override
            public void urlGenerateClick() {
                String url = urlQueryParamList.getTemUrl();
                showUrlDialog(url);
            }
        };
        initView();
    }

    private void initView() {
        initList();
        initButton();
    }

    private void initButton() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        parseButton = new JButton("Parse");
        parseButton.addActionListener(e -> {
            if (listener == null) {
                return;
            }
            listener.urlParseClick();
        });
        jPanel.add(parseButton);
        generateButton = new JButton("Generate");
        generateButton.addActionListener(e -> {
            if (listener == null) {
                return;
            }
            listener.urlGenerateClick();
        });
        jPanel.add(generateButton);
        this.childAdd(jPanel, BorderLayout.NORTH);
    }

    private void initList() {
        urlQueryParamList = new UrlQueryParamList();
        JBScrollPane scrollPane = new JBScrollPane(urlQueryParamList);
        this.childAdd(scrollPane, BorderLayout.CENTER);
    }

    public void setModelList(String url) {
        List<UrlModel> modelList = new ArrayList<>();
        if (StringUtils.isEmpty(url)) {
            urlQueryParamList.setModelList(modelList);
            return;
        }
        try {
            List<UrlModel> modelVector = UrlTool.parseUrl(url);
            if (!modelVector.isEmpty()) {
                modelList.addAll(modelVector);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        urlQueryParamList.setModelList(modelList);
    }

    public void showUrlDialog(String url) {
        SimpleDialog simpleDialog = new SimpleDialog(null,this,"Message",url);
        simpleDialog.setVisible(true);
    }
}

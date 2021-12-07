package cn.rangaofei.urltool.widget;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextArea;

import javax.swing.*;
import java.awt.*;

public class SimpleDialog extends JDialog {

    public SimpleDialog(Frame owner,Component parentComponent,String title,String msg) {
        super(owner, true);
        this.setResizable(true);
        this.setLocationRelativeTo(parentComponent);
        initView(title, msg);
    }

    private void initView(String title,String msg) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        JBLabel label = new JBLabel(title,JBLabel.CENTER);
        jPanel.add(label, BorderLayout.NORTH);
        JBTextArea msgLabel = new JBTextArea(msg);
        msgLabel.setLineWrap(true);
        msgLabel.setEditable(false);
        msgLabel.setMaximumSize(new Dimension(250,-1));
        jPanel.add(msgLabel,BorderLayout.CENTER);
        JButton leftButton = new JButton("确定");
        jPanel.add(leftButton,BorderLayout.SOUTH);
        jPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        this.setContentPane(jPanel);
    }
}

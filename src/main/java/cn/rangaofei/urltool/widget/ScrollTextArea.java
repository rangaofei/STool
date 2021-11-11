package cn.rangaofei.urltool.widget;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTextArea;

import javax.swing.*;
import java.awt.*;

public class ScrollTextArea extends JBScrollPane {
    private JBTextArea textArea;

    public ScrollTextArea() {
        initView();
    }

    private void initView(){
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textArea = new JBTextArea();
        textArea.setLineWrap(true);
        textArea.setToolTipText("enter your string");
        this.setViewportView(textArea);
    }

    public String getText(){
        return textArea.getText();
    }

    public void setText(String text){
        this.textArea.setText(text);
    }
}

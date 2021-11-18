package cn.rangaofei.urltool.widget;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTextArea;

import javax.swing.*;
import java.awt.*;

public class ScrollTextArea extends JBScrollPane {
    private boolean wrapText;
    private JBTextArea textArea;

    public ScrollTextArea() {
        this(true);
    }

    public ScrollTextArea(boolean wrapText){
        this.wrapText = wrapText;
        initView(wrapText);
    }

    private void initView(boolean wrapText){
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textArea = new JBTextArea();
        textArea.setLineWrap(wrapText);
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

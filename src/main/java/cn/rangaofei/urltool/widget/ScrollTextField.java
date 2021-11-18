package cn.rangaofei.urltool.widget;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTextArea;
import com.intellij.ui.components.JBTextField;

import javax.swing.*;

public class ScrollTextField extends JBScrollPane {
    private JBTextField textField;

    public ScrollTextField() {
        initView();
    }

    private void initView(){
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        textField = new JBTextField();
        textField.setToolTipText("enter your string");
        this.setViewportView(textField);
    }

    public String getText(){
        return textField.getText();
    }

    public void setText(String text){
        this.textField.setText(text);
    }
}

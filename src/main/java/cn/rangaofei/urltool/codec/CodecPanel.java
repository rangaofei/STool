package cn.rangaofei.urltool.codec;

import cn.rangaofei.urltool.widget.ScrollTextArea;
import com.intellij.ui.components.JBTabbedPane;
import com.intellij.ui.components.JBTextArea;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CodecPanel extends JPanel {
    private ScrollTextArea textArea;
    private JBTabbedPane tabbedPane;

    private CodecButtonListener listener;

    public CodecPanel(CodecButtonListener listener) {
        this.listener = listener;
        initData();
    }

    private void initData(){
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        addOutPutText();
        addTabbedPane();
    }

    private void addTabbedPane(){
        tabbedPane = new JBTabbedPane();
        tabbedPane.insertTab("url",null,new UrlCodecToolbar(listener),"",0);
        tabbedPane.insertTab("base64",null,new Base64CodecToolbar(listener),"",1);
        this.add(tabbedPane,BorderLayout.NORTH);
    }


    private void addOutPutText(){
        textArea = new ScrollTextArea();
        textArea.setBorder(JBUI.Borders.empty(10));
        this.add(textArea,BorderLayout.CENTER);
    }

    public void setText(String text){
        textArea.setText(text);
    }

}

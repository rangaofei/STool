package cn.rangaofei.urltool;

import cn.rangaofei.urltool.widget.ScrollTextArea;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BaseTextFieldPanel extends JPanel {

    private ScrollTextArea headerEditor;
    private JPanel container;

    public BaseTextFieldPanel() {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        initEditor();
        initContainer();
    }

    protected void headerEnterClick(String text){

    }


    protected String getTextFileText(){
        return headerEditor.getText();
    }

    private void initEditor() {
        headerEditor = new ScrollTextArea();
        headerEditor.setPreferredSize(new Dimension(this.getWidth(), 100));
        headerEditor.setBorder(JBUI.Borders.empty(10));
        this.add(headerEditor, BorderLayout.NORTH);
        headerEditor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    headerEnterClick(headerEditor.getText());
                }
            }
        });
    }

    private void initContainer(){
        container = new JPanel();
        container.setLayout(new BorderLayout());
        this.add(container);
    }

    public void childAdd(@NotNull Component comp, Object constraints) {
        this.container.add(comp, constraints);
    }
}

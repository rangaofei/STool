package cn.rangaofei.urltool.widget;

import javax.swing.*;

public class CreateButtonPanel extends JPanel{
    protected JButton createButton(String text){
        JButton jButton = new JButton();
        jButton.setText(text);
        return jButton;
    }
}

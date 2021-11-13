package cn.rangaofei.urltool.codec;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBTextField;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HexCodecToolbar extends AbstractCodecPanel {
    private JBTextField separator;
    private JBCheckBox checkBox;

    public HexCodecToolbar(CodecButtonListener listener) {
        super(listener);
    }


    protected void initView() {
        JButton urlEncodeButton = createButton("HexEncode");
        urlEncodeButton.addActionListener(e -> {
            if (listener == null) {
                return;
            }
            String sep = !checkBox.isSelected() ? "" : separator.getText();
            listener.hexEncode(sep);
        });
        this.add(urlEncodeButton);

        JButton urlDecodeButton = createButton("HexDecode");
        urlDecodeButton.addActionListener(e -> {
            if (listener == null) {
                return;
            }
            listener.hexDecode();
        });
        this.add(urlDecodeButton);


        checkBox = new JBCheckBox("Separator");
        checkBox.addItemListener(e -> {
            JBCheckBox checkBox1 = (JBCheckBox) e.getSource();
            separator.setVisible(checkBox1.isSelected());
        });
        this.add(checkBox);

        separator = new JBTextField();
        separator.setVisible(false);
        this.add(separator);
    }
}

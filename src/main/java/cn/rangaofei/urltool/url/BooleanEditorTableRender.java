package cn.rangaofei.urltool.url;

import com.intellij.ui.components.JBCheckBox;

import javax.swing.*;
import java.awt.*;

public class BooleanEditorTableRender extends DefaultCellEditor {
    public BooleanEditorTableRender() {
        super(new JBCheckBox());
        JBCheckBox checkBox = (JBCheckBox) getComponent();
        checkBox.setHorizontalAlignment(JCheckBox.CENTER);
    }
}

package cn.rangaofei.urltool.url;

import com.intellij.ui.components.JBCheckBox;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class BooleanTableRender extends JBCheckBox implements TableCellRenderer, UIResource {

    private final Border noFocusBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);

    public BooleanTableRender() {
        setHorizontalAlignment(JCheckBox.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            super.setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        setSelected((value != null && (Boolean) value));

//        if (hasFocus) {
//            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
//        } else {
//            setBorder(noFocusBorder);
//        }

        return this;
    }
}

package cn.rangaofei.urltool.url;

import cn.rangaofei.urltool.widget.ScrollTextField;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBTextField;

import javax.swing.*;
import java.awt.*;

public class UrlItemRender extends JPanel implements ListCellRenderer<UrlModel> {
    private JLabel keyField;
    private JBTextField valueField;

    public UrlItemRender() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        keyField = new JLabel();
        keyField.setMaximumSize(new Dimension(70, 30));
        keyField.setPreferredSize(new Dimension(70, 30));
        this.add(keyField);

        valueField = new JBTextField();
        valueField.setEditable(true);
        valueField.setPreferredSize(new Dimension(50, 30));
        this.add(valueField);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends UrlModel> list,
                                                  UrlModel value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        initView(list, value, isSelected);
        return this;
    }


    private void initView(JList<? extends UrlModel> list, UrlModel pair, boolean isSelected) {
        keyField.setText(pair.getKey());
        valueField.setText(pair.isSelected() ? "选中" : pair.getValue());
        if(pair.isSelected()){
            valueField.setEnabled(true);
            valueField.setEditable(true);
            valueField.grabFocus();
        }
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
    }
}

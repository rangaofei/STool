package cn.rangaofei.urltool.url;

import cn.rangaofei.urltool.widget.ScrollTextField;
import com.intellij.ui.components.JBTextField;

import javax.swing.*;
import java.awt.*;

public class UrlItemRender extends JPanel implements ListCellRenderer<UrlModel> {
    private ScrollTextField keyField;
    private ScrollTextField valueField;

    public UrlItemRender() {
        this.setLayout(new GridLayout());

        keyField = new ScrollTextField();
        this.add(keyField);

        valueField = new ScrollTextField();
        this.add(valueField);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends UrlModel> list,
                                                  UrlModel value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        keyField.setPreferredSize(new Dimension(100,-1));
        keyField.setMinimumSize(new Dimension(100,-1));
        keyField.setMaximumSize(new Dimension(100,-1));
        initView(value);
        return this;
    }

    private void initView(UrlModel pair) {
        keyField.setText(pair.getKey());
        valueField.setText(pair.getValue());
    }
}

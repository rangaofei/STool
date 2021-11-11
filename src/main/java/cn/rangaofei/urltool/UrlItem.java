package cn.rangaofei.urltool;

import javax.swing.*;
import java.awt.*;

public class UrlItem implements ListCellRenderer<UrlModel> {
    private JPanel item;
    private JTextArea key;
    private JTextArea value;

    public UrlItem() {
    }

    public void setData(UrlModel model) {
        GridBagLayout gridBag = new GridBagLayout();
        item = new JPanel(gridBag);
        this.key = new JTextArea();
        this.value = new JTextArea();
        this.key.setText(model.getKey());
        this.value.setText(model.getValue());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridwidth = GridBagConstraints.RELATIVE;
        c1.fill = GridBagConstraints.BOTH;
        c1.anchor = GridBagConstraints.EAST;
        gridBag.addLayoutComponent(key,c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridwidth = GridBagConstraints.REMAINDER;
        c2.anchor = GridBagConstraints.EAST;
        gridBag.addLayoutComponent(value,c2);

        item.add(key);
        item.add(value);
    }


    @Override
    public Component getListCellRendererComponent(JList<? extends UrlModel> list,
                                                  UrlModel value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        setData(value);
        return item;
    }
}

package cn.rangaofei.urltool.url;

import com.intellij.ui.components.JBList;

import javax.swing.*;
import java.awt.*;

public class UrlQueryParamList extends JBList<UrlModel> {
    public UrlQueryParamList() {
        initView();
    }

    private void initView(){
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setFixedCellWidth(200);
        this.setCellRenderer(new UrlItemRender());
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return super.getScrollableUnitIncrement(visibleRect, orientation, direction);
    }
}

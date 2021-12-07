package cn.rangaofei.urltool.url;

import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.List;

public class UrlQueryParamList extends JBTable {
    private UrlTableModel model;

    public UrlQueryParamList() {
        initView();
    }

    private void initView() {
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model = new UrlTableModel();
        this.setModel(model);

        TableColumnModel tcm = this.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setMinWidth(30);
        tc.setMaxWidth(30);
        tc.setPreferredWidth(30);
        tc.setCellRenderer(new BooleanTableRender());
        tc.setCellEditor(new BooleanEditorTableRender());
        this.setColumnModel(tcm);
    }

    public void setModelList(List<UrlModel> dataList) {
        model.setModelList(dataList);
    }

    public String getTemUrl(){
        StringBuilder sb =new StringBuilder();
        List<UrlModel> modelList =  model.getModelList();
        for (UrlModel urlModel:modelList){
            if(!urlModel.isSelected()){
                continue;
            }
            sb.append(urlModel.getValue());
        }
        return sb.toString();
    }
}

package cn.rangaofei.urltool.url;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class UrlTableModel extends AbstractTableModel {
    private List<UrlModel> modelList = new ArrayList<>();

    public UrlTableModel() {
    }

    public void setModelList(List<UrlModel> modelList) {
        this.modelList.clear();
        if (modelList == null) {
            return;
        }
        this.modelList.addAll(modelList);
    }

    public List<UrlModel> getModelList() {
        return modelList;
    }

    public void add(UrlModel model) {
        modelList.add(model);
        fireTableRowsInserted(modelList.size() - 1, modelList.size() - 1);
    }

    public void remove(int index) {
        modelList.remove(index);
        fireTableRowsDeleted(index, index);
    }

    @Override
    public int getRowCount() {
        return modelList == null ? 0 : modelList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        UrlModel model = modelList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                model.setSelected((Boolean) aValue);
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UrlModel model = modelList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.isSelected();
            case 1:
                return model.getKey();
            case 2:
                return model.getValue();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2 || columnIndex == 0;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "";
            case 1:
                return "segment";
            case 2:
                return "value";
            default:
                return "";
        }
    }
}

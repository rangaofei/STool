package cn.rangaofei.urltool.codec;

import cn.rangaofei.urltool.widget.CreateButtonPanel;

import java.awt.*;

public abstract class AbstractCodecPanel extends CreateButtonPanel {
    protected CodecButtonListener listener;

    public AbstractCodecPanel(CodecButtonListener listener) {
        this.listener = listener;
        this.setLayout(new GridLayout(1, 4));
        initView();
    }

    protected abstract void initView();
}

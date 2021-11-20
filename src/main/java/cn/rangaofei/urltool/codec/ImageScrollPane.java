package cn.rangaofei.urltool.codec;

import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageScrollPane extends JBScrollPane {
    private ImagePane imagePane;

    public ImageScrollPane() {

    }

    public void setImage(BufferedImage image) {
        imagePane = new ImagePane(image);
        imagePane.setPreferredSize(new Dimension(imagePane.getImgWidth(),imagePane.getImgHeight()));
        this.setViewportView(imagePane);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
}

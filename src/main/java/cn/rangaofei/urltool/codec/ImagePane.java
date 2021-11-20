package cn.rangaofei.urltool.codec;

import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePane extends JPanel {
    private BufferedImage image;
    private int imgWidth;
    private int imgHeight;


    public ImagePane(BufferedImage image) {
        setImage(image);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.imgWidth = image.getWidth(this);
        this.imgHeight = image.getHeight(this);
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    @Override
    public void paint(Graphics g1) {
        int x = 0;
        int y = 0;
        Graphics g = g1;
        if (null == image) {
            return;
        }
        int x1 = this.getWidth() - imgWidth;
        if (x1 > 0) {
            x = x1 / 2;
        }
        int y1 = this.getHeight() - imgHeight;
        if (y1 > 0) {
            y = y1 / 2;
        }
        g.drawImage(image, x, y, image.getWidth(this), image.getHeight(this), this);
        g = null;
    }
}

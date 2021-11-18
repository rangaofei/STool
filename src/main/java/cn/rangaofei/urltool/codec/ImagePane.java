package cn.rangaofei.urltool.codec;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePane extends JPanel {
    private BufferedImage image;

    public ImagePane() {
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        System.out.println("image size ::" + image.getWidth() + "*" + image.getHeight());
        System.out.println("this size ::" + this.getPreferredSize().getWidth() + "*" + this.getPreferredSize().getHeight());
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

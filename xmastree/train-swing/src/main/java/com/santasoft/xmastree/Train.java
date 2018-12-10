package com.santasoft.xmastree;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Train extends JLabel {

    public Train() throws IOException {
        ImageIcon icon = new ImageIcon(ImageIO.read(Train.class.getResource("/com/santasoft/xmastree/train.png")));
        setIcon(icon);
        setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
    }
}
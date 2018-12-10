package com.santasoft.xmastree;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Ornaments extends JLabel {

    public Ornaments() throws IOException {
        ImageIcon icon = new ImageIcon(ImageIO.read(Ornaments.class.getResource("/com/santasoft/xmastree/ornaments.png")));
        setIcon(icon);
        setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
    }
}
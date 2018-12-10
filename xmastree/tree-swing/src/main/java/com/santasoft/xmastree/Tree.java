package com.santasoft.xmastree;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tree extends JLabel {

    public Tree() throws IOException {
        ImageIcon icon = new ImageIcon(ImageIO.read(Tree.class.getResource("/com/santasoft/xmastree/tree.png")));
        setIcon(icon);
        setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
    }

    public static void compose(Object container) {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(128, 160));

        try {
            layeredPane.add(new Tree(), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        addFromClasspath("Ornaments", layeredPane);
        addFromClasspath("Train", layeredPane);
        addFromClasspath("Lights", layeredPane);

        ((JFrame) container).setContentPane(layeredPane);
    }

    private static void addFromClasspath(String component, JLayeredPane layeredPane) {
        try {
            layeredPane.add((JLabel) Class.forName("com.santasoft.xmastree." + component).getDeclaredConstructor().newInstance(), 0);
        } catch (Exception e) {
            // component was not requested
        }
    }
}
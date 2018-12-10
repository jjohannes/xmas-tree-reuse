package com.null8fuffzehn.app;

import javax.swing.*;
import java.awt.*;

public class DesktopApp {

    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new JLayeredPane());

        com.santasoft.xmastree.Tree.compose(frame);

        frame.getContentPane().setPreferredSize(new Dimension(128, 180));

        JLabel title = new JLabel(" NULL 8 FUFFZEHN");
        title.setBounds(0, 0, 128, 25);
        frame.getContentPane().add(title, 0);

        JButton button = new JButton("LEND MONEY");
        button.setBounds(0, 150, 128, 25);
        frame.getContentPane().add(button, 0);

        frame.pack();
        frame.setVisible(true);
    }
}

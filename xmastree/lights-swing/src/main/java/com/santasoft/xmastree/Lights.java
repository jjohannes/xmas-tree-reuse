package com.santasoft.xmastree;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Lights extends JLabel {
    private boolean animating = false;

    private final ImageIcon icon = new ImageIcon(ImageIO.read(Lights.class.getResource("/com/santasoft/xmastree/lights.png")));
    private final ImageIcon icon2 = new ImageIcon(ImageIO.read(Lights.class.getResource("/com/santasoft/xmastree/lights_on.png")));

    public Lights() throws IOException {
        setIcon(icon);
        setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                animating = !animating;
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (animating) {
                    setIcon(getIcon() == icon ? icon2 : icon);
                    invalidate();
                }
            }
        }, 0, 180);
    }

}
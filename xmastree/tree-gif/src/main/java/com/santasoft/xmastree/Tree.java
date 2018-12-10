package com.santasoft.xmastree;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Tree {

    public static void main(String... args) {
        compose(null);
    }

    public static void compose(Object container) {
        try {
            BufferedImage first = ImageIO.read(Tree.class.getResource("/com/santasoft/xmastree/tree.png"));
            ImageOutputStream output = new FileImageOutputStream(new File("decorated-tree.gif"));

            GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 250, true);
            writer.writeToSequence(first);

            List<BufferedImage> images = new ArrayList<>();

            addFromClasspath("Ornaments", images);
            addFromClasspath("Train", images);
            addFromClasspath("Lights", images);

            for (BufferedImage image : images) {
                writer.writeToSequence(image);
            }

            writer.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFromClasspath(String component, List<BufferedImage> images) {
        try {
            URL resource = Tree.class.getResource("/com/santasoft/xmastree/" + component.toLowerCase() + ".png");
            if (resource != null) {
                images.add(ImageIO.read(resource));
            }
        } catch (Exception e) {
            // component was not requested
        }
    }
}
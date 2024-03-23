package src;

import javax.swing.*;

public class GraphicElement {
    JLabel image;
    String name;
    int size;

    public GraphicElement(String name, int size) {
//        this.image = new ImageIcon();
        this.image = new JLabel(new ImageIcon("resources/"+name));
        this.name = name;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public JLabel setImage(JLabel image) {
        this.image = image;
        return image;
    }

    public String getName() {
        return name;
    }

    public JLabel getImage() {
        return image;
    }

    public int getSize() {
        return size;
    }
}
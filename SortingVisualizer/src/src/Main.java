package src;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<GraphicElement> elements = createExampleElements();

        SortingVisualizer visualizer = new SortingVisualizer(elements);
    }

    private static List<GraphicElement> createExampleElements() {

        List<GraphicElement> elements = new ArrayList<>();

        /*
        GraphicElement img = new GraphicElement("img.png", 290);
        GraphicElement img_1 = new GraphicElement("img_1.png", 318);
        GraphicElement img_2 = new GraphicElement("img_2.png", 290);
        GraphicElement img_3 = new GraphicElement("img_3.png", 283);
        GraphicElement img_4 = new GraphicElement("img4.png", 225);
        GraphicElement img_5 = new GraphicElement("img_5.png", 275);

         */

        elements.add(new GraphicElement("1.png", 300));
        elements.add(new GraphicElement("2.png", 157));
        elements.add(new GraphicElement("3.png", 101));
        elements.add(new GraphicElement("4.png", 192));

        /*
        elements.add(new GraphicElement("img.png", 290));
        elements.add(new GraphicElement("img_1.png", 318));
        elements.add(new GraphicElement("img_2.png", 290));
        elements.add(new GraphicElement("img_3.png", 283));
        elements.add(new GraphicElement("img_4.png", 225));
        elements.add(new GraphicElement("img_5.png", 275));
        */

        return elements;
    }

}

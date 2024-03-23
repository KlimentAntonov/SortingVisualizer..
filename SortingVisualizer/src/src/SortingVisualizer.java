package src;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SortingVisualizer extends JFrame {
    private final JComboBox<String> sortingAlgorithmsComboBox;
    private final JButton sortButton;
    private final JPanel panel;
    private final List<GraphicElement> elements;

    public SortingVisualizer(List<GraphicElement> elements) {
        this.elements = elements;
        setTitle("Sorting Visualizer");
        setSize(1600, 1200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        sortingAlgorithmsComboBox = new JComboBox<>(new String[]{"Bubble sort", "Selection sort", "Insertion sort", "Merge sort", "Quick sort", "Heap sort"});
        sortButton = new JButton("Sort");
        panel = new JPanel();

        panel.setLayout(null);
        panel.setBounds(0,0,1600,1200);
        panel.setBorder(new LineBorder(Color.RED,2));

        sortingAlgorithmsComboBox.setBounds(10,10,200,30);
        sortingAlgorithmsComboBox.setBorder(new LineBorder(Color.RED,2));

        sortButton.setBounds(240,10,100,30);
        sortButton.setBorder(new LineBorder(Color.RED,2));

        panel.add(sortingAlgorithmsComboBox);
        panel.add(sortButton);

        JPanel imgPnl = new JPanel();
        imgPnl.setBounds(0,-200,1600,1200);
        imgPnl.setLayout(new GridLayout(1,5));
        imgPnl.setBorder(new LineBorder(Color.RED,2));
        imgPnl.setBackground(Color.RED);


        for(GraphicElement el : elements) {
            imgPnl.add(el.getImage());

        }

        panel.add(imgPnl);
        add(panel);

        setVisible(true);

        sortButton.addActionListener(e -> {
            String selectedAlgorithm = (String) sortingAlgorithmsComboBox.getSelectedItem();
            switch (selectedAlgorithm) {
                case "Bubble sort":
                    bubblesort();
                    break;
                case "Selection sort":
                    selectionsort();
                    break;
                case "Insertion sort":
                    insertionsort();
                    break;
                case "Merge sort":
                    mergeSort();
                    break;
                case "Quick sort":
                    quicksort();
                    break;
            }
        });
    }

    private void bubblesort() {
        int n = elements.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elements.get(j).getSize() > elements.get(j + 1).getSize()) {
                    GraphicElement temp = elements.get(j);
                    elements.set(j, elements.get(j + 1));
                    elements.set(j + 1, temp);

                    panel.repaint();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }


    private void selectionsort() {
        int n = elements.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (elements.get(j).getSize() < elements.get(minIndex).getSize()) {
                    minIndex = j;
                }
            }

            GraphicElement temp = elements.get(minIndex);
            elements.set(minIndex, elements.get(i));
            elements.set(i, temp);

            panel.repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }


    private void insertionsort() {
        int n = elements.size();
        for (int i = 1; i < n; i++) {
            GraphicElement key = elements.get(i);
            int j = i - 1;
            while (j >= 0 && elements.get(j).getSize() > key.getSize()) {
                elements.set(j + 1, elements.get(j));
                j = j - 1;

                panel.repaint();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            elements.set(j + 1, key);
        }
    }


    private void mergeSort() {
        mergeSortHelper(0, elements.size() - 1);
    }

    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortHelper(left, middle);
            mergeSortHelper(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        List<GraphicElement> leftArray = new ArrayList<>(n1);
        List<GraphicElement> rightArray = new ArrayList<>(n2);

        for (int i = 0; i < n1; ++i) {
            leftArray.add(elements.get(left + i));
        }
        for (int j = 0; j < n2; ++j) {
            rightArray.add(elements.get(middle + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray.get(i).getSize() <= rightArray.get(j).getSize()) {
                elements.set(k, leftArray.get(i));
                i++;
            } else {
                elements.set(k, rightArray.get(j));
                j++;
            }
            k++;

            panel.repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        while (i < n1) {
            elements.set(k, leftArray.get(i));
            i++;
            k++;

            panel.repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        while (j < n2) {
            elements.set(k, rightArray.get(j));
            j++;
            k++;

            panel.repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }


    private void quicksort() {
        quicksortHelper(0, elements.size() - 1);
    }

    private void quicksortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quicksortHelper(low, pi - 1);
            quicksortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = elements.get(high).getSize();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (elements.get(j).getSize() < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        GraphicElement temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);

        panel.repaint();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void heapsort() {
        int n = elements.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(0, i);

            heapify(i, 0);
        }
    }

    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && elements.get(left).getSize() > elements.get(largest).getSize())
            largest = left;

        if (right < n && elements.get(right).getSize() > elements.get(largest).getSize())
            largest = right;

        if (largest != i) {
            swap(i, largest);

            heapify(n, largest);
        }
    }

}
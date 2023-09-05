import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public  class MainWindow extends JFrame {
    static int WIDTH = 739;
    static int HEIGHT = 400;

    static OutputPanel sinPanel;
    static OutputPanel cosPanel;
    static OutputPanel tanPanel;

    MainWindow(){
        super("~ShapeToWaves~");
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
//                setSize(getHeight()*739/400, getHeight());

                WIDTH = getWidth();
                HEIGHT = getHeight();

            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
//        setLayout(new FlowLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
//        mainPanel.setLayout(new FlowLayout());
        add(mainPanel);
        setResizable(false);
        setVisible(true);




        //add panel where user will draw a shape
        InputPanel panInput = new InputPanel();
        mainPanel.add(panInput);

        //add output graphs
        JPanel panGraphs = new JPanel();
        panGraphs.setLayout(new BoxLayout(panGraphs, BoxLayout.Y_AXIS));
        sinPanel = new OutputPanel("dy", Color.MAGENTA);
        cosPanel = new OutputPanel("dx", Color.GREEN);
        tanPanel = new OutputPanel("dy/dx", Color.CYAN);
        panGraphs.add(sinPanel);
        panGraphs.add(cosPanel);
        panGraphs.add(tanPanel);

        mainPanel.add(panGraphs);
    }


    public static void findGraphs(ArrayList<myPoint> pointsOfShape){

    }

}

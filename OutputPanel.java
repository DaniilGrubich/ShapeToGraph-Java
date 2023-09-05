import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class OutputPanel extends JPanel {
    ArrayList<Double> points = new ArrayList<>();
    ArrayList<Integer> degreeOfPoint = new ArrayList<>();
    String name;
    Color color;
    OutputPanel(String name, Color color){
        this.name = name + " vs degrees";
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        setSize(MainWindow.WIDTH-MainWindow.HEIGHT+39, (MainWindow.HEIGHT-39)/3);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(1, 1, getWidth()-2, getHeight()-2);

        g2.setColor(Color.lightGray);
        g2.drawLine(10, 1, 10, getHeight()-2);
        g2.drawString(name, 20, 15);

        g2.drawLine(10, getHeight()/2, getWidth()-20, getHeight()/2);


        g2.setColor(color);
        if(points != null)
        {
            double highestPoint = findHiestNum(points);
            double highestDegree = 360;
            for (int i = 0; i < points.size(); i++) {
                double relativePoint = getHeight()*points.get(i)/highestPoint/2;
                double relativeDegree = (getWidth()-20)*degreeOfPoint.get(i)/360;

                g2.drawRect((int) (relativeDegree+10), (int)relativePoint+getHeight()/2, 1,1);
            }
        }
    }

    public void setPoints(double[] points, int[] degrees) {
        this.points = new ArrayList<>();
        this.degreeOfPoint = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            this.points.add(points[i]);
            this.degreeOfPoint.add(degrees[i]);
        }
        repaint();
    }

    public double findHiestNum(ArrayList<Double> xs) {
        double highest = 0;
        for (double d :
                xs) {
            if (Math.abs(d) > highest)
                highest = Math.abs(d);
        }
        return highest;
    }
}

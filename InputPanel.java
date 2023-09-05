import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InputPanel extends JPanel {
    Point center;
    boolean pressed = false;
    ArrayList<Point> pointsOfShape = new ArrayList<>();
    ArrayList<myPoint> pointsOfShapeXY = new ArrayList<>();

    static int WIDTH = MainWindow.HEIGHT-39;
    static int HEIGHT = MainWindow.HEIGHT-39;

    InputPanel(){

         addMouseMotionListener(new MouseMotionAdapter() {
             @Override
             public void mouseDragged(MouseEvent e) {
                 pointsOfShape.add(new Point(e.getX(), e.getY()));
                 pointsOfShapeXY.add(new myPoint(e.getX(), e.getY(), center));
                 repaint();
             }
         });

         addMouseListener(new MouseAdapter() {
             @Override
             public void mouseReleased(MouseEvent e) {
//                 Collections.sort(pointsOfShapeXY);

//                 System.out.println("++++++");
//                 for (myPoint p :
//                         pointsOfShapeXY) {
//                     System.out.println(p.dergees);
//                 }
//                 System.out.println("++++++");

                 int degrees[] = new int[pointsOfShapeXY.size()];
                 double cosPoints[] = new double[pointsOfShapeXY.size()];
                 double sinPoints[] = new double[pointsOfShapeXY.size()];
                 double tanPoints[] = new double[pointsOfShapeXY.size()];

                 for (int i = 0; i < pointsOfShapeXY.size(); i++) {

                     degrees[i] = pointsOfShapeXY.get(i).TotalDergees;
                     sinPoints[i] = -pointsOfShapeXY.get(i).y;
                     cosPoints[i] = -pointsOfShapeXY.get(i).x;
                     tanPoints[i] = sinPoints[i]/cosPoints[i];


                 }
                 MainWindow.cosPanel.setPoints(cosPoints, degrees);
                 MainWindow.sinPanel.setPoints(sinPoints, degrees);
                 MainWindow.tanPanel.setPoints(tanPoints, degrees);


                 pointsOfShape = new ArrayList<>();
                 pointsOfShapeXY = new ArrayList<>();
             }
         });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        WIDTH = MainWindow.HEIGHT-39;
        HEIGHT = MainWindow.HEIGHT-39;
        setSize(WIDTH, HEIGHT);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.DARK_GRAY);
        g.fillRect(1, 1, getWidth()-2, getHeight()-2);

        g.setColor(Color.WHITE);
        center = new Point(getWidth()/2, getHeight()/2);
        g.fillRect(getWidth()/2, getHeight()/2, 1, 1);

        if(pointsOfShape.size()>0){
            g.setColor(Color.pink);
            for (Point p :
                    pointsOfShape) {
                g.drawRect(p.x, p.y, 1, 1);
            }
        }

    }
}

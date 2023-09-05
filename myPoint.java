import java.awt.*;

public class myPoint extends Point {

    int  TotalDergees;  //horizontal to center point
    double distance;
    myPoint(int x, int y, Point center){
        super(x - center.x, -(y-center.y));
        distance = Math.sqrt(this.x*this.x+this.y*this.y);
        double Sdergees = Math.toDegrees(Math.asin(this.y/(distance)));
        double Cdergees = Math.toDegrees(Math.acos(this.x/(distance)));

        if(Cdergees > 0&& Sdergees > 0)
            TotalDergees = (int) Cdergees;
        else if(Sdergees<0 && Cdergees>0)
            TotalDergees = (int) (180+(180-Cdergees));
    }
//    @Override
//    public int compareTo(Object o) {
//        if(this.TotalDergees<((myPoint)o).TotalDergees)
//            return -1;
//        else if(this.TotalDergees>((myPoint)o).TotalDergees)
//            return 1;
//        else
//            return 0;
//    }
}

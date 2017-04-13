import java.util.Random;

/**
 * Created by sreps on 1/12/2017.
 */
public class pie {
    public static void main(String[] args) {
        double counter1=1,counter2=1, x, y ,distance;
        while(true){
            counter1++;
            Random rand = new Random();
            x = rand.nextInt(10000) + 1;
            y = rand.nextInt(10000) + 1;
            // two point formula (distance from origin)
            distance = Math.sqrt((x*x + y*y));
            if(distance < (10000))
                counter2++;
            System.out.println(String.format("%f\n", 4 * (counter2/(counter1))));
        }
    }
}

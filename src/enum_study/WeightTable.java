package enum_study;

import java.util.Scanner;

/**
 * Created by Stone on 2017/7/26.
 *
 * @author Stone<Stone305585@live.com>
 */
public class WeightTable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double earthWeight = Integer.valueOf(sc.nextLine());



        double mass = earthWeight / Planet.VENUS.getSurfaceGravity();

        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %.3f asdf ---> %d", p.toString(), p.getSurfaceWeight(mass), 348538547283543l);
        }
    }
}

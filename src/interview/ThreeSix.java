package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/9/10.
 */
public class ThreeSix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String allFlag = sc.nextLine();
            String firstTimes = sc.nextLine();
            String secondTimes = sc.nextLine();

            char[] allArray = allFlag.toCharArray();
            char[] firstArray = firstTimes.toCharArray();
            char[] secondArray = secondTimes.toCharArray();

            boolean forward1 = false;
            boolean forward2 = false;
            boolean backward1 = false;
            boolean backward2 = false;

            String res = "invalid";

            if(firstArray.length > allArray.length || secondArray.length > allArray.length ||
                    firstArray.length + secondArray.length > allArray.length) {
                System.out.print(res);
            } else {
                for(int i = 0; i < allArray.length; i++) {

                    //正向1
                    if(!forward1 && allArray[i] == firstArray[0]) {
                        forward1 = hasSubForward(i, allArray, firstArray);
                    }

                    //逆向1
                    if(!backward2 && i >= (secondArray.length - 1) && allArray[i] == secondArray[secondArray.length - 1]) {
                        backward2 = hasSubBackward(i, allArray, secondArray);
                    }

                    //正向2
                    if(forward1 && (allArray.length - i - firstArray.length) >= secondArray.length
                            && !backward1 && allArray[i + firstArray.length] == secondArray[0]) {
                        backward1 = hasSubForward(i + firstArray.length, allArray, secondArray);
                    }


                    //逆向2
                    if(backward1 && !forward2 && (allArray.length - i - secondArray.length) >= firstArray.length
                            && allArray[i + firstArray.length] == firstArray[firstArray.length - 1]) {
                        forward2 = hasSubBackward(i + firstArray.length, allArray, firstArray);
                    }
                    if(forward1 && backward1){
                        if(res.equals("backward")) {
                            res = "both";
                        } else {
                            res = "forward";
                        }
                    }



                    if(forward2 && backward2) {
                        if(res.equals("forward")) {
                            res = "both";
                        } else {
                            res = "backward";
                        }
                    }

                }

                System.out.print(res);
            }



        }

    }

    public static boolean hasSubForward(int index, char[] allArray, char[] subArray) {

        for (int i = index; i < subArray.length + index; i++) {
            if (subArray[i - index] != allArray[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean hasSubBackward (int index, char[] allArray, char[] subArray) {

        if(index == subArray.length - 1) {
            for(int j = index; j >= 0; j--) {
                if(subArray[index - j] != allArray[j]) {
                    return false;
                }
            }
        } else {
            //index 必须大于等于 sub 长度
            for (int i = index; i > index - subArray.length; i--) {
                if (subArray[index - i] != allArray[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}

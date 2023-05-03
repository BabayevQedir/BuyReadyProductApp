package account;

import java.util.Scanner;

public class RequireScanner {
    public static int requireNumberInt(String text){
        Scanner scanner=new Scanner(System.in);
        System.out.println(text);
        int answer=scanner.nextInt();
        return answer;
    }

    public static String  requireTextString(String text){
        Scanner scanner=new Scanner(System.in);
        System.out.println(text);
        String answer=scanner.nextLine();
        return answer;
    }
    public static double requireNumberDouble(String text){
        Scanner scanner=new Scanner(System.in);
        System.out.println(text);
        double answer=scanner.nextDouble();
        return answer;
    }

}

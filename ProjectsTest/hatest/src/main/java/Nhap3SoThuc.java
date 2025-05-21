import java.util.Scanner;
public class Nhap3SoThuc {
    public static void main(String[] args) {
        Scanner tamgiac = new Scanner(System.in);
        System.out.println("nhập 3 cạnh xem phải tam giác không: ");
        int a = tamgiac.nextInt();
        int b = tamgiac.nextInt();
        int c = tamgiac.nextInt();
        if ( a>0 && b>0 && c>0 ) {
             if (a+b>c || a+c>b || b+c>a ) {
                System.out.println("đây là tam giác");

            } else {
                 System.out.println("đây không phải tam giác");
             }
        }else{
            System.out.println("phải nhập 3 số dương");
        }
    }
}

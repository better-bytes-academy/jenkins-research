# Cơ bản 
## Java là gì
Java là một ngôn ngữ lập trình đa nền tảng, hướng đến đối tượng, lấy mạng làm trung tâm và có thể sử dụng như 1 nền tảng. Ưu điểm: nhanh, bảo mật, đáng tin cậy.
## Các kiểu dữ liệu và phạm vi của biến
### Kiểu dữ liệu
**1 Biến là bộ nhớ để lưu giá trị**

**2 Có 2 kiểu dữ liệu**

**2.1 Primitive**
* 1 Boolean: lưu trữ 2 trạng thát 'true' hoặc 'false'. (VD: booclean <tên biến> = true)
* 2 Char: lưu kí tự hoặc số nguyên không âm.Giá trị nhỏ nhất là '\u0000' (hoặc 0) và giá trị lớn nhất là '\uffff' (hoặc 65,535). (VD:Char <tên> ='A')
* 3 Byte:  lưu số nguyên (âm hoặc dương)&(Nhỏ nhất:-128, lớn nhất 127)&(VD: byte <tên> =31)
* 4 Short: số nguyên như Byte nhưng kích cỡ lớn hơn (nhỏ nhất là -32,768 (-2^15)&lớn nhất là 32,767 (2^15 -1))&(VD: short <tên> = 31)
* 5 Int: lưu số nguyên lớn hơn short và byte ( nhỏ nhất là - 2,147,483,648.(-2^31) lớn nhất là 2,147,483,647 (2^31 -1))&( VD: int <tên> = 31)
* 6 Long: lưu số nguyên lớn nhất(nhỏ nhất là -9,223,372,036,854,775,808.(-2^63) và lớn nhất là 9,223,372,036,854,775,807 (2^63 -1))&(VD: long <tên> = 3100000L) chữ L để phân biệt với init 
* 7 Float: lưu số thực (VD: float <tên> = 31.1f ) chữ f để phân biệt với double (4 byte)
* 8 Double: giống Float nhưng kích thước lớn hơn (VD: 31.1) (8 byte)

**2.2 Non-Primitive**

* Được tạo từ class
* Có thể chứa nhiều giá trị (mảng, chuỗi)
* Hỗ trợ các phương thức (methods)
* Giá trị mặc định là ```null```
* Được lưu trữ bằng tham chiếu (reference)
* VD:
 ```
 String (chuỗi)
String name = "hahihi";
System.out.println(name.length());  // In ra: 6
```
```
array (mảng)
int[] numbers = {1, 2, 3, 4};
System.out.println(numbers[0]); // In ra: 1
```
```
class (đối tượng được định nghĩa)
class Person {
    String name;
}

Person p = new Person();
p.name = "Alice";
System.out.println(p.name); // In ra: Alice
```
```
arraylist(danh sách động)
import java.util.ArrayList;

ArrayList<String> list = new ArrayList<>();
list.add("Java");
System.out.println(list.get(0)); // In ra: Java
```
### Phạm vi của biến
Mỗi biến được khai báo ra có một phạm vi hoạt động

Phạm vi của biến dựa vào vị trí khai báo nếu khai báo trong class và ngoài method thì phạm vi là toàn class. Nếu khai báo trong method và method nằm trong class thì phạm vi chỉ là trong method đó. với block cũng vậy.
## Toán trong Java - toán tử 
**1 Toán tử số học**
```
+ (Cộng)
- (Trừ)
* (Nhân)
/ (Chia)
% (Chia lấy nguyên)
```
```VD
int a = 10, b = 3;
System.out.println("Cộng: " + (a + b)); // Kết quả: 13
System.out.println("Chia lấy nguyên: " + (a % b)); // Kết quả: 1
```
**2 Toán tử quan hệ**: 
So sánh giữa hai giá trị, trả về kết quả dạng true hoặc false
```
== (Bằng)
!= (Khác)
> (Lớn hơn)
< (Nhỏ hơn)
>= (Lớn hơn hoặc bằng)
<= (Nhỏ hơn hoặc bằng)
```
``` VD 
int x = 5, y = 10;
System.out.println("x > y: " + (x > y)); // Kết quả: false
System.out.println("x == y: " + (x == y)); // Kết quả: false
```
**3 toán tử logic**: Kết hợp các biểu thức logic, trả về giá trị true hoặc false (chỉ hoạt động trực tiếp với boolean)(muốn dùng với số thì phải có điều kiện)
```
&& (Và)
|| (Hoặc)
! (Phủ định)
```
``` VD 
boolean a = true, b = false;
System.out.println("a && b: " + (a && b)); // Kết quả: false
System.out.println("!a: " + (!a)); // Kết quả: false
```
**4 Toán tử gán**: Dùng để gán giá trị cho biến. Toán tử gán cơ bản là =, ngoài ra còn có các toán tử gán kết hợp
```
+= (Cộng và gán)
-= (Trừ và gán)
*= (Nhân và gán)
/= (Chia và gán)
```
```VD 
int a = 5;
a += 3; // Tương đương a = a + 3
System.out.println("a = " + a); // Kết quả: 8
```
**5 Toán tử tăng giảm**: tăng giảm (++, --) dùng để tăng hoặc giảm giá trị của biến số lên/xuống 1 đơn vị
```
int x = 5;
x++; // Tăng x lên 1
System.out.println("x = " + x); // Kết quả: 6
```
**6 Toán tử điều kiện (Ternary)**: Là một cách viết ngắn gọn của câu lệnh if-else.
```
int a = 10, b = 5;
String result = (a > b) ? "a lớn hơn b" : "a không lớn hơn b";
System.out.println(result); // Kết quả: a lớn hơn b
```
**7 Toán tử bitwise**: Hoạt động trên các bit của toán hạng, thường dùng trong các ứng dụng cấp thấp
```
& (AND)
| (OR)
^ (XOR)
~ (NOT)
<< (Dịch trái)
>> (Dịch phải)
```
```
int a = 5; // 0101 trong nhị phân
int b = 3; // 0011 trong nhị phân
System.out.println("a & b: " + (a & b)); // Kết quả: 1 (0001)
```
## Vòng lặp
### Vòng lặp ```For```
``` cấu trúc for đơn giản 
for (<tạo biến> ; <điều kiện> ; <tăng giảm biến>) { 
    System.out.println("<text>" + i);
} 
```
```vòng lặp for cải tiến (dùng để lặp mảng hoặc tập hợp)
int[] numbers = {1, 2, 3, 4, 5};
for (int <biến> : numbers) {
    System.out.println(<biến>);
}
//kết quả
1
2
3
4
5
```
``` vòng lặp for vô tận khi đặt điều kiện là true hoặc điều kiện không xác định
public class ForSample3 {
    public static void main(String[] args) {
        // for (int i = 1; true; i++) {
        for (int i = 1; ; i++) {
            System.out.println(i + " ");
        }
    }
}
//kết quả
1
2
3
...
```
Có thể sử dụng vòng lặp for vô tận, kết hợp với kiểm tra điều kiện kết thúc với lệnh break để thay thế cho vòng lặp while:
```VD
public class ForSample4{
    public static void main(String[] args) {
        int i;
        final int COUNT = 5;
        System.out.print("Using For:   ");
        i = 1;
        for (;;) {
            System.out.print(i + " ");
            if (i == COUNT) {
                break;
            }
            i++;
        }
 
        System.out.println();
        System.out.print("Using While: ");
        i = 1;
        while (i <= COUNT) {
            System.out.print(i + " ");
            i++;
        }
    }
}
```
### Vòng lặp ```while```
Vòng lặp này lặp lại đến khi điều kiện sai mới dừng
```VD
int i = 0;

while (i < 5) {
    System.out.println("Giá trị i: " + i);
    i++; // Tăng giá trị để tránh lặp vô hạn nếu để i-- thì vòng lặp vô hạn
}
```
### Vòng lặp ```do...while```
Khối lệnh sẽ được thực hiện ít nhất một lần, sau đó mới kiểm tra điều kiện để quyết định lặp tiếp hay không
```
int i = 0;

do {
    System.out.println("Giá trị i: " + i);
    i++;
} while (i < 5);

```
## Câu lệnh điều kiện
**1 If**: dùng khi có 1 điều kiện
```
if (điều kiện){
    System.out.println("đúng thì sẽ hiện kết quả");
}
```
**2 If else**: đúng sai 
```
if (điều kiệnkiện) {
    System.out.println("đúng thì hiện cái này");
} else {
    System.out.println("không đúng thì hiện cái này");
}
```
**3 if...else if...else**: khi có thêm điều kiện phức tạp
```
if (điều kiện) {
    System.out.println("đủ điều kiện thì hiện cái này");
} else if (điều kiện thêm) {
    System.out.println("đủ điều kiện tiếp thì hiện cái này");
} else {
    System.out.println("k đủ điều kiện thì hiện cái này");
}
```
**4 switch**: chọn lựa so sánh nhiều giá trị cụ thể. Dùng khi có nhiều trường hợp rẽ nhánh
```
int <tên> = <số>;
switch (<tên>) {
    case 1:
        System.out.println("kết quả");
        break;
    case 2:
        System.out.println("kết quả");
        break;
    case 3:
        System.out.println("kết quả");
        break;
    default:
        System.out.println("kết quả: VD: (không xác định)");
}
```
**5 ```?:``` toán tử 3 ngôi**: Cách viết ngắn gọn thay cho ```if...else``` đơn giản.
```
int a = <số> ;
String result = (điều kiện) ? "đủ điều kiện" : "không đủ điều kiện";
System.out.println(result); //hiện kết quả 
```
## Mảng trong Java (array)
Mảng: là một tập hợp các phần tử cùng kiểu dữ liệu, được lưu trữ liên tiếp trong bộ nhớ và được truy cập thông qua chỉ số (index) bắt đầu từ 0.
```
<kiểu dữ liệu>[] <tên mảng> = new <kiểu dữ liệu[<số giá trị cần gán>];
numbers[0] = giá trị;             
numbers[1] = giá trị;
numbers[2] = giá trị;
numbers[3] = giá trị;
numbers[4] = giá trị;
System.out.println("kết quả");
```
```khai báo và gán luôn giá trị 
int[] numbers = {10, 20, 30, 40, 50};
System.out.println(numbers[2]); // In ra: 30
```
```VD đầy đủ 
public class Main {
    public static void main(String[] args) {
        String[] fruits = {"Táo", "Chuối", "Cam"};

        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }
}
//kết quả
Táo  
Chuối  
Cam
```
# Hướng đối tượng 








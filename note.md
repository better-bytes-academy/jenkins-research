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
## CLass và object 
### Class
* Định nghĩa: Class là khuôn mẫu hoặc bản thiết kế dùng để tạo ra các đối tượng, nó chứa các thuộc tính (biến) hoặc hành động (methods) của đối tượng.
### Object (đối tượng)
* Định nghĩa: là một đối tượng cụ thể được tạo ra từ class. Có thể thao tác, thay đổi giá trị của đối tượng.
### ví dụ
```
// Định nghĩa class Sach
public class Sach {
    // đây là thuộc tính (attributes)
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;

    //Constructor (Hàm tạo) 
    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
    }
    // methods 
    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tên sách: " + tenSach);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
    }
    // Tạo các object sách
    public static void main(String[] args) {
        Sach sach1 = new Sach("001", "Java Programming", "John Doe", 2020);
        Sach sach2 = new Sach("002", "Data Structures", "Jane Smith", 2019);

        // Hiển thị thông tin về các object sách (methods)
        System.out.println("Thông tin sách 1:");
        sach1.hienThiThongTin();

        System.out.println("Thông tin sách 2:");
        sach2.hienThiThongTin();
    }
}
```
## Thuộc tính (attributes) và phương thức (method)
### Thuộc tính (attributes)
* Là dùng để khai báo các đặc điểm của biến trong class 
```
public class Person {
    // Thuộc tính (biến thành viên)
    String name;
    int age;
}
```
* Getter và Setter
```
public class Person {
    private String name;

    // Getter: xuất giá trị 
    public String getName() {
        return name;
    }

    // Setter: thay đổi giá trị 
    public void setName(String newName) {
        name = newName;
    }
}
```
### Phương thức (methods)
Là một khối lệnh để thực hiện một hành động cụ thể
```VD
public class Person {
    private String name;
    private int age;

    // Constructor : dùng để tạo đối tượng 
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Phương thức thường : Gắn với từng đối tượng
    public void sayHello() {
        System.out.println("Xin chào, tôi tên là " + name);
    }

    // Getter : xuất giá trị thuộc tính
    public String getName() {
        return name;
    }

    // Setter : thay đổi giá trị thuộc tính
    public void setName(String name) {
        this.name = name;
    }

    // Phương thức tĩnh : Gắn với lớp, không cần tạo đối tượng
    public static void introduce() {
        System.out.println("Tôi là con người.");
    }
}
```
## Phạm vi truy cập
* phạm vi truy cập
```
*lệnh*          *Ý nghĩa*
private	        Chỉ có thể truy cập trong nội bộ lớp đó
Không ghi gì    chỉ truy cập trong cùng package
(default)

protected       Truy cập trong cùng package hoặc lớp con ở package khác
public	        Truy cập từ bất cứ đâu
```
## 4 tính chất của OOP
### Tính đóng gói (Encapsulation)
Giấu dữ liệu, chỉ cho truy cập qua method 
```
class Person {
    private String name; // ẩn dữ liệu

    public void setName(String n) { name = n; }
    public String getName() { return name; }
}
```
### Kế thừa (Inheritance)
Lớp con kế thừa thuộc tính và phương thức từ lớp cha
```
class Animal {
    void speak() { 
        System.out.println("Sound"); 
        }
}

class Dog extends Animal { 

}
```
### Đa hình (Polymorphism)
Một hành vi – nhiều cách thực hiện (overriding, overloading)
```
class Animal {
    void speak() { 
        System.out.println("Animal");
        }
}

class Cat extends Animal {
    void speak() { 
        System.out.println("Meow"); 
        }
}
```
```
Animal a = new Cat();
a.speak();  // In: Meow
```
### Trừu tượng (Abstraction)
Ẩn chi tiết, chỉ hiển thị phần cần thiết (dùng ```abstract``` hoặc ```interface```)
```
interface Animal {
    void makeSound();  // khai báo hành vi
}
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Gâu gâu");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();   // Dùng theo kiểu trừu tượng
        a.makeSound();          // In: Gâu gâu
    }
}

```
## ```static``` và ```final```
### ```static```
Là một từ khóa dùng để khai báo biến, hằng số và methods làm cho chúng thuộc về class chứ không phải thuộc một object cụ thể
```
public class Student {
    static String school = "ABC";

    String name;
    Student(String name) { this.name = name; }

    void show() {
        System.out.println(name + " - " + school);
    }

    static void printSchool() {
        System.out.println("School: " + school);
    }
}
```
### ```final```: 
Để khai báo thuộc tính không thể thay đổi
```
public class Person {
    public final String country = "Vietnam";
}
```
## package
```package``` là một cách để tổ chức các class một cách có cấu trúc giúp tránh xung đột, dễ quản lí, kiểm soát truy cập giữa các lớp bằng cách sử dụng các modifier như public, protected, hoặc default.

**1 khai báo package**
```
package com.example.myapp;

public class MyClass {
    // code ở đây
}
```
Thư mục chứa file ```MyClass.java``` cần nằm trong thư mục ```com/example/myapp```

**2 Import package**
```
//import 1 class scanner 
import java.util.Scanner;

//import tất các class trong java.util
import java.util.*;
```
không dùng import thì phải khai báo đầy đủ tên package và class khi sử dụng
```
public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
    }
}
```
**3 không khai báo package**
```
không khai báo thì sẽ ở package default
```
**4 Tạo package trong project**
ví dụ cấu trúc 
```
src/
  └── com/
      └── myapp/
          ├── Main.java
          └── utils/
              └── Helper.java
// .java là file class
```
``` tạo class main trong package 
package com.myapp;

import com.myapp.utils.Helper;

public class Main {
    public static void main(String[] args) {
        Helper.sayHello();
    }
}
```
``` tạo class Helper trong package 
package com.myapp.utils;

public class Helper {
    public static void sayHello() {
        System.out.println("Hello from Helper!");
    }
}
```
## Tổ chức code
**1 Cấu trúc thư mục**
```
MyProject/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── yourcompany/
│   │   │           └── projectname/
│   │   │               ├── Main.java
│   │   │               ├── model/
│   │   │               ├── service/
│   │   │               ├── controller/
│   │   │               └── util/
│   └── test/
│       └── java/
│           └── com/...
├── pom.xml (dùng Maven)
```
```
model: Chứa các class biểu diễn dữ liệu	
VD: User.java, Product.java

service: Chứa logic nghiệp vụ	
VD: UserService.java

controller:	Xử lý yêu cầu từ UI/API	
VD: UserController.java

repository(nếu dùng JPA): quản lý truy cập dữ liệu	
VD: UserRepository.java

util: Các hàm tiện ích	
VD: StringUtils.java, DateUtils.java
```
**2 Test** 
```
Unit Test:	   Kiểm thử từng đơn vị nhỏ (thường là 1 method/class)

Integration Test:	Kiểm tra sự tương tác giữa nhiều class/module

System Test     	Kiểm tra toàn bộ hệ thống hoạt động đúng không

Regression Test:	Đảm bảo thay đổi mới không làm hỏng tính năng cũ
```
```
VD cấu trúc test

src/
├── main/
│   └── java/
│       └── com.example.project/
│           └── Calculator.java
└── test/
    └── java/
        └── com.example.project/
            └── CalculatorTest.java
```
Ví dụ file test
```có class
// Calculator.java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```
``` File test sẽ là
// CalculatorTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }
}
// @Test: đánh dấu method là một test case.
// assertEquals(expected, actual): kiểm tra kết quả.
```
## Quản lý dependency: Maven
**cấu trúc cơ bản của file ```pom.xml```**
```
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>5.3.25</version>
    </dependency>
</dependencies>

// groupId: Tên nhóm hoặc tổ chức
// artifactId: Tên của thư viện
// version: Phiên bản muốn sử dụng
```
**Quản lý dependency với scope**
```
compile: Mặc định – có mặt khi biên dịch, test, chạy.

provided: Có mặt khi biên dịch, nhưng môi trường chạy sẽ cung cấp (VD: servlet API).

runtime: Không cần khi biên dịch, nhưng cần khi chạy.

test: Chỉ dùng khi chạy test (JUnit, Mockito...).

system: Giống provided, nhưng bạn phải chỉ rõ đường dẫn cụ thể.
```
``` VD
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```
**Lệnh maven cơ bản**
```
mvn clean	            Xóa thư mục target
mvn compile	            Biên dịch mã nguồn
mvn test	            Chạy unit test
mvn package	            Đóng gói thành file .jar hoặc .war
mvn install 	        Cài đặt vào local repository
mvn dependency:tree	    Hiển thị cây phụ thuộc
```








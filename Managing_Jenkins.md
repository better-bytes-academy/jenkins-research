# Manager jenkins
Hầu hết các tác vụ quản trị tiêu chuẩn có thể được thực hiện từ màn hình trong phần Quản lý Jenkins của bảng điều khiển
## Configuring the System 
**1 Thư mục jenkins_home**:
 có thể thay đổi vị trí sau khi sử dụng Jenkins một thời gian.
**2 Configuring the system page**:
* System message: Thông báo hệ thống được hiển thị ở đầu mỗi trang trong Jenkins
* Labels:  được sử dụng để nhóm các agent (nodes) dựa trên các tiêu chí cụ thể. Chúng giúp phân công công việc cho các tác nhân cụ thể
* Jenkins location: Phần này định nghĩa URL của bộ điều khiển Jenkins. Điều này rất quan trọng để giao tiếp đúng cách với các tác nhân và công cụ bên ngoài. Nếu Jenkins nằm sau proxy ngược, hãy đảm bảo URL khớp với cấu hình proxy

## Configuration as Code

* Jenkins Configuration as Code (JCasC) định nghĩa các tham số cấu hình trong tệp YAML có thể lưu trữ dưới dạng source code. tính năng này nắm bắt các tham số cấu hình và giá trị được sử dụng khi cấu hình Jenkins từ giao diện người dùng web. Sau đó, cấu hình có thể được sửa đổi bằng cách chỉnh sửa tệp này rồi áp dụng
* Plugin Configuration as Code phải được cài đặt trên bộ điều khiển Jenkins mà bạn sẽ sử dụng để xây dựng cấu hình JCasC của mình

**1 Viewing the JCasC file** 

1.1  Configuration as Code trong phần System Configuration của trang Manage Jenkins trên bảng điều khiển. Sau đó nhấp vào View Configuration để xem tệp YAML.

1.2 Tệp YAML JCasC mặc định có bốn phần: 

   * jenkins: phần này định nghĩa đối tượng Jenkins gốc, với các cấu hình có thể được thiết lập bằng màn hình Quản lý Jenkins >> Hệ thống và Quản lý Jenkins >> Cấu hình Nút và Đám mây .

   * tool: phần này định nghĩa các công cụ xây dựng có thể được thiết lập trên màn hình Quản lý Jenkins >> Công cụ .

   * unclassified: phần này định nghĩa tất cả các cấu hình khác, bao gồm cấu hình cho các plugin đã cài đặt.

   * credentials: phần này định nghĩa thông tin xác thực có thể được thiết lập trên màn hình Quản lý Jenkins >> Quản lý thông tin xác thực . Bạn có thể muốn xóa phần này khỏi tệp YAML của mình; điều này được thảo luận trong Cách cài đặt Jenkins bằng Ansible và JCasC .

1.3 Cú pháp tệp YAML: 
* Tệp YAML phân biệt chữ hoa chữ thường
* Việc thụt lề rất quan trọng và cụ thể
* Mỗi mục là một key/value pair
   * Sau phím là dấu hai chấm (:) và một khoảng trắng.
   * YAML chuyển đổi một số chuỗi nhất định thành các kiểu khác trừ khi chúng nằm trong dấu ngoặc kép.
      * Các giá trị như true, false, Yes, và No được chuyển đổi thành giá trị Boolean.
      * Các giá trị như 2 và 3.0 được chuyển đổi thành giá trị dấu phẩy động
* Một giá trị có thể là một danh sách:

1.4 Checking the YAML files into SCM: 
* Để tận dụng tối đa lợi ích của JCasC, các tệp YAML phải được lưu trữ trong SCM. Điều này cung cấp cho bạn lịch sử mà bạn có thể sử dụng để theo dõi các thay đổi được thực hiện và cho phép bạn dễ dàng quay lại phiên bản trước đó của tệp nếu cần 

1.5 Modifying the JCasC file:
* Mở tệp YAML của JCasC bằng trình soạn thảo văn bản bạn chọn.
* Tìm dòng systemMessage
* Sửa đổi văn bản giữa các dấu ngoặc kép để chứa văn bản mới 
* Viết/lưu tập tin
* Nhấp vào nút TReload existing configuration để áp dụng các thay đổi
## Manager plugin
**1 Installing a plugin**
* cài qua giao diện người dùng
* qua dùng lệnh CLI của jenkins

**2 Cập nhật plugin** 
![ha](https://www.jenkins.io/doc/book/resources/blueocean/intro/blueocean-plugins-filtered.png)

## System Information 
![ha]( https://www.jenkins.io/doc/book/resources/managing/system-info-page.png)
## Jenkins Features Controlled with System Properties

**Jenkins có một số tính năng "ẩn" có thể được bật bằng thuộc tính hệ thống**
* Cách sử dụng: Thuộc tính hệ thống được xác định bằng cách truyền -Dproperty=value đến java dòng lệnh để khởi động Jenkins. Đảm bảo truyền tất cả các đối số này trước -jar đối số, nếu không chúng sẽ bị bỏ qua

* Properties in Jenkins Core (https://www.jenkins.io/doc/book/managing/system-properties/)
## Change System Time Zone 
User Defined Time Zone: ![ha]( https://www.jenkins.io/doc/book/resources/managing/change-system-timezone-user-defined-timezone.png)
## Jenkins CLI
**1 Dùng CLI qua SSH**:

1.1 Authentication:
* phải có quyền để truy cập CLI
* Xác thực ở chế độ SSH dựa trên xác thực khóa công khai/riêng tư dựa trên SSH. Để thêm khóa công khai SSH cho người dùng phù hợp, hãy điều hướng đến JENKINS_URL/me/security và dán khóa công khai SSH vào vùng văn bản phù hợp
![ha]( https://www.jenkins.io/doc/book/resources/managing/cli-adding-ssh-public-keys.png)

1.2 Lệnh thông dụng:
* Build:
   * Build cho phép người dùng kích hoạt bất kỳ công việc hoặc Pipeline nào mà họ được cấp quyền.
   * Lệnh gọi cơ bản nhất sẽ chỉ kích hoạt công việc hoặc Pipeline và thoát, nhưng với các tùy chọn bổ sung, người dùng cũng có thể truyền tham số, thăm dò SCM hoặc thậm chí theo dõi đầu ra của bảng điều khiển khi bản dựng hoặc Pipeline được kích hoạt
```
% ssh -l kohsuke -p 53801 localhost help build

java -jar jenkins-cli.jar build JOB [-c] [-f] [-p] [-r N] [-s] [-v] [-w]
Starts a build, and optionally waits for a completion.  Aside from general
scripting use, this command can be used to invoke another job from within a
build of one job.  With the -s option, this command changes the exit code based
on the outcome of the build (exit code 0 indicates a success) and interrupting
the command will interrupt the job.  With the -f option, this command changes
the exit code based on the outcome of the build (exit code 0 indicates a
success) however, unlike -s, interrupting the command will not interrupt the
job (exit code 125 indicates the command was interrupted).  With the -c option,
a build will only run if there has been an SCM change.
 JOB : Name of the job to build
 -c  : Check for SCM changes before starting the build, and if there's no
       change, exit without doing a build
 -f  : Follow the build progress. Like -s only interrupts are not passed
       through to the build.
 -p  : Specify the build parameters in the key=value format.
 -s  : Wait until the completion/abortion of the command. Interrupts are passed
       through to the build.
 -v  : Prints out the console output of the build. Use with -s
 -w  : Wait until the start of the command
% ssh -l kohsuke -p 53801 localhost build build-all-software -f -v
Started build-all-software #1
Started from command line by admin
Building in workspace /tmp/jenkins/workspace/build-all-software
[build-all-software] /bin/sh -xe /tmp/hudson1100603797526301795.sh
+ echo hello world
hello world
Finished: SUCCESS
Completed build-all-software #1 : SUCCESS
%

```
## script console

Jenkins có bảng điều khiển tập lệnh Groovy cho phép chạy các tập lệnh Groovy tùy ý trong thời gian chạy bộ điều khiển Jenkins hoặc trong thời gian chạy trên các agent

**1 Multiple contexts**:
* Chạy Script Console trên bộ điều khiển: Có thể truy cập tính năng này từ "Manage Jenkins" > "Script Console" . Hoặc bằng cách truy cập URL phụ  /script trên bộ điều khiển Jenkins
* Chạy Script Console trên các agent: Truy cập "Manage Jenkins" > "Manage Nodes" . Chọn bất kỳ nút nào để xem trang trạng thái. Trong menu bên trái, có một mục menu để mở "Script Console" trên agent cụ thể đó
* Chạy script từ controller Script Console trên các agent

**2 Administrative capabilities** 
* User management: 
```
Jenkins.instance.securityRealm.allUsers.each { user ->
    println user.id + ": " + user.fullName
}

import hudson.model.User
import jenkins.model.Jenkins

User user = User.get('new-user', true)
user.fullName = "New User"
user.save()
```
* System configuration:
``` 
Jenkins.instance.systemMessage = "New system message"
Jenkins.instance.save()

println Jenkins.VERSION
```
* Plugin management:
```
Jenkins.instance.pluginManager.plugins.each {
    println "${it.shortName}: ${it.version}"
}
Jenkins.instance.pluginManager.getPlugin('git').disable()
```
* Node/Agent management:
```
Jenkins.instance.nodes.each { node ->
    println "${node.name}: ${node.numExecutors} executors"
}
Jenkins.instance.getNode('agent-name').computer.doDoDelete()
```
## Managing Nodes 
**1 Nodes**
* Nodes là "machine" mà các agent xây dựng chạy trên đó.
Jenkins giám sát từng node được đính kèm để biết dung lượng đĩa, dung lượng tạm thời trống, swap trống, thời gian/đồng bộ hóa đồng hồ và thời gian phản hồi. Một node sẽ ngoại tuyến nếu bất kỳ giá trị nào trong số này vượt quá ngưỡng đã cấu hình. Hai loại node:
  * agent: quản lý việc thực thi tác vụ thay mặt cho bộ điều khiển Jenkins bằng cách sử dụng các trình thực thi
  * built-in node: Nút tích hợp là một nút tồn tại trong quy trình điều khiển. Có thể sử dụng các agent và built-in node để chạy tác vụ. Tuy nhiên không được khuyến khích bởi lí do bảo mật. 
* Tạo agent và node: https://www.jenkins.io/doc/book/managing/nodes/#creating-agents
## In-process Script Approval (phê duyệt các tập lệnh đang chờ xử lí)

Để bảo vệ Jenkins khỏi việc thực thi các tập lệnh độc hại, các plugin này thực thi các tập lệnh do người dùng cung cấp trong Groovy Sandbox giới hạn các API nội bộ có thể truy cập được. Sự bảo vệ này được cung cấp bởi plugin Script Security

![ha](https://www.jenkins.io/doc/book/resources/managing/manage-inprocess-script-approval.png)
.





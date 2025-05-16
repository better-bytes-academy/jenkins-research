# System administrator
dành cho quản trị viên hệ thống của Jenkins server và nodes. Chương này sẽ đề cập đến các chủ đề bảo trì hệ thống bao gồm bảo mật, giám sát và sao lưu/khôi phục.
## Backing-up/Restoring Jenkins 
**1 Create backup**
* Filesystem snapshots
* Plugins for backup
* viết shell script sao lưu jenkins controller

**1.1 filesystem snapshots**

Filesystem snapshots cung cấp tính nhất quán tối đa cho các bản sao lưu
* Linux btrfs
* Solaris ZFS (cũng hỗ trợ sao lưu gia tăng)
* Hệ điều hành FreeBSD
* OpenZFS trên Linux
* Một số file system architectures khác
* Cloud providers
* Một số thiết bị lưu trữ riêng biệt cũng cho phép bạn tạo ảnh chụp nhanh ở cấp độ lưu trữ.

**1.2 Plugin backup**

**1.3 Viết shell script để backup**: Tập lệnh shell sẽ tạo một thư mục mà /mnt/backup bản sao lưu sẽ được ghi vào; hãy đảm bảo rằng bạn có quyền ghi vào thư mục đó. Hãy cân nhắc việc tạo /mnt/backup như một hệ thống tệp riêng biệt với điểm gắn kết riêng. Một phương pháp thay thế là tạo một thư mục con trong /var. Lưu ý rằng nếu bạn sử dụng phương pháp này, bạn có thể cần sử dụng lệnh sudo/tmp để thực hiện thao tác khôi phục. Không nên sao lưu vào vì /tmp có thể bị xóa khi khởi động lại

**1.4 Back up the Controller Key Separately**: Bạn nên xử lý khóa điều khiển của mình giống như cách bạn xử lý khóa riêng SSH và KHÔNG BAO GIỜ đưa nó vào bản sao lưu thông thường. Thay vào đó, hãy sao lưu master.key tệp riêng và lưu trữ ở một vị trí rất an toàn, tránh xa các bản sao lưu khác của bạn. Đây là một tệp rất nhỏ và hiếm khi bị thay đổi. Nếu bạn cần khôi phục toàn bộ hệ thống, bạn sẽ cần khôi phục phần còn lại của hệ thống và sau đó áp dụng bản sao lưu của master.key tệp riêng

## Monitoring jenkins
**1 Giám sát với Datadog**
* Plugin Datadog cho Jenkins
* Plugin Metrics-Datadog cho Jenkins
* Jenkins trên Datadog

**2 Giám sát với Newrelic**
* Jenkins trên Newrelic
* Phát triển một đường ống tích hợp Jenkins cho tích hợp trên máy chủ của cơ sở hạ tầng Relic mới 

**3 Giám sát với Prometheus và Grafana**
* Plugin Prometheus cho Jenkins
* Blog hướng dẫn trên Medium

**4 Giám sát với JavaMelody**
* Plugin giám sát cho Jenkins

**5 Các Plugin Giám sát Khác**
* Phiên bản Node Monitors
* Giám sát tác nhân cho các nút Unix
* Giám sát công việc/hàng đợi/slave

(tham khảo: https://www.jenkins.io/doc/book/system-administration/monitoring/#monitoring-with-datadog)
## View logs
**1 Linux (rpm và deb)**
Theo mặc định, có thể xem nhật ký bằng cách chạy ```journalctl -u jenkins.service.```

Để tùy chỉnh vị trí nhật ký, hãy chạy ```systemctl edit jenkins``` và thêm lệnh sau:
```[Service]
Environment="JENKINS_LOG=%L/jenkins/jenkins.log" 
```
**2 Windows (MSI)**: 
Theo mặc định, nhật ký sẽ nằm ở vị trí ```%JENKINS_HOME%/jenkins.out```và ```%JENKINS_HOME%/jenkins.err```, trừ khi được tùy chỉnh trong ```%JENKINS_HOME%/jenkins.xml.```

**3 logs trong jenkins**
tạo logs:![ha](https://www.jenkins.io/doc/book/resources/managing/SystemLog.png)
![ha](https://www.jenkins.io/doc/book/resources/managing/Log-recorder.png)
![ha](https://www.jenkins.io/doc/book/resources/managing/Example-logger.png)
![ha](https://www.jenkins.io/doc/book/resources/managing/Config-logger.png)
## Reverse proxy
**1 Background**: Proxy ngược nhận các yêu cầu HTTP đến và chuyển tiếp các yêu cầu đó đến Jenkins. Proxy ngược nhận phản hồi HTTP đi từ Jenkins và chuyển tiếp các yêu cầu đó đến người yêu cầu ban đầu. Proxy ngược được cấu hình đúng sẽ ghi lại cả yêu cầu HTTP và phản hồi HTTP.

**2 Ví dụ trên từng loại máy chủ**: 
https://www.jenkins.io/doc/book/system-administration/reverse-proxy-configuration-with-jenkins/#general-guidelines
## Quản lí dịch vụ
https://www.jenkins.io/doc/book/system-administration/systemd-services/
## Đặt lại mật khẩu quản trị viên
1 Đăng nhập vào bộ điều khiển Jenkins của bạn.

2 Dừng tiến trình Jenkins. Bạn có thể sử dụng lệnh này: systemctl stop jenkins.

3 Chỉnh sửa tệp cấu hình Jenkins ( config.xml) bên trong thư mục jenkins/hoặc của bạn $JENKINS_HOME.

4 Tìm useSecurity và đổi nó từ true thành false theo cách thủ công.

5 Lưu tệp và đóng lại.

6 Khởi động lại dịch vụ Jenkins để áp dụng các thay đổi của bạn. Bạn có thể sử dụng lệnh này: systemctl start jenkins. Sau khi khởi động lại Jenkins, hãy điều hướng đến bộ điều khiển của bạn và đăng nhập.

7 Trên bảng điều khiển, chọn Quản lý Jenkins trong ngăn điều hướng ở phía bên trái của trang.

8 Trên trang Quản lý Jenkins , trong phần Bảo mật , chọn Cấu hình Bảo mật Toàn cầu .

9 Trong Security Realm , hãy chọn cơ sở dữ liệu người dùng của Jenkins từ menu thả xuống. Đảm bảo tùy chọn Allow users to sign up không được chọn và lưu các thay đổi của bạn. Thao tác này sẽ chuyển hướng bạn đến trang Manage Jenkins.

10 Trên trang Quản lý Jenkins , chọn Người dùng .

11 Bạn sẽ thấy danh sách hiển thị ID người dùng. Chọn ID người dùng mà bạn muốn thay đổi mật khẩu.

12 Chọn Cấu hình bằng biểu tượng bánh răng hoặc menu thả xuống từ ID người dùng. Tìm phần Mật khẩu để thay đổi mật khẩu của bạn.
## Bật bảo mật
1 Đăng nhập bằng tài khoản quản trị của bạn.

2 Trên bảng điều khiển, chọn Quản lý Jenkins trong ngăn điều hướng ở phía bên trái của trang.

3 Trên trang Quản lý Jenkins , trong phần Bảo mật , chọn Cấu hình Bảo mật Toàn cầu .

4 Đặt Ủy quyền thành Người dùng đã đăng nhập có thể làm bất cứ điều gì . Bỏ chọn tùy chọn Cho phép truy cập đọc ẩn danh . Chọn Lưu .



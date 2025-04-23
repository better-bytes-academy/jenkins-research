# Blue Ocean
### Blue Ocean là gì
**1 Blue Ocean**: là giao diện mới mẻ để quản lí cũng như tạo pipeline

**2 Tính năng**: tăng sự dễ dàng và phù hợp với người dùng cũng như từng thành viên trong dự án
## Bắt đầu với Blue Ocean
**1 Cài đặt Blue Ocean**
* Cài plugin: Blue Ocean

**2 Truy cập Blue Ocean**
* Trên giao diện jenkins thanh điều hướng bên trái có nút `Open Blue Ocean` chỉ cần click vòa là sẽ chuyển sang Blue Ocean
## Tạo Pipeline
**1 Thiết lập dự án Pipeline**:

Có thể tạo Pipeline từ:
* Kho lưu trữ Git
* Kho lưu trữ trên GitHub hoặc GitHub Enterprise
* Kho lưu trữ trên Bitbucket Cloud hoặc Bitbucket Server

a, Đối vơi với Git: Chọn git rồi paste URL Git của mình 
* Local
* Remote: chỉ hỗ trợ qua Giao thức SSH:
  * ssh:// - which displays as ssh://gituser@git-server-url/git-server-repos-group/my-git-repo.git
  * user@host:path/to/git/repo.git - which displays as gituser@git-server-url:git-server-repos-group/my-git-repo.git 
  * Blue Ocean tự động tạo cặp khóa công khai/riêng tư SSH hoặc cung cấp cho bạn cặp khóa hiện có
  * Phải đảm bảo rằng cặp khóa công khai/riêng tư SSH này đã được đăng ký với máy chủ Git của bạn (Cấu hình thành phần khóa công khai SSH của cặp khóa này (mà bạn có thể sao chép và dán từ giao diện Blue Ocean) cho tài khoản người dùng của máy chủ Git từ xa (ví dụ: trong tệp authorized_keyscủa thư mục máy gituser/.ssh).)

b, Đối với GitHub: tạo dự án và kết nối đến access token

Tạo access token:
* Vào menu Settings.
* Chọn tiếp menu Developer settings
* Trong mục Personal access tokens chọn Tokens (classic)
* Trong combobox Generate new token chọn Generate new token (classic)
* Sau đó đặt tên và cấp quyền

c, Đối với Bitbucket Cloud
* Tạo và điền tài khoản nhóm Bitbucket cloudcloud
* Chọn kho lưu trữ
## Dashboard
**1 Thanh điều hướng**:
Gồm có phần search và tạo Pipeline

**2 Danh sách pipeline**: Gồm tên, health, nhánh, yêu thích

**3 biểu tượng heatl**: Mặt trời => Giông bão thể hiện cho độ mượt khi run (>80% => <21%)
## Xem chi tiết run pipeline

![alt text](https://www.jenkins.io/doc/book/resources/blueocean/pipeline-run-details/overview.png) 

(1) Trạng thái chạy: Biểu tượng cho biết trạng thái của lần chạy Pipeline này. Màu của thanh điều hướng khớp với biểu tượng trạng thái.

(2) Tên đường ống: Tên của đường ống trong lần chạy này.

(3) Số lần chạy: Số ID cho lần chạy Pipeline này. Số ID là duy nhất cho mỗi Branch và Pull Request của Pipeline.

(4) Xem Tab: Truy cập chế độ xem Pipeline , Changes , Tests và Artifacts bằng một trong các tab cho lần chạy này. Chế độ xem mặc định là " Pipeline ".

(5) Chạy lại Pipeline: Thực hiện lại Pipeline của lần chạy này.

(6) Chỉnh sửa Pipeline: Mở Pipeline của lần chạy này trong Trình chỉnh sửa Pipeline .

(7) Cấu hình: Mở trang cấu hình Pipeline trong Jenkins.

(8) Chuyển đến chế độ Cổ điển: Chuyển sang chế độ xem giao diện người dùng "Cổ điển" để biết thông tin chi tiết về lượt chạy này.

(9) Đóng Chi tiết: Đóng chế độ xem Chi tiết và đưa người dùng trở lại chế độ xem Hoạt động cho Đường ống này.

(10) Yêu cầu nhánh hoặc kéo: Nhánh hoặc yêu cầu kéo cho lần chạy này.

(11) Commit Id: Commit ID cho lần chạy này.

(12) Thời lượng: Thời lượng của lần chạy này.

(13) Thời gian hoàn thành: Khi lượt chạy này hoàn thành.

(14) Thay đổi tác giả: Tên của tác giả có thay đổi trong lần chạy này.

(15) Chế độ xem tab: Hiển thị thông tin cho tab đã chọn.











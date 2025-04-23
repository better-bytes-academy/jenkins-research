
# Using Jenkins
    (Các chủ đề dành cho người dùng Jenkins thông thường (ở mọi cấp độ kỹ năng) về cách sử dụng Jenkins nằm ngoài phạm vi các tính năng cốt lõi của Jenkins: Pipeline và Blue Ocean)
* **Best Practices**: giới thiệu những phương pháp hay nhất dành cho người dùngdùng
  * **Automate job definition**: Jenkins có khả năng tự động tạo, cập nhật và xóa các công việc dựa trên các kho lưu trữ mà nó xác định trong hệ thống quản lý cấu hình phần mềm của bạn
  * **Giải pháp thay cho Automate job definition**:
    * **Sử dụng foder của tổ chức**:tự động tạo, cập nhật và xóa các thư mục Pipeline đa nhánh và các tác vụ Pipeline.
    * **Sử dụng nhiều nhánh pipelines**:tự động taọ, cập nhật, xóa các tác vụ pipelines.
    * **Sử dụng Pipeline**:Các công việc Pipeline được xác định thủ công để kiểm soát tốt hơn quy trình quản lý công việc
  * **Quản lí công việc của bạn**:
    * **Báo cáo kết quả xây dựng**: Biểu đồ và đồ thị cung cấp thông tin chi tiết có giá trị về trạng thái và tiến độ của dự án, thể hiện xu hướng và mô hình.
      * **Plugin Warnings Next Generation cung cấp khả năng truy cập thuận tiện vào nhiều báo cáo bao gồm**:
        * Cảnh báo và lỗi của trình biên dịch
        * Cảnh báo và lỗi phân tích tĩnh
        * Báo cáo về phạm vi mã
    * **Xây dựng trên các tác nhân**: Sử dụng tác nhân để thực hiện bản dựng
    * **Hiển thị lỗilỗi cho đúng người**: Chỉnh hệ thống thông báo để ưu tiên thông báo cho những người xác nhận gần đây nhất khi xảy ra lỗi vì họ có khả năng là nguyên nhân gây ra sự cố
    * **Sử dụng tên dự án đơn giản**
    * **Dấu vân tay phụ thuộc của bạn**:  Jenkins cung cấp giải pháp có tên là "dấu vân tay tệp" để theo dõi phiên bản nào của một dự án.
  * **Quản lí bộ điều khiển của bạn**:
    * **Bảo vệ bộ điều khiển của bạn**
    * **Sao lưu thường xuyên**
    * **Tránh tình trạng quá tải lịch trình**
    * **Tránh va chạm tài nguyên**
* **Làm việc với dự án**:
  *  Một số loại dự án:
     * Đường ống
     * Đường ống đa nhánh
     * Thư mục tổ chức
     * Phong cách tự do 
     * Đa cấu hình (ma trận)
     * Maven
     * Công việc bên ngoài
  * Sao chép dự án: Nhấn `new item` nhập tên dự án rồi nhập tên dự án muốn sao chép vào phần `copy from`
  * Đổi tên dự án: `rename`
  * Di chuyển dự án: cần phải có thư mục => `move`
  * sau khi đổi tên hoặc di chuyển dự án thì các dự án tham chiếu đến dự án này cần đuợc cập nhật để khớp với dự án mới thay đổi
* **Sử dụng thông tin xác thực**:
  * Bảo mật thông tin xác thực: thông tin xác thực được cấu hình trong Jenkins được lưu trữ dưới dạng mã hóa trên bộ điều khiển Jenkins
  * Cấu hình thông tin xác thực:
  * Thêm mới global credentials: 
    * Chọn manage jenkins => chọn credentials
    * Mục Stores => nhấp vào System
    * Nhấp vào liên kết Global credentials => nhấn `add`
    * Chọn loại thông tin xác thực => `create`
    * 
* **Command Palette (Bảng lệnh)**: Command Palette nằm ở góc trên bên phải của trang bên cạnh tên của bạn, Command Palette cho phép bạn tìm kiếm mọi thứ trong Jenkins.
  * Tìm kiếm không phân biệt chữ hoa chữ thường
  * Hỗ trợ OpenSearch
* **Tham chiếu đến một dự án khác theo tên**: Ở nhiều nơi trong Jenkins, bạn có thể tham chiếu đến một dự án/công việc khác theo tên (copyArtifacts projectName: 'myproject')
  * **Phân biệt giữa nhiều dự án có cùng tên**: có thể phân biệt chúng bằng cách sử dụng đường dẫn, tương tự như đường dẫn hệ thống tệp Unix
  * **Đường dẫn tuyệt đối**: Đường dẫn tuyệt đối bắt đầu bằng dấu gạch chéo và tham chiếu đến một dự án bằng cách mô tả đường dẫn đầy đủ(/myfolder/myproject)
  * **Đường dẫn tương đối**: có thể sử dụng đường dẫn kiểu /.../someproject hay /.../anotherproject để tìm các project trong thư mục cha
  * **Tham chiếu các thành phần bên trong dự án**:
    * Các dự án Maven:Bạn có thể tham khảo toàn bộ dự án Maven: mymavenproject hoặc qua group nhỏ bằng dấu `/`(VD:mymavenproject/my.group)
    * Dự án ma trận: mymatrixproject hoặc theo 1 cấu hình cụ thể (mymatrixproject/someaxis=somevalue)
    * Đường ống đa nhánh: Bạn có thể tham khảo một nhánh cụ thể: mymultibranchproject/mybranch
  * Mã hóa tên: Các ký tự đặc biệt trong đường dẫn phải được mã hóa theo URL
  ( nếu Multibranch Pipeline của bạn có một nhánh có dấu gạch chéo ( feature/myfeature), hãy thay thế dấu gạch chéo bằng %2F)
* **Fingerprint**: giúp bạn theo dõi các công việc dự án trong jenkins nó cho bạn biết bản dựng nào đang được sử dụng
* **API**:
  * API từ xa có thể được sử dụng để thực hiện những việc như sau:
  * lấy thông tin từ Jenkins để sử dụng theo chương trình.
  * kích hoạt một bản dựng mới
  * tạo/sao chép công việc
* **Executor Starvation**:
  * Agent đang ngoại tuyến : bản dựng của bạn cần chạy trên một agent cụ thể, nhưng agent đó đang ngoại tuyến, hãy sử dụng nhãn và không liên kết bản dựng với các agent cụ thể, để một agent ngoại tuyến duy nhất sẽ không ngăn bản dựng của bạn.
  * Đang chờ executor thực thi khả dụng trên một agent : bản dựng của bạn cần chạy trên một agent cụ thể, nhưng tác nhân đó đã bận rộn hoàn toàn, Sử dụng label để bản dựng có thể chạy trên bất kỳ máy nào đáp ứng các yêu cầu
  * Đang chờ người thực hiện có sẵn trên label : tất cả các agent có label đã cho đều đang bận rộn làm những việc khác. thêm nhiều agent hơn
* **Sử dụng agent Jenkins**: Các agent yêu cầu cài đặt Java và kết nối mạng với bộ điều khiển Jenkins
  * Cấu hình tác nhân với Docker:
    * Môi trường: cần có Cài đặt Java, Jenkins, Docker, Cặp khóa SSH
    * Tạo cặp khóa SSH:
      * 1 Trong cửa sổ terminal hãy chạy lệnh:`ssh-keygen -f ~/.ssh/jenkins_agent_key`
      * 2 Cung cấp mật khẩu để sử dụng với khóa
      * 3 Xác nhận kết quả đầu ra
    * Tạo thông tin xác thực Jenkins SSH:
      * Vào bảng điều khiển Jenkins của bạn
      * Vào `Manage Jenkins` tùy chọn trong menu chính và nhấp vào `Manage Credentials`
      * menu thông tin xác thực
      * chọn tùy chọn thả `Add Credentials` từ mục toàn cục
      * thêm tùy chọn thông tin xác thực 
      * Điền vào mẫu
  * thiết lập agent trong jenkin: 
    * Vào Manage Jenkins => vào node => New Node
    * Điền theo yêu cầu
    
* **Sử dụng JMeter với Jenkins**: Tích hợp liên tục và tự động hóa thử nghiệm đã trở thành tiêu chuẩn trong thế giới DevOps, nhưng mức hiệu suất và độ phức tạp của hệ thống sẽ tăng lên

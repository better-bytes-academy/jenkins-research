# 1 Handbook 
- Hướng dẫn: **install Jenkins, use Jenkins**
- Tính năng cốt lõi: **Pineline, Blue oocean**
- Quản trị viên: **managing Jenkins, system administrator Jenkins** 
# 2 Cài đặt Jenkins
- **Linux, windown**, cài DockerDocker 

  * Điều kiện tối thiểu: **256MB** Ram, **1 GB** dung lượng ổ đĩa
  * Yêu cầu phần mềm: **java**, **trình duyệt web tương thích** 
- **Kubernets**: cách thiết lập
  * Create a Namespace
  * Create a service account (admin permission)
  * Create local persistent volume (cho dữ liệu cố định khi khởi chạy jenkins)
  * Create a deployment YAML (triển khai)
  * Create a service YAML (triển khaihai)
# 3 Chính sách hỗ trợ
- Java: **Cần cài phiên bản java được hỗ trợ** ưu tiên 17 hoặc 21
-  Linux, Windown:
   * Phạm vi: tùy vào các plugin riêng lẻ
   * 3 mức hỗ trợ:
     * 1: supported (đầy đủ)
     * 2: Patches considered (còn hạn chế, cần thêm yêu cầu bổ sung)(cần xem xét các bản vá)
     * 3: unsupported 
- Khi nâng cấp java lên 11: 
  - sao lưu jenkins
  - nâng cấp pluginplugin
  - liên kết XML jakarta
  - cài đặt JDK tool
- Khi nâng cấp java lên 177: 
  - sao lưu jenkins
  - nâng cấp jenkins
  # 4 Sử dụng Jenkins
    (Các chủ đề dành cho người dùng Jenkins thông thường (ở mọi cấp độ kỹ năng) về cách sử dụng Jenkins nằm ngoài phạm vi các tính năng cốt lõi của Jenkins: Pipeline và Blue Ocean)
* **Thực hành**: giới thiệu những phương pháp hay nhất dành cho người dùngdùng
  * **Tự động định nghĩa công việc**: Jenkins có khả năng tự động tạo, cập nhật và xóa các công việc dựa trên các kho lưu trữ mà nó xác định trong hệ thống quản lý cấu hình phần mềm của bạn
  * **Giải pháp thay cho tự động quản lí công việc**:
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
  * Sao chép dự án
  * Đổi tên dự án
  * Di chuyển dự án
* **Sử dụng thông tin xác thực**:
  * Bảo mật thông tin xác thực: thông tin xác thực được cấu hình trong Jenkins được lưu trữ dưới dạng mã hóa trên bộ điều khiển Jenkins
  * Cấu hình thông tin xác thực
  * Thêm thông tin xác thực toàn cầu mới
* **Bảng lệnh**: Command Palette nằm ở góc trên bên phải của trang bên cạnh tên của bạn, Command Palette cho phép bạn tìm kiếm mọi thứ trong Jenkins.
  * Tìm kiếm không phân biệt chữ hoa chữ thường
  * Hỗ trợ OpenSearch
* **Tham chiếu đến một dự án khác theo tên**: Ở nhiều nơi trong Jenkins, bạn có thể tham chiếu đến một dự án/công việc khác theo tên (copyArtifacts projectName: 'myproject')
  * **Phân biệt giữa nhiều dự án có cùng tên**: có thể phân biệt chúng bằng cách sử dụng đường dẫn, tương tự như đường dẫn hệ thống tệp Unix
  * **Tham chiếu các thành phần bên trong dự án**:
    * Các dự án Maven
    * Dự án ma trận
    * Đường ống đa nhánh
  * Mã hóa tên: Các ký tự đặc biệt trong đường dẫn phải được mã hóa theo URL
* **API truy cập từ xa**:
  * API từ xa có thể được sử dụng để thực hiện những việc như sau:
  * lấy thông tin từ Jenkins để sử dụng theo chương trình.
  * kích hoạt một bản dựng mới
  * tạo/sao chép công việc
* **Sử dụng tác nhân Jenkins**: Các tác nhân yêu cầu cài đặt Java và kết nối mạng với bộ điều khiển Jenkins
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
* **Sử dụng JMeter với Jenkins**: Tích hợp liên tục và tự động hóa thử nghiệm đã trở thành tiêu chuẩn trong thế giới DevOps, nhưng mức hiệu suất và độ phức tạp của hệ thống sẽsẽ tăng lên
# 5 Pipeline
* **Jenkins Pipeline là gì**:là một bộ plugin hỗ trợ triển khai và tích hợp các đường ống phân phối liên tục **(CD)** vào Jenkins
  * **CD**: là biểu hiện tự động của quy trình của bạn để đưa phần mềm từ kiểm soát phiên bản đến người dùng và khách hàng của bạn
* **Tại sao lại là Pipeline**: Pipeline bổ sung một bộ công cụ tự động hóa mạnh mẽ vào Jenkins. Người dùng có thể tận dụng nhiều tính năng của Pipeline:
  * **Mã** : Đường ống được triển khai trong mã và thường được kiểm tra trong kiểm soát nguồn, cung cấp cho các nhóm khả năng chỉnh sửa, xem xét và lặp lại đường ống phân phối của họ.
  * **Bền bỉ** : Đường ống có thể hoạt động bình thường sau cả lần khởi động lại bộ điều khiển Jenkins theo kế hoạch hoặc không theo kế hoạch.
  * **Có thể tạm dừng** : Đường ống có thể tùy ý dừng lại và chờ con người nhập dữ liệu hoặc phê duyệt trước khi tiếp tục chạy Đường ống.
  * **Đa năng** : Đường ống hỗ trợ các yêu cầu CD phức tạp trong thế giới thực, bao gồm khả năng phân nhánh/nối, lặp và thực hiện công việc song song.
  * **Có thể mở rộng** : Plugin Pipeline hỗ trợ các tiện ích mở rộng tùy chỉnh cho DSL của nó [ 1 ] và nhiều tùy chọn để tích hợp với các plugin khác.
* **Bắt đầu với Pipeline**:
  * **Điều kiện sử dụng**: Jenkins 2.x trở lên, plugin PPipeline
  * **Xác định đường ống**:Có thể tạo Pipeline theo 3 cách:
    * **Qua Blue ocean**: sau khi thiết lập dự án Pipeline trong `Blue Ocean, Blue Ocean UI` sẽ giúp bạn viết Pipeline `Jenkinsfile` và cam kết nó với kiểm soát nguồn.
    * **Thông qua giao diện người dùng cổ điển**: bạn có thể nhập Pipeline cơ bản trực tiếp vào Jenkins thông qua giao diện người dùng cổ điển.
    * **Trong SCM**: bạn có thể viết `Jenkinsfile` thủ công, bạn có thể cam kết với kho lưu trữ kiểm soát nguồn của dự án.
* **Sử dụng Jenkinsfile**: mang lại một số lợi ích ngay lập tức: Đánh giá/lặp lại mã trên Pipeline, theo dõi kiểm toán cho Đường ống, nguồn thông tin đáng tin cậy duy nhất cho Pipeline, có thể được nhiều thành viên của dự án xem và chỉnh sửa.
  * Jenkinsfile: là tệp văn bản chứa định nghĩa về Pipeline Jenkins và được kiểm tra trong kiểm soát nguồn
* **Làm việc với Jenkinsfile**:
  * Sử dụng biến môi trường:
    * **ID xây dựng**: (ID bản dựng hiện tại, giống với BUILD_NUMBER đối với các bản dựng được tạo trong Jenkins phiên bản 1.597 trở lên.)
    * **Số xây dựng**: (Số bản dựng hiện tại, chẳng hạn như "153".)
    * **Xây dựng TAG**: (Chuỗi jenkins {JOB_NAME} {BUILD_NUMBER}. Thuận tiện để đưa vào tệp tài nguyên, tệp jar, v.v. để dễ nhận dạng hơn.)
    * **URL xây dựng**: (URL nơi có thể tìm thấy kết quả của bản dựng này (ví dụ: http://buildserver/jenkins/job/MyJobName/17/))
    * **Số thực hành**: (Số duy nhất xác định trình thực thi hiện tại (trong số các trình thực thi của cùng một máy) đang thực hiện bản dựng này. Đây là số bạn thấy trong "trạng thái trình thực thi bản dựng", ngoại trừ số bắt đầu từ 0, không phải 1.)
    * **Trang chủ JAVA**: (Nếu công việc của bạn được cấu hình để sử dụng một JDK cụ thể, biến này được đặt thành JAVA_HOME của JDK được chỉ định. Khi biến này được đặt, PATH cũng được cập nhật để bao gồm thư mục con bin của JAVA_HOME)
    * **URL của JENKINS**: (URL đầy đủ của Jenkins, chẳng hạn như `https://example.com:port/jenkins/` (LƯU Ý: chỉ khả dụng nếu URL Jenkins được đặt trong "Cấu hình hệ thống"))
    *Tên công vụ: (Tên của dự án xây dựng này, chẳng hạn như "foo" hoặc "foo/bar".)
    * **Tên nút**: (Tên của nút mà bản dựng hiện tại đang chạy. Đặt thành 'master' cho bộ điều khiển Jenkins.) 
    * **Không gian làm việc**: (Đường dẫn tuyệt đối của không gian làm việc)
`https://www.jenkins.io/doc/book/pipeline/jenkinsfile/`(link USE Jenkinsfile)
* **Lên lịch công việc trong Jenkins**: Chức năng lập lịch cho phép bạn lập lịch các tác vụ chạy tự động trong thời gian ngoài giờ hoặc thời gian chết. Việc lập lịch các tác vụ có thể giúp bạn mở rộng môi trường khi mức sử dụng Jenkins tăng lên:
* **Branches và Pull Requests**: khái niệm về Multibranch Pipelines được xây dựng trên Jenkinsfile nền tảng để cung cấp chức năng năng động và tự động hơn trong Jenkins.
  * **Tạo một Pipeline đa nhánh**:
    * Nhấp vào `new item` trên trang chủ Jenkins.
    * Nhập tên cho Pipeline của bạn, chọn `Multibranch Pipeline` và nhấp vào `OK`
    * Thêm Nguồn nhánh
    * Nhập vị trí của Git Repository
    * Lưu dự án Đường ống đa nhánh
    * Sau khi Lưu , Jenkins sẽ tự động quét kho lưu trữ được chỉ định và tạo các mục thích hợp cho mỗi nhánh trong kho lưu trữ có chứa Jenkinsfile
  * **Hỗ trợ Pull Requests**: Có thể sử dụng Multibranch Pipelines để xác thực yêu cầu pull/change requests bằng plugin thích hợp. Chức năng này được cung cấp bởi các plugin sau: 
    * GitHub Branch Source
    * Bitbucket Branch Source
    * GitLab Branch Source
    * Gitea
    * Tuleap Git Branch Source
    * AWS CodeCommit Jobs
    * DAGsHub Branch Source
* **Dùng Organization Folders**: cho phép Jenkins giám sát toàn bộ Tổ chức GitHub, Nhóm/Dự án Bitbucket, tổ chức GitLab hoặc tổ chức Gitea và tự động tạo Đường ống đa nhánh mới cho các kho lưu trữ chứa các nhánh và pull requessts có chứa tệp Jenkinsfile.

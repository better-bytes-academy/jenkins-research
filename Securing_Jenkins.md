# Securing Jenkins 
Để hỗ trợ an toàn cho sự lan rộng của các hồ sơ bảo mật và mối đe dọa này, Jenkins cung cấp nhiều tùy chọn cấu hình để bật, tùy chỉnh hoặc vô hiệu hóa các tính năng bảo mật khác nhau
## Access Control 
**1 Có hai phần access control**
* xác thực: được thực hiện bằng cách sử dụng security realm.
* Quyền hạn: được thực hiện bằng an authorization strategy.

**2 Những lỗi cấu hình thường gặp**
* Anyone can do anything: không nên sử dụng chiến lược này. Không bao giờ dựa vào URL Jenkins để không được biết đến bên ngoài nhóm hoặc tổ chức của bạn vì lý do bảo mật
* Logged-in users can do anything:  là một lựa chọn hợp lý miễn là chỉ những người dùng được tin cậy hoàn toàn mới có tài khoản để truy cập Jenkins
* Anonymous and authenticated users: không nên cấp các quyền đáng kể cho anonymous(người dùng ẩn danh) hoặc đã xác thực (bất kỳ người dùng đã xác thực nào) khi sử dụng chiến lược cấp phép cho phép kiểm soát chi tiết hơn 
* Built-in node: Người dùng có quyền hạn hạn chế không được phép cấu hình các tác vụ chạy trên nút tích hợp . Khi thiết lập phiên bản Jenkins mới, thêm người dùng và chuyển đổi chiến lược ủy quyền, điều quan trọng là phải thiết lập bản dựng phân tán và giới hạn những tác vụ nào có thể chạy trên nút tích hợp

**3 Permission**
Ở mức cơ bản nhất, quyền Overall/Read cung cấp cho người dùng một số quyền truy cập cơ bản vào Jenkins. Quyền này là điều kiện tiên quyết để có quyền truy cập đáng kể hơn vào Jenkins
## Bảo mật Jenkins 
**Việc bảo mật Jenkins có hai khía cạnh**
* Kiểm soát truy cập, đảm bảo người dùng được xác thực khi truy cập Jenkins và các hoạt động của họ được ủy quyền.
* Bảo vệ Jenkins khỏi các mối đe dọa bên ngoài

**Kiểm soát truy cập**
*Security Realm: xác định người dùng và mật khẩu của họ
* Authorization Strategy xác định ai có quyền truy cập vào những gì 
## Managing Security 
**1 Enable security**
![ha](https://www.jenkins.io/doc/book/resources/security/configure-global-security.png)
**1.1 Cổng TCP**
* Jenkins có thể sử dụng cổng TCP để giao tiếp với các agent 
* Đối với người quản trị muốn sử dụng tác nhân TCP đến, có hai tùy chọn cổng sau:
   * Ngẫu nhiên : Cổng TCP được chọn ngẫu nhiên để tránh xung đột trên bộ điều khiển Jenkins . Nhược điểm của các cổng ngẫu nhiên là chúng được chọn trong quá trình khởi động bộ điều khiển Jenkins, khiến việc quản lý các quy tắc tường lửa cho phép lưu lượng TCP trở nên khó khăn
   * điều chỉnh: Cổng được quản trị viên Jenkins chọn và nhất quán khi khởi động lại bộ điều khiển Jenkins. Điều này giúp quản lý các quy tắc tường lửa dễ dàng hơn, cho phép các tác nhân dựa trên TCP kết nối với bộ điều khiển
**1.2 Kiểm soát truy cập**
* Security Realm: thông báo cho môi trường Jenkins cách thức và nơi lấy thông tin người dùng (hoặc danh tính). Cũng thường được gọi là "xác thực".

* Cấu hình ủy quyền: thông báo cho môi trường Jenkins về việc người dùng và/hoặc nhóm nào có thể truy cập vào khía cạnh nào của Jenkins và ở mức độ nào.
**1.3 Security Realm**
* Ủy quyền cho container servle
* Cơ sở dữ liệu người dùng của Jenkins: Sử dụng kho dữ liệu người dùng tích hợp sẵn của Jenkins để xác thực thay vì ủy quyền cho hệ thống bên ngoài. Tính năng này được bật theo mặc định với các bản cài đặt Jenkins 2.0 trở lên và phù hợp với các môi trường nhỏ hơn.
## Controller Isolation 
**1 không build trên built-in node**: 
không nên chạy bất kỳ bản dựng nào trên built-in nodenode, thay vào đó hãy sử dụng các agent để chạy bản dựng.
**2 Agent → Controller Access Control**
Điều này cho phép một agent yêu cầu quy trình điều khiển cung cấp thông tin có sẵn cho nó, ví dụ, nội dung của tệp,...., và thậm chí để bộ điều khiển chạy một số lệnh nhất định khi được agent yêu cầu
![ha](https://www.jenkins.io/doc/book/resources/security/configure-global-security-agent-controller-toggle.png)
## Securing Builds 
**1 Isolating Distributed Builds**:

 Jenkins nên được thiết lập cho các bản dựng phân tán để đảm bảo các tập lệnh dựng không được thực thi trên bộ điều khiển, nơi chúng có thể truy cập vào thư mục gốc của Jenkins hoặc can thiệp vào hoạt động của Jenkins.

 các bản dựng cần phải được tách biệt khỏi nhau

 * Các giải pháp cho vấn đề này bao gồm:

    * Sử dụng nhà cung cấp dịch vụ đám mây tạo ra một tác nhân mới cho mỗi bản dựng.

    * Các plugin như Plugin Job Restrictions giới hạn những công việc nào có thể chạy trên một số nút nhất định.

**2 Pull Request Abuse**
Khi sử dụng organization fodel hoặc multibranch-Pipelines , Jenkins tự động xây dựng các yêu cầu kéo mới theo mặc định. Đặc biệt khi một phiên bản Jenkins xây dựng các dự án từ kho lưu trữ công khai, điều này có thể mở ra cánh cửa cho việc abuse, chẳng hạn như:
* Yêu cầu kéo thư rác kích hoạt nhiều bản dựng mới.
* Các yêu cầu kéo độc hại sửa đổi tập lệnh xây dựng, ví dụ như để khai thác tiền điện tử
## CSRF Protection 
Cross-Site Request Forgery (CSRF hoặc XSRF) là một loại lỗ hổng bảo mật trong các ứng dụng web. Nếu không được bảo vệ khỏi CSRF, người dùng hoặc quản trị viên Jenkins truy cập một số trang web khác sẽ cho phép người điều hành trang web đó thực hiện các hành động trong Jenkins
**1 Bảo vệ CSRF trong Jenkins**: Bảo vệ CSRF sử dụng một mã thông báo (gọi là crumb trong Jenkins) do Jenkins tạo ra và gửi đến người dùng. Bất kỳ lần gửi biểu mẫu hoặc hành động tương tự nào dẫn đến sửa đổi, như kích hoạt bản dựng hoặc thay đổi cấu hình, đều yêu cầu phải cung cấp crumb. Crumb chứa thông tin xác định người dùng mà nó được tạo ra.

**2 Cấu hình bảo vệ CSRF**: Manage Jenkins » Security » CSRF Protection
![ha](https://www.jenkins.io/doc/book/resources/security/configure-global-security-prevent-csrf.png)

**3 Vô hiệu hóa bảo vệ CSRF**: Để tắt bảo vệ CSRF, hãy đặt thuộc tính hệ thống hudson.security.csrf.GlobalCrumbIssuerConfiguration.DISABLE_CSRF_PROTECTION thành 'true' khi khởi động.
## Securing SCM credentials for Organization Folders and Multibranch Pipelines
**1 Credentials**
* Đối với nhiều cấu hình Branch Source, chẳng hạn như những cấu hình được cung cấp bởi plugin GitHub Branch Source và plugin Bitbucket Branch Source, người dùng Jenkins cấu hình dự án chỉ cần cung cấp một thông tin xác thực duy nhất, thông tin này sẽ được sử dụng theo hai cách:

    * Bằng bộ điều khiển, để thực hiện các hoạt động của plugin như quét Thư mục tổ chức, lập chỉ mục nhánh Đường ống đa nhánh, sửa đổi webhook, cập nhật trạng thái cam kết, v.v. Các hoạt động này thường tương tác với API của nhà cung cấp SCM có thể yêu cầu các quyền đáng kể ngoài quyền truy cập đọc/ghi vào nội dung của kho lưu trữ.

    * Theo nodes, để kiểm tra các kho lưu trữ đang được xây dựng bởi các tác vụ Pipeline con.

**2 Implications**:
Thông tin xác thực SCM dành cho Organization Folders và Multibranch Pipelines có thể được bất kỳ ai có khả năng sửa đổi thông tin xác thực Jenkinsfilecủa kho lưu trữ đang được xây dựng bởi  Organization Folders và Multibranch Pipelines đó sử dụng tùy ý
**3 Giải pháp**
* Nếu mối quan tâm chính của bạn là ngăn chặn người dùng có quyền đọc/ghi SCM vào kho lưu trữ sử dụng thông tin xác thực quét để truy cập vào các kho lưu trữ khác đang được Thư mục tổ chức xây dựng, bạn có một số tùy chọn sau:
   * Giả sử nhà cung cấp SCM cho phép bạn tạo thông tin xác thực chỉ có thể truy cập vào các kho lưu trữ cụ thể (chẳng hạn như mã thông báo truy cập cá nhân chi tiết của GitHub), bạn có thể tạo nhiều Thư mục tổ chức được định cấu hình để xây dựng các tập hợp con riêng biệt của các kho lưu trữ đang đề cập, xác định thông tin xác thực bị hạn chế trực tiếp trên mỗi Thư mục tổ chức trong Jenkins.
   * Tùy thuộc vào các tính năng liên quan đến thông tin xác thực của nhà cung cấp SCM, bạn có thể không sử dụng được Thư mục tổ chức một cách an toàn và thay vào đó sẽ cần tạo một Đường ống đa nhánh cho mỗi kho lưu trữ với thông tin xác thực được xác định trên đó chỉ cho phép truy cập vào kho lưu trữ cụ thể đó.
## Exposed Services and Ports
**1 TCP Agent Listener Port**
Jenkins có thể hiển thị cổng TCP cho phép các agent đến kết nối với nó. Có thể bật, tắt và cấu hình cổng này trong Manage Jenkins » Security .
## Credentials 
Sử dụng thông tin xác thực để bảo mật quyền truy cập

**1 Working with Credentials**
* Cấu hình thông tin xác thực. Xem Configuring Credentials
* Gọi thông tin xác thực trong Pipeline để có quyền truy cập vào tài nguyên bên ngoài.
**2 Giới hạn quyền truy cập vào credential**
* Hạn chế nghiêm ngặt số lượng người có quyền Credentials > Create .
* Chỉ cấp quyền truy cập cho những người, dự án và mục cụ thể thực sự cần quyền truy cập này để thực hiện công việc.
* Xác định từng thông tin xác thực ở mức thấp nhất có thể. Thông tin xác thực được xác định cho bộ điều khiển có sẵn cho tất cả các Đường ống do bộ điều khiển đó chạy. Thông tin xác thực được xác định cho một thư mục chỉ có sẵn cho các Đường ống chạy từ thư mục đó. Các màn hình được sử dụng để thêm và quản lý thông tin xác thực cho bộ điều khiển và thư mục giống hệt nhau ngoại trừ vị trí của chúng.
.



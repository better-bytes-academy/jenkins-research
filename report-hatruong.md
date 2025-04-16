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
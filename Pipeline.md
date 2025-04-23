# Pipeline
### Jenkins Pipeline là gì:
Jenkins Pipeline là một bộ plugin hỗ trợ triển khai và tích hợp các continuous delivery pipelines **(CD)** vào Jenkins.
> **CD**: là biểu hiện tự động của quy trình của bạn để đưa phần mềm từ kiểm soát phiên bản đến người dùng và khách hàng của bạn

Pipeline cung cấp một bộ công cụ có thể mở rộng để mô hình hóa các delivery pipelines từ đơn giản đến phức tạp "dưới dạng code" thông qua Pipeline domain-specific language (DSL) syntax.
> DSL là một loại ngôn ngữ lập trình được thiết kế để giải quyết các vấn đề trong một miền cụ thể(VD: SQL, HTML)

**Jenkinsfile**: là một file text chứa cấu hình của toàn bộ quy trình workflow jenkins pipeline dưới dạng code. Lợi thế của file text này giúp cho các lập trình viên hoặc quản trị viên dễ dàng truy cập, thay đổi nội dung code tuỳ biến ở mọi thời điểm.

**Có 2 loại jenkins pipeline và bộ khung của nó**:

**1 Declarative Pipeline:** 
```Jenkinsfile
pipeline {
    agent any (1)
    stages {
        stage('Build') { (2)
            steps {
                // (3)
            }
        }
        stage('Test') { (4)
            steps {
                // (5)
            }
        }
        stage('Deploy') { (6)
            steps {
                // (7)
            }
        }
    }
}
```
* (1) Thực hiện Pipeline này hoặc bất kì giai đoạn nào trên bất kì tác nhân nào có sẵn
* (2) Giai đoạn xây dựng
* (3) Thực hiện các bước xây dựng
* (4) Giai đoạn kiểm tra
* (5) Các bước kiểm tra
* (6) Giai đoạn triển khai
* (7) Các bước triển khai

**2 Scripted Pipeline:**
```Jenkinsfilesfiles
node {   (1)
    stage('Build') { (2) 
        //  (3)
    }
    stage('Test') {  (4)
        //  (5)
    }
    stage('Deploy') { (6) 
        //   (7)
    }
}
```
* (1) Thực hiện Pipeline này hoặc bất kì giai đoạn nào trên bất kì tác nhân nào có sẵn
* (2) Giai đoạn xây dựng
* (3) Thực hiện các bước xây dựng
* (4) Giai đoạn kiểm tra
* (5) Các bước kiểm tra
* (6) Giai đoạn triển khai
* (7) Các bước triển khai
## Bắt đầu với Pipeline
**1 Điều kiện tiên quyết**:
* Jenkins 2.x trở lên
* Pipeline plugin

**2 Xác định Pipeline**:

2.1 Declarative và Scripted Pipeline đều là DSLs

2.2 Có thể tạo Pipeline theo một trong những cách sau:

a, Thông qua Blue ocean: 
* Nếu bạn mới sử dụng Jenkins Pipeline, Blue Ocean UI sẽ giúp bạn thiết lập dự án Pipeline và tự động tạo và ghi Pipeline (tức là Jenkinsfile) cho bạn thông qua trình chỉnh sửa Pipeline đồ họa
* mọi thay đổi bạn thực hiện đối với Jenkinsfiletrình chỉnh sửa Pipeline của Blue Ocean đều được tự động lưu và commitcommit

b, Qua giai diện người dùng:
* => "New item"
* => nhập tên và click vào pipeline
* => click "ok" lướt xuống phần denifition chọn pipeline scripts
* => đẩy code vào nhấn "save"
* => "build now"
* có thể click console output để xem kết quả ra đầy đủđủ

c, Qua SCM:

sử dụng giao diện sẽ khó khăn hơn khi pipeline phức tạp và để dễ dàng hơn thì sử dụng jenkinsfile
* => "New item"
* => nhập tên và click vào pipeline
* => click "ok" lướt xuống phần denifition chọn pipeline script from SCM
* => chọn loại chứa jenkinsfiles của bạn
* trong Script Path hãy điền đường dẫn của jenkinsfiles 
## Dùng Jenkinsfile
**Tạo một tệp mới Jenkinsfiletrong thư mục gốc của dự án**. Viết code tùy dạng Declarative hoặc scripts pipeline vào Jenkinsfile.

**1 Using environment variables:**
* **ID xây dựng**: (ID bản dựng hiện tại, giống với BUILD_NUMBER đối với các bản dựng được tạo trong Jenkins phiên bản 1.597 trở lên.)
* **Số xây dựng**: (Số bản dựng hiện tại, chẳng hạn như "153".)
* **Xây dựng TAG**: (Chuỗi jenkins {JOB_NAME} {BUILD_NUMBER}. Thuận tiện để đưa vào tệp tài nguyên, tệp jar, v.v. để dễ nhận dạng hơn.)
* **URL xây dựng**: (URL nơi có thể tìm thấy kết quả của bản dựng này (ví dụ: http://buildserver/jenkins/job/MyJobName/17/))
* **Số thực hành**: (Số duy nhất xác định trình thực thi hiện tại (trong số các trình thực thi của cùng một máy) đang thực hiện bản dựng này. Đây là số bạn thấy trong "trạng thái trình thực thi bản dựng", ngoại trừ số bắt đầu từ 0, không phải 1.)
* **Trang chủ JAVA**: (Nếu công việc của bạn được cấu hình để sử dụng một JDK cụ thể, biến này được đặt thành JAVA_HOME của JDK được chỉ định. Khi biến này được đặt, PATH cũng được cập nhật để bao gồm thư mục con bin của JAVA_HOME)
* **URL của JENKINS**: (URL đầy đủ của Jenkins, chẳng hạn như https://example.com:port/jenkins/ (LƯU Ý: chỉ khả dụng nếu URL Jenkins được đặt trong "Cấu hình hệ thống"))
    *Tên công vụ: (Tên của dự án xây dựng này, chẳng hạn như "foo" hoặc "foo/bar".)
 * **Tên nút**: (Tên của nút mà bản dựng hiện tại đang chạy. Đặt thành 'master' cho bộ điều khiển Jenkins.) 
* **Không gian làm việc**: (Đường dẫn tuyệt đối của không gian làm việc)
https://www.jenkins.io/doc/book/pipeline/jenkinsfile/ (link USE Jenkinsfile)

**2 Thiết lập biến môi trường**: Tùy vào dạng pipeline
https://www.jenkins.io/doc/book/pipeline/jenkinsfile/#setting-environment-variables

## Branches và Pull Requests
**1 tạo mutilbranch pipeline**
* tạo new mutilbranch pipeline
* thêm nguồn branch

(chi tiết https://www.jenkins.io/doc/book/pipeline/multibranch/)

**2 Hỗ trợ Pull Requests**: Có thể sử dụng Multibranch Pipelines để xác thực yêu cầu pull/change requests bằng plugin thích hợp. Chức năng này được cung cấp bởi các plugin sau: 
* GitHub Branch Source
* Bitbucket Branch Source
* GitLab Branch Source
* Gitea
* Tuleap Git Branch Source
* AWS CodeCommit Jobs
* DAGsHub Branch Source
  





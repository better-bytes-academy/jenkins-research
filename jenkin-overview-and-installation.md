# Cài đặt jenkins
Jenkin thường được chạy nhưng một app độc lập với process riêng.
Jenkin war file chứa:
    - Winstone: command line interface
    - Jetty servlet container wrapper
Có thể chạy Jenkin war file trên bất cứ hệ điều hành nào có phiên bản Java  tương thích vơí Jenkin

Về mặt lý thuyết, Jenkin có thể chạy như một servlet trong một servlet container như Apache Tomcat, nhưng trong thực tế có nhiều vấn đề chưa được kiểm thử => không khuyến khích

## Cài đặt với Docker

### Docker là gì?
Docker cho phép thực hiện chạy chương trình trong một môi trường khép kín gọi là container.
Ứng dụng như Jenkin có thể được tải về như một images *(chỉ đọc)* và chạy trong Docker.
Docker container chứa một instance của Docker image.

Docker cho phép các ứng dụng chạy ở bất kì môi trường hệ điều hành/ cloud service nào hỗ trợ Docker. (MacOS, Linux, Windows, GCP, Azure, AWS)

### Cài đặt Docker
**1. Yêu cầu phần cứng- phần mềm**

Yêu cầu phần cứng: tra cứu tại https://www.jenkins.io/doc/book/scaling/hardware-recommendations/

Java: phiên bản JDK 17 hoặc 21 ( recommended) - Các phiên bản khác tra cứu tại: https://www.jenkins.io/doc/book/platform-information/support-policy-java/

**2. Tải và chạy Jenkin ở Docker**

> Phiên bản image của Jenkin trong Docker hub (https://hub.docker.com/r/jenkins/jenkins/) chứa bản LTS của Jenkin, không chứa Docker CLI, không chứa các plugin và tính năng được dùng nhiều của BlueOcean


2.1 MacOS and Linux
1. Mở terminal
2. Tạo một cầu nối mạng ( bridge network) trong Docker với câu lệnh `docker network create jenkins`
3. Để chạy được các câu lệnh Docker trong Jenkin node, tải `docker:dind` sử dụng câu lệnh:
```bash
docker run \
--name jenkins-docker \  (1)
--rm \    (2)
--detach \    (3)
--privileged \    (4)
--network jenkins \   (5)
--network-alias docker \  (6)
--env DOCKER_TLS_CERTDIR=/certs \     (7)
--volume jenkins-docker-certs:/certs/client \     (8)
--volume jenkins-data:/var/jenkins_home \     (9)
--publish 2376:2376 \     (10)
docker:dind \     (11)
--storage-driver overlay2     (12)
```

Note: 
- (1) Optional - khai báo tên docker container
- (2) Optional - **Tự động** xoá Docker container khi tắt docker
- (3) Optional - Chạy nền Docker container - tắt bằng câu lệnh `docker stop jenkins-docker`
- (4) Chạy Docker với các đặc quyền truy cập để đảm bảo hoạt động bình thường
- (5) Network bridge được tạo ra ở step 2
- (6) Cho phép Docker khả dụng với hostname `docker` và network `jenkins`
- (7) Mở TLS trong Docker server - recommended - yêu cầu quyền sử dụng shảed volume ( mô tả phía dưới)
- (8) Map đường dẫn  `/certs/client` trong container tới một Docker volumn có tên `jenkins-docker-certs` 
- (9) Map thư mục `/var/jenkins_home` trong container tới một Docker volume tên `jenkins-data` -> cho phép các Docker container khác ( được quản lý bởi Docker container daemon này (This Docker container daemon)) có thể gắn (mount) dữ liệu từ Jenkins
- (10) Optional - Mở port của Docker deamon tới máy host ( máy chạy Docker) - nên dùng, cho phép chạy các câu lệnh của Docker từ máy host nhằm điều khiển Docker daemon 
- (11) Image `docker:dind` -> tải về trước khi chạy câu lệnh trên `docker image pull docker:dind`
- (12) Trình điều khiển lưu trữ của Docker volume - refer: https://docs.docker.com/storage/storagedriver/select-storage-driver


4. Tuỳ chỉnh Docker image chính thức của Jenkin với 2 bước:

    a. Tạo `Dockerfile` với câu lệnh 
    ```bash
    FROM jenkins/jenkins:2.492.3-jdk17
    USER root
    RUN apt-get update && apt-get install -y lsb-release ca-certificates curl && \
        install -m 0755 -d /etc/apt/keyrings && \
        curl -fsSL https://download.docker.com/linux/debian/gpg -o /etc/apt/keyrings/docker.asc && \
        chmod a+r /etc/apt/keyrings/docker.asc && \
        echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] \
        https://download.docker.com/linux/debian $(. /etc/os-release && echo \"$VERSION_CODENAME\") stable" \
        | tee /etc/apt/sources.list.d/docker.list > /dev/null && \
        apt-get update && apt-get install -y docker-ce-cli && \
        apt-get clean && rm -rf /var/lib/apt/lists/*
    USER jenkins
    RUN jenkins-plugin-cli --plugins "blueocean docker-workflow"
    ```
    b. Build Docker image mới với `Dockerfile` trên, và cho nó một cái tên có ý nghĩa. VD: 
    `docker build -t myjenkins-blueocean:2.492.3-1`
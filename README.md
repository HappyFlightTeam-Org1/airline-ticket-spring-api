I. ĐỂ CHẠY ĐƯỢC DỰ ÁN NÀY CẦN:
1. Cài đặt maven >> tham khảo nguồn google
2. Cài đặt JDK 1.8 trở lên >> tham khảo nguồn google
3. Cài đặt Eclipse IDE hoặc Intellij IDE(recommend) >> tham khảo nguồn google
4. Cài đặt hệ quản trị cơ sở dữ liệu MySQL >> tham khảo nguồn google
II. CÁC BƯỚC RUN PROJECT NÀY:
BƯỚC 1: clone source code từ repository này về (có thể search cách clone repository github)
BƯỚC 2: mở dự án bằng Eclipse hoặc Intellij, sau đó mở cửa sổ Terminal của dự án lên
- Đối với Eclipse: click chuột phải vào dự án >> Show in Local Terminal >> Terminal
- Đối với Eclipse: click chuột phải vào dự án >> Open in Terminal
BƯỚC 3: tại cửa sổ Terminal  gõ lệnh git checkout dev để chuyển sang nhánh dev (nhánh đang chứa source code tổng hợp của dự án)
BƯỚC 4: 
- Đối với Eclipse: click chuột phải vào file pom.xml >> Maven >> Update project
- Đối với Intellij: click chuột phải vào file pom.xml >> Maven >> Reimport
BƯỚC 5: tạo một database có tên airline_ticket_db trong MySQL
BƯỚC 6: vào thư mục \airline-ticket-spring-api\src\main\resources\application.properties để cấu hình thông tin ứng dụng
#spring.datasource.username=${username MySQL của bạn} - ví dụ: spring.datasource.username=root
#spring.datasource.password=${password MySQL của bạn} - ví dụ: spring.datasource.password=12345678
#spring.jpa.hibernate.ddl-auto=create
BƯỚC 7:
- Đối với Eclipse: click chuột phải vào file src/main/java/com/fsoft/happflight/AirlineTicketSpringApiApplication.java >> Run as >> Java Application
- Đối với Intellij: click chuột trái vào nút run có hình tam giác màu xanh trên đầu ứng dụng, ngay bên cạnh [AirlineTicketSpringApiApplication]
# hoặc bạn có thể tham khảo cách chạy ứng dụng spring boot trên Intellij từ google
BƯỚC 8: sau khi BƯỚC 7 hoàn thành, mở file \airline-ticket-spring-api\src\main\java\com\fsoft\happflight\sql\airline_ticket_db.sql và insert dữ liệu theo hướng dẫn trong file
BƯỚC 9: chuyển #spring.jpa.hibernate.ddl-auto=create ở [BƯỚC 6] thành #spring.jpa.hibernate.ddl-auto=update và chạy lại chương trình
#HOAN_TAT

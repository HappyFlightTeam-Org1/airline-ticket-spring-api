-- create database airline_ticket_db;
-- drop database airline_ticket_db;
use airline_ticket_db;

-- DDL  airline_ticket_db;
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `reciptient` varchar(255) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `chuyen_bay`;
CREATE TABLE `chuyen_bay` (
  `ma_chuyen_bay` varchar(50)  NOT NULL,
  `kl_hanh_ly` varchar(50) DEFAULT NULL,
  `diem_den` varchar(50)  DEFAULT NULL,
  `diem_di` varchar(50) DEFAULT NULL,
  `gia_ve` varchar(50) DEFAULT NULL,
  `gio_ha_canh` time DEFAULT NULL,
  `gio_khoi_hanh` time DEFAULT NULL,
  `ngay_khoi_hanh` varchar(255) DEFAULT NULL,
  `thoi_gian_bay` varchar(50)  DEFAULT NULL,
  `trang_hai_van_hanh` varchar(50)  DEFAULT NULL,
  `trang_thai_xoa` int DEFAULT NULL,
  `ma_hang_bay` varchar(50)  DEFAULT NULL,
  `ma_may_bay` bigint DEFAULT NULL,
  PRIMARY KEY (`ma_chuyen_bay`),
  CONSTRAINT FOREIGN KEY (`ma_hang_bay`) REFERENCES `hang_bay` (`ma_hang_bay`),
  CONSTRAINT  FOREIGN KEY (`ma_may_bay`) REFERENCES `may_bay` (`ma_may_bay`)
) ;

CREATE TABLE `dat_cho` (
  `ma_dat_cho` bigint NOT NULL AUTO_INCREMENT,
  `trang_thai` varchar(50)  DEFAULT 'available',
  `ma_chuyen_bay` varchar(50) DEFAULT NULL,
  `ma_ghe` bigint DEFAULT NULL,
  PRIMARY KEY (`ma_dat_cho`),
  CONSTRAINT FOREIGN KEY (`ma_chuyen_bay`) REFERENCES `chuyen_bay` (`ma_chuyen_bay`),
  CONSTRAINT FOREIGN KEY (`ma_ghe`) REFERENCES `ghe` (`ma_ghe`)
);

CREATE TABLE `ghe` (
  `ma_ghe` bigint NOT NULL AUTO_INCREMENT,
  `ten_ghe` varchar(50)  DEFAULT NULL,
  `ma_loai_ghe` bigint DEFAULT NULL,
  `ma_may_bay` bigint DEFAULT NULL,
  PRIMARY KEY (`ma_ghe`),
  CONSTRAINT FOREIGN KEY (`ma_may_bay`) REFERENCES `may_bay` (`ma_may_bay`),
  CONSTRAINT  FOREIGN KEY (`ma_loai_ghe`) REFERENCES `loai_ghe` (`ma_loai_ghe`)
) ;

DROP TABLE IF EXISTS `hang_bay`;
CREATE TABLE `hang_bay` (
  `ma_hang_bay` varchar(50)  NOT NULL,
  `logo_url` varchar(250)  DEFAULT NULL,
  `ten_hang_bay` varchar(50)  DEFAULT NULL,
  PRIMARY KEY (`ma_hang_bay`)
) ;

DROP TABLE IF EXISTS `hanh_khach`;
CREATE TABLE `hanh_khach` (
  `ma_hanh_khach` bigint NOT NULL AUTO_INCREMENT,
  `gioi_tinh` varchar(20) DEFAULT NULL,
  `loai_hanh_khach` varchar(100)  DEFAULT NULL,
  `ngay_sinh` varchar(255) DEFAULT NULL,
  `ten_hanh_khach` varchar(100) DEFAULT NULL,
  `trang_thai_xoa` int DEFAULT NULL,
  PRIMARY KEY (`ma_hanh_khach`)
) ;

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ;

DROP TABLE IF EXISTS `hoa_don`;
CREATE TABLE `hoa_don` (
  `ma_hoa_don` varchar(50)  NOT NULL,
  `ngay_tao` varchar(255) DEFAULT NULL,
  `tong_tien` bigint DEFAULT NULL,
  `tt_thanh_toan` int DEFAULT NULL,
  `tt_xoa` int DEFAULT NULL,
  `email` varchar(50)  DEFAULT NULL,
  PRIMARY KEY (`ma_hoa_don`),
  CONSTRAINT FOREIGN KEY (`email`) REFERENCES `nguoi_dung` (`email`)
);

DROP TABLE IF EXISTS `loai_ghe`;
CREATE TABLE `loai_ghe` (
  `ma_loai_ghe` bigint NOT NULL AUTO_INCREMENT,
  `ten_loai_ghe` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_loai_ghe`)
);

DROP TABLE IF EXISTS `may_bay`;
CREATE TABLE `may_bay` (
  `ma_may_bay` bigint NOT NULL AUTO_INCREMENT,
  `sl_ghe_pho_thong` int DEFAULT NULL,
  `sl_ghe_thuong_gia` int DEFAULT NULL,
  `ten_may_bay` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_may_bay`)
);

DROP TABLE IF EXISTS `new_message`;
CREATE TABLE `new_message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quatity` int NOT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
); 


DROP TABLE IF EXISTS `nguoi_dung`;
CREATE TABLE `nguoi_dung` (
  `email` varchar(50)  NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(20)  DEFAULT NULL,
  `ho_chieu` varchar(20)  DEFAULT NULL,
  `ho_va_ten` varchar(50) DEFAULT NULL,
  `ngay_sinh` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(20) DEFAULT NULL,
  `trang_thai_xoa` int DEFAULT NULL,
  `ma_quoc_tich` bigint DEFAULT NULL,
  `ten_tai_khoan` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`email`),
  CONSTRAINT FOREIGN KEY (`ten_tai_khoan`) REFERENCES `tai_khoan` (`ten_tai_khoan`),
  CONSTRAINT  FOREIGN KEY (`ma_quoc_tich`) REFERENCES `quoc_tich` (`ma_quoc_tich`)
);

DROP TABLE IF EXISTS `quoc_tich`;
CREATE TABLE `quoc_tich` (
  `ma_quoc_tich` bigint NOT NULL AUTO_INCREMENT,
  `ten_quoc_tich` varchar(50)  DEFAULT NULL,
  PRIMARY KEY (`ma_quoc_tich`)
) ;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL,
  `role_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY (`role_name`)
);

DROP TABLE IF EXISTS `san_bay`;
CREATE TABLE `san_bay` (
  `ma_san_bay` varchar(50)  NOT NULL,
  `quoc_gia` varchar(50)  DEFAULT NULL,
  `ten_san_bay` varchar(50) DEFAULT NULL,
  `thanh_pho` varchar(50)  DEFAULT NULL,
  PRIMARY KEY (`ma_san_bay`)
) ;

DROP TABLE IF EXISTS `tai_khoan`;
CREATE TABLE `tai_khoan` (
  `ten_tai_khoan` varchar(50) NOT NULL,
  `mat_khau` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`ten_tai_khoan`)
);

DROP TABLE IF EXISTS `tai_khoan_role`;
CREATE TABLE `tai_khoan_role` (
  `ten_tai_khoan` varchar(50) NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`ten_tai_khoan`,`role_id`),
  CONSTRAINT  FOREIGN KEY (`ten_tai_khoan`) REFERENCES `tai_khoan` (`ten_tai_khoan`),
  CONSTRAINT  FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ;

DROP TABLE IF EXISTS `ve_may_bay`;
CREATE TABLE `ve_may_bay` (
  `ma_ve` varchar(255) NOT NULL,
  `gia_ve` bigint DEFAULT NULL,
  `hang_ve` varchar(50) DEFAULT NULL,
  `trang_thai_xoa` int DEFAULT NULL,
  `ma_dat_cho` bigint DEFAULT NULL,
  `ma_hanh_khach` bigint DEFAULT NULL,
  `ma_hoa_don` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_ve`),
  CONSTRAINT FOREIGN KEY (`ma_hoa_don`) REFERENCES `hoa_don` (`ma_hoa_don`),
  CONSTRAINT FOREIGN KEY (`ma_dat_cho`) REFERENCES `dat_cho` (`ma_dat_cho`),
  CONSTRAINT  FOREIGN KEY (`ma_hanh_khach`) REFERENCES `hanh_khach` (`ma_hanh_khach`)
);




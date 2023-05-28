create database airline_ticket_db;
use airline_ticket_db;
-- drop database airline_ticket_db;

INSERT INTO may_bay (sl_ghe_pho_thong, sl_ghe_thuong_gia, ten_may_bay)
VALUES
(28, 12, 'Boeing 747'),
(32, 8, 'Airbus A380'),
(32, 16, 'Boeing 737'),
(28, 12, 'Airbus A320'),
(32, 8, 'Boeing 777');

INSERT INTO may_bay (sl_ghe_pho_thong, sl_ghe_thuong_gia, ten_may_bay)
VALUES
(28, 12, 'Boeing 520');

INSERT INTO loai_ghe (ten_loai_ghe)
VALUES
('Phổ Thông'),
('Thương Gia');

-- INSERT 40 GHE VAO MAY BAY 1
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('H1', 2, 1), ('H2', 2, 1), ('H3', 2, 1), ('H4', 2, 1),
('I1', 2, 1), ('I2', 2, 1), ('I3', 2, 1), ('I4', 2, 1),
('J1', 2, 1), ('J2', 2, 1), ('J3', 2, 1), ('J4', 2, 1),
('A1', 1, 1), ('A2', 1, 1), ('A3', 1, 1), ('A4', 1, 1),
('B1', 1, 1), ('B2', 1, 1), ('B3', 1, 1), ('B4', 1, 1),
('C1', 1, 1), ('C2', 1, 1), ('C3', 1, 1), ('C4', 1, 1),
('D1', 1, 1), ('D2', 1, 1), ('D3', 1, 1), ('D4', 1, 1),
('E1', 1, 1), ('E2', 1, 1), ('E3', 1, 1), ('E4', 1, 1),
('F1', 1, 1), ('F2', 1, 1), ('F3', 1, 1), ('F4', 1, 1),
('G1', 1, 1), ('G2', 1, 1), ('G3', 1, 1), ('G4', 1, 1);
-- INSERT 40 GHE VAO MAY BAY 2
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('I1', 2, 2), ('I2', 2, 2), ('I3', 2, 2), ('I4', 2, 2),
('J1', 2, 2), ('J2', 2, 2), ('J3', 2, 2), ('J4', 2, 2),
('A1', 1, 2), ('A2', 1, 2), ('A3', 1, 2), ('A4', 1, 2),
('B1', 1, 2), ('B2', 1, 2), ('B3', 1, 2), ('B4', 1, 2),
('C1', 1, 2), ('C2', 1, 2), ('C3', 1, 2), ('C4', 1, 2),
('D1', 1, 2), ('D2', 1, 2), ('D3', 1, 2), ('D4', 1, 2),
('E1', 1, 2), ('E2', 1, 2), ('E3', 1, 2), ('E4', 1, 2),
('F1', 1, 2), ('F2', 1, 2), ('F3', 1, 2), ('F4', 1, 2),
('G1', 1, 2), ('G2', 1, 2), ('G3', 1, 2), ('G4', 1, 2),
('H1', 1, 2), ('H2', 1, 2), ('H3', 1, 2), ('H4', 1, 2);

-- INSERT 48 GHE VAO MAY BAY 3
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('I1', 2, 3), ('I2', 2, 3), ('I3', 2, 3), ('I4', 2, 3),
('J1', 2, 3), ('J2', 2, 3), ('J3', 2, 3), ('J4', 2, 3),
('K1', 2, 3), ('K2', 2, 3), ('K3', 2, 3), ('K4', 2, 3),
('L1', 2, 3), ('L2', 2, 3), ('L3', 2, 3), ('L4', 2, 3),
('A1', 1, 3), ('A2', 1, 3), ('A3', 1, 3), ('A4', 1, 3),
('B1', 1, 3), ('B2', 1, 3), ('B3', 1, 3), ('B4', 1, 3),
('C1', 1, 3), ('C2', 1, 3), ('C3', 1, 3), ('C4', 1, 3),
('D1', 1, 3), ('D2', 1, 3), ('D3', 1, 3), ('D4', 1, 3),
('E1', 1, 3), ('E2', 1, 3), ('E3', 1, 3), ('E4', 1, 3),
('F1', 1, 3), ('F2', 1, 3), ('F3', 1, 3), ('F4', 1, 3),
('G1', 1, 3), ('G2', 1, 3), ('G3', 1, 3), ('G4', 1, 3),
('H1', 1, 3), ('H2', 1, 3), ('H3', 1, 3), ('H4', 1, 3);

-- INSERT 40 GHE VAO MAY BAY 4
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('H1', 2, 4), ('H2', 2, 4), ('H3', 2, 4), ('H4', 2, 4),
('I1', 2, 4), ('I2', 2, 4), ('I3', 2, 4), ('I4', 2, 4),
('J1', 2, 4), ('J2', 2, 4), ('J3', 2, 4), ('J4', 2, 4),
('A1', 1, 4), ('A2', 1, 4), ('A3', 1, 4), ('A4', 1, 4),
('B1', 1, 4), ('B2', 1, 4), ('B3', 1, 4), ('B4', 1, 4),
('C1', 1, 4), ('C2', 1, 4), ('C3', 1, 4), ('C4', 1, 4),
('D1', 1, 4), ('D2', 1, 4), ('D3', 1, 4), ('D4', 1, 4),
('E1', 1, 4), ('E2', 1, 4), ('E3', 1, 4), ('E4', 1, 4),
('F1', 1, 4), ('F2', 1, 4), ('F3', 1, 4), ('F4', 1, 4),
('G1', 1, 4), ('G2', 1, 4), ('G3', 1, 4), ('G4', 1, 4);


-- INSERT 40 GHE VAO MAY BAY 5
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('I1', 2, 5), ('I2', 2, 5), ('I3', 2, 5), ('I4', 2, 5),
('J1', 2, 5), ('J2', 2, 5), ('J3', 2, 5), ('J4', 2, 5),
('A1', 1, 5), ('A2', 1, 5), ('A3', 1, 5), ('A4', 1, 5),
('B1', 1, 5), ('B2', 1, 5), ('B3', 1, 5), ('B4', 1, 5),
('C1', 1, 5), ('C2', 1, 5), ('C3', 1, 5), ('C4', 1, 5),
('D1', 1, 5), ('D2', 1, 5), ('D3', 1, 5), ('D4', 1, 5),
('E1', 1, 5), ('E2', 1, 5), ('E3', 1, 5), ('E4', 1, 5),
('F1', 1, 5), ('F2', 1, 5), ('F3', 1, 5), ('F4', 1, 5),
('G1', 1, 5), ('G2', 1, 5), ('G3', 1, 5), ('G4', 1, 5),
('H1', 1, 5), ('H2', 1, 5), ('H3', 1, 5), ('H4', 1, 5);


-- INSERT INTO HANG BAY

INSERT INTO hang_bay (ma_hang_bay, ten_hang_bay, logo_url)
VALUES
('HB01', 'Vietnam Airlines', 'https://upload.wikimedia.org/wikipedia/vi/thumb/b/bc/Vietnam_Airlines_logo.svg/2560px-Vietnam_Airlines_logo.svg.png'),
('HB02', 'Bamboo Airways', 'https://upload.wikimedia.org/wikipedia/commons/9/9b/Bamboo_Airways_Logo_QH-BAV.png'),
('HB03', 'Vietjet Air', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/VietJet_Air_logo.svg/2560px-VietJet_Air_logo.svg.png'),
('HB04', 'Pacific Airlines', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Logo_h%C3%A3ng_Pacific_Airlines.svg/1200px-Logo_h%C3%A3ng_Pacific_Airlines.svg.png');

-- INSERT INTO SANBAY
-- INSERT INTO san_bay (ma_san_bay, ten_san_bay, thanh_pho, quoc_gia)
-- VALUES
-- ('SGN', 'Sân bay Tân Sơn Nhất','TP HCM','Việt Nam'),
-- ('DAD', 'Sân bay Đà Nẵng','TP Đà Nẵng','Việt Nam'),
-- ('HAN', 'Sân bay Nội Bài','Thủ Đô Hà Nội','Việt Nam'),
-- ('DLI', 'Sân bay Liên Khương','Da Lat','Việt Nam'),
-- ('BKKA', 'Sân bay Bangkok','Thủ Đô Bangkok','Thái Lan'),
-- ('SYD', 'Sân bay Sydney','Sydney','Australia'),
-- ('MNL', 'Sân bay Ninoy Aquino','Manila','Philippines'),
-- ('JKTA', 'Sân bay Jakarta','Jakarta','Indonesia');

INSERT INTO san_bay (ma_san_bay, ten_san_bay, thanh_pho, quoc_gia)
VALUES
('SG', 'Tân Sơn Nhất','TP HCM','Việt Nam'),
('DN', 'Đà Nẵng','TP Đà Nẵng','Việt Nam'),
('HN', 'Nội Bài','Thủ Đô Hà Nội','Việt Nam'),
('NT','Cam Ranh','TP Nha Trang','Việt Nam'),
('HUE','Phú Bài','TP Huế','Việt Nam'),
('BK', 'Bangkok','Thủ Đô Bangkok','Thái Lan');

-- INSERT QUOC TICH
INSERT INTO quoc_tich (ten_quoc_tich)
VALUES
  ('Afghanistan'),
  ('Armenia'),
  ('Azerbaijan'),
  ('Bahrain'),
  ('Bangladesh'),
  ('Bhutan'),
  ('Brunei'),
  ('Cambodia'),
  ('China'),
  ('East Timor'),
  ('Egypt'),
  ('Georgia'),
  ('India'),
  ('Indonesia'),
  ('Iran'),
  ('Iraq'),
  ('Israel'),
  ('Japan'),
  ('Jordan'),
  ('Kazakhstan'),
  ('Korea, South'),
  ('Korea, North'),
  ('Kuwait'),
  ('Kyrgyzstan'),
  ('Laos'),
  ('Lebanon'),
  ('Malaysia'),
  ('Maldives'),
  ('Mongolia'),
  ('Myanmar'),
  ('Nepal'),
  ('Oman'),
  ('Pakistan'),
  ('Palestine'),
  ('Philippines'),
  ('Qatar'),
  ('Saudi Arabia'),
  ('Singapore'),
  ('Sri Lanka'),
  ('Syria'),
  ('Tajikistan'),
  ('Taiwan'),
  ('Thailand'),
  ('Turkey'),
  ('Turkmenistan'),
  ('United Arab Emirates'),
  ('Uzbekistan'),
  ('Vietnam'),
  ('Yemen'),
  ('Qatar');

-- INSERT ROLE
INSERT INTO `role` (role_id, `role_name`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role` (role_id, `role_name`) VALUES (2, 'ROLE_USER');

-- INSERT TAI KHOAN
INSERT INTO `tai_khoan` (`ten_tai_khoan`, `mat_khau`) VALUES ('admin', '123');
INSERT INTO `tai_khoan` (`ten_tai_khoan`, `mat_khau`) VALUES ('user', '123');

-- INSERT TAI KHOAN ROLE
INSERT INTO `tai_khoan_role` (`role_id`, `ten_tai_khoan`) VALUES ('1', 'admin');
INSERT INTO `tai_khoan_role` (`role_id`, `ten_tai_khoan`) VALUES ('2', 'user');

-- INSERT TAI KHOAN
INSERT INTO nguoi_dung (email, ten_tai_khoan, so_dien_thoai, ho_va_ten, ngay_sinh, dia_chi, ho_chieu, gioi_tinh, trang_thai_xoa, ma_quoc_tich)
VALUES
    ('admin@example.com', 'admin', '123456789', 'Nguyen Van A', '2000-01-01', 'Dia chi 1', '1234567890', 'Nam', 0, 2),
    ('user@example.com', 'user', '987654321', 'Nguyen Thi B', '1995-05-10', 'Dia chi 2', '0987654321', 'Nu', 0, 3);
    
INSERT INTO hanh_khach (ma_hanh_khach, loai_hanh_khach, ten_hanh_khach, ngay_sinh, gioi_tinh, trang_thai_xoa)
VALUES
  (1, 'Người Lớn', 'Nguyễn Văn A', '2000-02-01', 'Nam', 0),
  (2, 'Người Lớn', 'Nguyễn Văn B', '2000-02-01', 'Nữ', 0),
  (3, 'Người Lớn', 'Nguyễn Văn C', '2000-02-01', 'Nam', 0),
  (4, 'Người Lớn', 'Nguyễn Văn D', '2000-02-01', 'Nữ', 0),
  (5, 'Người Lớn', 'Nguyễn Văn R', '2000-02-01', 'Nam', 0),
  (6, 'Trẻ em', 'Nguyễn Văn V', '2000-02-01', 'Nữ', 0),
  (7, 'Trẻ em', 'Nguyễn Văn H', '2000-02-01', 'Nam', 0),
  (8, 'Người Lớn', 'Nguyễn Văn K', '2000-02-01', 'Nữ', 0),
  (9, 'Trẻ em', 'Nguyễn Văn L', '2000-02-01', 'Nam', 0),
  (10, 'Người Lớn', 'Nguyễn Văn P', '2000-02-01', 'Nữ', 0),
    (11, 'Người Lớn', 'Nguyễn Thiên Duy', '2000-02-01', 'Nam', 0),
  (12, 'Trẻ em', 'Nguyễn Hoàng Lân', '2001-02-20', 'Nam', 0);

-- INSERT CHUYEN BAY
INSERT INTO chuyen_bay (ma_chuyen_bay, kl_hanh_ly, diem_den, diem_di, gia_ve, gio_khoi_hanh,gio_ha_canh, 
 ma_hang_bay, ma_may_bay, ngay_khoi_hanh, thoi_gian_bay, trang_hai_van_hanh, trang_thai_xoa)
VALUES
('CB001', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1500000, '09:00', '10:30', 'HB01', 1, '2023-05-30', '1h 30m', 'Normal', 0),
('CB002', '25 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1600000, '10:00', '11:30', 'HB02', 2, '2023-05-30', '1h 30m', 'Normal', 0),
('CB003', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1400000, '12:00', '13:30', 'HB03', 3, '2023-05-30', '1h 30m', 'Normal', 0),
('CB004', '15 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1500000, '08:00', '09:30', 'HB04', 4, '2023-05-30', '1h 30m', 'Normal', 0),
('CB005', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1300000, '07:00', '08:30', 'HB02', 5, '2023-05-30', '1h 30m', 'Normal', 0),
('CB006', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1250000, '04:00', '05:30', 'HB01', 6, '2023-05-30', '1h 30m', 'Normal', 0),
('CB007', '25 kg', 'Thủ Đô Hà Nội','TP HCM',  1500000, '12:00', '13:30', 'HB03', 1, '2023-05-30', '1h 30m', 'Normal', 0),
('CB008', '30 kg', 'Thủ Đô Hà Nội','TP HCM',  1400000, '09:00', '10:30', 'HB02', 2, '2023-05-30', '1h 30m', 'Normal', 0),
('CB009', '20 kg', 'Thủ Đô Hà Nội','TP HCM',  1350000, '01:00', '02:30', 'HB04', 3, '2023-05-30', '1h 30m', 'Normal', 0),
('CB010', '15 kg', 'Thủ Đô Hà Nội','TP HCM',  1280000, '03:00', '04:30', 'HB02', 4, '2023-05-30', '1h 30m', 'Normal', 0),
('CB011', '20 kg', 'Thủ Đô Hà Nội','TP HCM',  1450000, '09:00', '10:30', 'HB01', 5, '2023-05-30', '1h 30m', 'Normal', 0),
('CB012', '25 kg', 'Thủ Đô Hà Nội','TP HCM',  1600000, '05:00', '06:30', 'HB03', 6, '2023-05-30', '1h 30m', 'Normal', 0),

('CB013', '25 kg', 'Thủ Đô Hà Nội', 'TP Huế', 1000000, '11:30', '13:00', 'HB02', 3, '2023-05-02', '1h 30m', 'Normal', 0),
('CB014', '15 kg', 'Thủ Đô Hà Nội', 'TP Huế', 9500000, '14:30', '17:00', 'HB02', 1, '2023-05-02', '2h 30m', 'Normal', 0),
('CB015', '20 kg',  'Thủ Đô Hà Nội','TP Huế',800000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('CB016', '25 kg', 'Thủ Đô Hà Nội', 'TP Huế', 700000, '11:30', '13:00', 'HB04', 2, '2023-6-02', '1h 30m', 'Normal', 0),
('CB017', '20 kg', 'Thủ Đô Hà Nội', 'TP Huế', 750000, '11:30', '13:00', 'HB02', 1, '2023-6-02', '1h 30m', 'Normal', 0),
('CB018', '30 kg', 'Thủ Đô Hà Nội', 'TP Huế', 100000, '11:30', '13:00', 'HB01', 4, '2023-6-02', '1h 30m', 'Normal', 0),
('CB019', '15 kg', 'Thủ Đô Hà Nội', 'TP Huế', 600000, '11:30', '13:00', 'HB01', 6, '2023-6-02', '1h 30m', 'Normal', 0),
('CB020', '20 kg', 'TP Huế','Thủ Đô Hà Nội',  650000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('CB021', '25 kg', 'TP Huế','Thủ Đô Hà Nội', 900000, '11:30', '13:00', 'HB04', 2, '2023-6-02', '1h 30m', 'Normal', 0),
('CB022', '20 kg', 'TP Huế', 'Thủ Đô Hà Nội', 1000000, '11:30', '13:00', 'HB02', 1, '2023-6-02', '1h 30m', 'Normal', 0),
('CB023', '30 kg', 'TP Huế','Thủ Đô Hà Nội',  1100000, '11:30', '13:00', 'HB01', 4, '2023-6-02', '1h 30m', 'Normal', 0),
('CB024', '15 kg', 'TP Huế','Thủ Đô Hà Nội',  8500000, '11:30', '13:00', 'HB01', 6, '2023-6-02', '1h 30m', 'Normal', 0),
('CB025', '20 kg', 'TP Huế','Thủ Đô Hà Nội',  700000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),

('CB026', '25 kg', 'TP HCM', 'TP Đà Nẵng', 1000000, '11:30', '13:00', 'HB02', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('CB027', '15 kg', 'TP HCM', 'TP Đà Nẵng', 9500000, '14:30', '17:00', 'HB02', 1, '2023-06-02', '2h 30m', 'Normal', 0),
('CB028', '20 kg', 'TP HCM', 'TP Đà Nẵng', 800000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('CB029', '25 kg', 'TP HCM', 'TP Đà Nẵng', 700000, '11:30', '13:00', 'HB04', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('CB030', '20 kg', 'TP HCM', 'TP Đà Nẵng', 750000, '11:30', '13:00', 'HB02', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('CB031', '30 kg', 'TP HCM', 'TP Đà Nẵng', 100000, '11:30', '13:00', 'HB01', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('CB032', '15 kg', 'TP HCM', 'TP Đà Nẵng', 600000, '11:30', '13:00', 'HB01', 6, '2023-06-02', '1h 30m', 'Normal', 0),
('CB033', '20 kg', 'TP Đà Nẵng', 'TP HCM', 650000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('CB034', '25 kg', 'TP Đà Nẵng', 'TP HCM', 900000, '11:30', '13:00', 'HB04', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('CB035', '20 kg', 'TP Đà Nẵng', 'TP HCM', 1000000, '11:30', '13:00', 'HB02', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('CB036', '30 kg', 'TP Đà Nẵng', 'TP HCM', 1100000, '11:30', '13:00', 'HB01', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('CB037', '15 kg', 'TP Đà Nẵng', 'TP HCM', 8500000, '11:30', '13:00', 'HB01', 6, '2023-06-02', '1h 30m','Normal', 0),

('CB038', '25 kg', 'TP Nha Trang', 'Thủ Đô Bangkok', 1000000, '11:30', '13:00', 'HB02', 3, '2023-05-25', '1h 30m', 'Normal', 0),
('CB039', '15 kg', 'TP Nha Trang', 'Thủ Đô Bangkok', 9500000, '14:30', '17:00', 'HB02', 1, '2023-05-25', '2h 30m', 'Normal', 0),
('CB040', '20 kg', 'TP Nha Trang', 'Thủ Đô Bangkok', 800000, '09:00', '10:30', 'HB03', 3, '2023-05-25', '1h 30m', 'Normal', 0),
('CB041', '25 kg', 'TP Nha Trang', 'Thủ Đô Bangkok', 700000, '11:30', '13:00', 'HB04', 2, '2023-05-25', '1h 30m', 'Normal', 0),
('CB042', '20 kg', 'TP Nha Trang', 'Thủ Đô Bangkok', 750000, '11:30', '13:00', 'HB02', 1, '2023-05-25', '1h 30m', 'Normal', 0),
('CB043', '30 kg', 'TP Nha Trang', 'Thủ Đô Bangkok', 100000, '11:30', '13:00', 'HB01', 4, '2023-05-25', '1h 30m', 'Normal', 0),
('CB044', '15 kg', 'TP Nha Trang', 'Thủ Đô Bangkok', 600000, '11:30', '13:00', 'HB01', 6, '2023-05-25', '1h 30m', 'Normal', 0),
('CB045', '20 kg', 'Thủ Đô Bangkok', 'TP Nha Trang', 650000, '09:00', '10:30', 'HB03', 3, '2023-05-25', '1h 30m', 'Normal', 0),
('CB046', '25 kg', 'Thủ Đô Bangkok', 'TP Nha Trang', 900000, '11:30', '13:00', 'HB04', 2, '2023-05-25', '1h 30m', 'Normal', 0),
('CB047', '20 kg', 'Thủ Đô Bangkok', 'TP Nha Trang', 1000000, '11:30', '13:00', 'HB02', 1, '2023-05-25', '1h 30m', 'Normal', 0),
('CB048', '30 kg', 'Thủ Đô Bangkok', 'TP Nha Trang', 1100000, '11:30', '13:00', 'HB01', 4, '2023-05-25', '1h 30m', 'Normal', 0),
('CB049', '15 kg', 'Thủ Đô Bangkok', 'TP Nha Trang', 8500000, '11:30', '13:00', 'HB01', 6, '2023-05-25', '1h 30m','Normal', 0);


-- select * from ve_may_bay v join hoa_don h on v.ma_hoa_don = h.ma_hoa_don where h.tt_thanh_toan = 0;


-- select ve_may_bay.ma_ve, ve_may_bay.gia_ve, ve_may_bay.hang_ve, 
-- ve_may_bay.ma_dat_cho, ve_may_bay.ma_hanh_khach, 
-- ve_may_bay.ma_hoa_don, ve_may_bay.trang_thai_xoa from ve_may_bay 
-- join hanh_khach on hanh_khach.ma_hanh_khach = ve_may_bay.ma_hanh_khach 
-- join dat_cho on ve_may_bay.ma_dat_cho = dat_cho.ma_dat_cho 
-- join chuyen_bay on chuyen_bay.ma_chuyen_bay = dat_cho.ma_chuyen_bay 
-- where ve_may_bay.trang_thai_xoa like 0 
-- and ve_may_bay.ma_ve like '%T%' 
-- and hanh_khach.ten_hanh_khach like '%%' 
-- and chuyen_bay.diem_di like '%%'
-- and chuyen_bay.diem_den like '%%';
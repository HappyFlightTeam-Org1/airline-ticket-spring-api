create database airline_ticket_db;
use airline_ticket_db;
-- drop database airline_ticket_db;

-- TAO TRIGGER TU DONG THEM MOI DAT CHO
DELIMITER //
CREATE TRIGGER tr_dat_cho AFTER INSERT ON chuyen_bay
FOR EACH ROW
BEGIN
    INSERT INTO dat_cho (ma_chuyen_bay, ma_ghe)
    SELECT NEW.ma_chuyen_bay, ghe.ma_ghe
    FROM ghe
    JOIN may_bay on ghe.ma_may_bay = may_bay.ma_may_bay
    JOIN chuyen_bay on may_bay.ma_may_bay = chuyen_bay.ma_may_bay;
END //

INSERT INTO may_bay (sl_ghe_pho_thong, sl_ghe_thuong_gia, ten_may_bay)
VALUES
(28, 12, 'Boeing 747'),
(32, 8, 'Airbus A380'),
(32, 8, 'Boeing 737'),
(28, 12, 'Airbus A320'),
(32, 8, 'Boeing 777'),
(28, 12, 'Boeing 717');

-- INSERT INTO DANH SACH HANG BAY

INSERT INTO hang_bay (ma_hang_bay, ten_hang_bay, logo_url)
VALUES
('HB01', 'Vietnam Airlines', 'https://upload.wikimedia.org/wikipedia/vi/thumb/b/bc/Vietnam_Airlines_logo.svg/2560px-Vietnam_Airlines_logo.svg.png'),
('HB02', 'Bamboo Airways', 'https://upload.wikimedia.org/wikipedia/commons/9/9b/Bamboo_Airways_Logo_QH-BAV.png'),
('HB03', 'Vietjet Air', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/VietJet_Air_logo.svg/2560px-VietJet_Air_logo.svg.png'),
('HB04', 'Pacific Airlines', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Logo_h%C3%A3ng_Pacific_Airlines.svg/1200px-Logo_h%C3%A3ng_Pacific_Airlines.svg.png');

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

-- INSERT DANH SACH SAN BAY
INSERT INTO san_bay (ma_san_bay, ten_san_bay, thanh_pho, quoc_gia)
VALUES
('SGN', 'Tân Sơn Nhất','TP HCM','Việt Nam'),
('DAD', 'Đà Nẵng','TP Đà Nẵng','Việt Nam'),
('HAN', 'Nội Bài','Thủ Đô Hà Nội','Việt Nam'),
('NTC','Cam Ranh','TP Nha Trang','Việt Nam'),
('HUE','Phú Bài','TP Huế','Việt Nam');

INSERT INTO loai_ghe (ten_loai_ghe)
VALUES
('Phổ Thông'),
('Thương Gia');

-- Tạo bảng tạm để tạo danh sách các số từ 1 đến số lượng ghế thương gia
CREATE TEMPORARY TABLE seat_numberss AS (
  SELECT 1 AS seat_number UNION ALL
 SELECT 2 UNION ALL
  SELECT 3 UNION ALL
  SELECT 4 UNION ALL
  SELECT 5 UNION ALL
   SELECT 6 UNION ALL
  SELECT 7 UNION ALL
  SELECT 8 UNION ALL
  SELECT 9 UNION ALL
   SELECT 10 UNION ALL
  SELECT 11 UNION ALL
  SELECT 12 UNION ALL
  SELECT 13 UNION ALL
   SELECT 14 UNION ALL
  SELECT 15 UNION ALL
  SELECT 16 UNION ALL
  SELECT 17 UNION ALL
    SELECT 18 UNION ALL
   SELECT 19 UNION ALL
  SELECT 20 UNION ALL
  SELECT 21 UNION ALL
  SELECT 22 UNION ALL
   SELECT 23 UNION ALL
  SELECT 24 UNION ALL
  SELECT 25 UNION ALL
  SELECT 26 UNION ALL
   SELECT 27 UNION ALL
  SELECT 28 UNION ALL
  SELECT 29 UNION ALL
  SELECT 30 UNION ALL
    SELECT 31 UNION ALL
    SELECT 32 UNION ALL
   SELECT 33 UNION ALL
  SELECT 34 UNION ALL
  SELECT 35 UNION ALL
  SELECT 36 UNION ALL
   SELECT 37 UNION ALL
  SELECT 38 UNION ALL
  SELECT 39 UNION ALL SELECT 40
);

-- Thêm các ghế thương gia vào máy bay
INSERT INTO ghe (ten_ghe, ma_may_bay, ma_loai_ghe)
SELECT CONCAT('B', sn.seat_number) AS ten_ghe,
       mb.ma_may_bay,
       lg.ma_loai_ghe
FROM may_bay mb
JOIN loai_ghe lg ON lg.ten_loai_ghe = 'Thương Gia'
JOIN seat_numbers sn ON sn.seat_number <= mb.sl_ghe_thuong_gia
ORDER BY mb.ma_may_bay, lg.ma_loai_ghe;
-- Thêm các ghế phổ thông vào máy bay
INSERT INTO ghe (ten_ghe, ma_may_bay, ma_loai_ghe)
SELECT CONCAT('E', sn.seat_number) AS ten_ghe,
       mb.ma_may_bay,
       lg.ma_loai_ghe
FROM may_bay mb
JOIN loai_ghe lg ON lg.ten_loai_ghe = 'Phổ Thông'
JOIN seat_numbers sn ON sn.seat_number <= mb.sl_ghe_pho_thong
ORDER BY mb.ma_may_bay, lg.ma_loai_ghe;
select * from ghe;

-- INSERT INTO DANH SACH CHUYEN BAY
INSERT INTO chuyen_bay (ma_chuyen_bay, kl_hanh_ly, diem_den, diem_di, gia_ve, gio_khoi_hanh,gio_ha_canh,
 ma_hang_bay, ma_may_bay, ngay_khoi_hanh, thoi_gian_bay, trang_hai_van_hanh, trang_thai_xoa)
VALUES
('FL00001', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1500000, '09:00', '10:30', 'HB01', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00002', '25 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1600000, '10:00', '11:30', 'HB02', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00003', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1400000, '12:00', '13:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00004', '15 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1500000, '08:00', '09:30', 'HB04', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00005', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1300000, '07:00', '08:30', 'HB02', 5, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00006', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1250000, '04:00', '05:30', 'HB01', 6, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00007', '25 kg', 'Thủ Đô Hà Nội','TP HCM',  1500000, '12:00', '13:30', 'HB03', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00008', '30 kg', 'Thủ Đô Hà Nội','TP HCM',  1400000, '09:00', '10:30', 'HB02', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00009', '20 kg', 'Thủ Đô Hà Nội','TP HCM',  1350000, '01:00', '02:30', 'HB04', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00010', '15 kg', 'Thủ Đô Hà Nội','TP HCM',  1280000, '03:00', '04:30', 'HB02', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00011', '20 kg', 'Thủ Đô Hà Nội','TP HCM',  1450000, '09:00', '10:30', 'HB01', 5, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00012', '25 kg', 'Thủ Đô Hà Nội','TP HCM',  1600000, '05:00', '06:30', 'HB03', 6, '2023-06-02', '1h 30m', 'Normal', 0),

('FL00026', '25 kg', 'TP HCM', 'TP Đà Nẵng', 1000000, '11:30', '13:00', 'HB02', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00027', '15 kg', 'TP HCM', 'TP Đà Nẵng', 1200000, '14:30', '17:00', 'HB02', 1, '2023-06-02', '2h 30m', 'Normal', 0),
('FL00028', '20 kg', 'TP HCM', 'TP Đà Nẵng', 1800000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00029', '25 kg', 'TP HCM', 'TP Đà Nẵng', 1700000, '11:30', '13:00', 'HB04', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00030', '20 kg', 'TP HCM', 'TP Đà Nẵng', 1750000, '11:30', '13:00', 'HB02', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00031', '30 kg', 'TP HCM', 'TP Đà Nẵng', 1100000, '11:30', '13:00', 'HB01', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00032', '15 kg', 'TP HCM', 'TP Đà Nẵng', 1600000, '11:30', '13:00', 'HB01', 6, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00033', '20 kg', 'TP Đà Nẵng', 'TP HCM', 1650000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00034', '25 kg', 'TP Đà Nẵng', 'TP HCM', 1900000, '11:30', '13:00', 'HB04', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00035', '20 kg', 'TP Đà Nẵng', 'TP HCM', 1000000, '11:30', '13:00', 'HB02', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00036', '30 kg', 'TP Đà Nẵng', 'TP HCM', 1100000, '11:30', '13:00', 'HB01', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00037', '15 kg', 'TP Đà Nẵng', 'TP HCM', 1500000, '11:30', '13:00', 'HB01', 6, '2023-06-02', '1h 30m','Normal', 0),

('FL00050', '20 kg', 'TP HCM', 'TP Huế', 1500000, '09:00', '10:30', 'HB01', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00051', '25 kg', 'TP HCM', 'TP Huế', 1600000, '10:00', '11:30', 'HB02', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00052', '20 kg', 'TP HCM', 'TP Huế', 1400000, '12:00', '13:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00053', '15 kg', 'TP HCM', 'TP Huế', 1500000, '08:00', '09:30', 'HB04', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00054', '20 kg', 'TP HCM', 'TP Huế', 1300000, '07:00', '08:30', 'HB02', 5, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00055', '20 kg', 'TP HCM', 'TP Huế', 1250000, '04:00', '05:30', 'HB01', 6, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00056', '25 kg', 'TP Huế','TP HCM',  1500000, '12:00', '13:30', 'HB03', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00057', '30 kg', 'TP Huế','TP HCM',  1400000, '09:00', '10:30', 'HB02', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00058', '20 kg', 'TP Huế','TP HCM',  1350000, '01:00', '02:30', 'HB04', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00059', '15 kg', 'TP Huế','TP HCM',  1280000, '03:00', '04:30', 'HB02', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00060', '20 kg', 'TP Huế','TP HCM',  1450000, '09:00', '10:30', 'HB01', 5, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00061', '25 kg', 'TP Huế','TP HCM',  1600000, '05:00', '06:30', 'HB03', 6, '2023-06-02', '1h 30m', 'Normal', 0),

('FL00062', '20 kg', 'TP HCM', 'TP Nha Trang', 1500000, '09:00', '10:30', 'HB01', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00063', '25 kg', 'TP HCM', 'TP Nha Trang', 1600000, '10:00', '11:30', 'HB02', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00064', '20 kg', 'TP HCM', 'TP Nha Trang', 1400000, '12:00', '13:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00065', '15 kg', 'TP HCM', 'TP Nha Trang', 1500000, '08:00', '09:30', 'HB04', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00066', '20 kg', 'TP HCM', 'TP Nha Trang', 1300000, '07:00', '08:30', 'HB02', 5, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00067', '20 kg', 'TP HCM', 'TP Nha Trang', 1250000, '04:00', '05:30', 'HB01', 6, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00068', '25 kg', 'TP Nha Trang','TP HCM',  1500000, '12:00', '13:30', 'HB03', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00069', '30 kg', 'TP Nha Trang','TP HCM',  1400000, '09:00', '10:30', 'HB02', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00070', '20 kg', 'TP Nha Trang','TP HCM',  1350000, '01:00', '02:30', 'HB04', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00071', '15 kg', 'TP Nha Trang','TP HCM',  1280000, '03:00', '04:30', 'HB02', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00072', '20 kg', 'TP Nha Trang','TP HCM',  1450000, '09:00', '10:30', 'HB01', 5, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00073', '25 kg', 'TP Nha Trang','TP HCM',  1600000, '05:00', '06:30', 'HB03', 6, '2023-06-02', '1h 30m', 'Normal', 0),

('FL00074', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1500000, '09:00', '10:30', 'HB01', 1, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00075', '25 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1600000, '10:00', '11:30', 'HB02', 2, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00076', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1400000, '12:00', '13:30', 'HB03', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00077', '15 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1500000, '08:00', '09:30', 'HB04', 4, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00078', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1300000, '07:00', '08:30', 'HB02', 5, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00079', '20 kg', 'TP HCM', 'Thủ Đô Hà Nội', 1250000, '04:00', '05:30', 'HB01', 6, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00080', '25 kg', 'Thủ Đô Hà Nội','TP HCM',  1500000, '12:00', '13:30', 'HB03', 1, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00081', '30 kg', 'Thủ Đô Hà Nội','TP HCM',  1400000, '09:00', '10:30', 'HB02', 2, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00082', '20 kg', 'Thủ Đô Hà Nội','TP HCM',  1350000, '01:00', '02:30', 'HB04', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00083', '15 kg', 'Thủ Đô Hà Nội','TP HCM',  1280000, '03:00', '04:30', 'HB02', 4, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00084', '20 kg', 'Thủ Đô Hà Nội','TP HCM',  1450000, '09:00', '10:30', 'HB01', 5, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00085', '25 kg', 'Thủ Đô Hà Nội','TP HCM',  1600000, '05:00', '06:30', 'HB03', 6, '2023-06-03', '1h 30m', 'Normal', 0),

('FL00086', '25 kg', 'TP HCM', 'TP Đà Nẵng', 1000000, '11:30', '13:00', 'HB02', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00087', '15 kg', 'TP HCM', 'TP Đà Nẵng', 1200000, '14:30', '17:00', 'HB02', 1, '2023-06-03', '2h 30m', 'Normal', 0),
('FL00088', '20 kg', 'TP HCM', 'TP Đà Nẵng', 1800000, '09:00', '10:30', 'HB03', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00089', '25 kg', 'TP HCM', 'TP Đà Nẵng', 1700000, '11:30', '13:00', 'HB04', 2, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00090', '20 kg', 'TP HCM', 'TP Đà Nẵng', 1750000, '11:30', '13:00', 'HB02', 1, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00091', '30 kg', 'TP HCM', 'TP Đà Nẵng', 1100000, '11:30', '13:00', 'HB01', 4, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00092', '15 kg', 'TP HCM', 'TP Đà Nẵng', 1600000, '11:30', '13:00', 'HB01', 6, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00093', '20 kg', 'TP Đà Nẵng', 'TP HCM', 1650000, '09:00', '10:30', 'HB03', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00094', '25 kg', 'TP Đà Nẵng', 'TP HCM', 1900000, '11:30', '13:00', 'HB04', 2, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00095', '20 kg', 'TP Đà Nẵng', 'TP HCM', 1000000, '11:30', '13:00', 'HB02', 1, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00096', '30 kg', 'TP Đà Nẵng', 'TP HCM', 1100000, '11:30', '13:00', 'HB01', 4, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00097', '15 kg', 'TP Đà Nẵng', 'TP HCM', 1500000, '11:30', '13:00', 'HB01', 6, '2023-06-03', '1h 30m','Normal', 0),

('FL00098', '20 kg', 'TP HCM', 'TP Huế', 1500000, '09:00', '10:30', 'HB01', 1, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00099', '25 kg', 'TP HCM', 'TP Huế', 1600000, '10:00', '11:30', 'HB02', 2, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00100', '20 kg', 'TP HCM', 'TP Huế', 1400000, '12:00', '13:30', 'HB03', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00101', '15 kg', 'TP HCM', 'TP Huế', 1500000, '08:00', '09:30', 'HB04', 4, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00102', '20 kg', 'TP HCM', 'TP Huế', 1300000, '07:00', '08:30', 'HB02', 5, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00103', '20 kg', 'TP HCM', 'TP Huế', 1250000, '04:00', '05:30', 'HB01', 6, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00104', '25 kg', 'TP Huế','TP HCM',  1500000, '12:00', '13:30', 'HB03', 1, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00105', '30 kg', 'TP Huế','TP HCM',  1400000, '09:00', '10:30', 'HB02', 2, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00106', '20 kg', 'TP Huế','TP HCM',  1350000, '01:00', '02:30', 'HB04', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00107', '15 kg', 'TP Huế','TP HCM',  1280000, '03:00', '04:30', 'HB02', 4, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00108', '20 kg', 'TP Huế','TP HCM',  1450000, '09:00', '10:30', 'HB01', 5, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00109', '25 kg', 'TP Huế','TP HCM',  1600000, '05:00', '06:30', 'HB03', 6, '2023-06-03', '1h 30m', 'Normal', 0),

('FL00110', '20 kg', 'TP HCM', 'TP Nha Trang', 1500000, '09:00', '10:30', 'HB01', 1, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00111', '25 kg', 'TP HCM', 'TP Nha Trang', 1600000, '10:00', '11:30', 'HB02', 2, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00112', '20 kg', 'TP HCM', 'TP Nha Trang', 1400000, '12:00', '13:30', 'HB03', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00113', '15 kg', 'TP HCM', 'TP Nha Trang', 1500000, '08:00', '09:30', 'HB04', 4, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00114', '20 kg', 'TP HCM', 'TP Nha Trang', 1300000, '07:00', '08:30', 'HB02', 5, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00115', '20 kg', 'TP HCM', 'TP Nha Trang', 1250000, '04:00', '05:30', 'HB01', 6, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00116', '25 kg', 'TP Nha Trang','TP HCM',  1500000, '12:00', '13:30', 'HB03', 1, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00117', '30 kg', 'TP Nha Trang','TP HCM',  1400000, '09:00', '10:30', 'HB02', 2, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00118', '20 kg', 'TP Nha Trang','TP HCM',  1350000, '01:00', '02:30', 'HB04', 3, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00119', '15 kg', 'TP Nha Trang','TP HCM',  1280000, '03:00', '04:30', 'HB02', 4, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00120', '20 kg', 'TP Nha Trang','TP HCM',  1450000, '09:00', '10:30', 'HB01', 5, '2023-06-03', '1h 30m', 'Normal', 0),
('FL00121', '25 kg', 'TP Nha Trang','TP HCM',  1600000, '05:00', '06:30', 'HB03', 6, '2023-06-03', '1h 30m', 'Normal', 0),

('FL00122', '25 kg', 'TP Nha Trang', 'TP Huế', 1000000, '11:30', '13:00', 'HB02', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00123', '15 kg', 'TP Nha Trang', 'TP Huế', 1500000, '14:30', '17:00', 'HB02', 1, '2023-06-02', '2h 30m', 'Normal', 0),
('FL00124', '20 kg', 'TP Nha Trang', 'TP Huế', 1800000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00125', '25 kg', 'TP Nha Trang', 'TP Huế', 1700000, '11:30', '13:00', 'HB04', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00126', '20 kg', 'TP Nha Trang', 'TP Huế', 1750000, '11:30', '13:00', 'HB02', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00127', '30 kg', 'TP Nha Trang', 'TP Huế', 1100000, '11:30', '13:00', 'HB01', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00128', '15 kg', 'TP Nha Trang', 'TP Huế', 1600000, '11:30', '13:00', 'HB01', 6, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00129', '20 kg', 'TP Huế', 'TP Nha Trang', 1650000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00130', '25 kg', 'TP Huế', 'TP Nha Trang', 1900000, '11:30', '13:00', 'HB04', 2, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00131', '20 kg', 'TP Huế', 'TP Nha Trang', 1000000, '11:30', '13:00', 'HB02', 1, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00132', '30 kg', 'TP Huế', 'TP Nha Trang', 1100000, '11:30', '13:00', 'HB01', 4, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00133', '15 kg', 'TP Huế', 'TP Nha Trang', 1500000, '11:30', '13:00', 'HB01', 6, '2023-06-02', '1h 30m','Normal', 0),

('FL00013', '25 kg', 'Thủ Đô Hà Nội', 'TP Huế', 1000000, '11:30', '13:00', 'HB02', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00014', '15 kg', 'Thủ Đô Hà Nội', 'TP Huế', 1500000, '14:30', '17:00', 'HB02', 1, '2023-06-02', '2h 30m', 'Normal', 0),
('FL00015', '20 kg',  'Thủ Đô Hà Nội','TP Huế',1200000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00016', '25 kg', 'Thủ Đô Hà Nội', 'TP Huế', 1100000, '11:30', '13:00', 'HB04', 2, '2023-6-02', '1h 30m', 'Normal', 0),
('FL00017', '20 kg', 'Thủ Đô Hà Nội', 'TP Huế', 1150000, '11:30', '13:00', 'HB02', 1, '2023-6-02', '1h 30m', 'Normal', 0),
('FL00018', '30 kg', 'Thủ Đô Hà Nội', 'TP Huế', 1200000, '11:30', '13:00', 'HB01', 4, '2023-6-02', '1h 30m', 'Normal', 0),
('FL00019', '15 kg', 'Thủ Đô Hà Nội', 'TP Huế', 1600000, '11:30', '13:00', 'HB01', 6, '2023-6-02', '1h 30m', 'Normal', 0),
('FL00020', '20 kg', 'TP Huế','Thủ Đô Hà Nội',  1650000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0),
('FL00021', '25 kg', 'TP Huế','Thủ Đô Hà Nội', 1900000, '11:30', '13:00', 'HB04', 2, '2023-6-02', '1h 30m', 'Normal', 0),
('FL00022', '20 kg', 'TP Huế', 'Thủ Đô Hà Nội', 1000000, '11:30', '13:00', 'HB02', 1, '2023-6-02', '1h 30m', 'Normal', 0),
('FL00023', '30 kg', 'TP Huế','Thủ Đô Hà Nội',  1100000, '11:30', '13:00', 'HB01', 4, '2023-6-02', '1h 30m', 'Normal', 0),
('FL00024', '15 kg', 'TP Huế','Thủ Đô Hà Nội',  1500000, '11:30', '13:00', 'HB01', 6, '2023-6-02', '1h 30m', 'Normal', 0),
('FL00025', '20 kg', 'TP Huế','Thủ Đô Hà Nội',  1700000, '09:00', '10:30', 'HB03', 3, '2023-06-02', '1h 30m', 'Normal', 0);

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

-- INSERT TAI KHOAN - MAT KHAU: happy123
INSERT INTO `tai_khoan` (`ten_tai_khoan`, `mat_khau`) VALUES ('admin', '$2a$10$PDd9TotrgFgnH4XvfVmlsuJrFbcrK9dMAivWGLurRkPu8H1ITw4mC');
INSERT INTO `tai_khoan` (`ten_tai_khoan`, `mat_khau`) VALUES ('user', '$2a$10$PDd9TotrgFgnH4XvfVmlsuJrFbcrK9dMAivWGLurRkPu8H1ITw4mC');

-- INSERT TAI KHOAN ROLE
INSERT INTO `tai_khoan_role` (`role_id`, `ten_tai_khoan`) VALUES ('1', 'admin');
INSERT INTO `tai_khoan_role` (`role_id`, `ten_tai_khoan`) VALUES ('2', 'user');

-- INSERT TAI KHOAN
INSERT INTO nguoi_dung (email, ten_tai_khoan, so_dien_thoai, ho_va_ten, ngay_sinh, dia_chi, ho_chieu, gioi_tinh, trang_thai_xoa, ma_quoc_tich)
VALUES
    ('admin@example.com', 'admin', '0968283686', 'Nguyễn Thị Phương Thảo', '2000-01-01', 'Cầu Giấy, Hà Nội', '205839938', 'Nữ', 0, 2),
    ('user@example.com', 'user', '0905678123', 'Phạm Nhật Vượng', '1995-05-10', 'Liên Chiểu, Đà Nẵng', '205256786', 'Nam', 0, 3);


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
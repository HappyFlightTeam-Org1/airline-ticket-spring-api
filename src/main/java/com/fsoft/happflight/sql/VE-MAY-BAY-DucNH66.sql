
create database new;
use new;

INSERT INTO SanBay (ma_san_bay, ten_san_bay, thanh_pho, quoc_gia)
VALUES ('SBN01', N'Sân bay Nội Bài', N'Hà Nội', N'Việt Nam'),
('SBN02', N'Sân bay Tân Sơn Nhất', N'Hồ Chí Minh', N'Việt Nam'),
 ('SBN03', N'Sân bay Đà Nẵng', N'Đà Nẵng', N'Việt Nam'),
 ('SBN04', N'Sân bay Cần Thơ', N'Cần Thơ', N'Việt Nam'),
 ('SBN05', N'Sân bay Phú Quốc', N'Phú Quốc', N'Việt Nam'),
('SBN06', N'Sân bay Cam Ranh', N'Khánh Hòa', N'Việt Nam'),
 ('SBN07', N'Sân bay Buôn Ma Thuột', N'Đắk Lắk', N'Việt Nam'),
('SBN08', N'Sân bay Huế', N'Thừa Thiên Huế', N'Việt Nam'),
 ('SBN09', N'Sân bay Vinh', N'Nghệ An', N'Việt Nam'),
 ('SBN10', N'Sân bay Pleiku', N'Gia Lai', N'Việt Nam');

 INSERT INTO HangBay (ma_hang_bay, ten_hang_bay)
VALUES 
  ('HBA01', N'Vietnam Airlines'),
  ('HBA02', N'Vietjet Air'),
  ('HBA03', N'Jetstar Pacific'),
  ('HBA04', N'Bamboo Airways');

  INSERT INTO LoaiGhe (ten_loai_ghe)
VALUES (N'Phổ thông'),
       (N'Thương gia');

INSERT INTO MayBay (ten_may_bay, sl_ghe_pho_thong, sl_ghe_thuong_gia)
VALUES (N'Máy bay 1', 50, 20),
(N'Máy bay 2', 50, 20),
(N'Máy bay 3', 50, 20),
(N'Máy bay 4', 50, 20),
(N'Máy bay 5', 50, 20);


DECLARE @i INT = 1;
WHILE @i <= 20
BEGIN
    INSERT INTO Ghe (ten_ghe, ma_may_bay, ma_loai_ghe)
    VALUES (N' Thương gia ' + CAST(@i AS NVARCHAR(50)), 1, 2);
    SET @i = @i + 1;
END;


SET @i = 1;
WHILE @i <= 50
BEGIN
    INSERT INTO Ghe (ten_ghe, ma_may_bay, ma_loai_ghe)
    VALUES (N' Phổ thông ' + CAST(@i AS NVARCHAR(50)), 1, 2);
    SET @i = @i + 1;
END;


INSERT INTO ChuyenBay (ma_chuyen_bay, diem_di, diem_den, ngay_khoi_hanh, gio_khoi_hanh, gio_ha_canh, thoi_gian_bay, gia_ve, kl_hanh_ly, trang_hai_van_hanh, trang_thai_xoa, ma_may_bay, ma_hang_bay)
VALUES ('CB001', N'Hà Nội', N'Hồ Chí Minh', '2023-05-15', '08:00', '10:00', '2 giờ', '1.000.000', '20 kg', N'Đang vận hành', 0, 1,'HBA01');

INSERT INTO DatCho (trang_thai, ma_ghe, ma_chuyen_bay)
SELECT N'Đã Đặt', ma_ghe, 'CB001'
FROM Ghe
WHERE ma_ghe BETWEEN 71 AND 140;




 drop database new;
 use new;


select * from SANBAY;
select * from hangbay;
select * from maybay;

select * from loaighe;
select * from ghe;
select * from datcho;

delete  chuyenbay;


select * from chuyenbay;

select * from hanhkhach;

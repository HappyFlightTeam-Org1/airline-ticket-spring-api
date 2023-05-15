create database airline_ticket_db;
use airline_ticket_db;
drop database airline_ticket_db;

INSERT INTO may_bay (sl_ghe_pho_thong, sl_ghe_thuong_gia, ten_may_bay)
VALUES
(28, 12, 'Boeing 747'),
(32, 8, 'Airbus A380'),
(32, 16, 'Boeing 737'),
(28, 12, 'Airbus A320'),
(32, 8, 'Boeing 777');

INSERT INTO loai_ghe (ten_loai_ghe)
VALUES
('Phổ Thông'),
('Thương Gia');

-- INSERT 40 GHE VAO MAY BAY 1
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('A1', 1, 1), ('A2', 1, 1), ('A3', 1, 1), ('A4', 1, 1),
('B1', 1, 1), ('B2', 1, 1), ('B3', 1, 1), ('B4', 1, 1),
('C1', 1, 1), ('C2', 1, 1), ('C3', 1, 1), ('C4', 1, 1),
('D1', 1, 1), ('D2', 1, 1), ('D3', 1, 1), ('D4', 1, 1),
('E1', 1, 1), ('E2', 1, 1), ('E3', 1, 1), ('E4', 1, 1),
('F1', 1, 1), ('F2', 1, 1), ('F3', 1, 1), ('F4', 1, 1),
('G1', 1, 1), ('G2', 1, 1), ('G3', 1, 1), ('G4', 1, 1),
('H1', 2, 1), ('H2', 2, 1), ('H3', 2, 1), ('H4', 2, 1),
('I1', 2, 1), ('I2', 2, 1), ('I3', 2, 1), ('I4', 2, 1),
('J1', 2, 1), ('J2', 2, 1), ('J3', 2, 1), ('J4', 2, 1);

-- INSERT 40 GHE VAO MAY BAY 2
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('A1', 1, 2), ('A2', 1, 2), ('A3', 1, 2), ('A4', 1, 2),
('B1', 1, 2), ('B2', 1, 2), ('B3', 1, 2), ('B4', 1, 2),
('C1', 1, 2), ('C2', 1, 2), ('C3', 1, 2), ('C4', 1, 2),
('D1', 1, 2), ('D2', 1, 2), ('D3', 1, 2), ('D4', 1, 2),
('E1', 1, 2), ('E2', 1, 2), ('E3', 1, 2), ('E4', 1, 2),
('F1', 1, 2), ('F2', 1, 2), ('F3', 1, 2), ('F4', 1, 2),
('G1', 1, 2), ('G2', 1, 2), ('G3', 1, 2), ('G4', 1, 2),
('H1', 1, 2), ('H2', 1, 2), ('H3', 1, 2), ('H4', 1, 2),
('I1', 2, 2), ('I2', 2, 2), ('I3', 2, 2), ('I4', 2, 2),
('J1', 2, 2), ('J2', 2, 2), ('J3', 2, 2), ('J4', 2, 2);

-- INSERT 48 GHE VAO MAY BAY 3
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('A1', 1, 3), ('A2', 1, 3), ('A3', 1, 3), ('A4', 1, 3),
('B1', 1, 3), ('B2', 1, 3), ('B3', 1, 3), ('B4', 1, 3),
('C1', 1, 3), ('C2', 1, 3), ('C3', 1, 3), ('C4', 1, 3),
('D1', 1, 3), ('D2', 1, 3), ('D3', 1, 3), ('D4', 1, 3),
('E1', 1, 3), ('E2', 1, 3), ('E3', 1, 3), ('E4', 1, 3),
('F1', 1, 3), ('F2', 1, 3), ('F3', 1, 3), ('F4', 1, 3),
('G1', 1, 3), ('G2', 1, 3), ('G3', 1, 3), ('G4', 1, 3),
('H1', 1, 3), ('H2', 1, 3), ('H3', 1, 3), ('H4', 1, 3),
('I1', 2, 3), ('I2', 2, 3), ('I3', 2, 3), ('I4', 2, 3),
('J1', 2, 3), ('J2', 2, 3), ('J3', 2, 3), ('J4', 2, 3),
('K1', 2, 3), ('K2', 2, 3), ('K3', 2, 3), ('K4', 2, 3),
('L1', 2, 3), ('L2', 2, 3), ('L3', 2, 3), ('L4', 2, 3);

-- INSERT 40 GHE VAO MAY BAY 4
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('A1', 1, 4), ('A2', 1, 4), ('A3', 1, 4), ('A4', 1, 4),
('B1', 1, 4), ('B2', 1, 4), ('B3', 1, 4), ('B4', 1, 4),
('C1', 1, 4), ('C2', 1, 4), ('C3', 1, 4), ('C4', 1, 4),
('D1', 1, 4), ('D2', 1, 4), ('D3', 1, 4), ('D4', 1, 4),
('E1', 1, 4), ('E2', 1, 4), ('E3', 1, 4), ('E4', 1, 4),
('F1', 1, 4), ('F2', 1, 4), ('F3', 1, 4), ('F4', 1, 4),
('G1', 1, 4), ('G2', 1, 4), ('G3', 1, 4), ('G4', 1, 4),
('H1', 2, 4), ('H2', 2, 4), ('H3', 2, 4), ('H4', 2, 4),
('I1', 2, 4), ('I2', 2, 4), ('I3', 2, 4), ('I4', 2, 4),
('J1', 2, 4), ('J2', 2, 4), ('J3', 2, 4), ('J4', 2, 4);


-- INSERT 40 GHE VAO MAY BAY 5
INSERT INTO ghe (ten_ghe, ma_loai_ghe, ma_may_bay)
VALUES
('A1', 1, 5), ('A2', 1, 5), ('A3', 1, 5), ('A4', 1, 5),
('B1', 1, 5), ('B2', 1, 5), ('B3', 1, 5), ('B4', 1, 5),
('C1', 1, 5), ('C2', 1, 5), ('C3', 1, 5), ('C4', 1, 5),
('D1', 1, 5), ('D2', 1, 5), ('D3', 1, 5), ('D4', 1, 5),
('E1', 1, 5), ('E2', 1, 5), ('E3', 1, 5), ('E4', 1, 5),
('F1', 1, 5), ('F2', 1, 5), ('F3', 1, 5), ('F4', 1, 5),
('G1', 1, 5), ('G2', 1, 5), ('G3', 1, 5), ('G4', 1, 5),
('H1', 1, 5), ('H2', 1, 5), ('H3', 1, 5), ('H4', 1, 5),
('I1', 2, 5), ('I2', 2, 5), ('I3', 2, 5), ('I4', 2, 5),
('J1', 2, 5), ('J2', 2, 5), ('J3', 2, 5), ('J4', 2, 5);

-- INSERT INTO HANG BAY

INSERT INTO hang_bay (ma_hang_bay, ten_hang_bay)
VALUES
('HB1', 'Vietnam Airlines'),
('HB2', 'Vietjet Air'),
('HB3', 'Bamboo Airways');


-- INSERT INTO SANBAY
INSERT INTO san_bay (ma_san_bay, ten_san_bay, thanh_pho, quoc_gia)
VALUES
('SGN', 'Sân bay Tân Sơn Nhất','TP HCM','Việt Nam'),
('DAD', 'Sân bay Đà Nẵng','Da Nang','Việt Nam'),
('HAN', 'Sân bay Nội Bài','Ha Noi','Việt Nam'),
('DLI', 'Sân bay Liên Khương','Da Lat','Việt Nam'),
('BKKA', 'Sân bay Bangkok','Bangkok','Thái Lan'),
('SYD', 'Sân bay Sydney','Sydney','Australia'),
('MNL', 'Sân bay Ninoy Aquino','Manila','Philippines'),
('JKTA', 'Sân bay Jakarta','Jakarta','Indonesia');

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
  ('Yemen');



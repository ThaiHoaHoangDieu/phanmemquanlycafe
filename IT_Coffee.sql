Use master
Go
Drop database IT_Coffee
Go
Create database IT_Coffee
Go
Use IT_Coffee
Go
Create table LoaiSanPham(
MaLoai Varchar(7) not null Primary key,
TenLoai Nvarchar(50) not null
)
Go
Create table SanPham(
MaSanPham Varchar(7) not null Primary key,
TenSanPham Nvarchar(30) not null,
DonGia Float not null Check(DonGia>0),
Size Nvarchar(20) not null,
Hinh varchar(50) not null,
MaLoai Varchar(7) references LoaiSanPham(MaLoai)
)
Go
Create Table NhanVien(
MaNV Varchar(7) not null Primary key,
MatKhau varchar(50) not null,
HoTen Nvarchar(50) not null,
GioiTinh BIT not null Default 0,
VaiTro BIT not null Default 0,
DiaChi Nvarchar(50) not null,
SDT varchar(15) not null,
Email varchar(50) not null,
Luong Float not null Check(Luong>0),
Hinh varchar(50) not null,
)
Go
Create table ThanhVien(
MaThanhVien Varchar(7) not null Primary key,
TenThanhVien Nvarchar(50) not null, 
MaNV Varchar(7) not null references NhanVien(MaNV),
NgayThem Date not null,
LoaiThe Nvarchar(50) not null,
SDT varchar(15) not null,
Email varchar(50) not null,
GhiChu Nvarchar(50) null
)
Go
Create Table HoaDon(
MaDonHang Varchar(7) Primary key not null,
MaNV Varchar(7) References NhanVien (MaNV),
NgayThem date not null,
Gio varchar(20) ,
)
Go
Create Table ChiTietHoaDon(
MaDonHang Varchar(7) References HoaDon(MaDonHang) ,
MaSanPham Varchar(7) References SanPham(MaSanPham) ,
TenSanPham Nvarchar(30) not null,
SoLuong int not null,
TongTien Float not null ,
primary key(MaDonHang, MaSanPham)
)
Go
Insert into LoaiSanPham values
('CF', N'Coffee - Sữa - Cacao'),
('TE', N'Trà - Lipton'),
('VT', N'Sinh tố'),
('YG', N'Yogurt'),
('JC', N'Juice'),
('LM', N'Chanh - Xí muội'),
('SD', N'Soda Ý'),
('MC', N'Matcha'),
('DK', N'Nước ngọt')
Go
Insert into SanPham values
('CF1', N'Cafe đen', 14000, N'Vừa', 'sp-cf1.jpg', 'CF'),
('CF2', N'Cafe sữa', 17000, N'Vừa', 'sp-cf1.jpg', 'CF'),
('CF3', N'Bạc xỉu', 17000, N'Vừa', 'sp-cf1.jpg', 'CF'),
('CF4', N'Sữa tươi cafe', 18000, N'Vừa', 'sp-cf1.jpg', 'CF'),
('CF5', N'Sữa tươi đá', 16000, N'Vừa', 'sp-cf1.jpg', 'CF'),
('CF6', N'Cacao nóng - đá', 18000, N'Vừa', 'sp-cf1.jpg', 'CF'),
('CF7', N'Caocao sữa nóng - đá', 20000, N'Vừa', 'sp-cf1.jpg', 'CF'),
('CF11', N'Cafe đen', 14000, N'Nhỏ', 'sp-cf1.jpg', 'CF'),
('CF21', N'Cafe sữa', 17000, N'Nhỏ', 'sp-cf1.jpg', 'CF'),
('CF31', N'Bạc xỉu', 17000, N'Nhỏ', 'sp-cf1.jpg', 'CF'),
('CF41', N'Sữa tươi cafe', 18000, N'Nhỏ', 'sp-cf1.jpg', 'CF'),
('CF51', N'Sữa tươi đá', 16000, N'Nhỏ', 'sp-cf1.jpg', 'CF'),
('CF61', N'Cacao nóng - đá', 18000, N'Nhỏ', 'sp-cf1.jpg', 'CF'),
('CF71', N'Caocao sữa nóng - đá', 20000, N'Nhỏ', 'sp-cf1.jpg', 'CF'),
('CF12', N'Cafe đen', 14000, N'Lớn', 'sp-cf1.jpg', 'CF'),
('CF22', N'Cafe sữa', 17000, N'Lớn', 'sp-cf1.jpg', 'CF'),
('CF32', N'Bạc xỉu', 17000, N'Lớn', 'sp-cf1.jpg', 'CF'),
('CF42', N'Sữa tươi cafe', 18000, N'Lớn', 'sp-cf1.jpg', 'CF'),
('CF52', N'Sữa tươi đá', 16000, N'Lớn', 'sp-cf1.jpg', 'CF'),
('CF62', N'Cacao nóng - đá', 18000, N'Lớn', 'sp-cf1.jpg', 'CF'),
('CF72', N'Caocao sữa nóng - đá', 20000, N'Lớn', 'sp-cf1.jpg', 'CF'),

('TE1', N'Trà gừng nóng đá', 18000, N'Vừa', 'sp-te1.jpg', 'TE'),
('TE2', N'Trà sữa matcha', 30000, N'Vừa', 'sp-te1.jpg', 'TE'),
('TE3', N'Trà đào', 22000, 'Vừa', N'sp-te1.jpg', 'TE'),
('TE4', N'Lipton nóng đá', 18000, N'Vừa', 'sp-te1.jpg', 'TE'),
('TE5', N'Lipton xí muội', 20000, N'Vừa', 'sp-te1.jpg', 'TE'),
('TE6', N'Lipton sữa', 20000, N'Vừa', 'sp-te1.jpg', 'TE'),
('TE7', N'Lipton chanh dây', 22000, N'Vừa', 'sp-te1.jpg', 'TE'),
('TE11', N'Trà gừng nóng đá', 18000, N'Nhỏ', 'sp-te1.jpg', 'TE'),
('TE21', N'Trà sữa matcha', 30000, N'Nhỏ', 'sp-te1.jpg', 'TE'),
('TE31', N'Trà đào', 22000, 'Nhỏ', N'sp-te1.jpg', 'TE'),
('TE41', N'Lipton nóng đá', 18000, N'Nhỏ', 'sp-te1.jpg', 'TE'),
('TE51', N'Lipton xí muội', 20000, N'Nhỏ', 'sp-te1.jpg', 'TE'),
('TE61', N'Lipton sữa', 20000, N'Nhỏ', 'sp-te1.jpg', 'TE'),
('TE71', N'Lipton chanh dây', 22000, N'Nhỏ', 'sp-te1.jpg', 'TE'),
('TE12', N'Trà gừng nóng đá', 18000, N'Lớn', 'sp-te1.jpg', 'TE'),
('TE22', N'Trà sữa matcha', 30000, N'Lớn', 'sp-te1.jpg', 'TE'),
('TE32', N'Trà đào', 22000, 'Lớn', N'sp-te1.jpg', 'TE'),
('TE42', N'Lipton nóng đá', 18000, N'Lớn', 'sp-te1.jpg', 'TE'),
('TE52', N'Lipton xí muội', 20000, N'Lớn', 'sp-te1.jpg', 'TE'),
('TE62', N'Lipton sữa', 20000, N'Lớn', 'sp-te1.jpg', 'TE'),
('TE72', N'Lipton chanh dây', 22000, N'Lớn', 'sp-te1.jpg', 'TE'),

('VT1', N'Sapoche', 25000, N'Vừa', 'sp-vt1.jpg', 'VT'),
('VT2', N'Măng cầu', 28000, N'Vừa', 'sp-vt1.jpg', 'VT'),
('VT3', N'Dâu', 28000, N'Vừa', 'sp-vt1.jpg', 'VT'),
('VT4', N'Việt quất', 25000, N'Vừa', 'sp-vt1.jpg', 'VT'),
('VT5', N'Bơ', 28000, N'Vừa', 'sp-vt1.jpg', 'VT'),
('VT6', N'Dâu tằm', 28000, N'Vừa', 'sp-vt1.jpg', 'VT'),
('VT7', N'Măng cầu dằm', 28000, N'Vừa', 'sp-vt1.jpg', 'VT'),
('VT8', N'Bơ dằm', 28000, N'Vừa', 'sp-vt1.jpg', 'VT'),
('VT11', N'Sapoche', 25000, N'Nhỏ', 'sp-vt1.jpg', 'VT'),
('VT21', N'Măng cầu', 28000, N'Nhỏ', 'sp-vt1.jpg', 'VT'),
('VT31', N'Dâu', 28000, N'Nhỏ', 'sp-vt1.jpg', 'VT'),
('VT41', N'Việt quất', 25000, N'Nhỏ', 'sp-vt1.jpg', 'VT'),
('VT51', N'Bơ', 28000, N'Nhỏ', 'sp-vt1.jpg', 'VT'),
('VT61', N'Dâu tằm', 28000, N'Nhỏ', 'sp-vt1.jpg', 'VT'),
('VT71', N'Măng cầu dằm', 28000, N'Nhỏ', 'sp-vt1.jpg', 'VT'),
('VT81', N'Bơ dằm', 28000, N'Nhỏ', 'sp-vt1.jpg', 'VT'),
('VT12', N'Sapoche', 25000, N'Lớn', 'sp-vt1.jpg', 'VT'),
('VT22', N'Măng cầu', 28000, N'Lớn', 'sp-vt1.jpg', 'VT'),
('VT32', N'Dâu', 28000, N'Lớn', 'sp-vt1.jpg', 'VT'),
('VT42', N'Việt quất', 25000, N'Lớn', 'sp-vt1.jpg', 'VT'),
('VT52', N'Bơ', 28000, N'Lớn', 'sp-vt1.jpg', 'VT'),
('VT62', N'Dâu tằm', 28000, N'Lớn', 'sp-vt1.jpg', 'VT'),
('VT72', N'Măng cầu dằm', 28000, N'Lớn', 'sp-vt1.jpg', 'VT'),
('VT82', N'Bơ dằm', 28000, N'Lớn', 'sp-vt1.jpg', 'VT'),

('YG1', N'Yogurt đá', 20000, N'Vừa', 'sp-yg1.jpg', 'YG'),
('YG2', N'Yogurt dâu tằm', 25000, N'Vừa', 'sp-yg1.jpg', 'YG'),
('YG3', N'Yogurt bơ dằm', 25000, N'Vừa', 'sp-yg1.jpg', 'YG'),
('YG4', N'Yogurt 3 tầng', 30000, N'Vừa', 'sp-yg1.jpg', 'YG'),
('YG11', N'Yogurt đá', 20000, N'Nhỏ', 'sp-yg1.jpg', 'YG'),
('YG21', N'Yogurt dâu tằm', 25000, N'Nhỏ', 'sp-yg1.jpg', 'YG'),
('YG31', N'Yogurt bơ dằm', 25000, N'Nhỏ', 'sp-yg1.jpg', 'YG'),
('YG41', N'Yogurt 3 tầng', 30000, N'Nhỏ', 'sp-yg1.jpg', 'YG'),
('YG12', N'Yogurt đá', 20000, N'Lớn', 'sp-yg1.jpg', 'YG'),
('YG22', N'Yogurt dâu tằm', 25000, N'Lớn', 'sp-yg1.jpg', 'YG'),
('YG32', N'Yogurt bơ dằm', 25000, N'Lớn', 'sp-yg1.jpg', 'YG'),
('YG42', N'Yogurt 3 tầng', 30000, N'Lớn', 'sp-yg1.jpg', 'YG'),

('JC1', N'Cà chua', 20000, N'Vừa', 'sp-jc1.jpg', 'JC'),
('JC2', N'Chanh dây', 18000, N'Vừa', 'sp-jc1.jpg', 'JC'),
('JC3', N'Cà rốt', 20000, N'Vừa', 'sp-jc1.jpg', 'JC'),
('JC4', N'Thơm', 22000, N'Vừa', 'sp-jc1.jpg', 'JC'),
('JC5', N'Ổi', 20000, N'Vừa', 'sp-jc1.jpg', 'JC'),
('JC6', N'Cam vắt', 22000, N'Vừa', 'sp-jc1.jpg', 'JC'),
('JC7', N'Bưởi', 25000, N'Vừa', 'sp-jc1.jpg', 'JC'),
('JC8', N'Nước ép không đá', 30000, N'Vừa', 'sp-jc1.jpg', 'JC'),
('JC11', N'Cà chua', 20000, N'Nhỏ', 'sp-jc1.jpg', 'JC'),
('JC21', N'Chanh dây', 18000, N'Nhỏ', 'sp-jc1.jpg', 'JC'),
('JC31', N'Cà rốt', 20000, N'Nhỏ', 'sp-jc1.jpg', 'JC'),
('JC41', N'Thơm', 22000, N'Nhỏ', 'sp-jc1.jpg', 'JC'),
('JC51', N'Ổi', 20000, N'Nhỏ', 'sp-jc1.jpg', 'JC'),
('JC61', N'Cam vắt', 22000, N'Nhỏ', 'sp-jc1.jpg', 'JC'),
('JC71', N'Bưởi', 25000, N'Nhỏ', 'sp-jc1.jpg', 'JC'),
('JC81', N'Nước ép không đá', 30000, N'Nhỏ', 'sp-jc1.jpg', 'JC'),

('LM1', N'Chanh nóng - đá', 18000, N'Vừa', 'sp-lm1.jpg', 'LM'),
('LM2', N'Chanh muối nóng - đá', 18000, N'Vừa', 'sp-lm1.jpg', 'LM'),
('LM3', N'Xí muội nóng đá', 18000, N'Vừa', 'sp-lm1.jpg', 'LM'),
('LM4', N'Dừa tươi', 22000, N'Vừa', 'sp-lm1.jpg', 'LM'),
('LM12', N'Chanh nóng - đá', 18000, N'Lớn', 'sp-lm1.jpg', 'LM'),
('LM22', N'Chanh muối nóng - đá', 18000, N'Lớn', 'sp-lm1.jpg', 'LM'),
('LM32', N'Xí muội nóng đá', 18000, N'Lớn', 'sp-lm1.jpg', 'LM'),
('LM42', N'Dừa tươi', 22000, N'Lớn', 'sp-lm1.jpg', 'LM'),

('SD1', N'Soda chanh', 25000, N'Vừa', 'sp-sd1.jpg', 'SD'),
('SD2', N'Soda việt quất', 25000, N'Vừa', 'sp-sd1.jpg', 'SD'),
('SD3', N'Soda bạc hà', 25000, N'Vừa', 'sp-sd1.jpg', 'SD'),
('SD11', N'Soda chanh', 25000, N'Nhỏ', 'sp-sd1.jpg', 'SD'),
('SD21', N'Soda việt quất', 25000, N'Nhỏ', 'sp-sd1.jpg', 'SD'),
('SD31', N'Soda bạc hà', 25000, N'Nhỏ', 'sp-sd1.jpg', 'SD'),

('MC1', N'Sinh tốt matcha', 25000, N'Vừa', 'sp-mc1.jpg', 'MC'),
('MC2', N'Soda matcha', 25000, N'Vừa', 'sp-mc1.jpg', 'MC'),
('MC3', N'Latte green tea', 25000, N'Vừa', 'sp-mc1.jpg', 'MC'),
('MC12', N'Sinh tốt matcha', 25000, N'Lớn', 'sp-mc1.jpg', 'MC'),
('MC22', N'Soda matcha', 25000, N'Lớn', 'sp-mc1.jpg', 'MC'),
('MC32', N'Latte green tea', 25000, N'Lớn', 'sp-mc1.jpg', 'MC'),

('DK1', N'Nước suối', 12000, N'Vừa', 'sp-dk1.jpg', 'DK'),
('DK2', N'Coca Cola / Pepsi / 7 Up', 16000, N'Vừa', 'sp-dk1.jpg', 'DK'),
('DK3', N'Trà Olong', 18000, N'Vừa', 'sp-dk1.jpg', 'DK'),
('DK4', N'Trà chanh 0 Độ', 16000, N'Vừa', 'sp-dk1.jpg', 'DK'),
('DK5', N'Sting', 16000, N'Vừa', 'sp-dk1.jpg', 'DK'),
('DK6', N'Bò Húc', 20000, N'Vừa', 'sp-dk1.jpg', 'DK'),
('DK7', N'C2', 14000, N'Vừa', 'sp-dk1.jpg', 'DK')
Go
Insert into NhanVien values 
('Dang','123',N'Lê Bảo Đăng',1,1,N'Trà Vinh','0961852791','dangletv234@gmail.com',200000,'nv1.jpg'),
('Dieu','123',N'Thái Hoa Hoàng Diệu',0,1,N'TP.HCM','0979127888','Dieu@gmail.com',100000,'nv2.jpg'),
('Duy','123',N'Hoàng Minh Duy',0,1,N'Đà Lạt','0961890907','Duy@gmail.com',200000,'nv3.jpg'),
('Hung','123',N'Trần Duy Hưng',0,1,N'Vũng Tàu','0987565656','Hung@gmail.com',150000,'nv4.jpg'),
('Vinh','123',N'Nguyễn Quang Vinh',0,1,N'TP.HCM','0987565656','Vinh@gmail.com',150000,'nv4.jpg'),
('Khanh','123',N'Trần Lâm Khanh',1,1,N'Bến Tre','0987565656','Khanh@gmail.com',150000,'nv4.jpg'),
('Chien','123',N'Nguyễn Minh Chiến',0,1,N'Vĩnh Long','0987565656','Chien@gmail.com',150000,'nv4.jpg'),
('Cuong','123',N'Mạnh Cường',0,1,N'Đồng Tháp','0987565656','Cuong@gmail.com',150000,'nv4.jpg'),
('Nam','123',N'Quốc Nam',1,1,N'TP.HCM','0987565656','Nam@gmail.com',150000,'nv4.jpg'),
('Tran','123',N'Quế Trân',0,1,N'Vũng Tàu','0987565656','Tran@gmail.com',150000,'nv4.jpg')
Go
Insert into ThanhVien values
('Hung',N'Trung Hưng','Dang','2019-12-9',N'Vip','096172813','Hung@gmail.com',N'Địa Chỉ Trà Vinh'),
('Tai',N'Văn Tài','Dieu','2018-11-9',N'Thường','0961927165','Tai@gmail.com',N'Địa Chỉ Trà Vinh'),
('Vinh',N'Quang Vinh','Duy','2020-8-9',N'Vip','0961851421','Vinh@gmail.com',N'Địa Chỉ Trà Vinh'),
('Khanh',N'Trần Quang Khanh','Dang','2012-4-9',N'Thường','0961851421','khanh@gmail.com',N'Địa Chỉ Trà Vinh'),
('Nhung',N'Hồng Nhung','Duy','2012-7-9',N'Thường','0961851421','Nhung@gmail.com',N'Địa Chỉ Trà Vinh'),
('Quoc',N'Trần Phục Quốc','Dang','2012-8-10',N'Vip','0961851421','Quoc@gmail.com',N'Địa Chỉ Trà Vinh'),
('Hien',N'Thanh Hiền','Dang','2012-8-9',N'Vip','0961851421','Hien@gmail.com',N'Địa Chỉ Trà Vinh'),
('Han',N'Bảo Hân','Dang','2012-8-9',N'Thường','0961851421','Han@gmail.com',N'Địa Chỉ Trà Vinh'),
('Ngoc',N'Bảo Ngọc','Duy','2012-8-9',N'Thường','0961851421','Ngoc@gmail.com',N'Địa Chỉ Trà Vinh'),
('Khang',N'Minh Khang','Duy','2012-8-9',N'Vip','0961851421','Khang@gmail.com',N'Địa Chỉ Trà Vinh'),
('Loi',N'Lợi','Duy','2012-8-9',N'Vip','0961851421','Loi@gmail.com',N'Địa Chỉ Trà Vinh')
Go
Insert into HoaDon values 
('HD0001','Dang','09-11-2021','3:15:12'),
('HD0002','Dieu','07-10-2021','4:30:14'),
('HD0003','Duy','01-12-2021','6:45:20'),
('HD0004','Dieu','07-11-2021','4:30:14'),
('HD0005','Dieu','06-11-2021','4:30:14'),
('HD0006','Dieu','05-11-2021','4:30:14'),
('HD0007','Dang','04-8-2021','5:15:13'),
('HD0008','Duy','03-7-2021','7:18:13')
Go
Insert into ChiTietHoaDon values
('HD0001','CF1',N'Cafe đen',2,30000),
('HD0001','CF2',N'Cafe sữa',2,34000),
('HD0001','CF3',N'Bạc xỉu',2,34000),
('HD0001','CF4',N'Sữa tươi cafe',2,36000),
('HD0001','CF5',N'Sữa tươi đá',2,32000),
('HD0001','CF6',N'Cacao nóng - đá',2,36000),
('HD0001','CF7',N'Caocao sữa nóng - đá',2,40000),
('HD0002','DK1',N'Nước suối',5,60000),
('HD0002','DK2',N'Coca Cola / Pepsi / 7 Up',5,60000),
('HD0002','DK3',N'Trà Olong',5,90000),
('HD0003','DK4',N'Trà chanh 0 Độ',3,54000),
('HD0003','DK5',N'Sting',3,48000),
('HD0003','DK6',N'Bò Húc',3,60000),
('HD0004','DK7',N'C2',2,28000),
('HD0004','JC1',N'Cà chua',2,40000),
('HD0004','JC2',N'Chanh dây',2,36000),
('HD0005','JC3',N'Cà rốt',1,20000),
('HD0006','JC4',N'Thơm',4,88000),
('HD0006','JC5',N'Ổi',4,80000),
('HD0006','JC6',N'Cam vắt',4,88000),
('HD0007','JC7',N'Bưởi',1,25000),
('HD0007','JC8',N'Nước ép không đá',1,30000),
('HD0008','LM1',N'Chanh nóng - đá',3,54000),
('HD0008','LM2',N'Chanh muối nóng - đá',3,54000),
('HD0008','LM3',N'Xí muội nóng đá',3,54000),
('HD0008','LM4',N'Dừa tươi',3,66000)
go
create proc sp_TopSP (@dateBegin date, @dateEnd date)
as begin
	select top(10) cthd.MaSanPham, cthd.TenSanPham, SUM(cthd.SoLuong) as 'DaBan'
	from ChiTietHoaDon cthd join HoaDon hd on cthd.MaDonHang = hd.MaDonHang
	where hd.NgayThem between @dateBegin and @dateEnd
	group by cthd.MaSanPham, cthd.TenSanPham
	order by DaBan desc
end
go
create proc sp_TopSP2 (@year int)
as begin
	select top(10) cthd.MaSanPham, cthd.TenSanPham, SUM(cthd.SoLuong) as 'DaBan'
	from ChiTietHoaDon cthd join HoaDon hd on cthd.MaDonHang = hd.MaDonHang
	where YEAR(hd.NgayThem) = @year
	group by cthd.MaSanPham, cthd.TenSanPham
	order by DaBan desc
end
go
create proc sp_TopSP3 (@month int, @year int)
as begin
	select top(10) cthd.MaSanPham, cthd.TenSanPham, SUM(cthd.SoLuong) as 'DaBan'
	from ChiTietHoaDon cthd join HoaDon hd on cthd.MaDonHang = hd.MaDonHang
	where YEAR(hd.NgayThem) = @year and MONTH(hd.NgayThem) = @month
	group by cthd.MaSanPham, cthd.TenSanPham
	order by DaBan desc
end
go
create proc sp_DoanhThu
as begin
	select hd.NgayThem, SUM(cthd.TongTien) as 'DoanhThu'
	from ChiTietHoaDon cthd join HoaDon hd on cthd.MaDonHang = hd.MaDonHang
	group by hd.NgayThem
end
go
create proc sp_DoanhThu2 (@date date)
as begin
	select hd.NgayThem, SUM(cthd.TongTien) as 'DoanhThu'
	from ChiTietHoaDon cthd join HoaDon hd on cthd.MaDonHang = hd.MaDonHang
	where hd.NgayThem = @date
	group by hd.NgayThem
end


















 









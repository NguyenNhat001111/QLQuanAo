CREATE DATABASE QLBQA
GO
USE QLBQA
GO

create table MauSac
(
   IDMauSac int not null primary key,
   MauSac nvarchar(20) not null
)
GO

create table DonViTinh
(
   IDDonViTinh int not null primary key,
   DonViTinh nvarchar(20) not null
)
GO

create table ChatLieu
(
   IDChatLieu int not null primary key,
   ChatLieuSP nvarchar(20) not null
)
GO

create table GioiTinh
(
   IDGioiTinh int not null primary key,
   GioiTinh nvarchar(10) not null
)
GO

create table KichCoSP
(
   IDKichCo int not null primary key,
   KichCo varchar(10) not null
)
GO

create table NhaSanXuat
(
   IDNhaSanXuat int not null primary key,
   TenNhaSX nvarchar(50) not null
)
GO

create table DanhMucSP
(
   IDDanhMuc int not null primary key,
   TenDanhMuc nvarchar(50) not null
)
GO

create table SanPham
(
   IDSanPham int identity(1,1) not null primary key,
   IDDanhMuc int not null foreign key references DanhMucSP(IDDanhMuc),
   IDNhaSanXuat int not null foreign key references NhaSanXuat(IDNhaSanXuat),
   TenSanPham nvarchar(50) not null,
   TrangThai int not null
)
GO

create table ChiTietSanPham
(
   IDCTSP int identity(1,1) not null primary key,
   MaSanPham varchar(20) not null,
   IDSanPham int not null foreign key references SanPham(IDSanPham),
   IDKichCo int not null foreign key references KichCoSP(IDKichCo),
   IDMauSac int not null foreign key references MauSac(IDMauSac),
   IDDonViTinh int not null foreign key references DonViTinh(IDDonViTinh),
   IDChatLieu int not null foreign key references ChatLieu(IDChatLieu),
   IDGioiTinh int not null foreign key references GioiTinh(IDGioiTinh),
   MoTa nvarchar(200) not null,
   GiaTien float not null,
   TenChiTiet nvarchar(50) not null,
   Soluong int not null,
   TrangThai int not null
)
GO

create table VaiTro
(
   IDVaiTro int not null primary key,
   TenVaiTro nvarchar(20) not null
)
GO

create table NguoiDung
(
   IDNguoiDung int identity(1,1) not null primary key,
   IDVaiTro int not null foreign key references VaiTro(IDVaiTro),
   HoTenNhanVien nvarchar(50) not null,
   SDT varchar(10) not null,
   DiaChi nvarchar(50) not null,
   CCCD varchar(12) not null,
   TrangThai int not null
)
GO

create table KhachHang
(
   IDKhachHang int identity(1,1) not null primary key,
   HoTenKH nvarchar(50) not null,
   SDT varchar(10) not null,
   DiaChi nvarchar(50) not null,
   CCCD varchar(12) not null,
)
GO

create table TaiKhoan
(
   IDTaiKhoan int identity(1,1) not null,
   Email varchar(50) not null ,
   IDNguoiDung int not null foreign key references NguoiDung(IDNguoiDung),
   MatKhau varchar(20) not null,
   TrangThai int not null
   Primary key(IDTaiKhoan, Email)
)
GO

create table HoaDon
(
   IDHoaDon int identity(1,1) not null primary key,
   IDNguoiDung int not null foreign key references NguoiDung(IDNguoiDung),
   IDKhachHang int not null foreign key references KhachHang(IDKhachHang),
   NgayLapHoaDon date not null,
   TongGiaTien float not null,
   HinhThucThanhToan nvarchar(50) not null,
   TrangThaiHoaDon int not null
)
GO

create table HoaDonChiTiet
(
   IDHoaDon int not null foreign key references HoaDon(IDHoaDon),
   IDCTSP int not null foreign key references ChiTietSanPham(IDCTSP),
   DonGia float not null,
   SoLuong int not null,
   TrangThai int not null,
   Primary key(IDHoaDon, IDCTSP)
)
GO

--MauSac
insert into MauSac values(0, N'Trắng')
insert into MauSac values(1, N'Đen')
insert into MauSac values(2, N'Nâu')
insert into MauSac values(3, N'Nâu Sữa')
insert into MauSac values(4, N'Xanh Rêu')
insert into MauSac values(5, N'Xanh Biển')

--DonViTinh
insert into DonViTinh values(0, N'Bộ')
insert into DonViTinh values(1, N'Chiếc')

--ChatLieu
insert into ChatLieu values(0, N'Cotton')
insert into ChatLieu values(1, N'Jeans')
insert into ChatLieu values(2, N'KaKi')
insert into ChatLieu values(3, N'Len')
insert into ChatLieu values(4, N'Nỉ')
insert into ChatLieu values(5, N'Thô')

--GioiTinh
insert into GioiTinh values(0, N'Nam')
insert into GioiTinh values(1, N'Nữ')
insert into GioiTinh values(2, N'Unisex')

--KichCoSanPham
insert into KichCoSP values(0, N'S')
insert into KichCoSP values(1, N'M')
insert into KichCoSP values(2, N'L')
insert into KichCoSP values(3, N'XL')
insert into KichCoSP values(4, N'XXL')

--NhaSanXuat
insert into NhaSanXuat values(0, N'Gucci')
insert into NhaSanXuat values(1, N'Channel')
insert into NhaSanXuat values(2, N'Yody')
insert into NhaSanXuat values(3, N'Puma')
insert into NhaSanXuat values(4, N'Adidas')
insert into NhaSanXuat values(5, N'Nike')
insert into NhaSanXuat values(6, N'Dior')

--DanhMucSanPham
insert into DanhMucSP values(0, N'Áo Phông')
insert into DanhMucSP values(1, N'Áo Hoodie')
insert into DanhMucSP values(2, N'Áo Phông')
insert into DanhMucSP values(3, N'Áo Dài')
insert into DanhMucSP values(4, N'Áo Len')
insert into DanhMucSP values(5, N'Áo Khoác')
insert into DanhMucSP values(6, N'Áo Sơ Mi')
insert into DanhMucSP values(7, N'Quần Đùi')
insert into DanhMucSP values(8, N'Quần Dài')


--SanPham
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(0, 1, N'Áo Phông Thời Trang Channel', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(1, 0, N'Áo Hoodie Channel', 1)

--ChiTietSanPham
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(1, 'SP01', 1, 0, 1, 1, 1, N'Demo mô tả', 250000, N'Demo tên chi tiết', 9, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 'SP02', 0, 1, 1, 1, 0, N'Demo mô tả', 200000, N'Demo tên chi tiết', 11, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 'SP03', 1, 0, 0, 0, 0, N'Demo mô tả', 200000, N'Demo tên chi tiết', 20, 1)

--Vaitro
insert into VaiTro values(0, N'ADMIN')
insert into VaiTro values(1, N'Nhân Viên')

--NguoiDung
insert into NguoiDung(IDVaiTro, HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(0, N'Lê Quân', '0392402083', N'Cầu Giấy - Hà Nội', '001202003794', 1)
insert into NguoiDung(IDVaiTro, HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(0, N'Nguyễn Văn Tèo', '0392458083', N'Láng Hạ - Hà Nội', '001202003794', 1)
insert into NguoiDung(IDVaiTro, HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(1, N'Nguyễn Văn Nam', '0396662083', N'Ba Đình - Hà Nội', '001201000794', 1)
insert into NguoiDung(IDVaiTro, HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(1, N'Nguyễn Minh Nhật', '0396668888', N'Cầu Giấy - Hà Nội', '001201002548', 1)

--TaiKhoan
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, TrangThai)
values('lequan@gmail.com', 1, 'admin', 1)
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, TrangThai)
values('vannamnguyen@gmail.com', 2, 'nhanvien1', 1)
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, TrangThai)
values('teovan@gmail.com', 3, 'admin123', 1)
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, TrangThai)
values('nguyenminhnhat@gmail.com', 4, 'nhanvien123', 1)

--KhachHang
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Minh Nhật', '0493676789', N'Hoàn Kiếm - Hà Nội', '001101000345')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Phí Công Lợi', '0493458389', N'Hoài Đức - Hà Nội', '001104573455')

--HoaDon
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, TrangThaiHoaDon)
values(2, 1, '9/11/2021', 1000000, N'Tiền Mặt', 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, TrangThaiHoaDon)
values(2, 2, '8/11/2021', 2500000, N'Chuyển Khoản Ngân Hàng', 1)

--HoaDonChiTiet
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(1, 2, 200000, 5, 1000000, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(2, 1, 250000, 6, 1500000, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(2, 2, 200000, 5, 1000000, 1)

select * from MauSac
select * from DonViTinh
select * from ChatLieu
select * from GioiTinh
select * from KichCoSP
select * from NhaSanXuat
select * from DanhMucSP
select * from SanPham
select * from ChiTietSanPham
select * from VaiTro
select * from NguoiDung
select * from TaiKhoan
select * from KhachHang
select * from HoaDon
select * from HoaDonChiTiet


--ThongKe
select HoaDon.IDHoaDon ,HoTenKH, HoTenNhanVien, KhachHang.DiaChi, KhachHang.SDT, NgayLapHoaDon, ChiTietSanPham.MaSanPham, SanPham.TenSanPham, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia, TongGiaTien from KhachHang 
inner join HoaDon on KhachHang.IDKhachHang=HoaDon.IDKhachHang
inner join NguoiDung on NguoiDung.IDNguoiDung=HoaDon.IDNguoiDung
inner join HoaDonChiTiet on HoaDon.IDHoaDon=HoaDonChiTiet.IDHoaDon
inner join ChiTietSanPham on HoaDonChiTiet.IDCTSP=ChiTietSanPham.IDCTSP
inner join SanPham on SanPham.IDSanPham=ChiTietSanPham.IDSanPham

--SanPham
select TenSanPham, TenDanhMuc, ChatLieuSP, MauSac, KichCo, TenNhaSX, GiaTien,Soluong,  ChiTietSanPham.TrangThai from ChiTietSanPham 
inner join MauSac on MauSac.IDMauSac=ChiTietSanPham.IDMauSac
inner join DonViTinh on DonViTinh.IDDonViTinh = ChiTietSanPham.IDDonViTinh
inner join ChatLieu on ChatLieu.IDChatLieu=ChiTietSanPham.IDChatLieu
inner join GioiTinh on GioiTinh.IDGioiTinh=ChiTietSanPham.IDgioiTinh
inner join KichCoSP on KichCoSP.IDKichCo=ChiTietSanPham.IDKichCo
inner join SanPham on ChiTietSanPham.IDSanPham=SanPham.IDSanPham
inner join DanhMucSP on DanhMucSP.IDDanhMuc=SanPham.IDDanhMuc
inner join NhaSanXuat on NhaSanXuat.IDNhaSanXuat=SanPham.IDNhaSanXuat

select IDHoaDon,NgayLapHoaDon,TongGiaTien,TrangThaiHoaDon from HoaDon



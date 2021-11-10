﻿CREATE DATABASE QLBQA
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
   GioiTinh int not null
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
   HoTen nvarchar(50) not null,
   SDT int not null,
   DiaChi nvarchar(50) not null,
   CCCD int not null,
   TrangThai int not null
)
GO

create table KhachHang
(
   IDKhachHang int identity(1,1) not null primary key,
   HoTenKH nvarchar(50) not null,
   SDT int not null,
   DiaChi nvarchar(50) not null,
   CCCD int not null,
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
   ThanhTien float not null,
   TrangThai int not null,
   Primary key(IDHoaDon, IDCTSP)
)
GO

--MauSac
insert into MauSac values(0, N'Trắng')
insert into MauSac values(1, N'Đen')

--DonViTinh
insert into DonViTinh values(0, N'Bộ')
insert into DonViTinh values(1, N'Chiếc')

--ChatLieu
insert into ChatLieu values(0, N'Cotton')
insert into ChatLieu values(1, N'Nỉ')

--GioiTinh
insert into GioiTinh values(0, 0)
insert into GioiTinh values(1, 1)

--KichCoSanPham
insert into KichCoSP values(0, N'S')
insert into KichCoSP values(1, N'M')

--NhaSanXuat
insert into NhaSanXuat values(0, N'Gucci')
insert into NhaSanXuat values(1, N'Channel')

--DanhMucSanPham
insert into DanhMucSP values(0, N'Áo Phông')
insert into DanhMucSP values(1, N'Áo Hoodie')

--SanPham
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(0, 1, N'Áo Phông Thời Trang Channel', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(1, 0, N'Áo Hoodie Channel', 1)

--ChiTietSanPham
insert into ChiTietSanPham(IDSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(1, 1, 0, 1, 1, 1, N'Demo mô tả', 250000, N'Demo tên chi tiết', 9, 1)
insert into ChiTietSanPham(IDSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 0, 1, 1, 1, 0, N'Demo mô tả', 200000, N'Demo tên chi tiết', 11, 1)

--Vaitro
insert into VaiTro values(0, N'ADMIN')
insert into VaiTro values(1, N'Nhân Viên')

--NguoiDung
insert into NguoiDung(IDVaiTro, HoTen, SDT, DiaChi, CCCD, TrangThai)
values(0, N'Lê Quân', 0392402083, N'Cầu Giấy - Hà Nội', 001202003794, 1)
insert into NguoiDung(IDVaiTro, HoTen, SDT, DiaChi, CCCD, TrangThai)
values(1, N'Nguyễn Văn Nam', 0396662083, N'Ba Đình - Hà Nội', 001201000794, 1)

--TaiKhoan
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, TrangThai)
values('lequan@gmail.com', 1, 'admin', 1)
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, TrangThai)
values('vannamnguyen@gmail.com', 2, 'nhanvien1', 1)

--KhachHang
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Minh Nhật', 0493676789, N'Hoàn Kiếm - Hà Nội', 001101000345)
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Phí Công Lợi', 0493458389, N'Hoài Đức - Hà Nội', 001104573455)

--HoaDon
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, TrangThaiHoaDon)
values(2, 1, '9/11/2021', 1000000, N'Tiền Mặt', 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, TrangThaiHoaDon)
values(2, 2, '8/11/2021', 2500000, N'Chuyển Khoản Ngân Hàng', 1)

--HoaDonChiTiet
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, ThanhTien,TrangThai)
values(1, 2, 200000, 5, 1000000, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, ThanhTien,TrangThai)
values(2, 1, 250000, 6, 1500000, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, ThanhTien,TrangThai)
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
delete from ChiTietSanPham

select HoaDon.IDHoaDon ,HoTenKH, HoTen,KhachHang.DiaChi, KhachHang.SDT, NgayLapHoaDon, SanPham.TenSanPham, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia, HoaDonChiTiet.ThanhTien, TongGiaTien from KhachHang 
inner join HoaDon on KhachHang.IDKhachHang=HoaDon.IDKhachHang
inner join NguoiDung on NguoiDung.IDNguoiDung=HoaDon.IDNguoiDung
inner join HoaDonChiTiet on HoaDon.IDHoaDon=HoaDonChiTiet.IDHoaDon
inner join ChiTietSanPham on HoaDonChiTiet.IDCTSP=ChiTietSanPham.IDCTSP
inner join SanPham on SanPham.IDSanPham=ChiTietSanPham.IDSanPham
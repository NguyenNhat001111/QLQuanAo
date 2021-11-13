CREATE DATABASE QLBQA
GO
USE QLBQA
GO

create table MauSac
(
   IDMauSac int identity(1,1) not null primary key,
   MauSac nvarchar(20)
)
GO

create table DonViTinh
(
   IDDonViTinh int identity(1,1) not null primary key,
   DonViTinh nvarchar(20) 
)
GO

create table ChatLieu
(
   IDChatLieu int identity(1,1) not null primary key,
   ChatLieuSP nvarchar(20)
)
GO

create table GioiTinh
(
   IDGioiTinh int identity(1,1) not null primary key,
   GioiTinh nvarchar(10)
)
GO

create table KichCoSP
(
   IDKichCo int identity(1,1) not null primary key,
   KichCo varchar(10)
)
GO

create table NhaSanXuat
(
   IDNhaSanXuat int identity(1,1) not null primary key,
   TenNhaSX nvarchar(50) 
)
GO

create table DanhMucSP
(
   IDDanhMuc int identity(1,1) not null primary key,
   TenDanhMuc nvarchar(50)
)
GO

create table SanPham
(
   IDSanPham int identity(1,1) not null primary key,
   IDDanhMuc int not null foreign key references DanhMucSP(IDDanhMuc),
   IDNhaSanXuat int not null foreign key references NhaSanXuat(IDNhaSanXuat),
   TenSanPham nvarchar(50) ,
   TrangThai int 
)
GO

create table ChiTietSanPham
(
   IDCTSP int identity(1,1) not null primary key,
   MaSanPham varchar(20),
   IDSanPham int not null foreign key references SanPham(IDSanPham),
   IDKichCo int not null foreign key references KichCoSP(IDKichCo),
   IDMauSac int not null foreign key references MauSac(IDMauSac),
   IDDonViTinh int not null foreign key references DonViTinh(IDDonViTinh),
   IDChatLieu int not null foreign key references ChatLieu(IDChatLieu),
   IDGioiTinh int not null foreign key references GioiTinh(IDGioiTinh),
   MoTa nvarchar(200) ,
   GiaTien float ,
   TenChiTiet nvarchar(50),
   Soluong int,
   TrangThai int 
)
GO

create table VaiTro
(
   IDVaiTro int not null primary key,
   TenVaiTro nvarchar(20)
)
GO

create table NguoiDung
(
   IDNguoiDung int identity(1,1) not null primary key,
   IDVaiTro int not null foreign key references VaiTro(IDVaiTro),
   HoTenNhanVien nvarchar(50),
   SDT varchar(10) ,
   DiaChi nvarchar(50) ,
   CCCD varchar(12),
   TrangThai int 
)
GO

create table KhachHang
(
   IDKhachHang int identity(1,1) not null primary key,
   HoTenKH nvarchar(50) ,
   SDT varchar(10) ,
   DiaChi nvarchar(50) ,
   CCCD varchar(12),
)
GO

create table TaiKhoan
(
   IDTaiKhoan int identity(1,1) not null,
   Email varchar(50) ,
   IDNguoiDung int not null foreign key references NguoiDung(IDNguoiDung),
   MatKhau varchar(20) ,
   TrangThai int 
   Primary key(IDTaiKhoan, Email)
)
GO

create table HoaDon
(
   IDHoaDon int identity(1,1) not null primary key,
   IDNguoiDung int not null foreign key references NguoiDung(IDNguoiDung),
   IDKhachHang int not null foreign key references KhachHang(IDKhachHang),
   NgayLapHoaDon date ,
   TongGiaTien float ,
   HinhThucThanhToan nvarchar(50),
   TrangThaiHoaDon int
)
GO

create table HoaDonChiTiet
(
   IDHoaDon int not null foreign key references HoaDon(IDHoaDon),
   IDCTSP int not null foreign key references ChiTietSanPham(IDCTSP),
   DonGia float ,
   SoLuong int ,
   TrangThai int ,
   Primary key(IDHoaDon, IDCTSP)
)
GO

--MauSac
insert into MauSac(MauSac) values(N'Trắng')
insert into MauSac(MauSac) values(N'Đen')
insert into MauSac(MauSac) values(N'Nâu')
insert into MauSac(MauSac) values(N'Nâu Sữa')
insert into MauSac(MauSac) values(N'Xanh Rêu')
insert into MauSac(MauSac) values(N'Xanh Biển')

--DonViTinh
insert into DonViTinh(DonViTinh) values(N'Bộ')
insert into DonViTinh(DonViTinh) values(N'Chiếc')

--ChatLieu
insert into ChatLieu(ChatLieuSP) values(N'Cotton')
insert into ChatLieu(ChatLieuSP) values(N'Jeans')
insert into ChatLieu(ChatLieuSP) values(N'KaKi')
insert into ChatLieu(ChatLieuSP) values(N'Len')
insert into ChatLieu(ChatLieuSP) values(N'Nỉ')
insert into ChatLieu(ChatLieuSP) values(N'Thô')

--GioiTinh
insert into GioiTinh(GioiTinh) values(N'Nam')
insert into GioiTinh(GioiTinh) values(N'Nữ')
insert into GioiTinh(GioiTinh) values(N'Unisex')

--KichCoSanPham
insert into KichCoSP(KichCo) values(N'S')
insert into KichCoSP(KichCo) values(N'M')
insert into KichCoSP(KichCo) values(N'L')
insert into KichCoSP(KichCo) values(N'XL')
insert into KichCoSP(KichCo) values(N'XXL')

--NhaSanXuat
insert into NhaSanXuat(TenNhaSX) values(N'Gucci')
insert into NhaSanXuat(TenNhaSX) values(N'Channel')
insert into NhaSanXuat(TenNhaSX) values(N'Yody')
insert into NhaSanXuat(TenNhaSX) values(N'Puma')
insert into NhaSanXuat(TenNhaSX) values(N'Adidas')
insert into NhaSanXuat(TenNhaSX) values(N'Nike')
insert into NhaSanXuat(TenNhaSX) values(N'Dior')

--DanhMucSanPham
insert into DanhMucSP(TenDanhMuc) values(N'Áo Phông')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Hoodie')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Phông')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Dài')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Len')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Khoác')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Sơ Mi')
insert into DanhMucSP(TenDanhMuc) values(N'Quần Đùi')
insert into DanhMucSP(TenDanhMuc) values(N'Quần Dài')


--SanPham
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(1, 1, N'Áo Phông Thời Trang Channel', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(2, 2, N'Áo Hoodie Channel', 1)

--ChiTietSanPham
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(1, 'SP01', 2, 1, 2, 5, 2, N'Demo mô tả', 250000, N'Demo tên chi tiết', 9, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 'SP02', 1, 2, 2, 5, 1, N'Demo mô tả', 200000, N'Demo tên chi tiết', 11, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 'SP03', 2, 1, 1, 1, 1, N'Demo mô tả', 200000, N'Demo tên chi tiết', 20, 1)

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
values(1, 2, 200000, 5, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(2, 1, 250000, 6, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(2, 2, 200000, 5, 1)

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



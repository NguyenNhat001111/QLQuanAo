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
   IDDanhMuc int foreign key references DanhMucSP(IDDanhMuc) on update cascade,
   IDNhaSanXuat int foreign key references NhaSanXuat(IDNhaSanXuat) on update cascade,
   TenSanPham nvarchar(50) ,
   TrangThai int 
)
GO

create table ChiTietSanPham
(
   IDCTSP int identity(1,1) not null primary key,
   MaSanPham varchar(20),
   IDSanPham int foreign key references SanPham(IDSanPham) on update cascade,
   IDKichCo int foreign key references KichCoSP(IDKichCo) on update cascade,
   IDMauSac int foreign key references MauSac(IDMauSac) on update cascade,
   IDDonViTinh int foreign key references DonViTinh(IDDonViTinh) on update cascade,
   IDChatLieu int foreign key references ChatLieu(IDChatLieu) on update cascade,
   IDGioiTinh int foreign key references GioiTinh(IDGioiTinh) on update cascade,
   MoTa nvarchar(200) ,
   GiaTien float ,
   TenChiTiet nvarchar(50),
   Soluong int,
   TrangThai int 
)
GO

create table KhuyenMai
(
   IDKhuyenMai int identity(1,1) not null primary key,
   TenKhuyenMai nvarchar(100),
   NgayBatDau date,
   NgayKetThuc date,
   DieuKienKhuyenMai nvarchar(50),
   GiaTriPhanTramKhuyenMai int,
   GiaTienKhuyenMai float
)
GO

create table ChiTietKhuyenMai
(
   IDCTKM int identity(1,1) not null primary key,
   IDCTSP int foreign key references ChiTietSanPham(IDCTSP) on update cascade,
   IDKhuyenMai int foreign key references KhuyenMai(IDKhuyenMai) on update cascade
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
   Email varchar(50) not null,
   IDNguoiDung int not null foreign key references NguoiDung(IDNguoiDung),
   MatKhau varchar(20) ,
   IDVaiTro int not null foreign key references VaiTro(IDVaiTro),
   TrangThai int 
   Primary key(IDTaiKhoan, Email)
)
GO

create table HoaDon
(
   IDHoaDon int identity(1,1) not null primary key,
   IDNguoiDung int not null foreign key references NguoiDung(IDNguoiDung),
   IDKhachHang int foreign key references KhachHang(IDKhachHang),
   NgayLapHoaDon date ,
   TongGiaTien float ,
   HinhThucThanhToan int,
   TrangThaiHoaDon int,
   BonusGiamGia float,
   GhiChu nvarchar(200)
)
GO

create table HoaDonChiTiet
(
   IDHoaDonChiTiet int identity(1,1) not null primary key, 
   IDHoaDon int not null foreign key references HoaDon(IDHoaDon) on update cascade,
   IDCTSP int not null foreign key references ChiTietSanPham(IDCTSP) on update cascade,
   DonGia float ,
   SoLuong int ,
   TrangThai int ,
   SoTienGiamGia float
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
values(1, 'SP1', 2, 1, 2, 5, 2, N'Demo mô tả', 250000, N'Áo Phông Channel Nữ Trắng', 9, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 'SP2', 1, 2, 2, 5, 1, N'Demo mô tả', 200000, N'Áo Hoodie Channel Nam Đen', 11, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 'SP3', 2, 1, 1, 1, 1, N'Demo mô tả', 200000, N'Áo Hoodie Channel Nam Trắng', 20, 1)

--Vaitro
insert into VaiTro values(0, N'ADMIN')
insert into VaiTro values(1, N'Nhân Viên')

--NguoiDung
insert into NguoiDung(HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(N'Lê Quân', '0392402083', N'Cầu Giấy - Hà Nội', '001202003794', 1)
insert into NguoiDung(HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(N'Nguyễn Văn Tèo', '0392458083', N'Láng Hạ - Hà Nội', '001202003794', 1)
insert into NguoiDung(HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(N'Nguyễn Văn Nam', '0396662083', N'Ba Đình - Hà Nội', '001201000794', 1)
insert into NguoiDung(HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(N'Nguyễn Minh Nhật', '0396668888', N'Cầu Giấy - Hà Nội', '001201002548', 1)
insert into NguoiDung(HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)
values(N'Nguyễn Phi Hưng', '0392402089', N'Hoài Đức - Hà Nội', '001201002548', 1)

--TaiKhoan
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, IDVaiTro, TrangThai)
values('lequan@gmail.com', 1, 'admin', 0, 1)
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, IDVaiTro, TrangThai)
values('vannamnguyen@gmail.com', 2, 'nhanvien1', 1, 1)
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, IDVaiTro, TrangThai)
values('teovan@gmail.com', 3, 'admin123', 0, 1)
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, IDVaiTro, TrangThai)
values('nguyenminhnhat@gmail.com', 4, 'nhanvien123', 1, 1)
insert into TaiKhoan(Email, IDNguoiDung, MatKhau, IDVaiTro, TrangThai)
values('phihung4598@gmail.com', 5, 'admin', 0, 1)

--KhachHang
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Minh Nhật', '0493676789', N'Hoàn Kiếm - Hà Nội', '001101000345')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Phí Công Lợi', '0493458389', N'Hoài Đức - Hà Nội', '001104573455')

--KhuyenMai
insert into KhuyenMai(TenKhuyenMai, NgayBatDau, NgayKetThuc, DieuKienKhuyenMai, GiaTriPhanTramKhuyenMai, GiaTienKhuyenMai) 
values(N'Black Friday', '11/25/2021', '11/30/2021', N'Áo thun', 30, 50000)
insert into KhuyenMai(TenKhuyenMai, NgayBatDau, NgayKetThuc, DieuKienKhuyenMai, GiaTriPhanTramKhuyenMai, GiaTienKhuyenMai) 
values(N'Black Tuesday', '11/14/2021', '11/16/2021', N'Áo Khoác', 40, null)
insert into KhuyenMai(TenKhuyenMai, NgayBatDau, NgayKetThuc, DieuKienKhuyenMai, GiaTriPhanTramKhuyenMai, GiaTienKhuyenMai) 
values(N'Black Sunday', '11/20/2021', '11/25/2021', N'Áo Dài Tay', 30, 100000)

--ChiTietKhuyenMai
insert into ChiTietKhuyenMai(IDCTSP, IDKhuyenMai) 
values(1, 2)
insert into ChiTietKhuyenMai(IDCTSP, IDKhuyenMai) 
values(2, 3)
insert into ChiTietKhuyenMai(IDCTSP, IDKhuyenMai) 
values(3, 1)

--HoaDon
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, BonusGiamGia, GhiChu, TrangThaiHoaDon)
values(2, 1, '9/11/2021', 1000000, 1, null, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, BonusGiamGia, GhiChu, TrangThaiHoaDon)
values(2, 2, '8/11/2021', 2500000, 2, null, null, 1)

--HoaDonChiTiet
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, SoTienGiamGia, TrangThai)
values(1, 2, 200000, 5, null, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, SoTienGiamGia, TrangThai)
values(2, 1, 250000, 6, null, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, SoTienGiamGia, TrangThai)
values(2, 2, 200000, 5, null, 1)

select * from MauSac
select * from DonViTinh
select * from ChatLieu
select * from GioiTinh
select * from KichCoSP
select * from NhaSanXuat
select * from DanhMucSP
select * from SanPham
select * from KhuyenMai
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

select MaSanPham, TenChiTiet, TenDanhMuc, ChatLieuSP, MauSac, KichCo, GioiTinh, TenNhaSX, GiaTien, Soluong from ChiTietSanPham
	inner join MauSac on MauSac.IDMauSac=ChiTietSanPham.IDMauSac
	inner join DonViTinh on DonViTinh.IDDonViTinh = ChiTietSanPham.IDDonViTinh
	inner join ChatLieu on ChatLieu.IDChatLieu=ChiTietSanPham.IDChatLieu
	inner join GioiTinh on GioiTinh.IDGioiTinh=ChiTietSanPham.IDgioiTinh
	inner join KichCoSP on KichCoSP.IDKichCo=ChiTietSanPham.IDKichCo
	inner join SanPham on ChiTietSanPham.IDSanPham=SanPham.IDSanPham
	inner join DanhMucSP on DanhMucSP.IDDanhMuc=SanPham.IDDanhMuc
	inner join NhaSanXuat on NhaSanXuat.IDNhaSanXuat=SanPham.IDNhaSanXuat


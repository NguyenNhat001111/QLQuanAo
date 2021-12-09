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
   TenChiTiet nvarchar(200),
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
   TrangThai int 
   
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
insert into ChatLieu(ChatLieuSP) values(N'Polyester')
insert into ChatLieu(ChatLieuSP) values(N'Dù')
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
insert into KichCoSP(KichCo) values(N'29')
insert into KichCoSP(KichCo) values(N'30')
insert into KichCoSP(KichCo) values(N'31')
insert into KichCoSP(KichCo) values(N'32')
insert into KichCoSP(KichCo) values(N'34')
insert into KichCoSP(KichCo) values(N'36')

--NhaSanXuat
insert into NhaSanXuat(TenNhaSX) values(N'Gucci')
insert into NhaSanXuat(TenNhaSX) values(N'Channel')
insert into NhaSanXuat(TenNhaSX) values(N'CoolMate')
insert into NhaSanXuat(TenNhaSX) values(N'Yody')
insert into NhaSanXuat(TenNhaSX) values(N'Puma')
insert into NhaSanXuat(TenNhaSX) values(N'Adidas')
insert into NhaSanXuat(TenNhaSX) values(N'Nike')
insert into NhaSanXuat(TenNhaSX) values(N'ManDo')
insert into NhaSanXuat(TenNhaSX) values(N'Dior')
insert into NhaSanXuat(TenNhaSX) values(N'Feaer')

--DanhMucSanPham
insert into DanhMucSP(TenDanhMuc) values(N'Áo Phông')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Hoodie')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Dài Tay')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Len')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Polo')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Phao')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Khoác')
insert into DanhMucSP(TenDanhMuc) values(N'Áo Sơ Mi')
insert into DanhMucSP(TenDanhMuc) values(N'Quần Đùi')
insert into DanhMucSP(TenDanhMuc) values(N'Quần Jean')


--SanPham
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(1, 1, N'Áo Phông Thời Trang Channel', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(2, null, N'Áo Hoodie ESSENTIALS', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(1, 3, N'Áo Phông Cotton', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(5, 3, N'Áo Polo CoolMax', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(3, 8, N'Áo Dài Tay ManDo', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(8, 8, N'Áo Sơ Mi Caro', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(7, 4, N'Áo phao nữ YODY', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(9, 10, N'Quần short nam', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(10, 10, N'Quần Jean nam', 1)
insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)
values(10, null, N'Quần Jean nữ', 1)

--ChiTietSanPham
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(1, 'SP1', 2, 1, 2, 5, 2, N'Áo Phông Channel chất liệu cotton thoáng mát', 250000, N'Áo Phông Channel Nữ Trắng', 9, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 'SP2', 1, 2, 2, 5, 3, N'Azila Viet Nam giới thiệu tới bạn mẫu áo Hoodie Nam Nữ ESSENTIALS form rộng thoải mái', 170000, N'Áo Hoodie Nam Nữ Azila Viet Nam ESSENTIALS Ulzzang', 11, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(2, 'SP3', 2, 1, 1, 5, 3, N'Azila Viet Nam giới thiệu tới bạn mẫu áo Hoodie Nam Nữ ESSENTIALS form rộng thoải mái', 170000, N'Áo Hoodie Nam Nữ Azila Viet Nam ESSENTIALS Ulzzang', 20, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(3, 'SP4', 3, 2, 2, 1, 1, N'Áo phông nam Cotton Compact phiên bản Premium chống nhăn Coolmate', 150000, N'Áo phông nam Cotton Compact', 134, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(4, 'SP5', 3, 1, 2, 1, 1, N'Chất Liệu vải Cotton, Form áo và dáng cổ có viền kẻ sọc', 200000, N'Áo Polo nam Coolmax làm mát tối đa thương hiệu Coolmate', 150, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(4, 'SP6', 3, 5, 2, 1, 1, N'Chất Liệu vải Cotton, Form áo và dáng cổ có viền kẻ sọc', 200000, N'Áo Polo nam Coolmax làm mát tối đa thương hiệu Coolmate', 90, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(5, 'SP7', 4, 1, 2, 5, 3, N'Áo Thun Nỉ Dài Tay Cổ 3 Phân Nam Unisex Form Rộng Trơn Basic Phong Cách Hàn Quốc MANDO', 200000, N'Áo Thun Nỉ Dài Tay Cổ 3 Phân MANDO', 67, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(6, 'SP8', 3, 4, 2, 1, 1, N'Sản xuất tại việt nam, form dáng sơ mi Hàn Quốc', 190000, N'Áo sơ mi caro phong cách Hàn Quốc', 18, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(6, 'SP9', 3, 5, 2, 1, 1, N'Sản xuất tại việt nam, form dáng sơ mi Hàn Quốc', 190000, N'Áo sơ mi caro phong cách Hàn Quốc', 18, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(7, 'SP10', 1, 2, 2, 6, 2, N'Áo Phao YODY chất liệu polyester', 500000, N'Áo phao nữ YODY siêu nhẹ có mũ siêu ấm', 24, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(7, 'SP11', 2, 4, 2, 6, 2, N'Áo Phao YODY chất liệu polyester', 500000, N'Áo phao nữ YODY siêu nhẹ có mũ siêu ấm', 15, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(7, 'SP12', 3, 6, 2, 6, 2, N'Áo Phao YODY chất liệu polyester', 500000, N'Áo phao nữ YODY siêu nhẹ có mũ siêu ấm', 7, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(8, 'SP13', 1, 2, 2, 7, 1, N'Quần short nam ngắn họa tiết Dri Fit 100% chất dù si thoáng mát', 119000, N'Quần short nam ngắn họa tiết Dri Fit', 3, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(8, 'SP14', 2, 2, 2, 7, 1, N'Quần short nam ngắn họa tiết Dri Fit 100% chất dù si thoáng mát', 119000, N'Quần short nam ngắn họa tiết Dri Fit', 5, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(9, 'SP15', 6, 2, 2, 1, 1, N'Quần jean nam FEAER DENIM chất co dãn thoáng khí vải bền bỉ', 429000, N'Quần jean nam FEAER DENIM', 7, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(9, 'SP16', 7, 2, 2, 1, 1, N'Quần jean nam FEAER DENIM chất co dãn thoáng khí vải bền bỉ', 429000, N'Quần jean nam FEAER DENIM', 6, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(9, 'SP17', 8, 6, 2, 1, 1, N'Quần jean nam FEAER DENIM chất co dãn thoáng khí vải bền bỉ', 429000, N'Quần jean nam FEAER DENIM', 9, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(10, 'SP18', 6, 6, 2, 1, 2, N'Quần Jean Nữ Lưng Cao Skinny Tôn Dáng Có Nhiều Màu Aaa Jeans', 289000, N'Quần Jean Nữ Lưng Cao Skinny', 15, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(10, 'SP19', 7, 6, 2, 1, 2, N'Quần Jean Nữ Lưng Cao Skinny Tôn Dáng Có Nhiều Màu Aaa Jeans', 289000, N'Quần Jean Nữ Lưng Cao Skinny', 5, 1)
insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong,TrangThai)
values(10, 'SP20', 8, 6, 2, 1, 2, N'Quần Jean Nữ Lưng Cao Skinny Tôn Dáng Có Nhiều Màu Aaa Jeans', 289000, N'Quần Jean Nữ Lưng Cao Skinny', 7, 1)

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
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Trần An', '0493458390', N'Hoài Đức - Hà Nội', '001104573456')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Phùng Văn Khánh', '0493458391', N'Hoài Đức - Hà Nội', '001104573457')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Thị Nhàn', '0493458392', N'Hoài Đức - Hà Nội', '001104573458')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Bá Công', '0493458393', N'Mai Dịch - Hà Nội', '001104573459')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Thiên Quân', '0493458400', N'Hoài Đức - Hà Nội', '001104573460')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Phùng Kim Tú', '0493458401', N'Hoài Đức - Hà Nội', '001104573461')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Duy Tuấn', '0493458402', N'Hoài Đức - Hà Nội', '001104573462')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Tiến Phát', '0493458403', N'Hoài Đức - Hà Nội', '001104573463')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Hoành Sang', '0493458404', N'Hoài Đức - Hà Nội', '001104573464')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Việt Quang', '0493458405', N'Hoài Đức - Hà Nội', '001104573465')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Đỗ Xuân Huy', '0493458406', N'Hoài Đức - Hà Nội', '001104573466')
insert into KhachHang(HoTenKH, SDT, DiaChi, CCCD)
values(N'Nguyễn Thu Nga', '0493458407', N'Hoài Đức - Hà Nội', '001104573467')

--HoaDon
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 1, '10/24/2021', 1000000, 1, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 2, '10/27/2021', 2500000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 3, '11/1/2021', 500000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 4, '11/3/2021', 619000, 1, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 5, '11/6/2021', 1120000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 6, '11/8/2021', 578000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 7, '11/14/2021', 638000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 8, '11/17/2021', 1000000, 1, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 9, '11/18/2021', 570000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 10, '11/18/2021', 1229000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 11, '11/18/2021', 850000, 1, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 12, '11/19/2021', 1248000, 1, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 13, '11/19/2021', 1000000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 14, '11/19/2021', 289000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 5, '11/20/2021', 238000, 1, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 7, '11/20/2021', 600000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 9, '11/20/2021', 700000, 1, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 3, '11/20/2021', 1200000, 2, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 8, '11/21/2021', 190000, 1, null, 1)
insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, GhiChu, TrangThaiHoaDon)
values(2, 12, '11/21/2021', 250000, 2, null, 1)


--HoaDonChiTiet
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(1, 2, 200000, 5, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(2, 1, 250000, 6, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(2, 2, 200000, 5, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(3, 10, 500000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(4, 16, 429000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(4, 8, 190000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(5, 1, 250000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(5, 2, 170000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(5, 11, 500000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(5, 5, 200000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(6, 18, 289000, 2, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(7, 5, 200000, 2, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(7, 14, 119000, 2, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(8, 12, 500000, 2, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(9, 8, 190000, 3, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(10, 6, 200000, 4, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(10, 16, 429000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(11, 3, 170000, 5, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(12, 12, 500000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(12, 16, 429000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(12, 7, 200000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(12, 14, 119000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(13, 1, 200000, 5, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(14, 19, 289000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(15, 14, 119000, 2, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(16, 5, 200000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(16, 1, 250000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(16, 4, 150000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(17, 10, 500000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(17, 6, 200000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(18, 5, 200000, 6, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(19, 9, 190000, 1, 1)
insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)
values(20, 1, 250000, 1, 1)

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

select MaSanPham, TenChiTiet, TenDanhMuc, ChatLieuSP, MauSac, KichCo, GioiTinh, TenNhaSX, GiaTien, Soluong from ChiTietSanPham
	inner join MauSac on MauSac.IDMauSac=ChiTietSanPham.IDMauSac
	inner join DonViTinh on DonViTinh.IDDonViTinh = ChiTietSanPham.IDDonViTinh
	inner join ChatLieu on ChatLieu.IDChatLieu=ChiTietSanPham.IDChatLieu
	inner join GioiTinh on GioiTinh.IDGioiTinh=ChiTietSanPham.IDgioiTinh
	inner join KichCoSP on KichCoSP.IDKichCo=ChiTietSanPham.IDKichCo
	inner join SanPham on ChiTietSanPham.IDSanPham=SanPham.IDSanPham
	inner join DanhMucSP on DanhMucSP.IDDanhMuc=SanPham.IDDanhMuc
	inner join NhaSanXuat on NhaSanXuat.IDNhaSanXuat=SanPham.IDNhaSanXuat

-- THỦ TỤC THỐNG KÊ
IF OBJECT_ID('sp_ThongKe') IS NOT NULL 
	DROP PROC sp_ThongKe
GO 
CREATE PROC sp_ThongKe
AS BEGIN
	select
		MAX(NgayLapHoaDon) Thoigian,
		Sum(HoaDonChiTiet.IDCTSP) SanPham,
		Sum(HoaDonChiTiet.SoLuong) SoLuong,
		Sum(TongGiaTien) Doanhthu 
	from KhachHang
		join HoaDon on KhachHang.IDKhachHang=HoaDon.IDKhachHang
		join HoaDonChiTiet on HoaDon.IDHoaDon=HoaDonChiTiet.IDHoaDon
		GROUP BY HoaDon.IDHoaDon
		ORDER BY HoaDon.IDHoaDon ASC
END

--- gửi email 
IF OBJECT_ID('sp_guiemail') IS NOT NULL 
	DROP PROC sp_guiemail
GO 
CREATE PROC sp_guiemail
AS BEGIN
select 
	Email email
	From TaiKhoan
	WHERE IDVaiTro = 0
	GROUP BY Email
END
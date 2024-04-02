--> Cau 1
select * from NhanVien
--> Cau 2
select * from NhanVien
where hoten like N'Nguyen %'

--> Cau 3
select sum(hsl) / count(hsl) 'TBC' from NhanVien

--> Cau 4
insert into Nhanvien (manv,hoten,gioitinh,ngaysinh,hsl,email,sodt)
values ('nv5','Cho','1','05/06/2004',3.5,'ex5@gmail.com','09252525254')

--> Cau 5
delete NhanVien
where manv = 'nv1'

--> Cau 6
update Nhanvien
set hsl = hsl + 2
where manv = 'nv2'
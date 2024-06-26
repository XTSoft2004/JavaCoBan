USE [Nhom1]
GO
/****** Object:  Table [dbo].[Nhanvien]    Script Date: 4/2/2024 11:54:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nhanvien](
	[manv] [nvarchar](50) NOT NULL,
	[hoten] [nvarchar](50) NULL,
	[gioitinh] [bit] NULL,
	[ngaysinh] [date] NULL,
	[hsl] [float] NULL,
	[email] [nvarchar](50) NULL,
	[sodt] [nvarchar](50) NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[manv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Nhanvien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [sodt]) VALUES (N'nv1', N'Hoàng Bảo Khánh', 1, CAST(N'2004-11-15' AS Date), 6.9, N'Hbkhanh0706@gmail.com', N'0911544246')
INSERT [dbo].[Nhanvien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [sodt]) VALUES (N'nv2', N'Lê Nguyễn Gia Hân', 0, CAST(N'2004-11-15' AS Date), 5, N'lenguyengiahan@gmail.com', N'123455667')
INSERT [dbo].[Nhanvien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [sodt]) VALUES (N'nv3', N'Nguyễn Khánh Linh', 0, CAST(N'2004-11-15' AS Date), 3, N'lenguyengiahan@gmail.com', N'1234556789')
INSERT [dbo].[Nhanvien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [sodt]) VALUES (N'nv5', N'Bạch Thị Thiện Thanh', 0, CAST(N'2004-11-15' AS Date), 3, N'lenguyengiahan@gmail.com', NULL)
INSERT [dbo].[Nhanvien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [sodt]) VALUES (N'nv6', N'Hoàng Bảo Khoa', 1, CAST(N'2004-11-15' AS Date), 2, N'hbkhoa1511@gmail.com', N'090520677')
INSERT [dbo].[Nhanvien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [sodt]) VALUES (N'nv7', N'Hoàng Bảo Khánh', 1, CAST(N'2004-11-15' AS Date), 3.4, N'Hbkhanh0706@gmail.com', N'0911544246')

USE [QuanLyBanHang]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/9/2024 2:12:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[idUser] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[fullname] [nvarchar](100) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[idUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 4/9/2024 2:12:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[machitiet] [int] IDENTITY(1,1) NOT NULL,
	[mahoadon] [int] NOT NULL,
	[mahang] [nvarchar](50) NOT NULL,
	[soluongmua] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[machitiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/9/2024 2:12:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[mahoadon] [int] IDENTITY(1,1) NOT NULL,
	[ngaytaohoadon] [datetime] NOT NULL,
	[idUser] [int] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[mahoadon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MatHang]    Script Date: 4/9/2024 2:12:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MatHang](
	[mahang] [nvarchar](50) NOT NULL,
	[tenhang] [nvarchar](100) NOT NULL,
	[ngaynhaphang] [date] NOT NULL,
	[soluong] [int] NOT NULL,
	[gia] [money] NOT NULL,
 CONSTRAINT [PK_MatHang] PRIMARY KEY CLUSTERED 
(
	[mahang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([idUser], [username], [password], [fullname]) VALUES (1, N'admin', N'1', N'Xuân Trường')
INSERT [dbo].[Account] ([idUser], [username], [password], [fullname]) VALUES (2, N'a', N'b', N'c')
INSERT [dbo].[Account] ([idUser], [username], [password], [fullname]) VALUES (3, N'xuantruong23', N'123', N'Xuan Truong Demo')
SET IDENTITY_INSERT [dbo].[Account] OFF
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([machitiet], [mahoadon], [mahang], [soluongmua]) VALUES (35, 16, N'MH002', 20)
INSERT [dbo].[ChiTietHoaDon] ([machitiet], [mahoadon], [mahang], [soluongmua]) VALUES (36, 16, N'MH005', 1)
INSERT [dbo].[ChiTietHoaDon] ([machitiet], [mahoadon], [mahang], [soluongmua]) VALUES (37, 16, N'MH010', 5)
INSERT [dbo].[ChiTietHoaDon] ([machitiet], [mahoadon], [mahang], [soluongmua]) VALUES (38, 17, N'MH008', 10)
INSERT [dbo].[ChiTietHoaDon] ([machitiet], [mahoadon], [mahang], [soluongmua]) VALUES (39, 17, N'MH009', 5)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (9, CAST(N'2024-04-09 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (10, CAST(N'2024-04-09 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (11, CAST(N'2024-04-10 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (12, CAST(N'2024-04-09 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (13, CAST(N'2024-04-09 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (14, CAST(N'2024-04-09 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (15, CAST(N'2024-04-09 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (16, CAST(N'2024-04-09 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (17, CAST(N'2024-04-09 00:00:00.000' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH001', N'Bút bi', CAST(N'2024-04-01' AS Date), 100, 50.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH002', N'Sách vở', CAST(N'2024-03-31' AS Date), 30, 200.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH003', N'Máy tính', CAST(N'2024-04-03' AS Date), 10, 1500.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH004', N'Điện thoại di động', CAST(N'2024-04-04' AS Date), 20, 8000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH005', N'Bàn làm việc', CAST(N'2024-04-03' AS Date), 4, 500.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH006', N'Máy in', CAST(N'2024-04-06' AS Date), 8, 300.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH007', N'Quần áo', CAST(N'2024-04-07' AS Date), 30, 1000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH008', N'Giày dép', CAST(N'2024-04-06' AS Date), 30, 700.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH009', N'Áo khoác', CAST(N'2024-04-07' AS Date), 10, 200.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH010', N'Đèn bàn', CAST(N'2024-04-08' AS Date), 7, 2500.0000)
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([mahoadon])
REFERENCES [dbo].[HoaDon] ([mahoadon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_MatHang] FOREIGN KEY([mahang])
REFERENCES [dbo].[MatHang] ([mahang])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_MatHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Account1] FOREIGN KEY([idUser])
REFERENCES [dbo].[Account] ([idUser])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Account1]
GO

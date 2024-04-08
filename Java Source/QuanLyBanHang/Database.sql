USE [QuanLyBanHang]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/8/2024 1:52:12 PM ******/
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
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 4/8/2024 1:52:12 PM ******/
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/8/2024 1:52:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[mahoadon] [int] IDENTITY(1,1) NOT NULL,
	[ngaytaohoadon] [date] NOT NULL,
	[idUser] [int] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[mahoadon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MatHang]    Script Date: 4/8/2024 1:52:12 PM ******/
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
SET IDENTITY_INSERT [dbo].[Account] OFF
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([machitiet], [mahoadon], [mahang], [soluongmua]) VALUES (1, 1, N'MH004', 2)
INSERT [dbo].[ChiTietHoaDon] ([machitiet], [mahoadon], [mahang], [soluongmua]) VALUES (2, 1, N'MH008', 5)
INSERT [dbo].[ChiTietHoaDon] ([machitiet], [mahoadon], [mahang], [soluongmua]) VALUES (3, 1, N'abc', 10)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([mahoadon], [ngaytaohoadon], [idUser]) VALUES (1, CAST(N'2024-04-08' AS Date), 1)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'abc', N'abc', CAST(N'2004-12-22' AS Date), 2, 3.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH001', N'Bút bi', CAST(N'2024-04-01' AS Date), 100, 5000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH002', N'Sách vở', CAST(N'2024-04-02' AS Date), 50, 20000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH003', N'MH003', CAST(N'2024-04-01' AS Date), 10, 100.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH004', N'Điện thoại di động', CAST(N'2024-04-04' AS Date), 20, 8000000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH005', N'Bàn làm việc', CAST(N'2024-04-05' AS Date), 5, 5000000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH006', N'Máy in', CAST(N'2024-04-06' AS Date), 8, 3000000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH007', N'Quần áo', CAST(N'2024-04-07' AS Date), 30, 1000000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH008', N'Giày dép', CAST(N'2024-04-08' AS Date), 40, 700000.0000)
INSERT [dbo].[MatHang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'MH010', N'Đèn bàn', CAST(N'2024-04-10' AS Date), 12, 250000.0000)
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

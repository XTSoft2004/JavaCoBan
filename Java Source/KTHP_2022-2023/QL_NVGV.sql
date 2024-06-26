USE [QL_NVGV]
GO
/****** Object:  Table [dbo].[GiangVien]    Script Date: 6/3/2024 3:03:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiangVien](
	[maGV] [nvarchar](50) NOT NULL,
	[HovaTen] [nvarchar](50) NULL,
	[LoaiHopDong] [nvarchar](50) NULL,
	[HeSoLuong] [float] NULL,
	[PhuCap] [float] NULL,
 CONSTRAINT [PK_GiangVien] PRIMARY KEY CLUSTERED 
(
	[maGV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Nhanvien]    Script Date: 6/3/2024 3:03:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nhanvien](
	[maNV] [nvarchar](50) NOT NULL,
	[HovaTen] [nvarchar](50) NULL,
	[LoaiHopDong] [nvarchar](50) NULL,
	[HeSoLuong] [float] NULL,
 CONSTRAINT [PK_Nhanvien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[GiangVien] ([maGV], [HovaTen], [LoaiHopDong], [HeSoLuong], [PhuCap]) VALUES (N'gv1', N'Le Van A', N'chinhthuc', 3, 100000)
INSERT [dbo].[GiangVien] ([maGV], [HovaTen], [LoaiHopDong], [HeSoLuong], [PhuCap]) VALUES (N'gv2', N'Hoang Thi B', N'hopdong', 3, 50000)
INSERT [dbo].[Nhanvien] ([maNV], [HovaTen], [LoaiHopDong], [HeSoLuong]) VALUES (N'nv1', N'Nguyen Van A', N'chinhthuc', 5.5)
INSERT [dbo].[Nhanvien] ([maNV], [HovaTen], [LoaiHopDong], [HeSoLuong]) VALUES (N'nv2', N'Nguyen Van B', N'chinhthuc', 4)
INSERT [dbo].[Nhanvien] ([maNV], [HovaTen], [LoaiHopDong], [HeSoLuong]) VALUES (N'nv3', N'Nguyen Thi C', N'hopdong', 2.5)
INSERT [dbo].[Nhanvien] ([maNV], [HovaTen], [LoaiHopDong], [HeSoLuong]) VALUES (N'nv4', N'Nguyen Van D', N'khonghople', 2.5)
INSERT [dbo].[Nhanvien] ([maNV], [HovaTen], [LoaiHopDong], [HeSoLuong]) VALUES (N'nv5', N'Nguyen Van E', N'chinhthuc', 3.5)

USE [QLCuaHangDT]
GO
/****** Object:  Table [dbo].[DiDong]    Script Date: 6/4/2024 12:04:05 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiDong](
	[maDT] [nvarchar](50) NOT NULL,
	[tenDT] [nvarchar](50) NULL,
	[HangSanXuat] [nvarchar](50) NULL,
	[Gia] [float] NULL,
	[MauSac] [nvarchar](50) NULL,
	[NgayHetHan] [datetime] NULL,
	[DLBoNho] [nvarchar](50) NULL,
 CONSTRAINT [PK_DiDong] PRIMARY KEY CLUSTERED 
(
	[maDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DTCD]    Script Date: 6/4/2024 12:04:05 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DTCD](
	[maDT] [nvarchar](50) NOT NULL,
	[tenDT] [nvarchar](50) NULL,
	[HangSX] [nvarchar](50) NULL,
	[Gia] [float] NULL,
	[Mausac] [nvarchar](50) NULL,
 CONSTRAINT [PK_DTCD] PRIMARY KEY CLUSTERED 
(
	[maDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DTDT]    Script Date: 6/4/2024 12:04:05 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DTDT](
	[maDT] [nvarchar](50) NOT NULL,
	[tenDT] [nvarchar](50) NULL,
	[HangSanXuat] [nvarchar](50) NULL,
	[Gia] [float] NULL,
	[NgayHetHan] [datetime] NULL,
	[DLBoNho] [nvarchar](50) NULL,
 CONSTRAINT [PK_DTDT] PRIMARY KEY CLUSTERED 
(
	[maDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[DiDong] ([maDT], [tenDT], [HangSanXuat], [Gia], [MauSac], [NgayHetHan], [DLBoNho]) VALUES (N'CD0001', N'Vsmart Pro', N'Vsmart', 50, NULL, CAST(N'2024-03-10 00:00:00.000' AS DateTime), N'128 GB')
INSERT [dbo].[DiDong] ([maDT], [tenDT], [HangSanXuat], [Gia], [MauSac], [NgayHetHan], [DLBoNho]) VALUES (N'CD0002', N'Vsmart Pro 1', N'Vsmart', 1550, NULL, CAST(N'2024-03-15 00:00:00.000' AS DateTime), N'64 GB')
INSERT [dbo].[DiDong] ([maDT], [tenDT], [HangSanXuat], [Gia], [MauSac], [NgayHetHan], [DLBoNho]) VALUES (N'CD0003', N'Vsmart Pro 3', N'Vsmart', 10, NULL, CAST(N'2024-03-05 00:00:00.000' AS DateTime), N'64 GB')

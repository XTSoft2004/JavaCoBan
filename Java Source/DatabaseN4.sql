USE [Nhom4]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 3/26/2024 11:01:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[manv] [nvarchar](50) NOT NULL,
	[hoten] [nvarchar](50) NULL,
	[gioitinh] [bit] NULL,
	[ngaysinh] [date] NULL,
	[hsl] [float] NULL,
	[email] [nvarchar](50) NULL,
	[sodt] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[manv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [sodt]) VALUES (N'nv3', N'Nguyen Ga', 0, CAST(N'2004-01-06' AS Date), 2, N'ex2@gmail.com', N'0925252252')
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [sodt]) VALUES (N'nv4', N'Vit', 1, CAST(N'2004-02-03' AS Date), 5, N'ex3@gmail.com', N'0225252525')

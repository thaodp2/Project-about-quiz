USE [online_quiz_2]
GO
/****** Object:  Table [dbo].[answer]    Script Date: 27/7/2021 4:02:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[answer](
	[questionId] [int] NOT NULL,
	[answer] [nvarchar](max) NOT NULL,
	[isTrue] [bit] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_answer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[question]    Script Date: 27/7/2021 4:02:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [nvarchar](max) NOT NULL,
	[dateCreate] [date] NOT NULL,
 CONSTRAINT [PK_question] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[resultTest]    Script Date: 27/7/2021 4:02:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[resultTest](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[uId] [int] NULL,
	[mark] [float] NULL,
	[startTime] [datetime] NULL,
	[endTime] [datetime] NULL,
	[isPassed] [bit] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 27/7/2021 4:02:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[isTeacher] [bit] NOT NULL,
	[email] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[answer] ON 

INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (6, N'6', 1, 12)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (6, N'5', 0, 13)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (6, N'4', 0, 14)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (6, N'3', 0, 15)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (26, N'123', 0, 89)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (26, N'195', 1, 90)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (26, N'111', 0, 91)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (26, N'121', 0, 92)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (27, N'Because it is enjoy', 0, 93)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (27, N'I don''t know', 0, 94)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (27, N'Because it is enough', 0, 95)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (27, N'Because it is the beginning of', 1, 96)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (28, N'In your house', 0, 97)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (28, N'In the dictionary', 1, 98)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (28, N'In my heart', 0, 99)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (28, N'In your wallet', 0, 100)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (29, N'Hand', 0, 101)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (29, N'Robot', 0, 102)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (29, N'Armchair', 1, 103)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (29, N'Phone', 0, 104)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (30, N'1', 1, 105)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (30, N'2', 0, 106)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (30, N'3', 0, 107)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (30, N'4', 0, 108)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (31, N'3', 0, 109)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (31, N'2', 0, 110)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (31, N'1', 0, 111)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (31, N'16', 1, 112)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (32, N'30', 1, 113)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (32, N'1', 0, 114)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (32, N'12', 0, 115)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (32, N'111', 0, 116)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (33, N'3', 0, 117)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (33, N'4', 0, 118)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (33, N'5', 0, 119)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (33, N'6', 1, 120)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (34, N'44', 1, 121)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (34, N'33', 0, 122)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (34, N'11', 0, 123)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (34, N'55', 0, 124)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (35, N'1', 1, 125)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (35, N'2', 0, 126)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (35, N'3', 0, 127)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (35, N'5', 0, 128)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (36, N'1', 1, 129)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (36, N'2', 0, 130)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (36, N'3', 0, 131)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (36, N'4', 0, 132)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (37, N'1', 1, 133)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (37, N'2', 0, 134)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (37, N'3', 0, 135)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (37, N'4', 0, 136)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (38, N'1', 1, 137)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (38, N'3', 0, 138)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (38, N'', 0, 139)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (38, N'', 0, 140)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (39, N'', 1, 141)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (39, N'', 0, 142)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (39, N'', 0, 143)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (39, N'4', 0, 144)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (40, N'2', 1, 145)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (40, N'2', 0, 146)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (40, N'3', 0, 147)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (40, N'4', 0, 148)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (41, N'mot', 0, 149)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (41, N'hai', 1, 150)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (41, N'ba', 0, 151)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (41, N'1', 0, 152)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (42, N'mot', 1, 153)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (42, N'hai', 0, 154)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (42, N'ba', 0, 155)
INSERT [dbo].[answer] ([questionId], [answer], [isTrue], [id]) VALUES (42, N'bon', 0, 156)
SET IDENTITY_INSERT [dbo].[answer] OFF
GO
SET IDENTITY_INSERT [dbo].[question] ON 

INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (6, N'3*3', CAST(N'2020-04-04' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (26, N'mot the ky co bao nhieu nam', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (27, N'5+5', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (28, N'123+123', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (29, N'test review tach bang option 1', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (30, N'test filnal', CAST(N'2021-07-24' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (31, N'test input commingggg', CAST(N'2021-07-25' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (32, N'out', CAST(N'2021-07-25' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (33, N'bang chu cai co bao nhieu so?', CAST(N'2021-07-25' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (34, N'out test', CAST(N'2021-07-26' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (35, N'test quiz option 1 ??', CAST(N'2021-07-27' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (36, N'out test question choice option 1', CAST(N'2021-07-27' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (37, N'test op tion 1', CAST(N'2021-07-27' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (38, N'test tach bang', CAST(N'2021-07-27' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (39, N'test commming', CAST(N'2021-07-27' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (40, N'test review tach bangggg 2', CAST(N'2021-07-27' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (41, N'test tach bang 2222', CAST(N'2021-07-27' AS Date))
INSERT [dbo].[question] ([id], [question], [dateCreate]) VALUES (42, N'test nuumber', CAST(N'2021-07-27' AS Date))
SET IDENTITY_INSERT [dbo].[question] OFF
GO
SET IDENTITY_INSERT [dbo].[resultTest] ON 

INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (1, 1, 3.3, CAST(N'2021-07-23T13:19:31.000' AS DateTime), CAST(N'2021-07-23T13:19:39.000' AS DateTime), 0)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (2, 1, 3.3, CAST(N'2021-07-23T13:19:31.000' AS DateTime), CAST(N'2021-07-23T13:19:39.000' AS DateTime), 0)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (3, 33, 6.7, CAST(N'2021-07-25T22:35:45.000' AS DateTime), CAST(N'2021-07-25T22:35:58.000' AS DateTime), 1)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (4, 33, 6.7, CAST(N'2021-07-25T22:35:45.000' AS DateTime), CAST(N'2021-07-25T22:35:58.000' AS DateTime), 1)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (5, 33, 6.7, CAST(N'2021-07-25T22:51:15.000' AS DateTime), CAST(N'2021-07-25T22:51:22.000' AS DateTime), 1)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (6, 33, 6.7, CAST(N'2021-07-25T22:51:15.000' AS DateTime), CAST(N'2021-07-25T22:51:22.000' AS DateTime), 1)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (7, 33, 0, CAST(N'2021-07-25T22:51:27.000' AS DateTime), CAST(N'2021-07-25T22:51:33.000' AS DateTime), 0)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (8, 33, 0, CAST(N'2021-07-25T22:51:27.000' AS DateTime), CAST(N'2021-07-25T22:51:33.000' AS DateTime), 0)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (9, 33, 10, CAST(N'2021-07-25T22:53:04.000' AS DateTime), CAST(N'2021-07-25T22:53:09.000' AS DateTime), 1)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (10, 33, 10, CAST(N'2021-07-25T22:53:04.000' AS DateTime), CAST(N'2021-07-25T22:53:09.000' AS DateTime), 1)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (11, 33, 10, CAST(N'2021-07-25T22:57:11.000' AS DateTime), CAST(N'2021-07-25T22:57:17.000' AS DateTime), 1)
INSERT [dbo].[resultTest] ([id], [uId], [mark], [startTime], [endTime], [isPassed]) VALUES (12, 33, 0, CAST(N'2021-07-27T15:39:40.000' AS DateTime), CAST(N'2021-07-27T15:39:51.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[resultTest] OFF
GO
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([id], [username], [password], [isTeacher], [email]) VALUES (1, N'thaodp', N'123456', 0, N'thaodphe141294@fpt.edu.vn')
INSERT [dbo].[user] ([id], [username], [password], [isTeacher], [email]) VALUES (33, N'thaoPhuong', N'123456', 1, N'thaodp@gmail.com')
INSERT [dbo].[user] ([id], [username], [password], [isTeacher], [email]) VALUES (34, N'thao123', N'123456', 1, N'thaodp@gmail.com')
INSERT [dbo].[user] ([id], [username], [password], [isTeacher], [email]) VALUES (35, N'thao111', N'123456', 1, N'thaodp@gmail.com')
SET IDENTITY_INSERT [dbo].[user] OFF
GO

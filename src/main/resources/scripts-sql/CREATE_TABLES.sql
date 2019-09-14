IF OBJECT_ID('[dbo].[TB_BOOKING]', 'U') IS NOT NULL
DROP TABLE [dbo].[TB_BOOKING]
GO

CREATE TABLE [dbo].[TB_BOOKING]
(
    [BOOKING_CD] INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    [RESOURCE_CD] INT NOT NULL,
    [USER_CD] INT NOT NULL,
    [BEGIN_HR] DATETIME NOT NULL,
    [END_HR] DATETIME NOT NULL,
    [STATUS_CD] INT NOT NULL DEFAULT 1
);
GO


IF OBJECT_ID('[dbo].[TB_RESOURCE]', 'U') IS NOT NULL
DROP TABLE [dbo].[TB_RESOURCE]
GO

CREATE TABLE [dbo].[TB_RESOURCE]
(
    [RESOURCE_CD] INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    [RESOURCE_NM] NVARCHAR(300) NOT NULL
);
GO


IF OBJECT_ID('[dbo].[TB_USER]', 'U') IS NOT NULL
DROP TABLE [dbo].[TB_USER]
GO

CREATE TABLE [dbo].[TB_USER]
(
    [USER_CD] INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    [USER_NM] NVARCHAR(300) NOT NULL
);
GO


ALTER TABLE [dbo].[TB_BOOKING]
ADD CONSTRAINT FK_RESOURCE_CD FOREIGN KEY([RESOURCE_CD]) REFERENCES [dbo].[TB_RESOURCE];


ALTER TABLE [dbo].[TB_BOOKING]
ADD CONSTRAINT FK_USER_CD FOREIGN KEY([USER_CD]) REFERENCES [dbo].[TB_USER];

ALTER TABLE [dbo].[TB_BOOKING]
ADD CONSTRAINT CK_STATUS_CD CHECK([STATUS_CD] IN (1, 2, 3)) -- 1 = ATIVO, 2 = CONCLUIDO, 3 = CANCELADO
-- Create a new stored procedure called 'PR_BOOKING_LIST_BY_DATE' in schema 'dbo'
-- Drop the stored procedure if it already exists
IF EXISTS (
SELECT *
    FROM INFORMATION_SCHEMA.ROUTINES
WHERE SPECIFIC_SCHEMA = N'dbo'
    AND SPECIFIC_NAME = N'PR_BOOKING_LIST_BY_DATE'
    AND ROUTINE_TYPE = N'PROCEDURE'
)
DROP PROCEDURE dbo.PR_BOOKING_LIST_BY_DATE
GO
-- Create the stored procedure in the specified schema
CREATE PROCEDURE dbo.PR_BOOKING_LIST_BY_DATE
    @dataAgendamento DATETIME
-- add more stored procedure parameters here
AS

    SELECT AG.BOOKING_CD,
        SL.RESOURCE_CD,
        SL.RESOURCE_NM,
        US.USER_CD,
        US.USER_NM,
        AG.BEGIN_HR,
        AG.END_HR FROM TB_BOOKING AG

    INNER JOIN TB_RESOURCE SL
            ON AG.RESOURCE_CD = SL.RESOURCE_CD

    INNER JOIN TB_USER US
            ON AG.USER_CD = US.USER_CD

    WHERE DATEPART(DAY, AG.BEGIN_HR) = DATEPART(DAY, @dataAgendamento)
    AND DATEPART(MONTH, AG.BEGIN_HR) = DATEPART(MONTH, @dataAgendamento)
    AND DATEPART(YEAR, AG.BEGIN_HR) = DATEPART(YEAR, @dataAgendamento)
GO

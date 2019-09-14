-- Create a new stored procedure called 'PR_USER_LIST' in schema 'dbo'
-- Drop the stored procedure if it already exists
IF EXISTS (
SELECT *
    FROM INFORMATION_SCHEMA.ROUTINES
WHERE SPECIFIC_SCHEMA = N'dbo'
    AND SPECIFIC_NAME = N'PR_USER_LIST'
    AND ROUTINE_TYPE = N'PROCEDURE'
)
DROP PROCEDURE dbo.PR_USER_LIST
GO
-- Create the stored procedure in the specified schema
CREATE PROCEDURE dbo.PR_USER_LIST
AS
    -- body of the stored procedure
    SELECT USER_CD, USER_NM FROM TB_USER
GO

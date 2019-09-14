-- Create a new stored procedure called 'PR_RESOURCE_LIST' in schema 'dbo'
-- Drop the stored procedure if it already exists
IF EXISTS (
SELECT *
    FROM INFORMATION_SCHEMA.ROUTINES
WHERE SPECIFIC_SCHEMA = N'dbo'
    AND SPECIFIC_NAME = N'PR_RESOURCE_LIST'
    AND ROUTINE_TYPE = N'PROCEDURE'
)
DROP PROCEDURE dbo.PR_RESOURCE_LIST
GO
-- Create the stored procedure in the specified schema
CREATE PROCEDURE dbo.PR_RESOURCE_LIST
AS
    -- body of the stored procedure
    SELECT RESOURCE_CD, RESOURCE_NM FROM TB_RESOURCE;
GO

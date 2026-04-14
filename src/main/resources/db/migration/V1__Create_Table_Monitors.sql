IF NOT EXISTS (SELECT name FROM sys.tables WHERE name = 'Monitors')
BEGIN
CREATE TABLE [Monitors] (
id INT PRIMARY KEY IDENTITY(1,1),
name NVARCHAR(100) NOT NULL,
url NVARCHAR(255) NOT NULL,
method NVARCHAR(20) NOT NULL,
timeout_ms INT NOT NULL,
expected_status INT NOT NULL,
enabled BIT NOT NULL,
period_seconds INT NOT NULL,
created_at DATETIME2 NOT NULL,
updated_at DATETIME2 NOT NULL)
END
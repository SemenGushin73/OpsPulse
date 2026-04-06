package org.example.dao;

import org.example.model.Monitor;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс с запросами к БД через statements
 */
public class MonitorDDL {
    private final String masterConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=true;trustServerCertificate=true;";
    private final String opsPulseConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=OpsPulseDB;encrypt=true;trustServerCertificate=true;";
    private final String user = "sa";
    private final String password = "YourStrong!Pass123";

    /**
     * Создание БД
     */
    public void createDatabase() {
        String sql = "IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'OpsPulseDB') " +
                "BEGIN CREATE DATABASE [OpsPulseDB] END";
        try (Connection con = DriverManager.getConnection(masterConnectionUrl, user, password);
             Statement statement = con.createStatement()) {
            statement.execute(sql);
            System.out.println("База данных создана или уже существует!");

        } catch (SQLException e) {
            System.err.println("Ошибка создания: " + e.getMessage());
        }
    }

    /**
     * Получение имени БД
     */
    public void getDatabaseName() {
        String sql = "SELECT DB_NAME()";
        try (Connection con = DriverManager.getConnection(opsPulseConnectionUrl, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            System.out.println("Подключение успешно!");
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString(1);
                    System.out.println(name);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
    }

    /**
     * Создание таблицы в БД
     */
    public void createTable() {
        String sql = "IF NOT EXISTS (SELECT name FROM sys.tables WHERE name = 'Monitors') " +
                "BEGIN " +
                "CREATE TABLE [Monitors] (" +
                "id INT PRIMARY KEY IDENTITY(1,1)," +
                "name NVARCHAR(100) NOT NULL," +
                "url NVARCHAR(255) NOT NULL," +
                "method NVARCHAR(20) NOT NULL," +
                "timeout_ms INT NOT NULL," +
                "expected_status INT NOT NULL," +
                "enabled BIT NOT NULL," +
                "period_seconds INT NOT NULL," +
                "created_at DATETIME2 NOT NULL," +
                "updated_at DATETIME2 NOT NULL)" +
                " END";
        try (Connection con = DriverManager.getConnection(opsPulseConnectionUrl, user, password);
             Statement statement = con.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица создана или уже существует!");

        } catch (SQLException e) {
            System.err.println("Ошибка создания: " + e.getMessage());
        }
    }

    /**
     * Вставка в таблицу
     */
    public boolean insertIntoTable(Monitor monitor) {
        String sql = "INSERT INTO Monitors (name, url, method, timeout_ms, expected_status, enabled, period_seconds, created_at, updated_at)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(opsPulseConnectionUrl, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, monitor.getName());
            preparedStatement.setString(2, monitor.getUrl());
            preparedStatement.setString(3, monitor.getMethod());
            preparedStatement.setInt(4, monitor.getTimeoutMs());
            preparedStatement.setInt(5, monitor.getExpectedStatus());
            preparedStatement.setBoolean(6, monitor.isEnabled());
            preparedStatement.setInt(7, monitor.getPeriodSeconds());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(monitor.getCreatedAt()));
            preparedStatement.setTimestamp(9, Timestamp.valueOf(monitor.getUpdatedAt()));
            int inserts = preparedStatement.executeUpdate();
            return inserts > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка SQL: " + e.getMessage());
        }
        return false;
    }

    /**
     * Получение списка данных из Monitors
     */
    public List<Monitor> findAll() {
        String sql = "SELECT * FROM Monitors";
        List<Monitor> monitors = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(opsPulseConnectionUrl, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Monitor monitor1 = new Monitor();
                    monitor1.setId(rs.getInt("id"));
                    monitor1.setName(rs.getString("name"));
                    monitor1.setUrl(rs.getString("url"));
                    monitor1.setMethod(rs.getString("method"));
                    monitor1.setTimeoutMs(rs.getInt("timeout_ms"));
                    monitor1.setExpectedStatus(rs.getInt("expected_status"));
                    monitor1.setEnabled(rs.getBoolean("enabled"));
                    monitor1.setPeriodSeconds(rs.getInt("period_seconds"));
                    monitor1.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    monitor1.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                    monitors.add(monitor1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка SQL: " + e.getMessage());
        }
        return monitors;
    }

    /**
     * Получение строки по ID из Monitors
     */
    public Monitor findById(int id) {
        String sql = "SELECT * FROM Monitors WHERE id = ?";
        try (Connection con = DriverManager.getConnection(opsPulseConnectionUrl, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return new Monitor(
                            rs.getString("name"),
                            rs.getString("url"),
                            rs.getString("method"),
                            rs.getInt("timeout_ms"),
                            rs.getInt("expected_status"),
                            rs.getBoolean("enabled"),
                            rs.getInt("period_seconds"),
                            rs.getTimestamp("created_at").toLocalDateTime(),
                            rs.getTimestamp("updated_at").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка SQL: " + e.getMessage());
        }
        return null;
    }

    /**
     * Удаление строки по ID из Monitors
     */
    public boolean deleteById(int id) {
        String sql = "DELETE FROM Monitors WHERE id = ?";
        try (Connection con = DriverManager.getConnection(opsPulseConnectionUrl, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка SQL: " + e.getMessage());
        }
        return false;
    }

    /**
     * Обновление строки по ID из Monitors
     */
    public boolean updateById(int id, Monitor monitor) {
        String sql = "UPDATE Monitors SET name = ?, url = ?, method = ?, timeout_ms = ?, expected_status = ?, enabled = ?," +
                " period_seconds = ?, created_at = ?, updated_at = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(opsPulseConnectionUrl, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, monitor.getName());
            preparedStatement.setString(2, monitor.getUrl());
            preparedStatement.setString(3, monitor.getMethod());
            preparedStatement.setInt(4, monitor.getTimeoutMs());
            preparedStatement.setInt(5, monitor.getExpectedStatus());
            preparedStatement.setBoolean(6, monitor.isEnabled());
            preparedStatement.setInt(7, monitor.getPeriodSeconds());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(monitor.getCreatedAt()));
            preparedStatement.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(10, id);
            int updates = preparedStatement.executeUpdate();
            return updates > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка SQL: " + e.getMessage());
        }
        return false;
    }

}
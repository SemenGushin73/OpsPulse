package org.example.dao;

import org.example.model.Monitor;

import java.util.List;

/**
 * Интерфейс для определения методов persist-context Monitor
 */
public interface MonitorDAO {

    /**
     * Сохранить сущность Monitor
     */
    public void saveMonitor(Monitor monitor);

    /**
     * Обновить сущность Monitor
     */
    public void updateMonitor(Monitor monitor);

    /**
     * Удалить сущность Monitor
     */
    public void deleteMonitor(int id);

    /**
     * Получить сущность Monitor по ID
     */
    Monitor getMonitorById(int id);

    /**
     * Получить все сущности Monitor
     */
    List<Monitor> getAllMonitors();

    /**
     * Получить сущность Monitor по name
     */
    Monitor getMonitorByName(String name);

}
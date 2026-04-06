package org.example.service;

import org.example.model.Monitor;

import java.util.List;

/**
 * Интерфейс для сервис-слоя
 */
public interface MonitorService {
    /**
     * Обновить монитор
     */
    void updateMonitor(Monitor monitor);

    /**
     * Удалить монитор
     */
    void deleteMonitor(int id);

    /**
     * Создать монитор и сохранить в БД
     */
    void saveMonitor(Monitor monitor);

    /**
     * Получить монитор по ID
     */
    Monitor getMonitor(int id);

    /**
     * Получить все мониторы
     */
    List<Monitor> getAllMonitors();

    /**
     * Получить монитор по name
     */
    Monitor getMonitorByName(String name);

}

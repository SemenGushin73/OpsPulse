package org.example.service;

import org.example.dao.MonitorDAO;
import org.example.model.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Класс-сервис
 */
@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorDAO monitorDAO;

    /**
     * Обновить монитор
     */
    @Override
    @Transactional
    public void updateMonitor(Monitor monitor) {
        monitorDAO.updateMonitor(monitor);
    }

    /**
     * Удалить монитор
     */
    @Override
    @Transactional
    public void deleteMonitor(int id) {
        monitorDAO.deleteMonitor(id);
    }

    /**
     * Создать монитор и сохранить в БД
     */
    @Override
    @Transactional
    public void saveMonitor(Monitor monitor) {
        monitorDAO.saveMonitor(monitor);
    }

    /**
     * Получить монитор по ID
     */
    @Override
    @Transactional
    public Monitor getMonitor(int id) {
        return monitorDAO.getMonitorById(id);
    }

    /**
     * Получить все мониторы
     */
    @Override
    @Transactional
    public List<Monitor> getAllMonitors() {
        return monitorDAO.getAllMonitors();
    }

    /**
     * Получить монитор по name
     */
    @Override
    @Transactional
    public Monitor getMonitorByName(String name) {
        return monitorDAO.getMonitorByName(name);
    }

}
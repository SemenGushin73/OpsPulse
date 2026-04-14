package org.example.controller;

import org.example.model.Monitor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Интефейс-кантракт для контроллера монитора
 */
public interface MonitorControllerContract {

    /**
     * Показать все мониторы
     */
    String getMonitors(ModelMap model);

    /**
     * Добавить монитор
     */
    String addMonitor(@ModelAttribute Monitor monitor);

    /**
     * Обновить монитор
     */
    String updateMonitor(@ModelAttribute Monitor monitor);

    /**
     * Удалить монитор
     */
    String deleteMonitor(@PathVariable int id);
}

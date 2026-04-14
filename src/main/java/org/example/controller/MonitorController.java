package org.example.controller;

import org.example.model.Monitor;
import org.example.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * Контроллер для работы с мониторами
 */
@Controller
@RequestMapping("/")
public class MonitorController implements MonitorControllerContract {

    @Autowired
    MonitorService monitorService;

    /**
     * Редирект на страницу с мониторами
     */
    @GetMapping("/")
    public String redirectToMonitors() {
        return "redirect:/monitors";
    }

    /**
     * Показать все мониторы
     */
    @Override
    @GetMapping("/monitors")
    public String getMonitors (ModelMap model) {
        List<Monitor> monitors = monitorService.getAllMonitors();
        model.addAttribute("monitors", monitors);
        return "monitors";
    }

    /**
     * Добавить монитор
     */
    @Override
    @PostMapping("/addMonitor")
    public String addMonitor(Monitor monitor) {
       monitorService.saveMonitor(monitor);
       return "redirect:/monitors";
    }

    /**
     * Обновить монитор
     */
    @Override
    @PostMapping("/updateMonitor")
    public String updateMonitor(Monitor monitor) {
        monitorService.updateMonitor(monitor);
        return "update-monitor";
    }

    /**
     * Удалить монитор
     */
    @Override
    @PostMapping("/deleteMonitor")
    public String deleteMonitor(int id) {
        monitorService.deleteMonitor(id);
        return "redirect:/monitors";
    }
}
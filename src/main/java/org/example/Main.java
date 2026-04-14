package org.example;

import org.example.config.DBConfig;
import org.example.config.MVCConfig;
import org.example.model.Monitor;
import org.example.service.MonitorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

/**
 * Класс запуска приложения
 */
public class Main {
    public static void main(String[] args) {
        Monitor monitor1 = new Monitor("YouTube", "https://youtube.com", "POST", 1500, 200, true, 60, LocalDateTime.now(), null);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
        MonitorService monitorService = context.getBean(MonitorService.class);
        System.out.println("Получить все мониторы:" + monitorService.getAllMonitors());
        monitorService.saveMonitor(monitor1);
        System.out.println("Получить все мониторы:" + monitorService.getAllMonitors());
//        System.out.println("Получить монитор по name:" + monitorService.getMonitorByName(monitor1.getName()));
//        monitor1.setMethod("GET");
//        monitorService.updateMonitor(monitor1);
//        System.out.println("Получить монитор по ID:" + monitorService.getMonitor(monitor1.getId()));
//        monitorService.deleteMonitor(monitor1.getId());
//        System.out.println("Получить все мониторы:" + monitorService.getAllMonitors());
    }
}
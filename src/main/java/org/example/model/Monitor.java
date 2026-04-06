package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Модель таблицы Monitor
 */
@Entity
@Table(name = "Monitors")
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "method")
    private String method;
    @Column(name = "timeout_ms")
    private int timeoutMs;
    @Column(name = "expected_status")
    private int expectedStatus;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "period_seconds")
    private int periodSeconds;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Monitor() {

    }

    public Monitor(String name, String url, String method, int timeoutMs, int expectedStatus, boolean enabled, int periodSeconds, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.url = url;
        this.method = method;
        this.timeoutMs = timeoutMs;
        this.expectedStatus = expectedStatus;
        this.enabled = enabled;
        this.periodSeconds = periodSeconds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public int getExpectedStatus() {
        return expectedStatus;
    }

    public void setExpectedStatus(int expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getPeriodSeconds() {
        return periodSeconds;
    }

    public void setPeriodSeconds(int periodSeconds) {
        this.periodSeconds = periodSeconds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Monitor monitor = (Monitor) o;
        return id == monitor.id && timeoutMs == monitor.timeoutMs && expectedStatus == monitor.expectedStatus && enabled == monitor.enabled && periodSeconds == monitor.periodSeconds && Objects.equals(name, monitor.name) && Objects.equals(url, monitor.url) && Objects.equals(method, monitor.method) && Objects.equals(createdAt, monitor.createdAt) && Objects.equals(updatedAt, monitor.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, method, timeoutMs, expectedStatus, enabled, periodSeconds, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", timeoutMs=" + timeoutMs +
                ", expectedStatus=" + expectedStatus +
                ", enabled=" + enabled +
                ", periodSeconds=" + periodSeconds +
                ", createdAt=" + createdAt +
                ", updated_at=" + updatedAt +
                '}';
    }
}
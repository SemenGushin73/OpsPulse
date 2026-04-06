package org.example.dao;

import org.example.model.Monitor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Класс для persist-context Monitor
 */
@Repository
public class MonitorDAOImpl implements MonitorDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Сохранить сущность Monitor
     */
    @Override
    public void saveMonitor(Monitor monitor) {
        em.persist(monitor);
    }

    /**
     * Обновить сущность Monitor
     */
    @Override
    public void updateMonitor(Monitor monitor) {
        em.merge(monitor);
    }

    /**
     * Удалить сущность Monitor
     */
    @Override
    public void deleteMonitor(int id) {
        Monitor monitor = em.find(Monitor.class, id);
        if  (monitor != null) {
            em.remove(monitor);
        }
    }

    /**
     * Получить сущность Monitor по ID
     */
    @Override
    public Monitor getMonitorById(int id) {
            return em.find(Monitor.class, id);
    }

    /**
     * Получить все сущности Monitor
     */
    @Override
    public List<Monitor> getAllMonitors() {
        return em.createQuery("from Monitor", Monitor.class).getResultList();
    }

    /**
     * Получить сущность Monitor по name
     */
    @Override
    public Monitor getMonitorByName(String name) {
        String jpql = "SELECT u FROM Monitor u WHERE u.name = :name";
        TypedQuery<Monitor> query = em.createQuery(jpql, Monitor.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

}

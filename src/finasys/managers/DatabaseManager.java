/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.managers;

import finasys.enities.Addresses;
import finasys.enities.FinaSysEntity;
import finasys.enities.Staff;
import finasys.enities.Tincomes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author giddyc
 */
public class DatabaseManager {

    private static DatabaseManager instance;

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
            return instance;
        } else {
            return instance;
        }
    }

    private EntityManagerFactory emf;
    private EntityManager em;

    protected DatabaseManager() {
    }

    public boolean isConnected() {
        return emf != null && em != null;
    }

    /**
     * Connect to the database.
     *
     * @return True on successful connection, false on fail.
     */
    public boolean connect() {
        emf = Persistence.createEntityManagerFactory("FinaSysPU");
        try {
            em = emf.createEntityManager();
        } catch (javax.persistence.PersistenceException e) {
            return false;
        }
        return em.isOpen();
    }

    public void flush() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.flush();
        et.commit();
    }

    public void restart() {
        em.close();
        em = emf.createEntityManager();
    }

    public List<Addresses> getAddressRows() {
        return em.createNamedQuery("Addresses.findAll", Addresses.class).getResultList();
    }

    public void insert(FinaSysEntity entity) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(entity);
        et.commit();
    }

    public void multipleInsert(List<FinaSysEntity> entities) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        for (FinaSysEntity entity : entities) {
            em.persist(entity);
        }
        et.commit();
    }

    public List<Tincomes> getTaxRows() {
        return em.createNamedQuery("Tincomes.findAll", Tincomes.class).getResultList();
    }

    public List<Staff> getStaffRows() {
        return em.createNamedQuery("Staff.findAll", Staff.class).getResultList();
    }

    /**
     * Use a named query to get results.
     *
     * @param type
     * @param value
     * @return Query results.
     */
    public List<Staff> getStaffSimilar(String type, String value) {
        System.out.println("SELECT * FROM ADMINISTRATOR.STAFF WHERE " + type + " like '" + value + "%'");
        Query q = em.createNativeQuery("SELECT * FROM ADMINISTRATOR.STAFF WHERE " + type + " like '" + value + "%'", Staff.class);
        return q.getResultList();
    }

    public void shutdown() {
        if (em == null || emf == null) {
            return;
        }
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }

    }

}

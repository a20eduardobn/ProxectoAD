package com.example.proxectoadeduardobn.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static volatile EntityManagerFactory instance;

    public static EntityManager createEntityManager() {
        if (instance == null) {
            synchronized (EntityManagerUtil.class) {
                if (instance == null) {
                    instance = Persistence.createEntityManagerFactory("persistenciaJPAProxecto");
                }
            }
        }
        return instance.createEntityManager();
    }

    public static void shutdown(){
        instance.close();
    }
}

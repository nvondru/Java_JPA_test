/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_query;

import Model.Players;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nicolas Vondru
 */
public class PlayerQuery {
    
    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;

    public PlayerQuery() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PersonViewerPU");
        entityManager = entityManagerFactory.createEntityManager();
        
    }
    
    public List<Players> listPlayers(){
        beginTransaction();
        List listPlayers = entityManager.createNamedQuery("Players.findAll", Players.class).getResultList();         
        commitTransaction();
        return listPlayers;        
    }

    public void beginTransaction(){
        entityManager.getTransaction().begin();
    }
    
    public void commitTransaction(){
        entityManager.getTransaction().commit();
    }
    
    
    
    

    
    
    
}

package help;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class jpaHelp {
    static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager= entityManagerFactory.createEntityManager();
    static EntityTransaction transaction=entityManager.getTransaction();
    public void upConnect(){
        transaction.begin();
    }
    public void closeConnect(){
        transaction.commit();
        if (transaction.isActive()){
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}

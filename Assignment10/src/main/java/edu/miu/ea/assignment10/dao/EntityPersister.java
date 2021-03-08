package edu.miu.ea.assignment10.dao;
import edu.miu.ea.assignment10.service.JPA_Util;
import javax.persistence.EntityManager;

public class EntityPersister<T> {

  public EntityPersister() {
    System.out.println("Call Entity Persistence Constructor ************************************************************************************************");
  }

  public void persistEntry(T entity, EntityManager entityManager){
    System.out.println("Call persistAccountEntry method ************************************************************************************************");
    JPA_Util.getInstance().getEm().persist(entity);
  }
}

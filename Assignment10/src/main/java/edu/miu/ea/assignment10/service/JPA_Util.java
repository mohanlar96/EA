package edu.miu.ea.assignment10.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA_Util {
  private static JPA_Util jpa_util;
  public static JPA_Util getInstance(){
    if(jpa_util==null){
      jpa_util=new JPA_Util();
    }
    return jpa_util;
  }
  private final EntityManager em;

  public JPA_Util() {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Assignment10TPU");
    this.em = entityManagerFactory.createEntityManager();
  }
  public EntityManager getEm(){
    return em;
  }
}

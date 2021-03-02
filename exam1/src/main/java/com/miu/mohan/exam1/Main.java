/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.mohan.exam1;

import com.miu.mohan.exam1.entities.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author 611517
 */
public class Main {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam1PU");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    static void PersistData() {
        Driver jack = new Driver();
        jack.setName("Jack");
        jack.notify();
        jack.setDob(LocalDate.of(2020, 01, 07));

        License l1 = new License();
        l1.setLicenseId("12IA876GH");
        l1.setState("IA");

        jack.setLicense(l1);

        Car toyota = new Car();
        toyota.setColor("red");
        toyota.setMileage(150000);
        toyota.setYear("2005");

        Car honda = new Car();
        honda.setColor("gray");
        honda.setMileage(120000);
        honda.setYear("2009");
        List<Car> jackCars = new ArrayList();
        jackCars.add(honda);
        jackCars.add(toyota);
        jack.setCars(jackCars);

        Insurance toyoIns = new Insurance();
        toyoIns.setType("Liability");
        toyoIns.setCoverage(25000);
        toyoIns.setMonthlyPremium(35);
        toyoIns.setStartDate(LocalDate.of(2021, 2, 17));
        toyoIns.setEndDate(LocalDate.of(2021, 9, 16));

        jack.setInsurance(toyoIns);

        Driver jill = new Driver();
        jill.setName("Jill");
        jill.setDob(LocalDate.of(1998, 10, 1));

        License l2 = new License();
        l2.setLicenseId("98240KJ21");
        l2.setState("IL");

        jill.setLicense(l2);

        Car bmw = new Car();
        bmw.setColor("red");
        bmw.setMileage(150000);
        bmw.setYear("2005");

        List jillCars = new ArrayList();
        jillCars.add(bmw);
        jill.setCars(jillCars);

        Insurance bmwIn = new Insurance();
        bmwIn.setType("Comprehensive");
        bmwIn.setCoverage(125000);
        bmwIn.setMonthlyPremium(250);
        bmwIn.setStartDate(LocalDate.of(2021, 2, 17));
        bmwIn.setEndDate(LocalDate.of(2021, 9, 16));
        jill.setInsurance(bmwIn);

        Driver john = new Driver();
        john.setName("John");
        john.setDob(LocalDate.of(2002, 10, 25));

        License l3 = new License();
        l3.setState("CA");
        l3.setLicenseId("78KL9232G");
        john.setLicense(l3);

        Car nissan = new Car();
        nissan.setColor("Grenn");
        nissan.setMileage(15000);
        nissan.setYear("2010");

        List<Car> johnCars = new ArrayList();
        johnCars.add(nissan);
        john.setCars(johnCars);;

        Insurance nissIns = new Insurance();
        nissIns.setCoverage(55000);
        nissIns.setStartDate(LocalDate.of(2020, 05, 10));
        nissIns.setEndDate(LocalDate.of(2021, 4, 4));
        nissIns.setMonthlyPremium(175);

        john.setInsurance(nissIns);

        em.persist(jack);
        em.persist(jill);
        em.persist(john);
    }

    static void SelectDrivers() {
        System.out.println("Question one done");
        Query drivers = em.createQuery("SELECT d FROM Driver d WHERE d.dob>'2001-01-01' ");
        System.out.println("Question 2 done \n " + drivers.getResultList());

    }

    static void CriteriaQuery() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Driver> criteriaQuery = criteriaBuilder.createQuery(Driver.class);

        Root<Driver> driverRoot = criteriaQuery.from(Driver.class);
        Join<Driver, Insurance> insuranceJoin = driverRoot.join("insurance");

        Predicate gpaPredicate = criteriaBuilder.greaterThan(insuranceJoin.get(Insurance_.monthlyPremium), 50);

        criteriaQuery.select(driverRoot);
        criteriaQuery.where(gpaPredicate);

        TypedQuery<Driver> driverss = em.createQuery(criteriaQuery);
        System.out.println("Question 3 ......\n " + driverss.getResultList());
    }

    public static void main(String[] args) {

//        https://sakai.cs.miu.edu/samigo-app/jsf/delivery/deliverAssessment.faces
//question link
        System.out.println("START>>>>>>>>>>");

        tx.begin();
        DemonstrateAllOfThe3Methods();

        System.out.println("Question 4 ..... \n");
        Insurance insUpdate = em.find(Insurance.class, 7L);
        insUpdate.setCoverage(20040);
        em.persist(insUpdate);

        System.out.println("Question 5.. version is added in insurance");

        tx.commit();

        System.out.println("ENDNG>>>>>>>>>>>>>>>>");
        em.close();
        emf.close();

    }

    private static void DemonstrateAllOfThe3Methods() {
        try {
            PersistData();
            

        } catch(Exception e) {

            System.out.println("There is some error occurs in PersistData "+e);

        }
        try {
            SelectDrivers();

        } catch(Exception e) {
            System.out.println("There is error occurs in SelectDrivers "+e);

        }

        try {
            CriteriaQuery();

        } catch(Exception e) {

            System.out.println("There is  error occurs in CriteriyQueries "+e);

        }

    }

}

package com.miu.mohan.exam1.entities;

import com.miu.mohan.exam1.entities.Car;
import com.miu.mohan.exam1.entities.Insurance;
import com.miu.mohan.exam1.entities.License;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-03-01T15:11:18")
@StaticMetamodel(Driver.class)
public class Driver_ { 

    public static volatile SingularAttribute<Driver, Insurance> insurance;
    public static volatile SingularAttribute<Driver, License> license;
    public static volatile ListAttribute<Driver, Car> cars;
    public static volatile SingularAttribute<Driver, LocalDate> dob;
    public static volatile SingularAttribute<Driver, String> name;
    public static volatile SingularAttribute<Driver, Long> id;

}
package com.miu.mohan.exam1.entities;

import com.miu.mohan.exam1.entities.Driver;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-03-01T15:11:18")
@StaticMetamodel(Insurance.class)
public class Insurance_ { 

    public static volatile SingularAttribute<Insurance, Integer> coverage;
    public static volatile SingularAttribute<Insurance, Driver> driver;
    public static volatile SingularAttribute<Insurance, LocalDate> endDate;
    public static volatile SingularAttribute<Insurance, Long> id;
    public static volatile SingularAttribute<Insurance, String> type;
    public static volatile SingularAttribute<Insurance, LocalDate> startDate;
    public static volatile SingularAttribute<Insurance, Integer> monthlyPremium;

}
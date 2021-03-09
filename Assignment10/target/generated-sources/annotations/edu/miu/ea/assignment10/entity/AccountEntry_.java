package edu.miu.ea.assignment10.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccountEntry.class)
public abstract class AccountEntry_ {

	public static volatile SingularAttribute<AccountEntry, Long> id;
	public static volatile SingularAttribute<AccountEntry, Long> accountNumber;
	public static volatile SingularAttribute<AccountEntry, Float> value;

	public static final String ID = "id";
	public static final String ACCOUNT_NUMBER = "accountNumber";
	public static final String VALUE = "value";

}


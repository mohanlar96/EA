package edu.miu.ea.assignment10.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccountEntry {

  Long accountNumber;
  Float value;
  @Id
  @GeneratedValue
  private Long id;

  public AccountEntry(Long accountNumber, Float value) {
    this.accountNumber = accountNumber;
    this.value = value;
  }

  public AccountEntry() {
  }

  public Long getAccountNumber() {
    return accountNumber;
  }

  public AccountEntry setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public Float getValue() {
    return value;
  }

  public AccountEntry setValue(Float value) {
    this.value = value;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}

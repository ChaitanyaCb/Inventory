package com.model;

public class Teacher
{
  private String name;
  private String id;
  private Integer age;
  
  public Teacher(String name,String id,Integer age)
  {
    this.name=name;
    this.age=age;
    this.id=id;
  }
  public String getName(){ return name;}
  public Integer getAge(){ return age;}
  public String getId(){return id;}

}

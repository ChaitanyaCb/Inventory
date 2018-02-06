package com.model;
public class Student
{
   private String name;
   private Integer height;
   private Integer weight;
   private Integer age;

   public Student(String name,int ht,int wth,int age)
   {
      this.name=name;
      this.height=ht;
      this.weight=wth;
      this.age=age;

   }
   public String getName(){ return name;}
   public Integer getHeight(){ return height;}
   public Integer getWeight(){ return weight;}
   public Integer getAge(){ return age;}

}

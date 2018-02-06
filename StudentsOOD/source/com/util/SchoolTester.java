package com.util;
import com.model.*;
import java.util.*;



public class SchoolTester
{
  public static void main(String[] args)
  {

      School school = new School();
      Classroom classroom1 = new Classroom("Alpha");
      Classroom classroom2 = new Classroom("Beta");
      school.addClassroom(classroom1);
      school.addClassroom(classroom2);
      school.addTeacher("abc","ENG01",40);


      try
      {
        Student newStudent = takeStudent();
        classroom1.addStudent(newStudent);
        school.assignTeacherToClass("Alpha","ENG01");
      }
      catch(Exception ex)
      {
        System.out.println("Try again");
      }

  }

  private static Student takeStudent() throws NullPointerException
  {
    Student s=null;
    Scanner sc = new Scanner(System.in);
    String name = "";
    int ht=0,wt=0,age=0;
    boolean flag=false;
    System.out.println("Enter Details:");
    try
    {
      System.out.print("Enter name");
      name = sc.nextLine();
      if(name.length()==0)
      {

        throw new MyException("Name cannot be empty");
      }
      System.out.println("Enter height");
      ht = sc.nextInt();
      if(ht==0)
      {
        MyException me = new MyException("Height cannot be zero");
        throw me;
      }
      System.out.println("Enter weight");
      wt = sc.nextInt();
      if(wt==0)
      {
        MyException me = new MyException("Weight cannot be zero");
        throw me;
      }
      System.out.println("Enter Age");
      age = sc.nextInt();
      if(wt==0)
      {
        MyException me = new MyException("Age cannot be zero");
        throw me;
      }
      s=new Student(name,ht,wt,age);
      flag=true;
    }
    catch(MyException ex)
    {
      System.out.println(ex);
    }
    if(flag)
      return s;
    else
      return null;

  }
}

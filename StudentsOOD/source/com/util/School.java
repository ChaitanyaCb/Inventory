package com.util;
import com.model.*;
import java.util.*;
import java.io.*;




public class School
{
  private ArrayList<Classroom> classrooms;
  private ArrayList<Teacher> teachers;
  School()
  {
    classrooms = new ArrayList<Classroom>();
    teachers = new ArrayList<Teacher>();
  }

  public void addClassroom(Classroom classroom)
  {
    classrooms.add(classroom);
  }

  public void addTeacher(String name,String id,int age)
  {
    teachers.add(new Teacher(name,id,age));
  }

  public void assignTeacherToClass(String classname,String tid)
  {

    try
    {
        Teacher newt = this.getTeacher(tid);


          for(Classroom c : classrooms)
          {
            if(!(c.getName().equalsIgnoreCase(classname)))
            {
                if(c.getTeacher().getId().equalsIgnoreCase(tid))
                {
                  System.out.println("Teacher is assigned already");
                  return;
                }
            }

          }

          try
          {
            Classroom newc = this.getClassroom(classname);
            newc.setTeacher(newt);
            System.out.println("Teacher Assigned");
          }
          catch(Exception ex)
          {
            System.out.println("No such classroom");
          }

    }
    catch(Exception ex)
    {
      System.out.println("No such teacher");
    }

  }
  private Classroom getClassroom(String classname) throws NullPointerException
  {
    for(Classroom c : classrooms)
    {
      if(c.getName().equalsIgnoreCase(classname))
      {
        return c;
      }
    }
    return null;
  }

  private Teacher getTeacher(String tid) throws NullPointerException
  {
    for(Teacher t : teachers)
    {
      if(t.getId().equalsIgnoreCase(tid))
      {
        return t;
      }
    }
    return null;

  }

}

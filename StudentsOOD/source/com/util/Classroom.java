package com.util;
import com.model.*;
import java.util.*;


public class Classroom
{
    private String name;
    private ArrayList<Student> students;
    private Teacher teacher;

    public Classroom(String name)
    {
        this.name=name;
        students = new ArrayList<Student>();

    }
    public String getName(){return name;}


    public void setTeacher(Teacher t)
    {
      teacher = t;
    }


    public Teacher getTeacher(){return teacher;}

    public void addStudent(Student s)
    {
      students.add(s);
    }


    public Student getStudent(String name)
    {
      for(Student s : students)
      {
          if(s.getName().equals(name))
          {
            return s;
          }

      }
      return null;

    }


    class HeightCompare implements Comparator<Student>
    {

        public int compare(Student one,Student two)
        {
            return one.getHeight().compareTo(two.getHeight());
        }

    }
    class WeightCompare implements Comparator<Student>
    {

        public int compare(Student one,Student two)
        {
            return one.getWeight().compareTo(two.getWeight());
        }

    }
    class NameCompare implements Comparator<Student>
    {

        public int compare(Student one,Student two)
        {
            return one.getName().compareTo(two.getName());
        }

    }



    public ArrayList<Student> filter(attr at,Object o)
    {
        ArrayList<Student> filtered = new ArrayList<Student>();
        switch(at)
        {
              case HEIGHT:
                        for(Student s : students)
                        {
                            if(s.getHeight().equals((Integer)o))
                            {
                              filtered.add(s);
                            }

                        }
              case WEIGHT:
                        for(Student s : students)
                        {
                            if(s.getWeight().equals((Integer)o))
                            {
                              filtered.add(s);
                            }

                        }
              case NAME:
                        for(Student s : students)
                        {
                            if(s.getName().equals((String)o))
                            {
                              filtered.add(s);
                            }

                        }
              case AGE:
                        for(Student s : students)
                        {
                            if(s.getAge().equals((Integer)o))
                            {
                              filtered.add(s);
                            }

                        }


        }
        return filtered;

    }


    public void sort(attr at)
    {
      switch(at)
      {
        case HEIGHT:

          HeightCompare hc = new HeightCompare();
          Collections.sort(students,hc);
          break;

        case WEIGHT:

          WeightCompare wc = new WeightCompare();
          Collections.sort(students,wc);
          break;

        case NAME:

          NameCompare ac = new NameCompare();
          Collections.sort(students,ac);
          break;

        default:

          System.out.println("No such attribute");
      }

    }


}

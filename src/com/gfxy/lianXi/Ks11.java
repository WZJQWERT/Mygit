package com.gfxy.lianXi;
import java.text.*;
   public class Ks11{



           public static void main(String[] args)
           {
               Person[] people = new Person[2];
               people[0] = new Worker("老张", 30000);
               people[1] = new XueSheng("小王", "计算机科学");
               for (int i = 0; i < people.length; i++)
               {
                   Person p = people[i];
                   //*********Found**********
                   System.out.println(p.getName() + ", " + p.getDescription());
               }
           }
       }

//*********Found**********
      abstract class Person
       {
           public Person(String n)
           {
               name = n;
           }
           //*********Found**********
           public  abstract String getDescription();
           public String getName()
           {
               return name;
           }
           private String name;
       }

       //*********Found**********
       class Worker extends Person
       {
           public Worker(String n, double s)
           {
               super(n);
               salary = s;
           }
           public String getDescription()
           {
               NumberFormat formatter = NumberFormat.getCurrencyInstance();
               return "工人，年薪是 " + formatter.format(salary) + "。";
           }
           private double salary;
       }

       //*********Found**********
        class XueSheng  extends Person
       {
           public XueSheng(String n, String m) {
               super(n);
               major = m;
           }
           public String getDescription()
           {
               return "学生，专业是 " + major + "。";
           }
           private String major;
       }


package org.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.setpAge(17);
        p1.setpId(5);
        p1.setpName("Abhay");

        Person p2 = null;

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.example.Person.class);
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        // 1. Insert
        transaction = session.beginTransaction();

        session.persist(p1); // takes obj to insert on db

        transaction.commit();

        // 2. Read
        p2 = session.find(Person.class, 5);
        System.out.println(p2);

        // 3. Update
        p1.setpAge(21);
        p1.setpName("Abhay garg");

        transaction = session.beginTransaction();

        session.merge(p1); // save or update
        // first fetch if fetched data is same as p1 then does nothing
        // if not same as p1 then update
        // if not present then insert

        transaction.commit();

        // Read
        p2 = session.find(Person.class, 5);
        System.out.println(p2);

        // 4. delete
        transaction = session.beginTransaction();

        session.remove(p1); // takes obj to delete
        // this will only take the obj so if you have the key then you have to first fetch the data
        // then delete that data from this method.
        // first fetch if present then delete otherwise do nothing

        transaction.commit();

        // HQL (Hibernate Query Language)

        // select * from person where age >= 17 -> SQL
        // from person where age >= 17 -> HQL

        String hqlQuery = null;
        String name = "Rohan";

        //hqlQuery = "FROM Person where pAge >= 16";
        hqlQuery = "From Person where pName like ?1";

        Query query = session.createQuery(hqlQuery, Person.class); // 'Person.class' not to be compulsory
        query.setParameter(1, name); // use only when query has '?'.
        System.out.println("HQL query obj : " + query);

        List<Person> personList = query.getResultList();

        System.out.println("Fetched data : " + personList);
        for (Person person : personList) {
            System.out.println(person);
        }

        // L2 cache
        Person ps1 = session.find(Person.class, 1);
        System.out.println(ps1);

        session.close();

        Session session2 = sessionFactory.openSession();
        Person ps2 = session2.find(Person.class, 1);
        System.out.println(ps2);

        session2.close();

        sessionFactory.close();
    }
}
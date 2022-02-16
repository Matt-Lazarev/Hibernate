package a_onetoone;

import e_config.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ApplicationMain {
    private static SessionFactory sessionFactory = Util.getSession();


    public static void main(String[] args) {
        Person person = new Person("Mike", "Watson");
        Passport passport = new Passport(1234, 102030);
        person.setPassport(passport);

    }

    @SuppressWarnings("unchecked")
    public static void savePerson(Person person){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            session.save(person);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

    public static void getPersonByPassportNumber(int number){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}

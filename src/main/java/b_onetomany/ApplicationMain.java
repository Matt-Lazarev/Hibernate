package b_onetomany;

import e_config.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMain {
    private static SessionFactory sessionFactory = Util.getSession();
//                new Configuration()
//            .configure("hibernate.cfg.xml")
//            .addAnnotatedClass(Group.class)
//            .addAnnotatedClass(Student.class)
//            .buildSessionFactory();


    public static void main(String[] args) {
        Student student1 = new Student("Kate");
        Student student2 = new Student("Bob");

        Group group = new Group("1001");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        group.setStudents(students);

        saveGroup(group);
    }

    @SuppressWarnings("unchecked")
    public static void saveGroup(Group group){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            session.save(group);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}

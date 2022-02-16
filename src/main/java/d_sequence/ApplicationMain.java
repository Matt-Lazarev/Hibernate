package d_sequence;

import e_config.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ApplicationMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getSession();

        try{
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Employee employee = new Employee();
            employee.setName("Matt");
            employee.setSpecialization("Manager");

            Employee employee2 = new Employee();
            employee2.setName("Bob");
            employee2.setSpecialization("Manager");

            session.save(employee);
            session.save(employee2);

            List<Employee> employees = session.createQuery("from Employee").getResultList();
            for(Employee emp : employees){
                System.out.println(emp.getId() + " " + emp.getName());
            }

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}

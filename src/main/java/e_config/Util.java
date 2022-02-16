package e_config;

import a_onetoone.Passport;
import a_onetoone.Person;
import b_onetomany.Group;
import b_onetomany.Student;
import c_manytomany.Client;
import c_manytomany.Good;
import d_sequence.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static SessionFactory session;

    public static SessionFactory getSession() {
        if (session == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/my_db");
                properties.put(Environment.USER, "postgres");
                properties.put(Environment.PASS, "root");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(properties);
//                configuration.addAnnotatedClass(Person.class);
//                configuration.addAnnotatedClass(Passport.class);
//                configuration.addAnnotatedClass(Group.class);
//               configuration.addAnnotatedClass(Student.class);
//                configuration.addAnnotatedClass(Client.class);
//                configuration.addAnnotatedClass(Good.class);
                configuration.addAnnotatedClass(Employee.class);
                //configuration.addAnnotatedClass(Person.class);
                //configuration.addAnnotatedClass(Passport.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                session = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return session;
    }
}

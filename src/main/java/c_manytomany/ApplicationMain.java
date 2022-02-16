package c_manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMain {
    private static SessionFactory sessionFactory =
            new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Good.class)
            .addAnnotatedClass(Client.class)
            .buildSessionFactory();

    public static void main(String[] args) {
        Client client1 = new Client("Mike");
        Client client2 = new Client("Bob");

        Good good1 = new Good("milk");
        Good good2 = new Good("bread");
        Good good3 = new Good("meat");
        Good good4 = new Good("eggs");
        Good good5 = new Good("fish");
        Good good6 = new Good("chocolate");

        List<Good> goodList1 = new ArrayList<>();
        goodList1.add(good1);
        goodList1.add(good2);
        goodList1.add(good3);

        client1.setGoods(goodList1);

        List<Good> goodList2 = new ArrayList<>();
        goodList2.add(good4);
        goodList2.add(good5);
        goodList2.add(good6);

        client1.setGoods(goodList2);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        //saveClient(clients);

        getAllClients();
    }

    public static void saveClient(List<Client> clients){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            for(Client client: clients){
                session.save(client);
            }

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

    public static void getAllClients(){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            List<Client> clients = session.createQuery("from Client ").getResultList();

            for(Client client : clients){
                System.out.println(client.getName());
            }

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}

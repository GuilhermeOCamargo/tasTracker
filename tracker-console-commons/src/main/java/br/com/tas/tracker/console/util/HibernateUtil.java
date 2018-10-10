package br.com.tas.tracker.console.util;

import br.com.tas.tracker.console.enums.ResourceBundles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @author guilherme.camargo
 * @since 17/09/2018
 * @version 1.0
 * */
public class HibernateUtil {

    private static SessionFactory sessionFactory = buildConsoleSessionFactory();

    private static SessionFactory buildConsoleSessionFactory() {
        try {
            // Uncomment the line below to use a local connection datasource
            //return new Configuration().configure("hibernate-console.cfg.xml").buildSessionFactory();
            return new Configuration().mergeProperties(MessageUtil
                    .loadProperties(ResourceBundles.HIBERNATE_CONSOLE.getDesc()))
                    .configure("hibernate-console.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession(){
        return getSessionFactory().openSession();
    }
}
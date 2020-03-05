package com.plalance.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.plalance.models.Animal;
import com.plalance.models.Personne;

@Component
public class HibernateUtil {


	private static String DRIVER;
	private static String DIALECT;
	private static String HOST;
	private static String PORT;
	private static String DATABASE;
	private static String USER;
	private static String PASSWORD;

	
    @Value("${datasource.driver}")
    public void setDriver(String driver) {
        DRIVER = driver;
    }
    
    @Value("${datasource.dialect}")
    public void setDialect(String dialect) {
        DIALECT = dialect;
    }
    
    @Value("${datasource.host}")
    public void setHost(String host) {
        HOST = host;
    }
    
    @Value("${datasource.port}")
    public void setPort(String port) {
        PORT = port;
    }
  
    @Value("${datasource.database}")
    public void setDatabase(String db) {
        DATABASE = db;
    }
    
    @Value("${datasource.user}")
    public void setUser(String user) {
        USER = user;
    }
    
    @Value("${datasource.password}")
    public void setPAssword(String password) {
        PASSWORD = password;
    }

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, DRIVER);
				settings.put(Environment.DIALECT, DIALECT);
				settings.put(Environment.URL,
						String.format("jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
								HOST, PORT, DATABASE));

				settings.put(Environment.USER, USER);
				settings.put(Environment.PASS, PASSWORD);
				

				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);

				// IMPORTANT
				configuration.addAnnotatedClass(Animal.class);
				configuration.addAnnotatedClass(Personne.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
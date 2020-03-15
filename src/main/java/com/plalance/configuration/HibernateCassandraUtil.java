//package com.plalance.configuration;
//
//import java.util.Properties;
//import java.util.logging.Logger;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Environment;
//import org.hibernate.ogm.OgmSessionFactory;
//import org.hibernate.ogm.cfg.OgmConfiguration;
//import org.hibernate.ogm.cfg.OgmProperties;
//import org.hibernate.ogm.datastore.impl.DatastoreProviderType;
//import org.hibernate.service.ServiceRegistry;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import com.plalance.models.Animal;
//import com.plalance.models.Personne;
//
//@Component
//public class HibernateCassandraUtil {
//
//	private static String DIALECT;
//	private static String HOST;
//	private static String PROVIDER;
//	private static String DATABASE;
//	private static String USER;
//	private static String PASSWORD;
//
//	@Value("${datasource.cassandra.dialect}")
//	public void setDialect(String dialect) {
//		DIALECT = dialect;
//	}
//
//	@Value("${datasource.cassandra.host}")
//	public void setHost(String host) {
//		HOST = host;
//	}
//
//	@Value("${datasource.cassandra.provider}")
//	public void setProvider(String provider) {
//		PROVIDER = provider;
//	}
//
//	@Value("${datasource.cassandra.database}")
//	public void setDatabase(String db) {
//		DATABASE = db;
//	}
//
//	@Value("${datasource.cassandra.user}")
//	public void setUser(String user) {
//		USER = user;
//	}
//
//	@Value("${datasource.cassandra.password}")
//	public void setPAssword(String password) {
//		PASSWORD = password;
//	}
//
//	private static final Logger log = Logger.getLogger(HibernateCassandraUtil.class.getName());
//
//	private static SessionFactory sessionFactory;
//
//	public static SessionFactory getSessionFactory() {
//
//		if (sessionFactory == null) {
//			try {
//
//				// Create a new instance of OmgConfiguration
//				OgmConfiguration configuration = new OgmConfiguration();
//
//				// Hibernate settings equivalent to hibernate.cfg.xml's properties
//				Properties settings = new Properties();
//				
//				settings.put(Environment.DIALECT, DIALECT);
//				settings.put(OgmProperties.DATASTORE_PROVIDER, DatastoreProviderType.CASSANDRA_EXPERIMENTAL.name());
//				
//				settings.put(OgmProperties.HOST, HOST);
//				settings.put(OgmProperties.USERNAME, USER);
//				settings.put(OgmProperties.PASSWORD, PASSWORD);
//				settings.put(OgmProperties.DATABASE, DATABASE);
////				settings.put(Environment.DIALECT, DIALECT); // Ignorable
//				
//				configuration.setProperties(settings);
//
//				// Target model classes to be managed by hibernate
//				configuration.addAnnotatedClass(Animal.class);
//				configuration.addAnnotatedClass(Personne.class);
//
//				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
//						.applySettings(configuration.getProperties()) //
//						.build(); //
//
//				sessionFactory = configuration.buildSessionFactory();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return sessionFactory;
//	}
//}
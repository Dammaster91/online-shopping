package san.com.shoppingbackend.config;

//@Configuration
//@ComponentScan(basePackages = "san.com.shoppingbackend.daoimpl")
//@EnableTransactionManagement
public class HibernateConfig {/*

	private final String DATABASE_URL = "jdbc:postgresql://127.0.0.1:5432/myProjects";
	private final String DATABASE_DRIVER = "org.postgresql.Driver";
	private final String DATABASE_DIALECT = "org.hibernate.dialect.PostgreSQL82Dialect";
	private final String DATABASE_USERNAME = "postgres";
	private final String DATABASE_PASSWORD = "root";

	@Bean
	public DataSource getDatasource() {
		BasicDataSource dataSource = new BasicDataSource();

		// providing the database information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("san.com.shoppingbackend");
		return builder.buildSessionFactory();
	}

	// All the Hibernate Properties will be return in this method
	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.formate_sql", "true");

		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		return transactionManager;
	}
*/}

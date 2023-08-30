package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DbConfig2 {
    @Profile("dev")
    @Configuration
    static class DevDbConfig {
        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            System.out.println("Dev_profile");

            DataSource ds = new DataSource();
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl("jdbc:mysql://localhost:3306/spring6");
            ds.setUsername("spring6");
            ds.setPassword("aA!123456");

            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);

            return ds;
        }

        @Bean
        public PlatformTransactionManager transactionManager(){
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }
    }

    @Profile("real")
    @Configuration
    static class RealDbConfig {
        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            System.out.println("Real_profile");
            DataSource ds = new DataSource();
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl("jdbc:mysql://localhost:3306/spring6");
            ds.setUsername("spring6");
            ds.setPassword("aA!123456");

            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);

            return ds;
        }

        @Bean
        public PlatformTransactionManager transactionManager(){
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }
    }
}

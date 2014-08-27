package hello;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
public class Application {

    @Autowired
    Greeting g;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Greeting getG() {
        return new Greeting(1, "");
    }

    @Bean
    DataSource dataSource() {
        return new SimpleDriverDataSource() {
            {
                setDriverClass(org.h2.Driver.class);
                setUsername("sa");
                setUrl("jdbc:h2:mem");
                setPassword("");
            }
        };
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Creating tables");
        jdbcTemplate.execute("drop table PERSONS if exists");
        jdbcTemplate.execute("create table PERSONS(" + "ID serial, NAME varchar(5) NOT NULL)");
        return jdbcTemplate;
    }

}

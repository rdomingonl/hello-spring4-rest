package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
@EnableTransactionManagement
@Import(RepositoryRestMvcConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    // @Bean
    // DataSource dataSource() {
    // return new SimpleDriverDataSource() {
    // {
    // setDriverClass(org.h2.Driver.class);
    // setUsername("sa");
    // setUrl("jdbc:h2:mem");
    // setPassword("");
    // }
    // };
    // }

    // @Bean
    // JdbcTemplate jdbcTemplate(DataSource dataSource) {
    // JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    // jdbcTemplate.execute("drop table PERSONS if exists");
    // jdbcTemplate.execute("create table PERSONS(" + "ID serial, NAME varchar(5) NOT NULL)");
    // return jdbcTemplate;
    // }

}

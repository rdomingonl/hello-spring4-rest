package hello;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerImpl implements HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /*
     * (non-Javadoc)
     * 
     * @see hello.iHelloWorldController#greeting(java.lang.String)
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Greeting greeting(String name) throws IOException {
        // add name to database

        jdbcTemplate.update("insert into PERSONS(NAME) values (?)", "ha");
        jdbcTemplate.update("insert into PERSONS(NAME) values (?)", name);

        // retrieve all names
        List<String> query = jdbcTemplate.query("select NAME from PERSONS", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {

                return rs.getString("NAME");
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String item : query) {
            if (sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append(item);
        }

        logger.error("sb:" + sb.toString());
        return new Greeting(counter.incrementAndGet(), String.format(template, sb.toString()));
    }

    @Override
    public Greeting greeting2() throws IOException {
        // retrieve all names
        List<String> query = jdbcTemplate.query("select NAME from PERSONS", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {

                return rs.getString("NAME");
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String item : query) {
            if (sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append(item);
        }

        logger.error("sb:" + sb.toString());
        return new Greeting(counter.incrementAndGet(), String.format(template, sb.toString()));
    }

}

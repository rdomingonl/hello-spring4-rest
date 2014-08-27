package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, WebSecurityConfig.class }, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
@TransactionConfiguration
public class HelloWorldIntegrationTest {

    MockMvc mockMvc;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    HelloWorldControllerImpl controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = webAppContextSetup(this.wac)
                .defaultRequest(get("/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                .alwaysExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).build();

        // this.mockMvc = standaloneSetup(controller).setMessageConverters(new MappingJackson2HttpMessageConverter())
        // .build();
    }

    @Test
    public void sayHello() throws Exception {
        this.mockMvc.perform(
                get("/hello").param("name", "ray").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)).andDo(print());

        // this.mockMvc.perform(
        // get("/hello").param("name", "ray").contentType(MediaType.APPLICATION_JSON)
        // .accept(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    public void sayHello2() throws Exception {
        this.mockMvc.perform(get("/hello2").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}

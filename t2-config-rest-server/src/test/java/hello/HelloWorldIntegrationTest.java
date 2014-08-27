package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@TransactionConfiguration
public class HelloWorldIntegrationTest {
    Logger logger = LoggerFactory.getLogger(HelloWorldIntegrationTest.class);

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    HelloWorldController controller;

    /**
     * This {@link MockMvc} object sends and accepts JSON only. It always expects JSON compatible content in return.
     */
    protected MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        logger.debug("Setup new mockJsonMvc");
        this.mockMvc = webAppContextSetup(this.wac)
                .defaultRequest(get("/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                .alwaysExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).build();

    }

    @Test
    public void sayHello() throws Exception {
        logger.error("before");
        this.mockMvc.perform(get("/hello").param("name", "ray")).andDo(print());
        logger.error("after");
    }
}

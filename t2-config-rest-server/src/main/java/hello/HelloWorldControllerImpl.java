package hello;

import hello.jpa.Customer;
import hello.jpa.CustomerRepository;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerImpl implements HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    ApplicationContext ctx;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /*
     * (non-Javadoc)
     * 
     * @see hello.iHelloWorldController#greeting(java.lang.String)
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Greeting greeting(String name) throws IOException {

        CustomerRepository repository = ctx.getBean(CustomerRepository.class);
        Customer newCustomer = new Customer(name);

        logger.info("Saving new customer:" + newCustomer);
        newCustomer = repository.save(newCustomer);

        logger.info("Find all customers");
        Iterable<Customer> customers = repository.findAll();
        StringBuffer sb = new StringBuffer();
        for (Customer c : customers) {
            if (sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append(c.getName());
        }
        logger.info("Composed greeting : " + sb.toString());
        return new Greeting(counter.incrementAndGet(), String.format(template, sb.toString()));
    }
    
    @Override
    public Greeting addGreeting(Greeting greeting) {
        greeting.setContent(greeting.getContent() + "!");
        return greeting;
    }
}

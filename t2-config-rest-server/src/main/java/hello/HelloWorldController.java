package hello;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface HelloWorldController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public abstract Greeting greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) throws IOException;

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public abstract Greeting greeting2() throws IOException;

}
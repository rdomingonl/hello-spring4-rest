package hello;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "Hallo API", description = "Dit is de hallo API")
public interface HelloWorldController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "Groet je", notes = "Deze functie groet je vriendelijk", consumes = "application/json,application/xml", produces = "application/json,application/xml")
    public abstract Greeting greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) throws IOException;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ApiOperation(value = "Post a greeting", notes = "Deze functie groet je vriendelijk met een uitroepteken", consumes = "application/json,application/xml", produces = "application/json,application/xml")
    public Greeting addGreeting(@Valid @RequestBody Greeting greeting);
}
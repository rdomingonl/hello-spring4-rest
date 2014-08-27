package hello;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Hallo API", description = "Dit is de hallo API")
public interface HelloWorldController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "Groet je", notes = "Deze functie groet je vriendelijk", consumes = "application/json,application/xml", produces = "application/json,application/xml")
    public abstract Greeting greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) throws IOException;

}
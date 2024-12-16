package coding_maverick.todo_webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // something that handles request
public class HelloWorldController {

    @RequestMapping("hello-world") // we are mapping the req url to method
    @ResponseBody  // It will directly send the response
    public String getHello() {
        return "Hello, this is violet";
    }

    @RequestMapping("hello-world-jsp")
    public String getHelloJsp() {
        return "sayHello";
    }
}

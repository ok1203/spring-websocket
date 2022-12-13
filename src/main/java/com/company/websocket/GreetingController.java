package com.company.websocket;

import com.company.websocket.service.LogNotFoundException;
import com.company.websocket.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @Autowired
    private LogService service;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMessage message) throws InterruptedException, LogNotFoundException {
        Thread.sleep(2000);
//        return new Greeting("Hello, " +
//                HtmlUtils.htmlEscape(message.getName()));

        String[] cmd = message.getName().split("[\":{}, ]+");
        String addLog = "addLog";
        String logs = "logs";
        for (int j = 0; j < cmd.length; j++) {
            System.out.print(cmd[j] + " ");
        }
        if (cmd[2].equals(addLog)) {
            System.out.println("lalala");
            Log log = new Log();
            log.setContent(cmd[4]);
            service.save(log);
            return null;
        } else if (cmd[2].equals(logs)) {
            System.out.println("bababa");
            String list = "";
            for(int i = 1; i < service.listAll().size(); i++){

                list = list.concat(service.get(i).getContent());
                list = list.concat("\n");

            }
            return new Greeting(
                HtmlUtils.htmlEscape(list));
        } else {
            System.out.println("tatata");
            return null;
        }
    }
}

package precato.precato.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Faz uma consulta de status para saber se a aplicação está online
@RestController
public class StatusController {

    @GetMapping(path ="/api/status")
    public String check(){
        return "online";
    }
}
package precato.precato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import precato.precato.model.CredorModel;
import precato.precato.repository.CredorRepository;

@RestController
public class CredorController {

    @Autowired
    private CredorRepository repository;

    @GetMapping(path = "api/credor/{Identificador_Credor}")
    public ResponseEntity consultar(@PathVariable("Identificador_Credor") String Identificador_Credor){
        return repository.findById(Identificador_Credor)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "api/credor/salvar")
    public CredorModel salvar(@RequestBody CredorModel credorSave){
        return repository.save(credorSave);
    }

}

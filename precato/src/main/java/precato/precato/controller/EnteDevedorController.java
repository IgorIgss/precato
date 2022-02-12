package precato.precato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import precato.precato.model.EnteDevedorModel;
import precato.precato.repository.EnteDevedorRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class EnteDevedorController {

    @Autowired
    private EnteDevedorRepository repository;

    @GetMapping(path = "api/entedevedor/{Identificador_Ente_Devedor}")
    public ResponseEntity consultar(@PathVariable ("Identificador_Ente_Devedor") String Identificador_Ente_Devedor){
        return repository.findById(Identificador_Ente_Devedor)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "api/entedevedor/salvar")
    public EnteDevedorModel salvar(@RequestBody EnteDevedorModel entedevedor){
        return repository.save(entedevedor);
    }



}

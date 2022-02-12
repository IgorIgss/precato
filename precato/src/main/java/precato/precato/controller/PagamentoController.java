package precato.precato.controller;

import precato.precato.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import precato.precato.model.PagamentoModel;
import precato.precato.repository.PagamentoRepository;
import com.google.gson.Gson;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;


@RestController
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @GetMapping(path = "api/pagamento/{Identificador_Remessa}")
    public ResponseEntity consultar(@PathVariable("Identificador_Remessa") String Identificador_Remessa){
        return repository.findById(Identificador_Remessa)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "api/pagamento/salvar")
    public PagamentoModel salvar(@RequestBody PagamentoModel pagamento) throws Exception {
        Credor temp;

        try{
            temp = buscaCredor(pagamento.identificador_Credor);
            if (temp.StatusCadastro == "Aprovado"){
                return repository.save(pagamento);
            }
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }

        return pagamento;
    }



    static String webService = "http://localhost:8080/api/credor/";
    static int codigoSucesso = 200;

    public static Credor buscaCredor(String codigoCredor) throws Exception {
        String urlParaChamada = webService + codigoCredor + "/json";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Credor pgt = gson.fromJson(jsonEmString, Credor.class);

            return pgt;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }

}


class Credor {
    public String IdentificadorCredor;
    public String NomeCredor;
    public String CPFCredor;
    public String StatusCadastro;

    public String getIdentificadorCredor() {
        return IdentificadorCredor;
    }

    public void setIdentificadorCredor(String identificadorCredor) {
        IdentificadorCredor = identificadorCredor;
    }

    public String getNomeCredor() {
        return NomeCredor;
    }

    public void setNomeCredor(String nomeCredor) {
        NomeCredor = nomeCredor;
    }

    public String getCPFCredor() {
        return CPFCredor;
    }

    public void setCPFCredor(String CPFCredor) {
        this.CPFCredor = CPFCredor;
    }

    public String getStatusCadastro() {
        return StatusCadastro;
    }

    public void setStatusCadastro(String statusCadastro) {
        StatusCadastro = statusCadastro;
    }

    public String ShowAsString() {
        return "Pagamento ["+ IdentificadorCredor+", " +CPFCredor+", "+StatusCadastro+"]";
    }
}

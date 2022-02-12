package precato.precato.model;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "ente_devedor")
public class EnteDevedorModel {

    @Id
    @NotBlank(message = "Campo não informado")
    @NotNull
    public String Identificador_Ente_Devedor;

    @Column
    @NotNull
    public String Nome_Ente_Devedor;

    @Column
    @NotNull
    @CNPJ
    public String CNPJ_Ente_Devedor;

    public EnteDevedorModel(String identificador_Ente_Devedor, String nome_Ente_Devedor, String CNPJ_Ente_Devedor) {
        Identificador_Ente_Devedor = identificador_Ente_Devedor;
        Nome_Ente_Devedor = nome_Ente_Devedor;
        this.CNPJ_Ente_Devedor = CNPJ_Ente_Devedor;
    }

    public String getIdentificador_Ente_Devedor() {
        return Identificador_Ente_Devedor;
    }

    public void setIdentificador_Ente_Devedor(String identificador_Ente_Devedor) {
        Identificador_Ente_Devedor = identificador_Ente_Devedor;
    }

    public String getNome_Ente_Devedor() {
        return Nome_Ente_Devedor;
    }

    public void setNome_Ente_Devedor(String nome_Ente_Devedor) {
        Nome_Ente_Devedor = nome_Ente_Devedor;
    }

    public String getCNPJ_Ente_Devedor() {
        return CNPJ_Ente_Devedor;
    }

    public void setCNPJ_Ente_Devedor(String CNPJ_Ente_Devedor) {
        this.CNPJ_Ente_Devedor = CNPJ_Ente_Devedor;
    }


}

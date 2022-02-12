package precato.precato.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "credor")
public class CredorModel {

    @Id
    @NotBlank(message = "Campo não informado")
    @NotNull
    public String Identificador_Credor;

    @Column
    @NotNull
    public String Nome_Credor;

    @Column
    @NotNull
    @CPF
    public String CPF_Credor;

    @Column
    @NotNull
    public String Status_Cadastro;

    public CredorModel(String identificador_Credor, String nome_Credor, String CPF_Credor, String status_Cadastro) {
        Identificador_Credor = identificador_Credor;
        Nome_Credor = nome_Credor;
        this.CPF_Credor = CPF_Credor;
        Status_Cadastro = status_Cadastro;
    }

    public String getIdentificador_Credor() {
        return Identificador_Credor;
    }

    public void setIdentificador_Credor(String identificador_Credor) {
        Identificador_Credor = identificador_Credor;
    }

    public String getNome_Credor() {
        return Nome_Credor;
    }

    public void setNome_Credor(String nome_Credor) {
        Nome_Credor = nome_Credor;
    }

    public String getCPF_Credor() {
        return CPF_Credor;
    }

    public void setCPF_Credor(String CPF_Credor) {
        this.CPF_Credor = CPF_Credor;
    }

    public String getStatus_Cadastro() {
        return Status_Cadastro;
    }

    public void setStatus_Cadastro(String status_Cadastro) {
        Status_Cadastro = status_Cadastro;
    }
}

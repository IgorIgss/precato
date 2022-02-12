package precato.precato.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "pagamento")
public class PagamentoModel {

    @Id
    @NotBlank(message = "Campo não informado")
    @NotNull
    public String Identificador_Remessa;

    @Column
    @NotBlank(message = "Campo não informado")
    @NotNull
    public String identificador_Credor;

    @Column
    @NotNull
    @NotBlank(message = "Campo não informado")
    public String Identificador_Ente_Devedor;

    @Column
    @NotNull
    @Min(value = 1)
    public float Valor_Inicial;

    @Column
    @NotNull
    @Min(value = 1)
    public float Valor_Final;

    @Column
    @NotNull
    public Timestamp Data;

    @Column
    @NotNull
    public String Status_Remessa;

    @Column
    public String Motivo;

    public PagamentoModel(String identificador_Remessa, String identificador_Credor, String identificador_Ente_Devedor, float valor_Inicial, float valor_Final, Timestamp data, String status_Remessa, String motivo) {
        if (valor_Final < valor_Inicial){
            Identificador_Remessa = identificador_Remessa;
            this.identificador_Credor = identificador_Credor;
            Identificador_Ente_Devedor = identificador_Ente_Devedor;
            Valor_Inicial = valor_Inicial;
            Valor_Final = valor_Final;
            Data = data;
            Status_Remessa = status_Remessa;
            Motivo = motivo;
        } else {
            System.out.println("Valor final maior que o valor inicial");
        }
    }

    public String getIdentificador_Remessa() {
        return Identificador_Remessa;
    }

    public void setIdentificador_Remessa(String identificador_Remessa) {
        Identificador_Remessa = identificador_Remessa;
    }

    public String getIdentificador_Credor() {
        return identificador_Credor;
    }

    public void setIdentificador_Credor(String identificador_Credor) {
        this.identificador_Credor = identificador_Credor;
    }

    public String getIdentificador_Ente_Devedor() {
        return Identificador_Ente_Devedor;
    }

    public void setIdentificador_Ente_Devedor(String identificador_Ente_Devedor) {
        Identificador_Ente_Devedor = identificador_Ente_Devedor;
    }

    public float getValor_Inicial() {
        return Valor_Inicial;
    }

    public void setValor_Inicial(float valor_Inicial) {
        Valor_Inicial = valor_Inicial;
    }

    public float getValor_Final() {
        return Valor_Final;
    }

    public void setValor_Final(float valor_Final) {
        Valor_Final = valor_Final;
    }

    public Timestamp getData() {
        return Data;
    }

    public void setData(Timestamp data) {
        Data = data;
    }

    public String getStatus_Remessa() {
        return Status_Remessa;
    }

    public void setStatus_Remessa(String status_Remessa) {
        Status_Remessa = status_Remessa;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }


}

package hmar.eb.mil.br.sat.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Graduacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private String posto;

    public Graduacao() {
        super();
    }

    public Graduacao(String posto) {
        this.posto = posto;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}

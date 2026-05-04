package org.example.model;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nome;
    private String cognome;
    private int eta;
    private String residenza;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }
    public String getResidenza() {
        return residenza;
    }
    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    
}

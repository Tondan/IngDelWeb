/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

/**
 *
 * @author Cristiano Orsetti
 */
public class Sillabo {
    private int IdSillabo;
    private String descrizione;
    
    private Corso corso;
    private int id_corso;

    public int getIdSillabo() {
        return IdSillabo;
    }

    public void setIdSillabo(int IdSillabo) {
        this.IdSillabo = IdSillabo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
        this.id_corso=this.corso.getCorso();
    }

    public int getId_corso() {
        return id_corso;
    }

    
    
    
    
}

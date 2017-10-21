/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;

/**
 *
 * @author Cristiano Orsetti
 */
public class Libro {
    private int idLibro;
    private String titolo;
    private String volume;
    private String Anno;
    private String Editore;
    private String Link;
    private int id_corso;
    private String codiceCorso;

    public int getId_corso() {
        return id_corso;
    }

    public String getCodiceCorso() {
        return codiceCorso;
    }
    private Corso corso;
     
    public Corso getCorso() throws DataLayerException {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
        this.id_corso= this.corso.getCorso();
        this.codiceCorso= this.corso.getCodice();           
    }
    

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAnno() {
        return Anno;
    }

    public void setAnno(String Anno) {
        this.Anno = Anno;
    }

    public String getEditore() {
        return Editore;
    }

    public void setEditore(String Editore) {
        this.Editore = Editore;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }
    
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;
import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Libro;
import java.time.Year;
import java.util.List;


/**
 *
 * @author Toni & Tony
 */
public class LibroImpl implements Libro {
    
    private int IDLibro;
    private String Autore;
    private String Titolo;
    private String Volume;
    private Year Anno;
    private String Editore;
    private String Link;
    private List<Corso> Corso;
    protected IgwDataLayer ownerdatalayer;
    
    public LibroImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        Corso=null;
        this.IDLibro=0;
        this.Autore=null;
        this.Titolo=null;
        this.Volume=null;
        this.Anno=null;
        this.Editore=null;
        this.Link=null;
    }
    
    @Override
    public int getIDLibro() {
        return this.IDLibro;
    }

    @Override
    public String getAutore() {
        return this.Autore;
    }
    

    @Override
    public String getTitolo() {
        return this.Titolo;
    }

    @Override
    public String getVolume() {
        return this.Volume;
    }

    @Override
    public Year getAnno() {
        return this.Anno;
    }

    @Override
    public String getEditore() {
        return this.Editore;
    }

    @Override
    public String getLink() {
        return this.Link;
    }

    @Override
    public void setAutore(String autore) {
        this.Autore=autore;
    }

    @Override
    public void setTitolo(String titolo) {
        this.Titolo=titolo;
    }

    @Override
    public void setVolume(String volume) {
        this.Volume=volume;
    }

    @Override
    public void setAnno(Year anno) {
        this.Anno=anno;
    }

    @Override
    public void setEditore(String editore) {
        this.Editore=editore;
    }

    @Override
    public void setLink(String link) {
        this.Link=link;
    }

    @Override
    public List<Corso> getCorsi() throws DataLayerException {
        return this.Corso;
    }

    @Override
    public void setCorsi(List<Corso> corsi) {
        this.Corso=corsi;
    }

    @Override
    public void addCorsi(Corso corso) {
        this.Corso.add(corso);
    }

}

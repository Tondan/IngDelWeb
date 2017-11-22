/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;
import courseweb.model.interfacce.*;
import courseweb.controller.data.DataLayerException;
import java.util.List;
/**
 *
 * @author Tony & Toni
 */
public class DocenteImpl implements Docente {
    
    private int id_docente;
    
    private String immagine;
    
    private String nome;
    
    private String cognome;
    
    private String email;
    
    private String ufficio;
    
    private String telefono;
    
    private String specializzazione;
    
    private String ricerche;
    
    private String pubblicazione;
    
    private String curriculum;
    
    private String ricevimento;
    
    private List<Corso> corsi;
    
    
    public DocenteImpl(){
        this.id_docente=0;
        this.nome=null;
        this.cognome=null;
        this.email=null;
        this.ufficio=null;
        this.telefono=null;
        this.specializzazione=null;
        this.ricerche=null;
        this.pubblicazione=null;
        this.curriculum=null;
        this.ricevimento=null;
    }
    
    
    @Override
    public int getIDDocente(){
        return this.id_docente;
    }

    @Override
    public String getImmagine() {
        return this.immagine;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCognome() {
        return this.cognome;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getUfficio() {
        return this.ufficio;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public String getSpecializzazione() {
        return this.specializzazione;
    }

    @Override
    public String getRicerche() {
        return this.ricerche;
    }

    @Override
    public String getPubblicazione() {
       return this.pubblicazione;
    }

    @Override
    public String getCurriculum() {
        return this.curriculum;
    }

    @Override
    public String getRicevimento() {
        return this.ricevimento;
    }

    @Override
    public void setImmagine(String Immagine) {
        this.immagine=Immagine;
    }
    

    @Override
    public void setNome(String nome) {
        this.nome=nome;
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome=cognome;
    }

    @Override
    public void setEmail(String email) {
        this.email=email;
    }

    @Override
    public void setUfficio(String ufficio) {
       this.ufficio=ufficio;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono=telefono;
    }

    @Override
    public void setSpecializzazione(String specializzazione) {
        this.specializzazione=specializzazione;    
    }

    @Override
    public void setRicerche(String ricerche) {
        this.ricerche=ricerche;
    }

    @Override
    public void setPubblicazioni(String pubblicazioni) {
        this.pubblicazione=pubblicazioni;
    
    }

    @Override
    public void setCurriculum(String curriculum) {
        this.curriculum=curriculum;
    }

    @Override
    public void setRicevimento(String ricevimento) {
        this.ricevimento=ricevimento;
    }

    @Override
    public List<Corso> getCorsi() throws DataLayerException {
        return this.corsi;
    }

        @Override
    public void setCorsi(List<Corso> corsi){
        this.corsi=corsi;
    }
    
    @Override
    public void addCorso(Corso corso){
        this.corsi.add(corso);
    }
    
}

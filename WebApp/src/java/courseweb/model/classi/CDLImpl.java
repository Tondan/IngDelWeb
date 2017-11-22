/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import java.time.Year;
import courseweb.model.interfacce.*;
import java.util.List;

/**
 *
 * @author Toni & Tony
 */


public class CDLImpl implements CDL{
    
    private int id_cdl;
    
    private String nome_it;
    
    private String nome_en;
    
    private Year anno;
    
    private int cfu;
    
    private List<Corso> corsi;
    
    public CDLImpl(){
        this.id_cdl=0;
        this.nome_it=null;
        this.nome_en=null;
        this.anno=null;
        this.cfu=0;
        this.corsi=null;
    }
    
    @Override
    public int getIDCDL(){
        return this.id_cdl;
    }
    
    @Override
    public String getNome_it(){
        return this.nome_it;
    }
    
    @Override
    public String getNome_en(){
        return this.nome_en;
    }
    
    @Override
    public void setNome_it(String nome){
        this.nome_it=nome;
    }
    
    @Override
    public void setNome_en(String nome){
        this.nome_en=nome;
    }
    
    @Override
    public Year getAnno(){
        return this.anno;
    }
    
    @Override
    public void setAnno(Year anno){
        this.anno=anno;
    }
    
    @Override
    public int getCfu(){
        return this.cfu;
    }
    
    @Override
    public void setCfu(int cfu){
        this.cfu=cfu;
    }
    
    @Override
    public List<Corso> getCorsiInCdl() throws DataLayerException{
        return this.corsi;
    }
    
    @Override
    public void setCorsiInCdl(List<Corso> corsi){
        this.corsi=corsi;
    }
    
    @Override
    public void addCorsoInCdl(Corso corso){
        this.corsi.add(corso);
    }
}
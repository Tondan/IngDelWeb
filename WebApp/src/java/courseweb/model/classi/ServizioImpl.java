/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;
import courseweb.model.interfacce.Servizio;
import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Gruppo;
import java.util.List;
/**
 *
 * @author Tony
 */
public class ServizioImpl implements Servizio {

    private int IDServizio;
    private String Script;
    private String Descrizione;
    private List<Gruppo> Gruppi;
    
    
    public ServizioImpl(){
        this.IDServizio=0;
        this.Script=null;
        this.Descrizione=null;
        this.Gruppi=null;
    }
    
    @Override
    public int getIDServizio() {
        return this.IDServizio;
    }

    @Override
    public String getScript() {
        return this.Script;
    }

    @Override
    public String getDescrizione() {
        return this.Descrizione;
    }

    @Override
    public void setIDServizio(int idservizio) {
        this.IDServizio=idservizio;
    }

    @Override
    public void setScript(String script) {
        this.Script=script;
    }

    @Override
    public void setDescrizione(String descrizione) {
        this.Descrizione=descrizione;
    }

    @Override
    public List<Gruppo> getGruppi() throws DataLayerException {
      return this.Gruppi;
    }

    @Override
    public void setGruppi(List<Gruppo> gruppi) {
        this.Gruppi=gruppi;
    }

    @Override
    public void addGruppo(Gruppo gruppo) {
        this.Gruppi.add(gruppo);
    }
    
}

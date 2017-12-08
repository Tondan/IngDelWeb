package courseweb.model.classi;
import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.*;


/**
 *
 * @author Toni & Tony
 */
public class Dublino_itImpl implements Dublino_it{
    
    private Corso corso;
    
    private int id_corso;
    
    private String knowledge;
    
    private String application;
    
    private String evaluation;
    
    private String communication;
    
    private String lifelong;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
    public Dublino_itImpl(IgwDataLayer ownerdatalayer){
    this.ownerdatalayer=ownerdatalayer;
    this.corso=null;
    this.knowledge=null;
    this.application=null;
    this.evaluation=null;
    this.communication=null;
    this.lifelong=null;
    this.id_corso=-1;
    this.dirty=false;
}
    
    @Override
    public void setIDCorso(int id_corso){
        this.id_corso=id_corso;
    }

    @Override
    public Corso getCorso() throws DataLayerException{
        if(corso==null)
            corso=ownerdatalayer.getCorso(id_corso);
        return corso;
    }

    @Override
    public void setCorso(Corso corso) {
        this.corso=corso;
        this.dirty=false;
    }

    @Override
    public String getKnowledge() {
        return this.knowledge;
    }

    @Override
    public void setKnowledge(String knowledge) {
        this.knowledge=knowledge;
        this.dirty=false;
    }

    @Override
    public String getApplication() {
        return this.application;
    }

    @Override
    public void setApplication(String application) {
        this.application=application;
        this.dirty=false;
    }

    @Override
    public String getEvaluation() {
        return this.evaluation;
    }

    @Override
    public void setEvaluation(String evaluation) {
       this.evaluation=evaluation;
       this.dirty=false;
    }

    @Override
    public String getCommunication() {
        return this.communication;
    }

    @Override
    public void setCommunication(String communication) {
        this.communication=communication;
        this.dirty=false;
    }

    @Override
    public String getLifelong() {
        return this.lifelong;
    }

    @Override
    public void setLifelong(String lifelong) {
        this.lifelong=lifelong;
        this.dirty=false;
    }

    
    
   
}
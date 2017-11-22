package courseweb.model.classi;
import courseweb.model.interfacce.*;


/**
 *
 * @author Tony
 */
public class Dublino_enImpl implements Dublino_en{
    
    private Corso corso;
    
    private String knowledge;
    
    private String application;
    
    private String evaluation;
    
    private String communication;
    
    private String lifelong;
    
    protected IgwDataLayer ownerdatalayer;
    
    public Dublino_enImpl(IgwDataLayer ownerdatalayer){
    this.ownerdatalayer=ownerdatalayer;
    this.corso=null;
    this.knowledge=null;
    this.application=null;
    this.evaluation=null;
    this.communication=null;
    this.lifelong=null;
}

    @Override
    public Corso getCorso() {
        return this.corso;
    }

    @Override
    public void setCorso(Corso corso) {
        this.corso=corso;
    }

    @Override
    public String getKnowledge() {
        return this.knowledge;
    }

    @Override
    public void setKnowledge(String knowledge) {
        this.knowledge=knowledge;
    }

    @Override
    public String getApplication() {
        return this.application;
    }

    @Override
    public void setApplication(String application) {
        this.application=application;
    }

    @Override
    public String getEvaluation() {
        return this.evaluation;
    }

    @Override
    public void setEvaluation(String evaluation) {
       this.evaluation=evaluation;
    }

    @Override
    public String getCommunication() {
        return this.communication;
    }

    @Override
    public void setCommunication(String communication) {
        this.communication=communication;
    }

    @Override
    public String getLifelong() {
        return this.lifelong;
    }

    @Override
    public void setLifelong(String lifelong) {
        this.lifelong=lifelong;
    }
    
    
    
}
/*
 * N.B Attenzione la liste vanno messe in caso di relazioni n-n ed 1-n
 *     dalla parte dell'1 (1-n), o ad entrambe dalla parte dell'n (n-n)
 */
package courseweb.model.interfacce;
import courseweb.controller.data.DataLayerException;
import java.util.Calendar;
import java.util.List;
/**
 *
 @author Toni $ Tony
 */
public interface CDL {
    
    int getIDCDL();
    
    String getNome_it();
    
    void setNome_it(String nome_it);
    
    String getNome_en();
    
    void setNome_en(String nome_en);
    
    int getAnno();

    void setAnno(int anno);
    
    int getCfu();
    
    void setCfu(int cfu);
    
    List<Corso> getCorsiInCdl() throws DataLayerException;
    
    void setCorsiInCdl(List<Corso> corsi);
    
    void addCorsoInCdl(Corso corso);
}

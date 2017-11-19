/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;

import java.util.List;
/**
 *
 * @author Toni & Tony
 */
public interface Docenti_Corso {
    
    int getCorso(int id_corso);
    
    void setCorso(int id_corso);
    
    int getDocente(int id_docente);
    
    void setDocente(int id_docente);
    
    List<Docente> getDocenti(int corso);
    
    List<Corso> getCorsi(int docente);
    
}

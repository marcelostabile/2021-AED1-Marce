package mutualista;

import archivos.*;
import implementacionesParcial.*;
import mutualista.*;
import tdas.*;

/*Implementación de la clase consulta, parte 2 del parcial*/
public class Consulta implements IConsulta{

    private String idMedicoConsulta;
    private String apellidoPaciente; 
    private String diaYHora;
    private String codPoliclinica; 
    private String especialidadConsulta;

    public Consulta(String idMedicoConsulta, String apellidoPaciente, String diaYHora, String codPoliclinica,
            String especialidadConsulta) {
        this.idMedicoConsulta = idMedicoConsulta;
        this.apellidoPaciente = apellidoPaciente;
        this.diaYHora = diaYHora;
        this.codPoliclinica = codPoliclinica;
        this.especialidadConsulta = especialidadConsulta;
    }

    @Override
    public String getIDMedicoConsulta() {
        return this.idMedicoConsulta;
    }

    @Override
    public String getApellidoPaciente() {
        return this.apellidoPaciente;
    }

    @Override
    public String getEspecialidadConsulta() {
        return this.especialidadConsulta;
    }

    @Override
    public String getDiaYHora() {
        return this.diaYHora;
    }

    @Override
    public String getCodPoliclinica() {
        return this.codPoliclinica;
    }

    @Override
    public void setIdMedicoConsulta(String idMedicoConsulta) {
        this.idMedicoConsulta = idMedicoConsulta;        
    }

    @Override
    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;        
    }

    @Override
    public void setEspecialidadConsulta(String especialidadConsulta) {
        this.especialidadConsulta = especialidadConsulta;        
    }

    @Override
    public void setDiaYHora(String diaYHora) {
        this.diaYHora = diaYHora;        
    }

    @Override
    public void setCodPoliclinica(String codPoliclinica) { 
        this.codPoliclinica = codPoliclinica;
    }
    
}

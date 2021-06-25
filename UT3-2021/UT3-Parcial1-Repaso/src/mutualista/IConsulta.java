package mutualista;

import archivos.*;
import implementacionesParcial.*;
import mutualista.*;
import tdas.*;

public interface IConsulta {
    //  idMedico, Apellido_Paciente, Especialidad, DiaYHora, policlinica

    public String getIDMedicoConsulta();
    public String getApellidoPaciente();
    public String getEspecialidadConsulta();
    public String getDiaYHora();
    public String getCodPoliclinica();

    public void setIdMedicoConsulta(String idMedicoConsulta);
    public void setApellidoPaciente(String apellidoPaciente);
    public void setEspecialidadConsulta(String especialidadConsulta);
    public void setDiaYHora(String diaYHora);
    public void setCodPoliclinica(String codPoliclinica);
}

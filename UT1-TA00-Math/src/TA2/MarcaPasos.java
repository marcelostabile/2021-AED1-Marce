package TA2;

public class MarcaPasos {

    private short presion;
    private short frecuencia;
    private short nivelAzucar;

    private long fuerzaMaximaExpuesto;
    private double tiempoMinimoLatidos;
    private double bateriaRestante;
    private char codigo[];

    public MarcaPasos () {
        presion = 0;
        frecuencia = 0;
        nivelAzucar = 0;

        fuerzaMaximaExpuesto = 0;
        tiempoMinimoLatidos = 0.0;
        bateriaRestante = 0.0;
        codigo = new char[8];
    }

    public short getPresion() {
        return presion;
    }

    public void setPresion(short presion) {
        this.presion = presion;
    }

    public short getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(short frecuencia) {
        this.frecuencia = frecuencia;
    }

    public short getNivelAzucar() {
        return nivelAzucar;
    }

    public void setNivelAzucar(short nivelAzucar) {
        this.nivelAzucar = nivelAzucar;
    }

    public long getFuerzaMaximaExpuesto() {
        return fuerzaMaximaExpuesto;
    }

    public void setFuerzaMaximaExpuesto(long fuerzaMaximaExpuesto) {
        this.fuerzaMaximaExpuesto = fuerzaMaximaExpuesto;
    }

    public double getTiempoMinimoLatidos() {
        return tiempoMinimoLatidos;
    }

    public void setTiempoMinimoLatidos(double tiempoMinimoLatidos) {
        this.tiempoMinimoLatidos = tiempoMinimoLatidos;
    }

    public double getBateriaRestante() {
        return bateriaRestante;
    }

    public void setBateriaRestante(double bateriaRestante) {
        this.bateriaRestante = bateriaRestante;
    }

    public char[] getCodigo() {
        return codigo;
    }

    public void setCodigo(char[] codigo) {
        this.codigo = codigo;
    }
    
}

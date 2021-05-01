package farmacia;

public class Suero implements ISuero {
    
    private int idSuero;
    private String descSuero;

    public Suero(int idSuero, String descSuero) {
        this.idSuero = idSuero;
        this.descSuero = descSuero;
    }

    public int getIdSuero() {
        return idSuero;
    }

    public void setIdSuero(int idSuero) {
        this.idSuero = idSuero;
    }

    public String getDescSuero() {
        return descSuero;
    }

    public void setDescSuero(String descSuero) {
        this.descSuero = descSuero;
    }

}

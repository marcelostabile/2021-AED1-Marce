package farmacia;

public class Farmaco implements IFarmaco {

    private int idFarmaco;
    private String descFarmaco;

    public Farmaco(int idFarmaco, String descFarmaco) {
        this.idFarmaco = idFarmaco;
        this.descFarmaco = descFarmaco;
    }

    public int getIdFarmaco() {
        return idFarmaco;
    }

    public void setIdFarmaco(int idFarmaco) {
        this.idFarmaco = idFarmaco;
    }

    public String getDescFarmaco() {
        return descFarmaco;
    }

    public void setDescFarmaco(String descFarmaco) {
        this.descFarmaco = descFarmaco;
    }

}
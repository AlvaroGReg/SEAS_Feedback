package Model;

/**
 *
 * @author alvar
 */
public class ClientModel {
    private int id;
    private String name;
    private String prename1;
    private String prename2;
    private boolean vip;

    public ClientModel(int id, String name, String prename1, String prename2, boolean vip) {
        this.id = id;
        this.name = name;
        this.prename1 = prename1;
        this.prename2 = prename2;
        this.vip = vip;
    }

    public ClientModel(String name, String prename1, String prename2, boolean vip) {
        this.name = name;
        this.prename1 = prename1;
        this.prename2 = prename2;
        this.vip = vip;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename1() {
        return prename1;
    }

    public void setPrename1(String prename1) {
        this.prename1 = prename1;
    }

    public String getPrename2() {
        return prename2;
    }

    public void setPrename2(String prename2) {
        this.prename2 = prename2;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

}
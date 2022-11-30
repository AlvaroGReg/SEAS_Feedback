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
    private int vipCode;

    public ClientModel(int id, String name, String prename1, String prename2, int code) {
        this.id = id;
        this.name = name;
        this.prename1 = prename1;
        this.prename2 = prename2;
        this.vipCode = code;
    }

    public ClientModel(String name, String prename1, String prename2, int code) {
        this.name = name;
        this.prename1 = prename1;
        this.prename2 = prename2;
        this.vipCode = code;
    }

    public ClientModel(int id, String name, String prename1, String prename2) {
        this.id = id;
        this.name = name;
        this.prename1 = prename1;
        this.prename2 = prename2;
    }

    public ClientModel(String name, String prename1, String prename2) {
        this.name = name;
        this.prename1 = prename1;
        this.prename2 = prename2;
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

    public int getCode() {
        return vipCode;
    }

    public void setCode(int code) {
        this.vipCode = code;
    }   
}
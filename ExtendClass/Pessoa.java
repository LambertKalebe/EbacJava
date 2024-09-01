package ExtendClass;

abstract class Pessoa {
    private String name;
    private int tel;

    // Constructor
    public Pessoa(String name, int tel) {
        this.name = name;
        this.tel = tel;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getTel() {
        return tel;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}








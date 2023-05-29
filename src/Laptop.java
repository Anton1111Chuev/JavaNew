public class Laptop {
    private int  RAM, HD;
    private String name;


    public Laptop(String name, int ram, int hd) {
        this.RAM = ram;
        this.HD = hd;
        this.name = name;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getHD() {
        return HD;
    }

    public void setHD(int HD) {
        this.HD = HD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

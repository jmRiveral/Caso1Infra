public class buzon {
    private String id;
    private int capacidad;

    public buzon(String pId,int pcCapacidad){
        this.id=pId;
        this.capacidad=pcCapacidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getId() {
        return id;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}

package co.edu.usbbog.swm.model;

public class Ingresos {

    private int id;
    private String ingresos;
    private double valor;
    private int usuario;

    public Ingresos(int id, String ingresos, double valor, int usuario) {
        this.id = id;
        this.ingresos = ingresos;
        this.valor = valor;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngresos() {
        return ingresos;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Ingresos{" +
                "id=" + id +
                ", ingresos='" + ingresos + '\'' +
                ", valor=" + valor +
                ", usuario=" + usuario +
                '}';
    }

    public Ingresos() {

    }
}

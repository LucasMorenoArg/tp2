public class Cuota {

    private double monto;
    private String estado;

    private boolean conDemora;

    public Cuota(double monto) {
        this.monto = monto;
        this.estado = "pendiente";
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isConDemora() {
        return conDemora;
    }

    public void setConDemora(boolean conDemora) {
        this.conDemora = conDemora;
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "monto=" + monto +
                ", estado='" + estado + '\'' +
                '}';
    }
}

import java.util.List;
public class PlanPago {

    private String nombreContribuyente;
    private List<Cuota> cuotasPlan;
    private double interesesAcumulados;

    private double montoTotalPlan;

    public PlanPago(String nombreContribuyente, List<Cuota> cuotasPlan, double montoTotalPlan) {
        this.nombreContribuyente = nombreContribuyente;
        this.cuotasPlan = cuotasPlan;
        this.montoTotalPlan = montoTotalPlan;
    }

    public String getNombreContribuyente() {
        return nombreContribuyente;
    }

    public void setNombreContribuyente(String nombreContribuyente) {
        this.nombreContribuyente = nombreContribuyente;
    }

    public List<Cuota> getCuotasPlan() {
        return cuotasPlan;
    }

    public void setCuotasPlan(List<Cuota> cuotasPlan) {
        this.cuotasPlan = cuotasPlan;
    }

    public double getInteresesAcumulados() {
        return interesesAcumulados;
    }

    public void setInteresesAcumulados(double interesesAcumulados) {
        this.interesesAcumulados = interesesAcumulados;
    }

    public double getMontoTotalPlan() {
        return montoTotalPlan;
    }

    public void setMontoTotalPlan(double montoTotalPlan) {
        this.montoTotalPlan = montoTotalPlan;
    }

    @Override
    public String toString() {
        return "PlanPago{" +
                "nombreContribuyente='" + nombreContribuyente + '\'' +
                ", cuotasPlan=" + cuotasPlan +
                ", intereseserAcumulados=" + interesesAcumulados +
                '}';
    }

    public void registrarIntereses(double interes) {
        interesesAcumulados += interes;
    }

    public void abonarCuota(int demora) {

        cuotasPlan.stream().filter(cuotas -> cuotas.getEstado().equals("pendiente")).findFirst().ifPresent(cuota1 -> {
            cuota1.setEstado("abonada");
            double interes = 0.05 * demora * cuota1.getMonto();
            cuota1.setConDemora(demora != 0);
            registrarIntereses(interes);
        });
    }

    public double calcularInteresPromedio() {
        long cuotasConDemora = cuotasPlan.stream().filter(Cuota::isConDemora).count();
        double promedioIntereses = interesesAcumulados / cuotasConDemora;
        return Double.isNaN(promedioIntereses) ? 0 : promedioIntereses;
    }

    public boolean planCancelado() {
        return cuotasPlan.stream().allMatch(cuota -> cuota.getEstado().equals("abonada"));
    }

    public Long cuotasDemoradas() {
        return cuotasPlan.stream().filter(Cuota::isConDemora).count();
    }
}

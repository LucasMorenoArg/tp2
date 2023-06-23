import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ContenedorPlanesPago {

    private List<PlanPago> planesPago;
    private double montoTotalPlan;

    public List<PlanPago> getPlanesPago() {
        return planesPago;
    }

    public void setPlanesPago(List<PlanPago> planesPago) {
        this.planesPago = planesPago;
    }

    public double getMontoTotalPlan() {
        return montoTotalPlan;
    }

    public void setMontoTotalPlan(double montoTotalPlan) {
        this.montoTotalPlan = montoTotalPlan;
    }

    @Override
    public String toString() {
        return "ContenedorPlanesPago{" +
                "planesPago=" + planesPago +
                ", montoTotalPlan=" + montoTotalPlan +
                '}';
    }

    public PlanPago crearPlanPago(String linea) {
        String[] datos = linea.split(";");
        double montoTotalPlan = Integer.valueOf(datos[1]) * Integer.valueOf(datos[2]);
        PlanPago planPago = new PlanPago(datos[0], new ArrayList<>(), montoTotalPlan);
        int cantCuotas = Integer.valueOf(datos[1]);
        double montoCuota = Double.valueOf(datos[2]);

        IntStream.range(0, cantCuotas).forEach((s) -> {
            planPago.getCuotasPlan().add(new Cuota(montoCuota));
        });

        return planPago;
    }

    public void registrarPago(String linea) {
        String[] datos = linea.split(";");
        String nombreContribuyente = datos[0];
        int demora = Integer.valueOf(datos[1]);
        PlanPago planPago = planesPago.stream()
                .filter(p -> p.getNombreContribuyente().equals(nombreContribuyente))
                .findFirst().get();
        planPago.abonarCuota(demora);
    }
}

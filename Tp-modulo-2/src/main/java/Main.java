import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        ContenedorPlanesPago contenedorPlanesPago = new ContenedorPlanesPago();
        File fileContribuyentes = new File("contribuyentes.txt");
        List<PlanPago> planPagos = Files.lines(fileContribuyentes.toPath())
                .map(contenedorPlanesPago::crearPlanPago)
                .collect(Collectors.toList());

        contenedorPlanesPago.setPlanesPago(planPagos);

        File filePagos = new File("pagos.txt");
        Files.lines(filePagos.toPath()).forEach(contenedorPlanesPago::registrarPago);

        MiFuncion pagosCancelados = (List<PlanPago> p ) -> {System.out.println("planes de pagos cancelados: " + p.stream().filter(s -> s.planCancelado()).count());};
        MiFuncion sumaDeudasRegistradas = (List<PlanPago> p ) -> {System.out.println("suma total de deudas registradas: " + p.stream().map(PlanPago::getMontoTotalPlan).mapToDouble(Double::doubleValue).sum());};
        MiFuncion busquedaParaAndres = (List<PlanPago> p ) -> {System.out.println("Pagos realizados por Andrés : " + p.stream().filter(planPago -> planPago.getNombreContribuyente().equals("Andres")).findFirst().get().getCuotasPlan().stream().filter(cuota -> !cuota.isConDemora()).collect(Collectors.toList()));};
        MiFuncion promedioInteresesPagados = (List<PlanPago> p ) -> {
            double interesesPagados = p.stream().mapToDouble(PlanPago::calcularInteresPromedio).sum();
            long cantidadCuotasDemoradas = p.stream().filter(planPago1 -> planPago1.cuotasDemoradas() > 0).count();
            System.out.println("promedio de intereses pagados: " + interesesPagados / cantidadCuotasDemoradas);
        };

        List<MiFuncion> menu = new ArrayList<>();
        menu.add(null);
        menu.add(pagosCancelados);
        menu.add(sumaDeudasRegistradas);
        menu.add(busquedaParaAndres);
        menu.add(promedioInteresesPagados);

        Scanner scanner = new Scanner(System.in);
        System.out.println("selecccione una opción");
        System.out.println("0 para salir");
        System.out.println("1 para saber cuantos planes de pagos fueron cancelados en su totalidad");
        System.out.println("2 para saber la Sumatoria de las deudas registradas");
        System.out.println("3 para ver los pagos realizados por Andrés");
        System.out.println("4 para saber Promedio general de intereses adicionales cobrados");
        int opcion = scanner.nextInt();

        while (opcion != 0) {

            System.out.println("##################################################################");
            menu.get(opcion).defaultmethod(contenedorPlanesPago.getPlanesPago());
            System.out.println("##################################################################");

            System.out.println("selecccione una opción nuevamente");
            opcion = scanner.nextInt();
        }


    }
}

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Y_7QyZAz)
# Trabajo Práctico 2

En una municipalidad otorgan planes de pagos a los contribuyentes
que adeudan impuestos. De cada plan se conoce el nombre del
contribuyente, el total de la deuda, la cantidad de cuotas y una
lista de las cuotas pagadas. El  importe a pagar de cada cuota es
el cociente entre el total de la deudad y la cantidad de cuotas.

A su vez, cada vez que un deudor efectúa un pago se registran los
datos correspondientes a la operación. De cada pago se conoce el 
plan al que corresponde y cantidad de días de demora.
Cuando el pago se realiza el día del vencimiento o antes, la demora
se carga como 0 y en caso contrario a la cantidad de días transcurridos
entre el vencimiento y el pago. Cuando el pago se realiza en fecha,
no se cobran intereses adicionales, pero si hay demora se le cobra
un 0,5% del importe de la cuota por día.

La municipalidad necesita un software que le permita registrar los
datos de todos los planes emitidos y de los pagos recibidos.
Asimismo, el software debe poder calcular el importe de los
intereses adicionales a partir de la cantidad de días de demora.

Se debe desarrollar un programa en Java que obtenga de dos archivos de texto los datos de
los planes y de los pagos y luego de finalizada la carga informe:

-   Cantidad de planes pagados en su totalidad (es decir, que tengan
    tantos pagos recibidos como la cantidad de cuotas pactadas)

-   Sumatoria de las deudas registradas

-   Listado de todos los pagos efectuados por un contribuyente en
    particular

-   Promedio general de intereses adicionales cobrados

El programa no debería utilizar ninguna estructura de control (condicionales y ciclos), únicamente colecciones y flujos.

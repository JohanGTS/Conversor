/*

 */
package conversor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author Johan
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DecimalFormat numberFormat = new DecimalFormat("#.00");
        String[] tipoConversor = {"Moneda", "Distancia", "Tiempo"};
        Object valorSeleccionado = JOptionPane.showInputDialog(null,
                "Elija uno", "Input",
                JOptionPane.INFORMATION_MESSAGE, null,
                tipoConversor, tipoConversor[0]);

        int indiceTipoConversor = retornarIndice(tipoConversor, valorSeleccionado);

        switch (indiceTipoConversor) {
            case 0:
                List<Moneda> monedas = new ArrayList<>();

                monedas.add(new Moneda("peso dominicano", 0.018));
                monedas.add(new Moneda("dolar estadounidense", 1));
                monedas.add(new Moneda("peso mexicano", 0.052));
                monedas.add(new Moneda("dolar canadiense", 0.75));
                monedas.add(new Moneda("euro", 1.07));
                monedas.add(new Moneda("libra esterlina", 1.22));

                Moneda monedaSeleccionada = (Moneda) JOptionPane.showInputDialog(null,
                        "Elija moneda base", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        monedas.toArray(), monedas.get(0).getNombre());

                Moneda valorConversor
                        = (Moneda) JOptionPane.showInputDialog(null,
                                "Elija moneda a convertir", "Input",
                                JOptionPane.INFORMATION_MESSAGE, null,
                                monedas.stream().filter(moneda -> !moneda.getNombre().equalsIgnoreCase(monedaSeleccionada.getNombre())).collect(Collectors.toList()).toArray(),
                                monedas.get(0).getNombre());

                double valorConverir = introducirValor();
                double valorConvertido = monedaSeleccionada.obtenerConversion(valorConversor, valorConverir);
                JOptionPane.showMessageDialog(null, ("El valor en " + valorConversor.getNombre()
                        + " es de " + numberFormat.format(valorConvertido)));
                break;
            case 1:
                /*List<Distancia> distancias = new ArrayList<>();

                distancias.add(new Distancia("metro", 1));
                distancias.add(new Distancia("milimetro", 0.001));
                distancias.add(new Distancia("centimetro", 0.01));
                distancias.add(new Distancia("kilometro",1000));
                distancias.add(new Distancia("milla", 0.000621371));
                distancias.add(new Distancia("pie",0.3048));

                Distancia distanciaSeleccionada = (Distancia) JOptionPane.showInputDialog(null,
                        "Elija moneda base", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        distancias.toArray(), distancias.get(0).getNombre());

                Distancia distanciaConversor
                        = (Distancia) JOptionPane.showInputDialog(null,
                                "Elija moneda a convertir", "Input",
                                JOptionPane.INFORMATION_MESSAGE, null,
                                distancias.stream().filter(moneda -> !moneda.getNombre().equalsIgnoreCase(distanciaSeleccionada.getNombre())).collect(Collectors.toList()).toArray(),
                                distancias.get(0).getNombre());

                valorConverir = introducirValor();
                valorConvertido = distanciaSeleccionada.obtenerConversion(distanciaConversor, valorConverir);
                JOptionPane.showMessageDialog(null, ("El valor en " + distanciaConversor.getNombre()
                        + " es de " + numberFormat.format(valorConvertido)));**/
                break;

            case 2:
                break;

            default:
                JOptionPane.showMessageDialog(null, "Algo inesperado ocurrió", "alert", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Se encarga de retornar el índice en que se encuentre un arreglo de objetos
     * @param arreglo Arreglo en el que se desea buscar un elemento
     * @param valorBuscar Elemento que se buscará en el arreglo
     * @return índice en que se encuentra el valorBuscar , si no se encuentra retorna -1
     **/
    public static int retornarIndice(Object[] arreglo, Object valorBuscar) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valorBuscar) {
                return i;
            }
        }
        return -1;
    }

    public static double introducirValor() {
        try {
            String inputValue = JOptionPane.showInputDialog("Digite el valor a convertir: ");
            return Double.parseDouble(inputValue);
        } catch (NullPointerException e) {
            return -1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor no esperado", "alert", JOptionPane.ERROR_MESSAGE);
            return introducirValor();
        }
    }

}

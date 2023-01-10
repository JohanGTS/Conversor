/*

 */
package conversor;

import javax.swing.JOptionPane;

/**
 *
 * @author Johan
 */
public class Moneda extends Cambio{
    
    private double precioDolar;

    public Moneda(String nombre, double precioDolar) {
        super(nombre);
        this.precioDolar=precioDolar;
    }

    public double getPrecioDolar() {
        return precioDolar;
    }

    public void setPrecioDolar(double precioDolar) {
        this.precioDolar = precioDolar;
    }
    
    /**
     * Método que se encarga de realizar la conversión de una moneda a otra basándose en los precios del dólar
     * de las monedas deseadas
     * @param moneda Moneda a convertir
     * @return Representación de una unidad de la moneda antigua a la nueva moneda
     **/
    private double obtenerConversion(Moneda moneda) {
        try 
        {
            if(this.precioDolar<=0||moneda.getPrecioDolar()<=0)
                throw new IllegalArgumentException("Valor no posible");
            return this.precioDolar/ moneda.getPrecioDolar();
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No es posible realizar esta operación", "alert", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        
    }
    /**
     * Método que toma una Moneda y su cantidad para retornar la conversión en la moneda entrada
     * @param moneda Representa la Moneda en que se desea convertir la cantidad
     * @param cantidad Cantidad de la Moneda
     * 
     * @return La representación en la moneda pasada como parámetro por la cantidad
     **/
    public double obtenerConversion(Moneda moneda, double cantidad){
        return obtenerConversion(moneda)*cantidad;
    }
    
}

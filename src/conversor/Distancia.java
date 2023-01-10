/*

 */
package conversor;

import javax.swing.JOptionPane;

/**
 *
 * @author Johan
 */
public class Distancia extends Cambio{
    
    private double distanciaEnMetros;
    
    public Distancia(String nombre, double distanciaEnMetros) {
        super(nombre);
        this.distanciaEnMetros=distanciaEnMetros;
    }

    public double getDistanciaEnMetros() {
        return distanciaEnMetros;
    }

    public void setDistanciaEnMetros(double distanciaEnMetros) {
        this.distanciaEnMetros = distanciaEnMetros;
    }
    
    
    
    /**
     * Método que se encarga de realizar la conversión de una distancia a otra basándose en su representación en metros
     * @param distancia Distancia a convertir
     * @return Representación de una unidad de la moneda antigua a la nueva moneda
     **/
    private double obtenerConversion(Distancia distancia) {
        try 
        {
            if(this.distanciaEnMetros<=0||distancia.getDistanciaEnMetros()<=0)
                throw new IllegalArgumentException("Valor no posible");
            return this.distanciaEnMetros/ distancia.getDistanciaEnMetros();
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No es posible realizar esta operación", "alert", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        
    }
    /**
     * Método que toma una Moneda y su cantidad para retornar la conversión en la moneda entrada
     * @param distancia Representa la Distancia en que se desea convertir la cantidad
     * @param cantidad Cantidad de la Distancia
     * 
     * @return La representación en la moneda pasada como parámetro por la cantidad
     **/
    public double obtenerConversion(Distancia distancia, double cantidad){
        return obtenerConversion(distancia)*cantidad;
    }
    
}

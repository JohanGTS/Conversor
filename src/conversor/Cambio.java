
package conversor;


public abstract class Cambio {
    private String nombre;

    public Cambio(String nombre) {
        this.nombre = nombre;
    }
  
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return   nombre ;
    }
}

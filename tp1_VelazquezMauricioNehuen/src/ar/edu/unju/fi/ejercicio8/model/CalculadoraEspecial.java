package ar.edu.unju.fi.ejercicio8.model;

/**
 * Clase que representa a una calculadora de Sumatoria y Productoria
 * @author Velazquez Mauricio Nehuen
 */

public class CalculadoraEspecial {
    private Integer n;

    public CalculadoraEspecial() { }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    /**
     * Este metodo se encarga de calcular la sumatoria del numero N
     * Formula: [(k * (k + 1)) / 2]^2 + ... + [((k+n) * ((k+n) + 1)) /2]^2
     * k = 1 se incrementa de a 1 hasta que sea igual a n
     * @return un Integer que es la sumatoria del numero n
     */
    public Integer calcularSumatoria(){
        int sumatoria = 0;
        for(int i = 1; i <= n; i++){
            int operacion = ( (i * (i + 1)) / 2) * ( (i * (i + 1)) / 2);
            sumatoria = sumatoria + operacion;
        }
        return sumatoria;
    }

    /**
     * Este metodo se encarga de calcular la productoria del numero N
     * Formula: k*(k + 4 ) * ... * [(k+1)*((k+1) + 4)]
     * k = 1 se incrementa de a 1 hasta que sea igual a n
     * @return un Integer que es la productoria del numero n
     */
    public Integer calcularProductoria(){
        int productoria = 1;
        for (int i = 1; i <= n; i++){
            productoria = productoria * (i * (i + 4));
        }
        return productoria;
    }
}

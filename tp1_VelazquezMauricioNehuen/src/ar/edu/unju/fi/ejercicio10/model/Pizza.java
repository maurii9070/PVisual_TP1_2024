package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
    private Integer diametro;
    private Float precio;
    private Float area;
    private Boolean ingredientesEspeciales;
    private static final Float ADICIONAL_INGREDIENTES_ESP_20 = 500.0F;
    private static final Float ADICIONAL_INGREDIENTES_ESP_30 = 750.0F;
    private static final Float ADICIONAL_INGREDIENTES_ESP_40 = 1000.0F;

    public Pizza() {}

    @Override
    public String toString() {
        return  "Diametro = " + diametro + '\n' +
                "Ingredientes especiales = " + ingredientesEspeciales + '\n' +
                "Precio Pizza = $" + precio + '\n' +
                "Area de la pizza = " + area;
    }

    public Integer getDiametro() {
        return diametro;
    }

    public void setDiametro(Integer diametro) {
        this.diametro = diametro;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getArea() {
        return this.area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Boolean getIngredientesEspeciales() {
        return ingredientesEspeciales;
    }

    public void setIngredientesEspeciales(Boolean ingredientesEspeciales) {
        this.ingredientesEspeciales = ingredientesEspeciales;
    }

    public void calcularPrecio(){
        if(diametro == 20 && !ingredientesEspeciales){precio = 4500.0F ;}
        if(diametro == 20 && ingredientesEspeciales){precio = 4500.0F + ADICIONAL_INGREDIENTES_ESP_20;}

        if(diametro == 30 && !ingredientesEspeciales){precio = 4800.0F;}
        if(diametro == 30 && ingredientesEspeciales){precio = 4800.0F + ADICIONAL_INGREDIENTES_ESP_30;}

        if(diametro == 40 && !ingredientesEspeciales){precio = 5500.0F;}
        if(diametro == 40 && ingredientesEspeciales){precio = 5500.0F + ADICIONAL_INGREDIENTES_ESP_40;}
    }

    public void calcularArea(){
        int radio = diametro / 2;
        area = (float) Math.PI * (float)Math.pow(radio, 2);
    }
}

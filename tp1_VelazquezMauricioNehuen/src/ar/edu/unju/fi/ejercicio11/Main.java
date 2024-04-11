package ar.edu.unju.fi.ejercicio11;

public class Main {
    public static void main(String[] args) {

        int j = 40;
        int aux = 40;
        int i = 2;

        /*
            Forma de calcular...
            i = 2
            j = 40
            Guardo el valor de i en un auxiliar (aux = i)

            Procedimiento..
            1) En el primer paso si k == 1 multiplico (j x i) para obtener el primer valor
                40 = 40 * 2 --> 80
            2) Al no cumplirse la primera condicion uso la formula j = j + aux - [(i * k) - 1]
                80 = 80 + 40 - [(2 * 2) - 1] --> 120 - 3 = 117
                117 = 117 + 40 - [(2 * 3) - 1] --> 157 - 5 = 152
                152 = 152 + 40 - [(2 * 4) - 1] --> 192 - 7 = 185
                185 = 185 + 40 - [(2 * 5) - 1] --> 225 - 9 = 216
                y asi sucesivamente hasta que i <= 0 donde rompemos el ciclo if
        */

        for(int k = 1; k < 100000; k++){
            // Primer paso
            if(k == 1){
                j = j * i;
                System.out.print(j +" ");
            } else {
                //Segundo paso
                j = j + aux - ((i * k) - 1);
                if(j <=0){break;}
                System.out.print(j +" ");
            }

        }
    }
}

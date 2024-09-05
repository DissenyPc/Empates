package controlador;

import java.util.Scanner;

public class inicio {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        int nGoles;

        // Expresion regular para validar la entrada de cada gool
        String validar = "^[LV] (0|[0-9][0-9]?|1[01][0-9]|120):(0[0-9]|[1-5][0-9])$";

        while ((nGoles = entrada.nextInt()) >= 0 && nGoles <= 100){ // Mientras que el numero de goles sea positivo menor de 101

            String Introducido;
            entrada.nextLine();
            char[] equipo = new char[nGoles];
            int[] tiempo = new int[nGoles];
            int golesL=0;
            int golesV=0;
            int empates = 1;

            for ( int i = 0; i < nGoles; i++) { // pdimos tantos goles como n de goles elejido

                Introducido = entrada.nextLine();
                
                if (!Introducido.matches(validar)) { // comparamos el gool introducido con la expresion aceptada
                    
                    System.out.println("El formato es incorrecto. Vuelve a introducirlo: V o L seguido de 2 ditos minutos seguido de : seguido de 2 digitos segundos");
                    i--;
                    
                } else { // Si es correcto

                    equipo[i] = Introducido.charAt(0); // en el array equipo vamos metiendo los equipos que han ido marcando

                    // en el array tiempos vamos metiendo el tiempo ya convertido a segundos de cada gool

                    tiempo[i] = ((Integer.parseInt(Introducido.substring(2, 4)))*60) + (Integer.parseInt(Introducido.substring(5, 7)));  

                }

            }

            // bucle para ordenar los goles
            for (int x= 0; x < nGoles; x++){
                for (int y = 0; y< nGoles-1; y++){

                    if (tiempo[y] > tiempo[y+1]){

                        int temp = tiempo[y];
                        tiempo[y] = tiempo[y+1];
                        tiempo[y+1] = temp;

                        char tempChar = equipo[y];
                        equipo[y] = equipo[y+1];
                        equipo[y+1] = tempChar;
                    }

                }
            }

            // bucle para contar los empates

            for (int i= 0; i < nGoles; i++) {

                if (equipo[i]=='L') { 
                    golesL++; 
                } else { 
                    golesV++; 
                }

                if (golesL == golesV) {
                     empates++;
                    }
            }


            System.err.println(golesL + "-" + golesV + " " + empates);
            
        }

        

        entrada.close();
    }

}

import java.util.Scanner;
import java.util.Stack;
import java.util.Random;
public class Ejemplo {

    public static void main(String[] args){
        int aux1 = 0, var1, var2, i, cantidad;
        Scanner teclado = new Scanner(System.in);
        Random random = new Random(System.currentTimeMillis());
        Stack<Integer> pila1 = new Stack<Integer>();
        Stack<Integer> pila2 = new Stack<Integer>();
        Stack<Integer> pila3 = new Stack<Integer>();

        do{
            System.out.println("Ingrese la cantidad de numeros que desee ordenar");
            cantidad = teclado.nextInt();
        }while(cantidad<1);
        teclado.close();

        System.out.println("Generando numeros aleatorios....");
        for (i = 0; i < cantidad; i++){
            aux1 = random.nextInt(99)+1;
            pila1.push(aux1);
            System.out.print(pila1.peek()+" | ");
        }

        System.out.println("\nOrdenando datos.....");
        
        for(i=0;i<cantidad;i++){
            while(pila1.isEmpty()==false){
                var1 = pila1.pop();
                pila2.push(var1);
                if(pila1.isEmpty()==false){
                    var2 = pila1.pop();
                    pila3.push(var2);  
                    if(var1 <= var2){
                        pila1.push(var2);
                        pila3.pop();
                    }else{
                        pila1.push(var1);
                        pila2.pop();
                    }  
                }
            }
            while(pila2.isEmpty()==false){
                pila1.push(pila2.pop());
            }
            while(pila3.isEmpty()==false){
                pila1.push(pila3.pop());
            }
        }
        i=1;
        while(pila1.isEmpty()==false){
            System.out.println("Posicion "+i+" = "+pila1.pop());
            i++;
        }
    }
}


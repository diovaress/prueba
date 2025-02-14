package com.mycompany.tiendabasica;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto {
    String nombre;
    int precio;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void verProducto() {
        System.out.println(nombre + " - $" + precio);
    }
}

class FabricaComidaRapida {
    public Producto crearHamburguesa() {
        return new Producto("Hamburguesa con queso", 50);
    }

    public Producto crearHotDog() {
        return new Producto("Hot Dog simple", 30);
    }
}

public class TiendaBasica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FabricaComidaRapida fabrica = new FabricaComidaRapida();
        List<Producto> carrito = new ArrayList<>();
        int opcion = 0; 

        do {
            System.out.println("\n--- MENU TIENDITA ---");
          System.out.println("\n--------------------------");
            System.out.println("1. Agregar Hamburguesa al carrito");

            System.out.println("2. Agregar hot dog  al pedido");

            System.out.println("3. Ver pedido");
        
            System.out.println(" 4. Comprar");
        
            System.out.println("5. Salir");
     
            System.out.print("Elige una opcion: ");
              System.out.println("\n--------------------------");

            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
            } else {
                System.out.println("la entrada no es valida.... intenta nuevamente.");
                teclado.next();
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    Producto hamburguesa = fabrica.crearHamburguesa();
                    carrito.add(hamburguesa);
                     System.out.println("\n****************************");
                    System.out.println("Hamburguesa agregada al pedido.");
                      System.out.println("\n****************************");
                }
                case 2 -> {
                    Producto hotdog = fabrica.crearHotDog();
                    carrito.add(hotdog);
                    System.out.println("\n****************************");
                    System.out.println("hot dog agregado al pedido.");
                    System.out.println("\n****************************");
                }
                case 3 -> {
                    if (carrito.isEmpty()) {
                        System.out.println("\n****************************");
                        System.out.println("Tu pedido esta vacío.");
                        System.out.println("\n****************************");
                    } else {
                        System.out.println("\n--- Tu Pedido ---");
                        int total = 0;
                        for (Producto p : carrito) {
                            p.verProducto();
                            total += p.precio;
                            System.out.println("\n****************************");
                        }
                        System.out.println("Total a pagar: Q" + total);
                        System.out.println("\n****************************");
                    }
                }
                case 4 -> {
                    if (carrito.isEmpty()) {
                        System.out.println("aun no haz hecho una eleccion.");
                    } else {
                        System.out.println("\n la compra fue realizada");
                        carrito.clear();
                    }
                }
                case 5 -> System.out.println("gracias por su compra");
                default -> System.out.println("Opcion no es valida.... intenta de nuevo.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}

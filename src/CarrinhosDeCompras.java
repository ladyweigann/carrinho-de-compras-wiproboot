import java.util.Scanner;

public class CarrinhosDeCompras {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cod, desejaContinuar = "sim";
        Integer qtd;
        Double subtotal;
        String[][] produtos = {
                { "Código", "Produto", "Qtd", "Preço(R$)" },
                { "1", "Mouse", "10", "10.5" },
                { "2", "Teclado", "10", "40.0" },
                { "3", "Monitor", "10", "90.0" },
                { "4", "Fone", "10", "60.0" },
                { "5", "Microfone", "10", "30.0" } };

        while(desejaContinuar.equals("sim") || desejaContinuar.equals("s")){

            System.out.println("=====================================================================");
            for (String[] row : produtos){
                System.out.format("|| %15s %15s %15s %15s || %n", row);
            }
            System.out.println("=====================================================================");
            System.out.println("Informe o código do produto desejado: ");
            cod = sc.next();
            switch (cod) {
                case "1":
                    System.out.println("O produto escolhido foi: " + produtos[1][1]);
                    break;
                case "2":
                    System.out.println("O produto escolhido foi: " + produtos[2][1]);
                    break;
                case "3":
                    System.out.println("O produto escolhido foi: " + produtos[3][1]);
                    break;
                case "4":
                    System.out.println("O produto escolhido foi: " + produtos[4][1]);
                    break;
                case "5":
                    System.out.println("O produto escolhido foi: " + produtos[5][1]);
                    break;
                default:
                    System.out.println("Produto não encontrado");
                    break;
            }
            System.out.println("deseja continuar? ");
            desejaContinuar = sc.next();
        }
        sc.close();
    }
}

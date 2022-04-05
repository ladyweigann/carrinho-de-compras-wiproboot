import java.util.Scanner;

public class CarrinhosDeCompras {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String cod, resposta = "S";
		int qtd, tamanhoCarrinho = 10;
		int linha = 0;
		double subtotal = 0, totalSemIposto = 0, total = 0;
		double valorUnitario = 0;
		double totalComDesconto = 0, tributos;

		String[][] carrinho = new String[tamanhoCarrinho][4];
		String[][] produtos = { { "1", "Mouse", "10", "10.5" }, { "2", "Teclado", "10", "40.0" },
				{ "3", "Monitor", "10", "90.0" }, { "4", "Fone", "10", "60.0" }, { "5", "Microfone", "10", "30.0" } };

		String[] payment = { "À vista (dinheiro, pix ou cartão MasterdCard)você tem 20% de desconto!",
				"À vista no cartão de crédito você tem 10% de desconto!",
				"Parcelado em 2x infelizmente não tem desconto.", "Parcelado em 3x infelizmente não tem desconto." };

		while (resposta.equals("S")) {

			System.out.println("=====================================================================");
			for (String[] row : produtos) {
				System.out.format("|| %15s %15s %15s %15s || %n", row);
			}

			System.out.println("=====================================================================");

			System.out.println("Informe o código do produto desejado: ");
			cod = sc.next();
			switch (cod) {
			case "1":
				System.out.println("O produto escolhido " + produtos[0][1]);
				valorUnitario = Double.parseDouble(produtos[0][3]);
				break;
			case "2":
				System.out.println("O produto escolhido " + produtos[1][1]);
				valorUnitario = Double.parseDouble(produtos[1][3]);
				break;
			case "3":
				System.out.println("O produto escolhido " + produtos[2][1]);
				valorUnitario = Double.parseDouble(produtos[2][3]);
				break;
			case "4":
				System.out.println("O produto escolhido " + produtos[3][1]);
				valorUnitario = Double.parseDouble(produtos[3][3]);
				break;
			case "5":
				System.out.println("O produto escolhido " + produtos[4][1]);
				valorUnitario = Double.parseDouble(produtos[4][3]);
				break;
			default:
				System.out.println("Produto não encontrado");
				break;
			}

			int posicao = (Integer.parseInt(cod) - 1);

			System.out.println("Informe a quantidade desejada: ");
			qtd = sc.nextInt();

			int qtdDisp = Integer.parseInt(produtos[posicao][2]) - qtd;

			if (qtdDisp < 0) {
				System.out.println("Quantidade indisponível!");
				System.out.println("Quantidade em estoque: " + produtos[posicao][2]);
			} else {

				produtos[posicao][2] = Integer.toString(qtdDisp);

				carrinho[linha][0] = Integer.toString(posicao + 1);
				carrinho[linha][1] = produtos[linha][1];
				carrinho[linha][2] = Integer.toString(qtd);

				subtotal += qtd * valorUnitario;
				carrinho[linha][3] = Double.toString(subtotal);

				total += subtotal;
				System.out.println("Subtotal -> " + carrinho[linha][3]);
				linha++;

				System.out.println("Estoque Restante: " + produtos[posicao][2]);
			}
			tamanhoCarrinho++;

			subtotal = 0;

			System.out.println("Deseja comprar mais algum Produto? [S/N]");

			String opcResposta = sc.next();
			resposta = opcResposta.toUpperCase();

			System.out.println("*************************** SEU CARRINHO ******************************");
			System.out.println("          COD          PRODUTO            QTD          SUBTOTAL          ");
			System.out.println("***********************************************************************");

			for (String[] row : carrinho) {

				if (!row.equals(null) || !row.equals("")) {
					System.out.format("|| %10s %15s %15s %15s        || %n", row);
				}else {
					continue;
				}
			}

			System.out.println("***********************************************************************");

		}

		System.out.println("====$================================================================$====");
		System.out.println("==========================FORMAS DE PAGAMENTO=============================");
		for (int i = 0; i < payment.length; i++) {
			{
				System.out.println(i + 1 + " - " + payment[i]);
			}
			System.out.println("========================================================================== \n");
		}
		System.out.println("Escolha sua forma de pagamento(1, 2, 3 ou 4): ");
		int pay = sc.nextInt();
		switch (pay) {
		case 1:
			totalComDesconto = total * 0.2;
			break;
		case 2:
			totalComDesconto = total * 0.1;
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			System.out.println("Forma de pagamento inválida!");
			break;
		}

		System.out.println("**************************** NOTA FISCAL *******************************");
		System.out.println();
		System.out.println("          COD          PRODUTO            QTD          SUBTOTAL          ");
		System.out.println();
		System.out.println("***********************************************************************");

		for (String[] row : carrinho) {

			if (!row.equals(null) || !row.equals("")) {
				System.out.format("|| %10s %15s %15s %15s        || %n", row);
			}

		}

		System.out.println("***********************************************************************");

		total -= totalComDesconto;
		System.out.printf("Total a pagar: R$ %.2f %n", total);

		tributos = total * 0.09;
		System.out.printf("Total de Tributos pagos R$ %.2f %n", tributos);

		System.out.printf("Desconto total R$%.2f %n", totalComDesconto);

		sc.close();
	}

}

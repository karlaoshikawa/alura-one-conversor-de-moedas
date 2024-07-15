package conversordemoedas.main;
import conversordemoedas.models.Currency;
import conversordemoedas.utils.ConvertCurrency;
import conversordemoedas.utils.SaveFiles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    static List<Currency> history = new ArrayList<>();

    public void showMenu () throws IOException {

        Scanner scan = new Scanner(System.in);
        int choice;
        Currency currency;

        do {
            System.out.println(menu());
            choice = scan.nextInt();

            switch (choice) {

                case 1:
                    currency = ConvertCurrency.
                                checkConvertionRate("USD", "BRL", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 2:
                    currency = ConvertCurrency.
                            checkConvertionRate("BRL", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 3:
                    currency = ConvertCurrency.
                            checkConvertionRate("USD", "ARS", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 4:
                    currency = ConvertCurrency.
                            checkConvertionRate("ARS", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 5:
                    currency = ConvertCurrency.
                            checkConvertionRate("USD", "COP", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 6:
                    currency = ConvertCurrency.
                            checkConvertionRate("COP", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 7:
                    System.out.println("Digite o código da moeda de origem em letras maiúsculas");
                    String originCurrency = scan.next();

                    System.out.println("Digite o código da moeda de destino em letras maiúsculas");
                    String convertedCurrency = scan.next();

                    currency = ConvertCurrency.
                            checkConvertionRate(originCurrency, convertedCurrency, scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 8:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("""
                    *********************** - ERRO - *******************************
                    
                                         Opção inválida
                   
                            Pressione 'Enter' para voltar ao menu principal
                    
                    ****************************************************************
                    
                    """);
                    scan.nextLine(); // Limpa o buffer
                    scan.nextLine(); // Aguarda a entrada do usuário
            }

            System.out.println("Deseja continuar consultando conversões?");
            System.out.println("       s - SIM   |   n - Não");
            char exit =  scan.next().toLowerCase().charAt(0);
            if (exit == 'n'){
                break;
            }

        } while ( choice != 8);
        scan.close();
        saveHistoryFile();
    }

    private String menu(){
        return """
                ----------------------------------------------------------------
                
                1) De Dólar para Real Brasileiro
                2) De Real Brasileiro para Dólar
                3) De Dólar para Peso Argentino
                4) De Peso Argentino para Dólar
                5) De Dólar para Peso Colombiano
                6) De Peso Colombiano para Dólar
                7) Digitar moeda de origem e destino que não tenha na lista
                8) Sair

                Escolha uma opção válida:
                """;
    }

    public static void saveHistoryFile () throws IOException {
        var fileSaver = new SaveFiles();
        fileSaver.saveJson(history);
    }
}

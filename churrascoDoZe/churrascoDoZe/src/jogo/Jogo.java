package jogo;

import modelo.Cena;
import modelo.Comando;
import repositorio.CenaDAO;
import repositorio.ComandoDAO;

import java.util.Scanner;

public class Jogo {
    private static CenaDAO cenaDAO = new CenaDAO();  // Instância de CenaDAO
    private static ComandoDAO comandoDAO = new ComandoDAO();  // Instância de ComandoDAO
    private static int cenaAtualId = 1; // Cena inicial

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("Digite 'start' para iniciar o jogo ou 'help' para obter ajuda.");

        while (true) {
            System.out.print("> ");
            comando = scanner.nextLine().trim().toLowerCase();

            if (comando.equals("start")) {
                mostrarCena(cenaAtualId);
            } else if (comando.equals("help")) {
                mostrarAjuda();
            } else if (comando.startsWith("use") || comando.startsWith("get") || comando.startsWith("check")) {
                processarComando(comando);
            } else if (comando.equals("sair")) {
                System.out.println("Saindo do jogo.");
                scanner.close();
                return;
            } else {
                System.out.println("Comando não reconhecido. Digite 'help' para obter ajuda.");
            }
        }
    }

    private static void mostrarCena(int idCena) {
        try {
            Cena cena = cenaDAO.findCenaById(idCena);
            if (cena != null) {
                System.out.println("Descrição da Cena: " + cena.getDescricao());
            } else {
                System.out.println("Cena não encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mostrarAjuda() {
        try {
            ComandoDAO comandoDAO = new ComandoDAO();
            Comando comando = comandoDAO.findComandoByNome("help");
            if (comando != null) {
                System.out.println("Descrição do comando 'help': " + comando.getDescricao());
            } else {
                System.out.println("Ajuda não encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processarComando(String comando) {
        try {
            Comando comandoInfo = comandoDAO.findComandoByNome(comando);
            if (comandoInfo != null) {
                System.out.println("Descrição do comando '" + comando + "': " + comandoInfo.getDescricao());
                if (comando.startsWith("use")) {
                    // Aqui você pode adicionar a lógica para mudar de cena
                    if (comando.equals("use mercado")) {
                        cenaAtualId = 2; // Por exemplo, mudar para a cena 2
                        mostrarCena(cenaAtualId);
                    }
                    // Adicione outros comandos de uso e lógica de mudança de cena conforme necessário
                }
                // Adicione lógica para outros comandos, como 'get', 'check', etc.
            } else {
                System.out.println("Comando não reconhecido.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
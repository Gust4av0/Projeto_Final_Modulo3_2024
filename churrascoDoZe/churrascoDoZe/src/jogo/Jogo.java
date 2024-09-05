package jogo;

import modelo.Cena;
import modelo.Comando;
import modelo.Save;
import org.w3c.dom.ls.LSOutput;
import repositorio.CenaDAO;
import repositorio.ComandoDAO;
import repositorio.SaveDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Jogo {
    private static CenaDAO cenaDAO = new CenaDAO();  // Instância de CenaDAO
    private static ComandoDAO comandoDAO = new ComandoDAO();  // Instância de ComandoDAO
    private static int cenaAtualId = 1; // Cena inicial

    public Jogo() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String comando;

        Save save = SaveDAO.novoJogo();
        System.out.println(save.getCenaAtual().getIdCena());

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
                System.out.println(cena.getDescricao()); //Mostra a cena 1 do jogo
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

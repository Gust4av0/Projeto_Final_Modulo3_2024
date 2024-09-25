package jogo;

import modelo.*;
import repositorio.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private static CenaDAO cenaDAO = new CenaDAO();  // Instância de CenaDAO
    private static int cenaAtualId = 1; // Cena inicial

    public Jogo() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String comando;

        Save save = SaveDAO.novoJogo();
        System.out.println(save.getCenaAtual().getIdCena());

        System.out.println("Seja Bem Vindo ao Jogo, Churrasco do Zé!");
        System.out.println("------------------------------------------------------------");
        System.out.println("Comandos para Iniciar o Jogo:");
        System.out.println("Digite 1 para iniciar um novo Game!");

        while (true) {
            System.out.print("> ");
            comando = scanner.nextLine().trim().toLowerCase();

            if (comando.equals("1")) {
                if (InventarioDAO.inventarioVazio()) {
                    System.out.println("Inventário já estava vazio! iniciando novo jogo...");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Jogo Iniciado! Digite Help para obter os comandos válidos no Game!");
                    mostrarCena(cenaAtualId);
                } else {
                    InventarioDAO.limparInventario();
                    System.out.println("Inventário limpo com sucesso! Iniciando novo jogo...");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Jogo Iniciado! Digite Help para obter os comandos válidos no Game!");
                    mostrarCena(cenaAtualId);
                }
            } else if (comando.equals("help")) {
                mostrarAjuda(comando);
            } else if (comando.equals("inventario")) {
                mostrarInventario();  // Mostra o inventário
            } else if (comando.startsWith("use") || comando.startsWith("get")) {
                processarComando(comando);
            } else {
                System.out.println("Comando não reconhecido. \nDigite 1 para iniciar um novo Game! \nOu HELP para obter os comando permitidos no Game!");
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
            System.out.println("Houve algum problema: " + e);
        }
    }


        private static void mostrarAjuda(String comando) {
        try {
            ComandoDAO comandoDAO = new ComandoDAO();
            Comando comandoDigitado = comandoDAO.findComandoByNome(comando);
            if (comando != null) {
                System.out.println("Descrição do comando 'help': " + comandoDigitado.getDescricao());
            } else {
                System.out.println("Ajuda não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro com o banco de Dados: " + e);
        }
    }

    // Método para mostrar o inventário
    private static void mostrarInventario() {
        try {
            List<Objetos> inventario = InventarioDAO.listarInventario();
            if (inventario.isEmpty()) {
                System.out.println("O inventário está vazio.");
            } else {
                System.out.println("Itens no inventário:");
                for (Objetos item : inventario) {
                    System.out.println("- " + item.getNomeObjeto());
                }
            }
        } catch (SQLException e) {
            System.out.println("Houve um problema ao acessar o inventário: " + e);
        }
    }


    private static void processarComando(String comando) {
        try {
            ObjetoDAO objetoDAO = new ObjetoDAO();

            switch (comando){ //irá validar os comandos
                case "use mercado":
                    cenaAtualId += 1;
                    mostrarCena(cenaAtualId);
                    break;
                case "get carne":
                    Objetos carne = objetoDAO.findObjetoByComandoCorreto(comando);
                    InventarioDAO.salvarInventario(carne.getIdObjeto());
                    System.out.println("Carne adicionada ao inventário");
                    break;
                case "get cerveja":
                    Objetos cerveja = objetoDAO.findObjetoByComandoCorreto(comando);
                    InventarioDAO.salvarInventario(cerveja.getIdObjeto());
                    System.out.println("Cerveja adicionada ao inventário");
                    break;
                case "get fosforo":
                    Objetos fosforo = objetoDAO.findObjetoByComandoCorreto(comando);
                    InventarioDAO.salvarInventario(fosforo.getIdObjeto());
                    System.out.println("Fósforo adicionado ao inventário");
                    break;
                case "use casa":
                    cenaAtualId += 1;
                    mostrarCena(cenaAtualId);
                    break;
                case "use fosforo with churrasqueira":
                    Objetos fosforoChurrasqueira = objetoDAO.findObjetoByComandoCorreto(comando);
                    System.out.println(fosforoChurrasqueira.getResultadoPositivo());
                    cenaAtualId += 1;
                    mostrarCena(cenaAtualId);
                    break;
                case "use carne with grelha":
                    Objetos carneGrelha = objetoDAO.findObjetoByComandoCorreto(comando);
                    System.out.println(carneGrelha.getResultadoPositivo());
                    break;
                case "use cerveja":
                    cenaAtualId += 1;
                    mostrarCena(cenaAtualId);
                    System.out.println("---------------------------------------------------------");
                    System.out.println("JOGO FINALIZADO COM SUCESSO!!!!!!!!!!");
                    break;
                default:
                    System.out.println("Comando inválido! Consegue tentar outro amigão?");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Houve algum problema: " + e);
        }
    }
}
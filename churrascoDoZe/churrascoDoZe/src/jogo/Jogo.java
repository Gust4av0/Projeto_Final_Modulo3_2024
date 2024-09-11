package jogo;

import modelo.*;
import org.w3c.dom.ls.LSOutput;
import repositorio.*;

import java.sql.SQLException;
import java.util.Scanner;

import static spark.Spark.staticFiles;

public class Jogo {
    private static CenaDAO cenaDAO = new CenaDAO();  // Instância de CenaDAO
    private static ComandoDAO comandoDAO = new ComandoDAO();  // Instância de ComandoDAO
    private static int cenaAtualId = 1; // Cena inicial

    public Jogo() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        //staticFiles.location("CSS/");
        Scanner scanner = new Scanner(System.in);
        String comando;

        Save save = SaveDAO.novoJogo();
        System.out.println(save.getCenaAtual().getIdCena());

        System.out.println("Seja Bem Vindo ao Jogo, Churrasco do Zé!");
        System.out.println("------------------------------------------------------------");
        System.out.println("Comandos para Iniciar o Jogo:");
        System.out.println("Digite 1 para iniciar um novo Game!");
        System.out.println("Digite 2 para listar os Jogos Salvos!");

        while (true) {
            System.out.print("> ");
            comando = scanner.nextLine().trim().toLowerCase();

            if (comando.equals("1")) {
                if (InventarioDAO.inventarioVazio()) {
                    System.out.println("Inventário já estava vazio! iniciando novo jogo...");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Jogo Iniciado! Digite Help para obter os comandos válidos no Game!");
                    mostrarCena(cenaAtualId);
                } else{
                    InventarioDAO.limparInventario();
                    System.out.println("Inventário limpo com sucesso! Iniciando novo jogo...");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Jogo Iniciado! Digite Help para obter os comandos válidos no Game!");
                    mostrarCena(cenaAtualId);
                }
        } else if (comando.equals("help")) {
                mostrarAjuda();
            } else if (comando.startsWith("use") || comando.startsWith("get") || comando.startsWith("check")) {
                processarComando(comando);
            } else if (comando.equals("sair")) {
                System.out.println("Saindo do jogo.");
                scanner.close();
                return;
            } else {
                System.out.println("Comando não reconhecido. \nDigite 1 para iniciar um novo Game! \nDigite 2 para listar os Jogos Salvos! \nOu HELP para obter os comando permitidos no Game!");
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
            ComandoDAO comandoDAO = new ComandoDAO();
            ObjetoDAO objetoDAO = new ObjetoDAO();
            InventarioDAO inventarioDAO = new InventarioDAO();
            Comando comandoInfo = comandoDAO.findComandoByNome(comando);

            switch (comando){
                case "use mercado":
                    cenaAtualId += 1;
                    mostrarCena(cenaAtualId);
                    break;
                case "get carne":
                    Objeto carne = objetoDAO.findObjetoByComandoCorreto(comando);
                    if (carne != null) {
                        if (!InventarioDAO.itemJaNoInventario(carne.getIdObjeto())) {
                            System.out.println(carne.getResultadoPositivo());
                            InventarioDAO.salvarInventario(carne.getIdObjeto());
                        } else {
                            System.out.println("Você já pegou a carne! Verifica o item que resta!");
                        }
                    }
                    break;
                case "get cerveja":
                    Objeto cerveja = objetoDAO.findObjetoByComandoCorreto(comando);
                    if (cerveja != null) {
                        if (!InventarioDAO.itemJaNoInventario(cerveja.getIdObjeto())) {
                            System.out.println(cerveja.getResultadoPositivo());
                            InventarioDAO.salvarInventario(cerveja.getIdObjeto());
                        } else {
                            System.out.println("Você já pegou a cerveja! Verifica o item que resta!");
                        }
                    }
                    break;
                case "get fosforo":
                    Objeto fosforo = objetoDAO.findObjetoByComandoCorreto(comando);
                    if (fosforo != null) {
                        if (!InventarioDAO.itemJaNoInventario(fosforo.getIdObjeto())) {
                            System.out.println(fosforo.getResultadoPositivo());
                            InventarioDAO.salvarInventario(fosforo.getIdObjeto());
                        } else {
                            System.out.println("Você já pegou o fósforo! Verifica o item que resta!");
                        }
                    }
                    break;
                case "use casa":
                    int quantidadeItensInventario = InventarioDAO.contarItensInventario();
                    if (quantidadeItensInventario >= 3) {
                        cenaAtualId += 1;
                        mostrarCena(cenaAtualId);
                    } else {
                        System.out.println("OPSSSSSSSSSSSSSSSS! Você não pode voltar para casa antes de pegar os itens para o Churrasco!!!!!");
                        System.out.println("Você precisa de: Carne, Cerveja e Fósforos!");
                    }
                    break;
                case "use fosforo with churrasqueira":
                    Objeto objeto4 = objetoDAO.findObjetoByComandoCorreto(comando);
                    System.out.println(objeto4.getResultadoPositivo());
                    cenaAtualId += 1;
                    mostrarCena(cenaAtualId);
                    break;
                case "use carne with grelha":
                    Objeto objeto5 = objetoDAO.findObjetoByComandoCorreto(comando);
                    System.out.println(objeto5.getResultadoPositivo());
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
            e.printStackTrace();
        }
    }
}
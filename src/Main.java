import dao.Collaborator;
import profile.Atendente;
import profile.Usuario;
import profile.Gerente;
import profile.Vendedor;

import java.util.Scanner;

/**
 * Classe principal com o menu interativo
 */
public class Main {
    public static void main(String[] args) {
        Collaborator collaborator = new Collaborator();
        Scanner scanner = new Scanner(System.in);
        boolean sistemaAtivo = true;

        while (sistemaAtivo) {
            System.out.println("\n=== COLLABORATOR PROFILE ===");
            System.out.println("1. Login");

            // Mostrar opções adicionais se já estiver logado
            if (collaborator.getUsuarioLogado() != null) {
                if (collaborator.getUsuarioLogado() instanceof Gerente) {
                    System.out.println("2. Cadastrar usuário");
                }
                System.out.println("3. Menu do Usuário");
                System.out.println("4. Logoff");
                System.out.println("5. Sair do Sistema");
            } else {
                System.out.println("2. Sair do Sistema");
            }

            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (collaborator.getUsuarioLogado() == null) {
                // Menu quando não está logado
                switch (opcao) {
                    case 1:
                        collaborator.realizarLogin();
                        break;
                    case 2:
                        sistemaAtivo = false;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } else {
                // Menu quando está logado
                switch (opcao) {
                    case 1:
                        System.out.println("Você já está logado como: " + collaborator.getUsuarioLogado().getNome());
                        break;
                    case 2:
                        if (collaborator.getUsuarioLogado() instanceof Gerente) {
                            collaborator.cadastrarUsuario();
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        break;
                    case 3:
                        exibirMenuUsuario(collaborator, scanner);
                        break;
                    case 4:
                        collaborator.realizarLogoff();
                        break;
                    case 5:
                        sistemaAtivo = false;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
        scanner.close();
    }

    /**
     * Exibe o menu específico do tipo de usuário logado
     */
    private static void exibirMenuUsuario(Collaborator collaborator, Scanner scanner) {
        Usuario usuario = collaborator.getUsuarioLogado();
        if (usuario == null) return;

        boolean noMenuUsuario = true;
        while (noMenuUsuario) {
            System.out.println("\n=== MENU DO USUÁRIO ===");
            System.out.println("1. Alterar dados");
            System.out.println("2. Alterar senha");

            if (usuario instanceof Gerente) {
                System.out.println("3. Gerar relatório financeiro");
                System.out.println("4. Consultar vendas");
            } else if (usuario instanceof Vendedor) {
                System.out.println("3. Realizar venda");
                System.out.println("4. Consultar minhas vendas");
            } else if (usuario instanceof Atendente) {
                System.out.println("3. Receber pagamento");
                System.out.println("4. Fechar caixa");
            }

            System.out.println("5. Voltar ao menu principal");
            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    collaborator.alterarDadosUsuario();
                    break;
                case 2:
                    collaborator.alterarSenhaUsuario();
                    break;
                case 3:
                    if (usuario instanceof Gerente) {
                        ((Gerente) usuario).gerarRelatorioFinanceiro();
                    } else if (usuario instanceof Vendedor) {
                        ((Vendedor) usuario).realizarVenda();
                    } else if (usuario instanceof Atendente) {
                        System.out.print("Digite o valor do pagamento: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        ((Atendente) usuario).receberPagamento(valor);
                    }
                    break;
                case 4:
                    if (usuario instanceof Gerente) {
                        ((Gerente) usuario).consultarVendas();
                    } else if (usuario instanceof Vendedor) {
                        ((Vendedor) usuario).consultarVendas();
                    } else if (usuario instanceof Atendente) {
                        ((Atendente) usuario).fecharCaixa();
                    }
                    break;
                case 5:
                    noMenuUsuario = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
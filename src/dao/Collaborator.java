package dao;

import profile.ProfileCollaborator;
import profile.Usuario;
import profile.Gerente;
import profile.Vendedor;
import profile.Atendente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pela manipulação dos colaboradores do sistema
 */
public class Collaborator {
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;
    private Scanner scanner;

    public Collaborator() {
        this.usuarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        // Carrega usuários de exemplo
        this.usuarios.addAll(ProfileCollaborator.getUsuariosExemplo());
    }

    /**
     * Realiza o login no sistema
     */
    public void realizarLogin() {
        System.out.print("\nEmail: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuario.realizarLogin();
                usuarioLogado = usuario;
                return;
            }
        }
        System.out.println("Email ou senha incorretos!");
    }

    /**
     * Cadastra um novo usuário no sistema (apenas para gerentes)
     */
    public void cadastrarUsuario() {
        if (usuarioLogado == null || !(usuarioLogado instanceof Gerente)) {
            System.out.println("Apenas gerentes podem cadastrar novos usuários!");
            return;
        }

        System.out.println("\n=== CADASTRO DE NOVO USUÁRIO ===");
        System.out.println("1. Gerente");
        System.out.println("2. Vendedor");
        System.out.println("3. Atendente");
        System.out.print("Escolha o tipo de usuário: ");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();

        // Validação do nome
        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio!");
            return;
        }

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        // Validação básica de email
        if (email == null || email.isEmpty() || !email.contains("@")) {
            System.out.println("Email inválido!");
            return;
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine().trim();

        // Validação básica de senha
        if (senha == null || senha.isEmpty() || senha.length() < 4) {
            System.out.println("Senha deve ter pelo menos 4 caracteres!");
            return;
        }

        try {
            switch (tipo) {
                case 1:
                    usuarios.add(new Gerente(nome, email, senha));
                    break;
                case 2:
                    usuarios.add(new Vendedor(nome, email, senha));
                    break;
                case 3:
                    usuarios.add(new Atendente(nome, email, senha));
                    break;
                default:
                    System.out.println("Tipo inválido!");
                    return;
            }
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }


    /**
     * Altera dados do usuário logado
     */
    public void alterarDadosUsuario() {
        System.out.print("\nNovo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo email: ");
        String novoEmail = scanner.nextLine();

        usuarioLogado.alterarDados(novoNome, novoEmail);
        System.out.println("Dados atualizados com sucesso!");
    }

    /**
     * Altera senha do usuário logado
     */
    public void alterarSenhaUsuario() {
        System.out.print("\nNova senha: ");
        String novaSenha = scanner.nextLine();

        usuarioLogado.alterarSenha(novaSenha);
        System.out.println("Senha alterada com sucesso!");
    }

    /**
     * Realiza logoff do usuário atual
     */
    public void realizarLogoff() {
        if (usuarioLogado != null) {
            usuarioLogado.realizarLogoff();
            usuarioLogado = null;
        }
    }

    // Getters
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}

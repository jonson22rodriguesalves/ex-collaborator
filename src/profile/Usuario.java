package profile;

/**
 * Classe abstrata base para todos os tipos de usuários do sistema
 */
public abstract class Usuario {
    // Atributos comuns a todos os usuários
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean isAdmin;

    /**
     * Construtor da classe Usuario com validações
     */
    public Usuario(String nome, String email, String senha) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (senha == null || senha.trim().isEmpty() || senha.length() < 4) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 4 caracteres");
        }

        this.nome = nome.trim();
        this.email = email.trim();
        this.senha = senha.trim();
    }

    // Métodos comuns a todos os usuários
    public abstract void realizarLogin();
    public abstract void realizarLogoff();
    public abstract void alterarDados(String novoNome, String novoEmail);
    public abstract void alterarSenha(String novaSenha);

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    // Não há setter para isAdmin pois deve ser definido nas classes filhas
}

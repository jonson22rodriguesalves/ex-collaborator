package profile;

/**
 * Classe que representa um profile.Gerente no sistema
 */
public class Gerente extends Usuario {
    /**
     * Construtor da classe profile.Gerente
     * @param nome Nome do gerente
     * @param email Email do gerente
     * @param senha Senha do gerente
     */
    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.isAdmin = true; // profile.Gerente sempre é admin
    }

    /**
     * Método para gerar relatório financeiro
     */
    public void gerarRelatorioFinanceiro() {
        System.out.println("Relatório financeiro gerado por " + this.nome);
    }

    /**
     * Método para consultar vendas
     */
    public void consultarVendas() {
        System.out.println("Consultando vendas...");
    }

    @Override
    public void realizarLogin() {
        System.out.println("profile.Gerente " + this.nome + " realizou login");
    }

    @Override
    public void realizarLogoff() {
        System.out.println("profile.Gerente " + this.nome + " realizou logoff");
    }

    @Override
    public void alterarDados(String novoNome, String novoEmail) {
        this.nome = novoNome;
        this.email = novoEmail;
        System.out.println("Dados do gerente atualizados");
    }

    @Override
    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha do gerente alterada");
    }
}

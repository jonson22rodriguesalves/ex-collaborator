package profile;

/**
 * Classe que representa um profile.Vendedor no sistema
 */
public class Vendedor extends Usuario {
    private int quantidadeVendas;

    /**
     * Construtor da classe profile.Vendedor
     * @param nome Nome do vendedor
     * @param email Email do vendedor
     * @param senha Senha do vendedor
     */
    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
        this.quantidadeVendas = 0;
        this.isAdmin = false; // profile.Vendedor nunca é admin
    }

    /**
     * Método para realizar uma venda (incrementa o contador de vendas)
     */
    public void realizarVenda() {
        this.quantidadeVendas++;
        System.out.println("Venda realizada por " + this.nome);
    }

    /**
     * Método para consultar vendas do vendedor
     */
    public void consultarVendas() {
        System.out.println("profile.Vendedor " + this.nome + " realizou " + this.quantidadeVendas + " vendas");
    }

    @Override
    public void realizarLogin() {
        System.out.println("profile.Vendedor " + this.nome + " realizou login");
    }

    @Override
    public void realizarLogoff() {
        System.out.println("profile.Vendedor " + this.nome + " realizou logoff");
    }

    @Override
    public void alterarDados(String novoNome, String novoEmail) {
        this.nome = novoNome;
        this.email = novoEmail;
        System.out.println("Dados do vendedor atualizados");
    }

    @Override
    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha do vendedor alterada");
    }

    // Getter para quantidade de vendas
    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    // Não há setter para quantidadeVendas pois só deve ser alterado via realizarVenda()
}

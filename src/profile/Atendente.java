package profile;

/**
 * Classe que representa um profile.Atendente no sistema
 */
public class Atendente extends Usuario {
    private double valorEmCaixa;

    /**
     * Construtor da classe profile.Atendente
     * @param nome Nome do atendente
     * @param email Email do atendente
     * @param senha Senha do atendente
     */
    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.valorEmCaixa = 0.0;
        this.isAdmin = false; // profile.Atendente nunca é admin
    }

    /**
     * Método para receber pagamentos (incrementa o valor em caixa)
     * @param valor Valor a ser adicionado ao caixa
     */
    public void receberPagamento(double valor) {
        this.valorEmCaixa += valor;
        System.out.println("Pagamento de R$" + valor + " recebido por " + this.nome);
    }

    /**
     * Método para fechar o caixa (zera o valor em caixa)
     */
    public void fecharCaixa() {
        System.out.println("Caixa fechado com R$" + this.valorEmCaixa);
        this.valorEmCaixa = 0.0;
    }

    @Override
    public void realizarLogin() {
        System.out.println("profile.Atendente " + this.nome + " realizou login");
    }

    @Override
    public void realizarLogoff() {
        System.out.println("profile.Atendente " + this.nome + " realizou logoff");
    }

    @Override
    public void alterarDados(String novoNome, String novoEmail) {
        this.nome = novoNome;
        this.email = novoEmail;
        System.out.println("Dados do atendente atualizados");
    }

    @Override
    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha do atendente alterada");
    }

    // Getter para valor em caixa
    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    // Não há setter para valorEmCaixa pois só deve ser alterado via receberPagamento() e fecharCaixa()
}
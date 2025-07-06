# Santander Boot Camp 2025

🏢 COLLABORATOR PROFILE - Sistema de Gestão de Usuários com Hierarquia de Perfis

* Sistema Java para gerenciamento de colaboradores com diferentes níveis de acesso, implementando:
* Hierarquia de classes para tipos de usuários (Gerente, Vendedor, Atendente)
* Controle de acesso baseado em perfil
* Operações específicas para cada tipo de usuário
* Validação de dados de entrada
* Menu interativo dinâmico conforme perfil do usuário

🛠️ Tecnologias Utilizadas
* Java 17+
* Scanner para entrada de dados
* Herança e polimorfismo
* Encapsulamento de propriedades
* Menu interativo com switch-case
* Validação de dados de entrada

📚 Pré-requisitos
* Java JDK 17 ou superior
* Conhecimento básico de compilação Java
* Terminal/Console para execução

* 🚀 Como Executar
 
1. Compile o programa:
* bash
* javac -d bin dao/Collaborator.java profile/Atendente.java profile/Usuario.java profile/Gerente.java profile/Vendedor.java profile/ProfileCollaborator.java Main.java
* Execute o programa:
 
* bash
* java -cp bin Main
* Siga o fluxo interativo:
 
 
* === COLLABORATOR PROFILE ===
1. Login
2. Sair do Sistema
* Escolha uma opção:
 
3. 🎯 Funcionalidades Implementadas
* ✔️ Sistema hierárquico de tipos de usuários
* ✔️ Controle de acesso diferenciado:
* ✔️ Gerentes: acesso completo (cadastro de usuários, relatórios)
* ✔️ Vendedores: controle de vendas
* ✔️ Atendentes: gestão de caixa
* ✔️ Menu dinâmico que adapta às permissões do usuário
* ✔️ Validação de dados de entrada (email, senha, nome)
* ✔️ Operações específicas para cada perfil
* ✔️ Gerenciamento de sessão (login/logoff)
 
* 📝 Exemplo de Uso
 
* === COLLABORATOR PROFILE ===
1. Login
2. Sair do Sistema
* Escolha uma opção: 1
 
* Email: admin@gmail.com
* Senha: admin123
 
* Gerente Jonson realizou login
 
* === MENU DO USUÁRIO ===
1. Alterar dados
2. Alterar senha
3. Gerar relatório financeiro
4. Consultar vendas
5. Voltar ao menu principal
* Escolha uma opção: 3
* Relatório financeiro gerado por Jonson
 
* ⚠️ Importante
* O sistema vem com usuários de exemplo pré-cadastrados:
* Gerente: admin@empresa.com / admin123
* Vendedor: vendedor@empresa.com / vendedor123
* Atendente: atendente@empresa.com / atendente123
* Apenas gerentes podem cadastrar novos usuários
* Cada tipo de usuário tem um menu específico com operações permitidas
* O sistema não persiste dados entre execuções
 
 ````mermaid
classDiagram
    class Usuario {
        <<abstract>>
        #nome: String
        #email: String
        #senha: String
        #isAdmin: boolean
        +realizarLogin()
        +realizarLogoff()
        +alterarDados(String, String)
        +alterarSenha(String)
        +getEmail() String
    }
    
    class Gerente {
        +Gerente(String nome, String email, String senha)
        +gerarRelatorioFinanceiro()
        +consultarVendas()
    }
    
    class Vendedor {
        -quantidadeVendas: int
        +Vendedor(String nome, String email, String senha)
        +realizarVenda()
        +consultarVendas()
    }
    
    class Atendente {
        -valorEmCaixa: double
        +Atendente(String nome, String email, String senha)
        +receberPagamento(double)
        +fecharCaixa()
    }
    
    class Collaborator {
        -usuarios: List~Usuario~
        -usuarioLogado: Usuario
        -scanner: Scanner
        +Collaborator()
        +realizarLogin()
        +cadastrarUsuario()
        +alterarDadosUsuario()
        +alterarSenhaUsuario()
        +realizarLogoff()
        +getUsuarioLogado() Usuario
        +getUsuarios() List~Usuario~
    }
    
    class ProfileCollaborator {
        -usuariosExemplo: List~Usuario~
        +getUsuariosExemplo() List~Usuario~
    }
    
    Usuario <|-- Gerente
    Usuario <|-- Vendedor
    Usuario <|-- Atendente
    Collaborator --> Usuario
    Collaborator --> ProfileCollaborator
    ProfileCollaborator --> Usuario

 ````

* 🔄 Fluxograma Básico
* [Início]
* ↓
* [Menu Principal]
* ↓
* ├─ Não logado:
* │ ├─ 1. Login → Verifica credenciais → Menu do Usuário
* │ └─ 2. Sair → Encerra programa
* └─ Logado:
* ├─ Gerente: Opções administrativas
* ├─ Vendedor: Controle de vendas
* ├─ Atendente: Gestão de caixa
* └─ 4. Logoff → Volta ao menu não logado
 
* 📌 Observações
* Todas as classes devem estar nos pacotes especificados (dao e profile)
* O sistema não persiste os dados entre execuções
* As senhas são armazenadas em texto simples (não recomendado para produção)
* A entrada de dados é validada para evitar erros de execução
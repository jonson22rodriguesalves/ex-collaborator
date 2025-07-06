package profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena os perfis de colaboradores exemplos
 */
public class ProfileCollaborator {
    private static List<Usuario> usuariosExemplo = new ArrayList<>();

    static {
        // Inicializa com os usuários de exemplo
        usuariosExemplo.add(new Gerente("Jonson", "admin@gmail.com", "admin123"));
        usuariosExemplo.add(new Vendedor("profile.Vendedor Souza", "vendedor@empresa.com", "vendedor123"));
        usuariosExemplo.add(new Atendente("profile.Atendente Costa", "atendente@empresa.com", "atendente123"));
    }

    /**
     * Retorna a lista de usuários exemplo
     */
    public static List<Usuario> getUsuariosExemplo() {
        return new ArrayList<>(usuariosExemplo);
    }
}
/**
 * Created by petto on 4/2/16.
 */
public class ComTitulo implements FormatadorNome {
    private String titulo;

    public ComTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String formatarNome(String nome, String sobrenome) {
        return titulo + " " + nome + " " + sobrenome;

    }
}

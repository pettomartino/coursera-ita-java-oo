/**
 * Created by petto on 4/2/16.
 */
enum Sexo {
    Masculino,
    Feminino;
}
public class Respeitoso implements FormatadorNome {

    private String tratamento;

    public Respeitoso(Sexo sexo) {
        tratamento = (sexo == Sexo.Masculino ? "Sr." : "Sra.");
    }

    @Override
    public String formatarNome(String nome, String sobrenome) {
        return tratamento + " " + sobrenome;

    }
}

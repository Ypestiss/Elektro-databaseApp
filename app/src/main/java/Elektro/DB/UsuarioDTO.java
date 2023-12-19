package Elektro.DB;
import java.util.Random;

public class UsuarioDTO {

    Random rand = new Random();

    int idCliente = 100000 + rand.nextInt(999999);
    int idFunc = 100000 + rand.nextInt(999999);
    int idRandom = 1000 + rand.nextInt(9999);
    private static String Nome_login;
    private String Senha_login;
    private int Id_login;
    public UsuarioDTO(){
        this.Nome_login = "";
        this.Senha_login = "";
        this.Id_login = 0;
    }

    public static String getNome_login() {
        return Nome_login;
    }

    public void setNome_login(String nome_login) {
        Nome_login = nome_login;
    }

    public String getSenha_login() {
        return Senha_login;
    }

    public void setSenha_login(String senha_login) {
        Senha_login = senha_login;
    }

    public int getId_login() {
        return Id_login;
    }

    public void setId_login(int id_login) {
        Id_login = id_login;
    }






}

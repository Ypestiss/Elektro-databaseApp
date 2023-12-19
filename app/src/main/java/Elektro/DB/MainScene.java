package Elektro.DB;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.sql.Connection;

import Elektro.DB.registros.Registro_fragment;

public class MainScene extends AppCompatActivity implements OnConnectionCompleteListener{

    Connection connection;
    ConexaoDAO conexaodao;
    UsuarioDTO userDTO;
    Context context = this;
    UsuarioDAO userDAO;
    public MainScene(Context context){
        conexaodao = new ConexaoDAO(context);
        conexaodao.openDatabase((OnConnectionCompleteListener) this);
        Log.d("UsuarioDAO", "Conexão:" + conexaodao);
    }
    private EditText NomeFunc, SenhaFunc;

    public MainScene(){

    }

    @Override
    public int onConnectionComplete(Connection connection) {
        this.connection = connection;
        Log.d("MainScene", "teste:" + connection);
        return 1;
    }

    @Override
    public void onConnectionError(Exception e) {
        Log.d("MainScene", "erro:" + e);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_scene);


        NomeFunc = findViewById(R.id.editTextNomeCliente);
        SenhaFunc = findViewById(R.id.editTextSenhaFuncionario);
        Button loginButton = findViewById(R.id.buttonLogin);

        conexaodao = new ConexaoDAO(this);
        conexaodao.openDatabase(this);
        userDAO = new UsuarioDAO(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomeFuncionarioText = NomeFunc.getText().toString();
                String senhaFuncionarioText = SenhaFunc.getText().toString();

                // Criar um objeto UsuarioDTO e configurar os valores
                UsuarioDTO userDTO = new UsuarioDTO();
                userDTO.setNome_login(nomeFuncionarioText);
                userDTO.setSenha_login(senhaFuncionarioText);

                // Chamar o método de login na classe UsuarioDAO
                new AsyncTask<Void, Void, Integer>() {
                    @Override
                    protected Integer doInBackground(Void... voids) {
                        System.out.println("Fazendo o login...");
                        return userDAO.doLogin(userDTO);
                    }
                    @Override
                    protected void onPostExecute(Integer resultado){
                        super.onPostExecute(resultado);
                        if (resultado == 1){
                            Log.d("MainScene", "Logado!!");
                            Toast.makeText(context, "Logado como: " + userDTO.getNome_login(), Toast.LENGTH_SHORT).show();

                            carregarFragmento();
                        } else{
                            Log.d("MainScene", "Erro no login, nome ou senha incorreta!!");
                        }
                    }
                }.execute();

            }
        });
    }

    private void carregarFragmento() {
        findViewById(R.id.main_scene_layout).setVisibility(View.GONE);
        findViewById(R.id.container).setVisibility(View.VISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Inicia a transação
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Adiciona, substitui ou remove fragmentos conforme necessário
        Registro_fragment registrofragment = new Registro_fragment();
        fragmentTransaction.replace(R.id.container, registrofragment);


        // Commita a transação
        fragmentTransaction.commit();
    }
}
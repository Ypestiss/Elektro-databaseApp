package Elektro.DB.registros;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;

import Elektro.DB.ConexaoDAO;
import Elektro.DB.OnConnectionCompleteListener;
import Elektro.DB.R;
import Elektro.DB.UsuarioDTO;

public class Registro_fragment extends Fragment implements OnConnectionCompleteListener {
    ConexaoDAO conexao;
    RegistrosDTO registrosDTO;
    RegistrosDAO registrosDAO;
    Connection conn;
    Context context;
    String TAG = "Registro_Fragment";

    public Registro_fragment() {
        conexao = new ConexaoDAO(context);
        conexao.openDatabase(this);
        registrosDAO = new RegistrosDAO(context);
    }
    public static Registro_fragment newInstance(String param1, String param2) {
        Registro_fragment fragment = new Registro_fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView Teste_login;
    private EditText Nome_Cliente, Id_Cliente, Documento, Rg, Email, Telefone, Celular, Uc, Contrato, Corte,
            Endereço_Cliente, Cep, Bairro_cliente, Etapa, Cidade, Estado, Tarifa, Classe_Principal, Municipio,
            Localiza, Nis, CNPJ, Fatura, Total_Fatura, Equipamento_Codigo, Protocolo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_scene, container, false);
        Teste_login = view.findViewById(R.id.TesteLogin);
        Nome_Cliente = view.findViewById(R.id.editTextNomeCliente);
        Id_Cliente = view.findViewById(R.id.editTextIdCliente);
        Documento = view.findViewById(R.id.editTextDocumento);
        Rg = view.findViewById(R.id.editTextRg);
        Email = view.findViewById(R.id.editTextEmail);
        Telefone = view.findViewById(R.id.editTextTelefone);
        Celular = view.findViewById(R.id.editTextCelular);
        Uc = view.findViewById(R.id.editTextUc);
        Contrato = view.findViewById(R.id.editTextContrato);
        Corte = view.findViewById(R.id.editTextCorte);
        Endereço_Cliente = view.findViewById(R.id.editTextEndereçoRua);
        Cep = view.findViewById(R.id.editTextCep);
        Bairro_cliente = view.findViewById(R.id.editTextBairro);
        Etapa = view.findViewById(R.id.editTextEtapa);
        Cidade = view.findViewById(R.id.editTextCidade);
        Estado = view.findViewById(R.id.editTextEstado);
        Tarifa = view.findViewById(R.id.editTextTarifa);
        Classe_Principal = view.findViewById(R.id.editTextClassePrincipal);
        Municipio = view.findViewById(R.id.editTextMunicipio);
        Localiza = view.findViewById(R.id.editTextLocaliza);
        Nis = view.findViewById(R.id.editTextNIS);
        CNPJ = view.findViewById(R.id.editTextCNPJ);
        Fatura = view.findViewById(R.id.editTextFatura);
        Total_Fatura = view.findViewById(R.id.editTextTotalFatura);
        Equipamento_Codigo = view.findViewById(R.id.editTextEquipamentoCod);
        Protocolo = view.findViewById(R.id.editTextProtocolo);

        Button loginButton = view.findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teste_Login_Text = UsuarioDTO.getNome_login();
                String nome_Cliente_Text = Nome_Cliente.getText().toString();
                String id_Cliente_Text = Id_Cliente.getText().toString();
                String documento_Text = Documento.getText().toString();
                String rg_Text = Rg.getText().toString();
                String email_Text = Email.getText().toString();
                String telefone_Text = Telefone.getText().toString();
                String celular_Text = Celular.getText().toString();
                String uc_Text = Uc.getText().toString();
                String contrato_Text = Contrato.getText().toString();
                String corte_Text = Corte.getText().toString();
                String endereço_Text = Endereço_Cliente.getText().toString();
                String cep_Text = Cep.getText().toString();
                String bairro_Text = Bairro_cliente.getText().toString();
                String etapa_Text = Etapa.getText().toString();
                String cidade_Text = Cidade.getText().toString();
                String estado_Text = Estado.getText().toString();
                String tarifa_Text = Tarifa.getText().toString();
                String classe_Text = Classe_Principal.getText().toString();
                String municipio_Text = Municipio.getText().toString();
                String localiza_Text = Localiza.getText().toString();
                String nis_Text = Nis.getText().toString();
                String cnpj_Text = CNPJ.getText().toString();
                String fatura_Text = Fatura.getText().toString();
                String totalfatura_Text = Total_Fatura.getText().toString();
                String equipamento_Text = Equipamento_Codigo.getText().toString();
                String protocolo_Text = Protocolo.getText().toString();

                RegistrosDTO regDTO = new RegistrosDTO();
                regDTO.setNome_cliente(nome_Cliente_Text);
                regDTO.setDocumento(Integer.parseInt(documento_Text));
                regDTO.setRG(Integer.parseInt(rg_Text));


                Log.d(TAG,"Testando: "+ nome_Cliente_Text);

                new AsyncTask<Void,Void,Integer>(){

                    @Override
                    protected Integer doInBackground(Void... voids) {
                        Log.d(TAG, "doInBackground: Carregando...");
                        return registrosDAO.doRegistro(regDTO);
                    }

                    @Override
                    protected void onPostExecute(Integer resultado) {
                        super.onPostExecute(resultado);
                        if(resultado == 1){
                            Log.d(TAG, "onPostExecute: Dados inseridos com sucesso!!" + teste_Login_Text);
                            Toast.makeText(getActivity(), "Dados inseridos com sucesso!!", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Log.e(TAG, "onPostExecute: Erro ao Inserir dados!! ");
                        }
                    }
                }.execute();
            }
        });
        return view;

    }
    @Override
    public int onConnectionComplete(Connection connection) {
        this.conn = connection;
        Log.d("Registros", "Conexão estabelecida no login:" + conn);
        return 1;
    }
    @Override
    public void onConnectionError(Exception e) {
        Log.d("Registros", "Erro na conexão: " + e);

    }
}
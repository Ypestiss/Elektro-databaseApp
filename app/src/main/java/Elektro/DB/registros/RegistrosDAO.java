package Elektro.DB.registros;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Elektro.DB.ConexaoDAO;
import Elektro.DB.OnConnectionCompleteListener;
import Elektro.DB.UsuarioDTO;

public class RegistrosDAO implements OnConnectionCompleteListener {

    Connection connection;
    ConexaoDAO conexaodao;

    public RegistrosDAO(Context context){
        conexaodao = new ConexaoDAO(context);
        conexaodao.openDatabase(this);
        Log.d("RegistrosDAO", "Conexão:" + conexaodao);
    }
    @Override

    public int onConnectionComplete(Connection connection) {
        this.connection = connection;
        Log.d("RegistrosDAO", "Conectado!");
        return 1;
    }

    @Override
    public void onConnectionError(Exception e) {
        Log.d("RegistroDAO", "onConnectionError: " + e);
    }

    public int doRegistro(RegistrosDTO registrosDTO) {
        String TAG = "RegistroDAO";
        Log.d(TAG, "doRegistro: Chamou ");
        try {
            Log.d(TAG, "doRegistro: Tentando conectar...");
            if (connection == null) {
                Log.d(TAG, "doRegistro: Falha ao conectar!! Conexão Nula");
                return 0;
            } else {
                try {
                    if (!dadosExistem(registrosDTO)) {
                        Log.d("UsuarioDAO", "Conetado a:" + connection);
                        String sql = "INSERT INTO data (Nome_cliente, Id_cliente, Documento, RG," +
                                "Telefone, Celular, Email, UC, Contrato, Corte, Endereco_rua, Cep, Bairro_nome, Etapa, Cidade," +
                                "Estado, Tarifa, Classe_principal, Municipio, Localiza, NIS, CNPJ_uc, Fatura," +
                                "Total_fatura, Equipamento_codigo, Protocolo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                                "?, ?, ?, ?, ?, ?)";
                        PreparedStatement pstm = connection.prepareStatement(sql);
                        pstm.setString(1, registrosDTO.getNome_cliente());
                        pstm.setInt(2, registrosDTO.getId_cliente());
                        pstm.setInt(3, registrosDTO.getDocumento());
                        pstm.setInt(4, registrosDTO.getRG());
                        pstm.setInt(5, registrosDTO.getTelefone());
                        pstm.setInt(6, registrosDTO.getCelular());
                        pstm.setString(7, registrosDTO.getEmail());
                        pstm.setInt(8, registrosDTO.getUC());
                        pstm.setString(9, registrosDTO.getContrato());
                        pstm.setString(10, registrosDTO.getCorte());
                        pstm.setString(11, registrosDTO.getEndereco_rua());
                        pstm.setInt(12, registrosDTO.getCep());
                        pstm.setString(13, registrosDTO.getBairro_nome());
                        pstm.setString(14, registrosDTO.getEtapa());
                        pstm.setString(15, registrosDTO.getCidade());
                        pstm.setString(16, registrosDTO.getEstado());
                        pstm.setString(17, registrosDTO.getTarifa());
                        pstm.setString(18, registrosDTO.getClasse_principal());
                        pstm.setString(19, registrosDTO.getMunicipio());
                        pstm.setString(20, registrosDTO.getLocaliza());
                        pstm.setInt(21, registrosDTO.getNIS());
                        pstm.setInt(22, registrosDTO.getCNPJ_uc());
                        pstm.setFloat(23, registrosDTO.getFatura());
                        pstm.setFloat(24, registrosDTO.getTotal_fatura());
                        pstm.setString(25, registrosDTO.getEquipamento_codigo());
                        pstm.setString(26, registrosDTO.getProtocolo());


                        int resultado = pstm.executeUpdate();
                        return resultado;
                    }
                } catch (SQLException e) {
                    Log.e(TAG, "UsuarioDAO: " + e);
                } finally {
                    if (connection != null) {
                        Log.d(TAG, "doRegistro: Teste ");
                    }
                }

            }
        } catch (Exception e) {
            Log.e(TAG, "Vsf: " + e);
        }
        return 0;
    }

    private boolean dadosExistem(RegistrosDTO regDTO){
        try{
            Log.d("Conexão", "Conexão é:" + connection);
            Log.d("UsuarioDAO", "Verificando se há dados existentes. . .");
            String sql = "SELECT COUNT(*) FROM data WHERE Nome_cliente = ? AND Documento = ?";
            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, regDTO.getNome_cliente());
                stmt.setInt(2, regDTO.getDocumento());

                ResultSet resultado = stmt.executeQuery();
                resultado.next();
                int count = resultado.getInt(1);
                Log.d("UsuarioDAO", "logando... ");
                return count > 0;
            }
        }catch (SQLException e) {
            return true;
        }

    }
}

package Elektro.DB;

import android.content.Context;
import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UsuarioDAO implements OnConnectionCompleteListener {
    Connection connection;
    ConexaoDAO conexaodao;
    UsuarioDTO userDTO;

    public UsuarioDAO(Context context) {
        conexaodao = new ConexaoDAO(context);
        conexaodao.openDatabase(this);
        Log.d("UsuarioDAO", "Conexão:" + conexaodao);
    }

    @Override
    public int onConnectionComplete(Connection connection) {
        this.connection = connection;
        Log.d("UsuarioDAO", "teste:" + connection);
        return 1;
    }

    @Override
    public void onConnectionError(Exception e) {
        Log.e("UsuarioDAO", "Erro ao abrir a conexão com o banco de dados: " + e.getMessage());
    }

    public int doLogin(UsuarioDTO userDTO) {
        try {
            Log.d("UsuarioDAO", "Iniciando registro");
            if (connection == null) {
                Log.d("UsuarioDAO", "falha ao abrir registro");
                return 0;
            } else{
                Log.d("UsuarioDAO", "Conetado a:" + connection);
                String sql = "SELECT COUNT(*) FROM usuarios WHERE Nome_login = ? AND Senha_login = ? AND Id_login = ?";
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString(1, userDTO.getNome_login());
                pstm.setString(2, userDTO.getSenha_login());
                pstm.setInt(3, userDTO.getId_login());

                ResultSet rowLogged = pstm.executeQuery(); // Use executeUpdate
                rowLogged.next();
                int count = rowLogged.getInt(1);
                Log.d("UsuarioDAO", "Logado com sucesso" + count);
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o rastreamento da pilha para facilitar a depuração
            Log.e("UsuarioDAO", "Erro SQL durante a inserção: " + e.getMessage());
        } finally {
            if (connection != null) {
                System.out.println("Onde fechava a conexão");
                // connection.close(); // Certifique-se de fechar a conexão
            }
        }
        return 0;
    }
    /*
    */
}

/*
String sql = "INSERT INTO data (Nome_cliente, Nome_func, Id_cliente, Id_func, Documento, RG," +
                        "Telefone, Celular, Email, UC, Contrato, Corte, Endereco_rua, Cep, Bairro_nome, Etapa, Local, Cidade," +
                        "Estado, Tarifa, Classe_principal, Municipio, Localiza, NIS, CNPJ_uc, Id_inscricao, Foto_url, Fatura," +
                        "Total_fatura, Equipamento_codigo, Protocolo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setString(1, userDTO.getNome_cliente());
                pstm.setString(2, userDTO.getNome_func());
                pstm.setInt(3, userDTO.getId_cliente());
                pstm.setInt(4, userDTO.getId_func());
                pstm.setInt(5, userDTO.getDocumento());
                pstm.setInt(6, userDTO.getRG());
                pstm.setInt(7, userDTO.getTelefone());
                pstm.setInt(8, userDTO.getCelular());
                pstm.setString(9, userDTO.getEmail());
                pstm.setInt(10, userDTO.getUC());
                pstm.setString(11, userDTO.getContrato());
                pstm.setString(12, userDTO.getCorte());
                pstm.setString(13, userDTO.getEndereco_rua());
                pstm.setInt(14, userDTO.getCep());
                pstm.setString(15, userDTO.getBairro_nome());
                pstm.setString(16, userDTO.getEtapa());
                pstm.setInt(17, userDTO.getLocal());
                pstm.setString(18, userDTO.getCidade());
                pstm.setString(19, userDTO.getEstado());
                pstm.setString(20, userDTO.getTarifa());
                pstm.setString(21, userDTO.getClasse_principal());
                pstm.setInt(22, userDTO.getMunicipio());
                pstm.setString(23, userDTO.getLocaliza());
                pstm.setInt(24, userDTO.getNIS());
                pstm.setInt(25, userDTO.getCNPJ_uc());
                pstm.setString(26, userDTO.getId_inscricao());
                pstm.setInt(27, userDTO.getFoto_url());
                pstm.setFloat(28, userDTO.getFatura());
                pstm.setFloat(29, userDTO.getTotal_fatura());
                pstm.setString(30, userDTO.getEquipamento_codigo());
                pstm.setString(31, userDTO.getProtocolo());

 */
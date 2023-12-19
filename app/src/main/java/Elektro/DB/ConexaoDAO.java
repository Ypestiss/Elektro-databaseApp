package Elektro.DB;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.*;

public class ConexaoDAO {

    public ConexaoDAO(Context context) {
    }

    public void openDatabase(final OnConnectionCompleteListener listener) {
        new AsyncTask<Void, Void, Connection>() {
            @Override
            protected  Connection doInBackground(Void... voids) {
                Log.d("conexaoDAO", "doInBackground: chamou função background ");
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    return DriverManager.getConnection("jdbc:mysql://192.168.0.117:3306/registros", "admin", "admin");
                } catch (ClassNotFoundException | SQLException e) {
                    listener.onConnectionError(e);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Connection connection) {
                if (connection != null) {
                    try {
                        System.out.println(connection);
                        listener.onConnectionComplete(connection);
                    } catch (Exception e) {
                        listener.onConnectionError(e);
                    }
                } else {
                    throw new RuntimeException("Conexão nula após doInBackground");
                }
            }
        }.execute();
    }
    public void closeDatabase(Connection connection, Statement statement) {
        if (statement != null) {
            Log.d("ConexãoDAO", "closeDatabase: " + statement);
           // statement.close();
        }
        if (connection != null) {
            Log.d("ConexãoDAO", "ConnectionClose:" + connection);
            //connection.close();
        }
    }

    public void closeDatabase(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                Log.d("ConexãoDAO", "resultSet: " + resultSet);
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão", e);
        }
    }
}
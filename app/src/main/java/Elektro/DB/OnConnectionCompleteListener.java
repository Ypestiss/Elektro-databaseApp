package Elektro.DB;

import java.sql.Connection;

public interface OnConnectionCompleteListener {
    int onConnectionComplete(Connection connection);
    void onConnectionError(Exception e);
}
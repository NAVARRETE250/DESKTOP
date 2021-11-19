package conexion;

import java.rmi.Remote;

public interface Interfaz{
    public String getResponse(String data);
    public void sendUsername(String username);
}

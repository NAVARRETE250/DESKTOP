package conexion;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

public interface Interfaz{
    public String getResponse(String data);
    public void sendUsername(String username);
    public ArrayList<String> getAllUsernames();
    public boolean kahootIsStarted();
    public ArrayList<String> getRespuestas(int ronda);
    public ArrayList<Boolean> getSoluciones();
    public boolean tiempoAcabado();
    public int getRonda();
    public int getTiempoRestante();
    public void sendPuntuacion(String username, int puntuación);
    public boolean ultimaPregunta();
}

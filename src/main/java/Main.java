import static classes.DataBase.DataBase.checkConnection;
import static classes.DataBase.DataBase.query;
import static classes.StartATM.startATM;

public class Main {
    public static void main(String[] args) {
        checkConnection();
        startATM();
    }
}

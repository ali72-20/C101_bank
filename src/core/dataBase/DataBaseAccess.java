package core.dataBase;

public class DataBaseAccess {
    public static DataBaseServicesImpl dataBaseServices;
    private DataBaseAccess(){
        dataBaseServices = new DataBaseServicesImpl();
    }

}

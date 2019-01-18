package parameters;

public class ParameterProvider {

    public static final String SERVER_IP_ADDRESS = "localhost";
    public static final String SERVER_PORT_NUMBER = "8080";

    public static final String CLIENT_IP_ADDRESS = "localhost";
    public static final Integer CLIENT_PORT_NUMBER = 8080;

    public static final String DATABASE_CONNECTOR_DATABASE_SERVER_IP="localhost";
    public static final String DATABASE_CONNECTOR_DATABASE_PORT_NUMBER = "1433";
    public static final String DATABASE_CONNECTOR_DATABASE_NAME = "PasswordManagerDatabase";
    public static final String DATABASE_CONNECTOR_DATABASE_LOGIN = "PMDBUser";
    public static final String DATABASE_CONNECTOR_DATABASE_PASSWORD = "12345";
    public static final String DATABASE_CONNECTOR_DATABASE_URL = "jdbc:sqlserver://"+DATABASE_CONNECTOR_DATABASE_SERVER_IP+":"+DATABASE_CONNECTOR_DATABASE_PORT_NUMBER+";databasename="+DATABASE_CONNECTOR_DATABASE_NAME;

    public static final String WINDOW_TITLE = "Car Rental Shop";
}

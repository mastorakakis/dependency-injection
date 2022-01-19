package gr.pricefox.lib;

public class DI {

    private static final DI instance = new DI();

    private DI() {}

    public static DI getInstance() {
        return instance;
    }


}

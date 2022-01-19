package gr.pricefox;

import gr.pricefox.lib.DI;
import gr.pricefox.service.MyService;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        DI di = DI.getInstance();

        MyService myService = di.singletonOf(MyService.class);
    }
}

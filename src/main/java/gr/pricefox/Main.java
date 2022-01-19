package gr.pricefox;

import gr.pricefox.service.MyService;
import gr.pricefox.service.OtherService;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        DI di = DI.getInstance();

        MyService myService = di.singletonOf(MyService.class);
        System.out.println(myService);
        MyService myService1 = di.singletonOf(MyService.class);
        System.out.println(myService1);

        OtherService otherService = di.oneOf(OtherService.class);
        System.out.println(otherService);
        OtherService otherService1 = di.oneOf(OtherService.class);
        System.out.println(otherService1);


    }
}

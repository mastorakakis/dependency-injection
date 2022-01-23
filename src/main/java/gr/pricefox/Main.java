package gr.pricefox;

import gr.pricefox.model.CarInsuranceProvider;
import gr.pricefox.service.InvalidService;
import gr.pricefox.service.MyService;
import gr.pricefox.service.OtherService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CustomAnnotationException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {

        DI di = DI.getInstance();

//        req1(di);
        req2(di, CarInsuranceProvider.class);
    }

    public static void req1(DI di) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, CustomAnnotationException {
        System.out.println("======Singleton==========");
//        MyService myService = di.singletonOf(MyService.class);
//        MyService myService1 = di.singletonOf(MyService.class);
//        System.out.println(myService);
//        System.out.println(myService1);
        MyService myServiceAnnotated = di.instanceOf(MyService.class);
        MyService myServiceAnnotated2 = di.instanceOf(MyService.class);
        System.out.println(myServiceAnnotated);
        System.out.println("         " + myServiceAnnotated.getMyRepository());
        System.out.println(myServiceAnnotated2);
        System.out.println("         " + myServiceAnnotated2.getMyRepository());

        System.out.println("======Prototype===========");
//        OtherService otherService = di.oneOf(OtherService.class);
//        OtherService otherService1 = di.oneOf(OtherService.class);
//        System.out.println(otherService);
//        System.out.println(otherService1);
        OtherService otherServiceAnnotated = di.instanceOf(OtherService.class);
        OtherService otherServiceAnnotated2 = di.instanceOf(OtherService.class);
        System.out.println(otherServiceAnnotated);
        System.out.println("         " + otherServiceAnnotated.getOtherRepository());
        System.out.println(otherServiceAnnotated2);
        System.out.println("         " + otherServiceAnnotated2.getOtherRepository());

        System.out.println("=======Invalid=============");
        InvalidService invalidService = di.instanceOf(InvalidService.class);
        System.out.println(invalidService);
    }

    public static <T> void req2(DI di, Class<T> theInterface) {
        List<Class<T>> classes = di.listOf(theInterface);
        classes.forEach(element -> System.out.println(element.getSimpleName()));
    }
}

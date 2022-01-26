package gr.pricefox;

import gr.pricefox.model.AllianzProvider;
import gr.pricefox.model.AnekLines;
import gr.pricefox.model.AnyTimeProvider;
import gr.pricefox.model.CarInsuranceProvider;
import gr.pricefox.model.MinettaProvider;
import gr.pricefox.service.InvalidService;
import gr.pricefox.service.MyService;
import gr.pricefox.service.OtherService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CustomAnnotationException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {

        DI di = DI.getInstance();

        req1(di);
        req2(di, CarInsuranceProvider.class);
    }

    public static void req1(DI di) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, CustomAnnotationException {

        System.out.println("======Singleton==========");
        MyService myServiceAnnotated = di.objectOf(MyService.class);
        MyService myServiceAnnotated2 = di.objectOf(MyService.class);
        System.out.println(myServiceAnnotated);
        System.out.println("         " + myServiceAnnotated.getMyRepository());
        System.out.println(myServiceAnnotated2);
        System.out.println("         " + myServiceAnnotated2.getMyRepository());

        System.out.println("======Prototype===========");
        OtherService otherServiceAnnotated = di.objectOf(OtherService.class);
        OtherService otherServiceAnnotated2 = di.objectOf(OtherService.class);
        System.out.println(otherServiceAnnotated);
        System.out.println("         " + otherServiceAnnotated.getOtherRepository());
        System.out.println(otherServiceAnnotated2);
        System.out.println("         " + otherServiceAnnotated2.getOtherRepository());

        System.out.println("=======Invalid=============");
        InvalidService service = null;
        try {
            service = di.objectOf(InvalidService.class);
        } catch (CustomAnnotationException e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid service: " + service);
        }
    }

    public static <T> void req2(DI di, Class<T> theInterface) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, CustomAnnotationException, IllegalAccessException {

        System.out.println("\n" + theInterface.getSimpleName() + " Implementations:");
        AnyTimeProvider anyTimeProvider = di.objectOf(AnyTimeProvider.class);
        AnyTimeProvider anyTimeProvider2 = di.objectOf(AnyTimeProvider.class);
        AnyTimeProvider anyTimeProvider3 = di.objectOf(AnyTimeProvider.class);
        MinettaProvider minettaProvider = di.objectOf(MinettaProvider.class);
        AllianzProvider allianzProvider = di.objectOf(AllianzProvider.class);
        AllianzProvider allianzProvider2 = di.objectOf(AllianzProvider.class);
        AnekLines anekLines = di.objectOf(AnekLines.class);

        List<CarInsuranceProvider> carInsuranceProviders = di.listOf(CarInsuranceProvider.class);
        carInsuranceProviders.forEach(c -> System.out.println(c.getClass().getSimpleName()));

        System.out.println(carInsuranceProviders.get(0).getMyService());
    }
}

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

import static org.junit.Assert.*;

public class DITest {

    private final DI di = DI.getInstance();

    @org.junit.Test
    public void listOf() {
        List<Class<CarInsuranceProvider>> classList = di.classListOf(CarInsuranceProvider.class);
        assertFalse(classList.contains(AnekLines.class));
        assertTrue(classList.contains(AllianzProvider.class));
        assertTrue(classList.contains(AnyTimeProvider.class));
        assertTrue(classList.contains(MinettaProvider.class));
    }

    @org.junit.Test
    public void objectOf_singleton() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, CustomAnnotationException, IllegalAccessException {
        MyService myServiceAnnotated = di.objectOf(MyService.class);
        MyService myServiceAnnotated2 = di.objectOf(MyService.class);
        assertEquals(myServiceAnnotated, myServiceAnnotated2);
        assertNotNull(myServiceAnnotated.getMyRepository());
        assertNotNull(myServiceAnnotated2.getMyRepository());
        assertEquals(myServiceAnnotated.getMyRepository(), myServiceAnnotated2.getMyRepository());
    }

    @org.junit.Test
    public void objectOf_oneOf() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, CustomAnnotationException, IllegalAccessException {
        OtherService otherService = di.objectOf(OtherService.class);
        OtherService otherService2 = di.objectOf(OtherService.class);
        assertNotEquals(otherService, otherService2);
        assertNotNull(otherService.getMyRepository());
        assertNotNull(otherService2.getMyRepository());
        assertEquals(otherService.getMyRepository(), otherService2.getMyRepository());
    }

    @org.junit.Test
    public void unsatisfiedDependency() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, CustomAnnotationException, IllegalAccessException {
        InvalidService service = null;
        try {
            service = di.objectOf(InvalidService.class);
        } catch (CustomAnnotationException e) {
            assertNull(service);
        }
    }
}
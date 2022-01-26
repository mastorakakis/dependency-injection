package gr.pricefox.model;

import gr.pricefox.annotation.Component;
import gr.pricefox.service.MyService;

@Component
public class AnyTimeProvider implements CarInsuranceProvider {

    private MyService myService;

    private AnyTimeProvider() {
    }

    private AnyTimeProvider(MyService myService) {
        this.myService = myService;
    }

    public MyService getMyService() {
        return myService;
    }
}

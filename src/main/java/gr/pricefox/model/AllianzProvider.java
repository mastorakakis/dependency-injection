package gr.pricefox.model;

import gr.pricefox.annotation.Component;
import gr.pricefox.service.MyService;

@Component
public class AllianzProvider implements CarInsuranceProvider {

    private MyService myService;

    private AllianzProvider() {
    }

    private AllianzProvider(MyService myService) {
        this.myService = myService;
    }

    public MyService getMyService() {
        return myService;
    }
}

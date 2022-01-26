package gr.pricefox.model;

import gr.pricefox.annotation.Component;
import gr.pricefox.service.MyService;

@Component
public class MinettaProvider implements CarInsuranceProvider {

    private MyService myService;

    private MinettaProvider() {
    }

    private MinettaProvider(MyService myService) {
        this.myService = myService;
    }

    public MyService getMyService() {
        return myService;
    }
}

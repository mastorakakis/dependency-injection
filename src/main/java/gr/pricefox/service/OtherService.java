package gr.pricefox.service;

import gr.pricefox.annotation.Component;
import gr.pricefox.annotation.Scope;
import gr.pricefox.repository.MyRepository;

@Component(scope = Scope.PROTOTYPE)
public class OtherService {

    private MyRepository myRepository;

    private OtherService() {
    }

    private OtherService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public MyRepository getMyRepository() {
        return myRepository;
    }
}

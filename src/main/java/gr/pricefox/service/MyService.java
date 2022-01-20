package gr.pricefox.service;

import gr.pricefox.annotation.Component;
import gr.pricefox.repository.MyRepository;

@Component
public class MyService {

    private MyRepository myRepository;

    public MyService() {
    }

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public MyRepository getMyRepository() {
        return myRepository;
    }
}

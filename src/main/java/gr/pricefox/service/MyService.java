package gr.pricefox.service;

import gr.pricefox.repository.MyRepository;

public class MyService {

    private MyRepository myRepository;

    public MyService() {
    }

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}

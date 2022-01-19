package gr.pricefox.service;

import gr.pricefox.repository.OtherRepository;

public class OtherService {

    private OtherRepository otherRepository;

    public OtherService() {
    }

    public OtherService(OtherRepository otherRepository) {
        this.otherRepository = otherRepository;
    }
}

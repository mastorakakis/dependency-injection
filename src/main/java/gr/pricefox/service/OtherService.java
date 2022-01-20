package gr.pricefox.service;

import gr.pricefox.annotation.Component;
import gr.pricefox.annotation.Scope;
import gr.pricefox.repository.OtherRepository;

@Component(scope = Scope.PROTOTYPE)
public class OtherService {

    private OtherRepository otherRepository;

    public OtherService() {
    }

    public OtherService(OtherRepository otherRepository) {
        this.otherRepository = otherRepository;
    }

    public OtherRepository getOtherRepository() {
        return otherRepository;
    }
}

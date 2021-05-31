package ijector;

import client.DIClientImp;
import client.IDIClient;
import service.EmailServiceImp;
import service.IMessageService;

public class EmailServiceInjectorImp implements IMessageServiceInjector {

    private IMessageService service;
    private DIClientImp client;
    
    @Override
    public IDIClient getDIClientByConstructor() {
        return new DIClientImp(new EmailServiceImp());
    }

    @Override
    public IDIClient getDIClientBySetter() {
        service = new EmailServiceImp();
        client = new DIClientImp();
        client.setMessageService(service);
        return client;
    }

    
    
}

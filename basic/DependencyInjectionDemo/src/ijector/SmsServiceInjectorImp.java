package ijector;

import client.DIClientImp;
import client.IDIClient;
import service.IMessageService;
import service.SmsServiceImp;

public class SmsServiceInjectorImp implements IMessageServiceInjector {

    private IMessageService service;
    private DIClientImp client;
    @Override
    public IDIClient getDIClientByConstructor() {
        return new DIClientImp(new SmsServiceImp());
    }

    @Override
    public IDIClient getDIClientBySetter() {
        service = new SmsServiceImp();
        client = new DIClientImp();
        client.setMessageService(service);
        return client;
    }
    
}

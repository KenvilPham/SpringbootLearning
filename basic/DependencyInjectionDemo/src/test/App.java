package test;

import client.IDIClient;
import ijector.IMessageServiceInjector;
import ijector.SmsServiceInjectorImp;

public class App {
    public static void main(String[] args) throws Exception {
        String email = "kenvil.pham92@gmail.com";
        String phoneNumber = "0999999999";
        String msg = "Demo dependency injection";

        IMessageServiceInjector injector = new SmsServiceInjectorImp();
        IDIClient client = injector.getDIClientByConstructor();

        client.processMessage(msg, phoneNumber);

    }
}

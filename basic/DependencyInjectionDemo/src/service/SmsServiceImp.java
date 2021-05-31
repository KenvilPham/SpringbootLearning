package service;

public class SmsServiceImp implements IMessageService {

    @Override
    public void sendMessage(String msg, String receiver) {
        System.out.println("Send sms to: " + receiver + " - with content: " + msg);
    }
    
}

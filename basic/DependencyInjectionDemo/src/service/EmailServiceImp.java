package service;

public class EmailServiceImp implements IMessageService {

    @Override
    public void sendMessage(String msg, String receiver) {
        System.out.println("Send email to: " + receiver + " -  with content: " + msg);
        
    }
    
}

package client;

import service.IMessageService;

public class DIClientImp implements IDIClient {

    private IMessageService messageService;

    public DIClientImp() {
    }

    public DIClientImp(IMessageService messageService) {
        this.messageService = messageService;
    }

    public void setMessageService(IMessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void processMessage(String msg, String receiver) {
        messageService.sendMessage(msg, receiver);
    }
    
}

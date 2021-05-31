package ijector;

import client.IDIClient;

public interface IMessageServiceInjector {
    IDIClient getDIClientByConstructor();
    IDIClient getDIClientBySetter();
}

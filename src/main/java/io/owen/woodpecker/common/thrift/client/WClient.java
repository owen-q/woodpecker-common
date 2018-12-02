package io.owen.woodpecker.common.thrift.client;

import io.owen.woodpecker.common.thrift.WoodpeckerService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by owen_q on 2018. 12. 2..
 */
public class WClient {
    private Logger logger = LoggerFactory.getLogger(WClient.class);
    private final String host;
    private final int port;

    private TTransport tTransport;
    private TProtocol tProtocol;
    private WoodpeckerService.Client tClient;

    private WClient() {
        this.host = "localhost";
        this.port = 10000;
    }

    public WClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public WClient init(){
        try {
            this.tTransport= new TFramedTransport(new TSocket(this.host, this.port));
            this.tProtocol = new TBinaryProtocol(this.tTransport);
            this.tClient = new WoodpeckerService.Client(this.tProtocol);

            this.tTransport.open();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

        return this;
    }

    public void invoke() throws TException{
        long result = this.tClient.registerAgent();

        logger.info("result!: " + result);
    }

    public void close(){
        this.tTransport.close();
    }
}

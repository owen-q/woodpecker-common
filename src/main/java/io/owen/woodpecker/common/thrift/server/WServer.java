package io.owen.woodpecker.common.thrift.server;

import io.owen.woodpecker.common.thrift.WServiceImpl;
import io.owen.woodpecker.common.thrift.WoodpeckerService;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by owen_q on 2018. 12. 2..
 */
public class WServer {
    private Logger logger = LoggerFactory.getLogger(WServer.class);
    private final int port;

    private boolean isInitialized = false;
    private TNonblockingServerTransport serverTransport;
    private WoodpeckerService.Processor processor;
    private TServer tServer;

    private WServer() {
        this.port = 10000;
    }

    public WServer(int port) {
        this.port = port;
    }

    public WServer init(){
        try{
            this.serverTransport = new TNonblockingServerSocket(this.port);
            this.processor = new WoodpeckerService.Processor<>(new WServiceImpl());
            this.tServer = new TNonblockingServer(new TNonblockingServer.Args(this.serverTransport).processor(this.processor));

            if(logger.isDebugEnabled())
                logger.debug("Thrift server is on port " + this.port);

            this.isInitialized = true;
        }
        catch (TTransportException e){
            e.printStackTrace();
        }

        return this;
    }

    public void start() throws Exception{
        if(!this.isInitialized)
            throw new Exception("WServer must be initialized before start!");

        this.tServer.serve();
    }
}

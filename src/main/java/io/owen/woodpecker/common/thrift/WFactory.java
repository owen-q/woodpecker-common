package io.owen.woodpecker.common.thrift;

import io.owen.woodpecker.common.thrift.server.WServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by owen_q on 2018. 12. 2..
 */
public class WFactory {
    private Logger logger = LoggerFactory.getLogger(WFactory.class);


    // TODO(owen.q): blocking, nonblocking factory 메소드 제공
    public static WServer createBlockingServer(){
      return null;
    }
}

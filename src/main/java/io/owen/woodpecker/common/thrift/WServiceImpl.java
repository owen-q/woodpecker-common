package io.owen.woodpecker.common.thrift;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by owen_q on 2018. 12. 2..
 */
public class WServiceImpl implements WoodpeckerService.Iface {
    private Logger logger = LoggerFactory.getLogger(WServiceImpl.class);

    @Override
    public long registerAgent() throws TException {
        logger.info("registerAgent");
        return 0;
    }

    @Override
    public void start() throws TException {

    }
}

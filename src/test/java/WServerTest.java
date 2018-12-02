import io.owen.woodpecker.common.thrift.server.WServer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by owen_q on 2018. 12. 2..
 */


public class WServerTest {
    private Logger logger = LoggerFactory.getLogger(WServerTest.class);
    
    
    @Test
    public void createServer() {
        // Given:
        int givenListenPort = 10001;

        // When:
        try{
            WServer server = new WServer(givenListenPort);

            server.init().start();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Then:   
    }
}

import io.owen.woodpecker.common.thrift.client.WClient;
import org.apache.thrift.TException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by owen_q on 2018. 12. 2..
 */
public class WClientTest {
    private Logger logger = LoggerFactory.getLogger(WClientTest.class);

    @Test
    public void testInvokeRPC() {
        // Given:
        String givenHost = "localhost";
        int givenPort = 10001;


        // When:
        WClient wClient = new WClient(givenHost, givenPort);
        wClient.init();

        try{
            wClient.invoke();
        }
        catch (TException te){
            te.printStackTrace();
        }
        // Then:
    }
}

import org.junit.Test;
import org.junit.Assert;

public class practice3Test {
    practice3 ticket1 = new practice3();

    @Test
    public void testTicket() {

        Assert.assertEquals(10, ticket1.GreenTicket(5,5,3) );
        Assert.assertEquals(20, ticket1.GreenTicket(5,5,5));
        Assert.assertEquals(0, ticket1.GreenTicket(5,4,3));
    }
}

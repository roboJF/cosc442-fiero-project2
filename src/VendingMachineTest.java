import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    private VendingMachine machine;
    private VendingMachineItem coke;

    @BeforeEach
    void setUp(){
        machine = new VendingMachine();
        coke = new VendingMachineItem("Coke", 1.49);
    }

    @Test
    void testConstructorNoBalance(){
        double balance = machine.getBalance();
        assertEquals(0.0, balance, 0.0001);
    }
}

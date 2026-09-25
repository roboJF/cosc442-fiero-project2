import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void testConstructorEmptySlots(){
        assertNull(machine.getItem("A"));
        assertNull(machine.getItem("B"));
        assertNull(machine.getItem("C"));
        assertNull(machine.getItem("D"));
    }

    @Test
    void testAddItem(){
        machine.addItem(coke, "A");

        assertSame(coke, machine.getItem("A"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"E", "a", "", "2", "BB", " "})
    void testAddItemInvalidCode(String code){
        assertThrows(VendingMachineException.class, () -> machine.addItem(coke, code));
    }

    @Test
    void testAddItemOccupied() {
        VendingMachineItem pepsi = new VendingMachineItem("Pepsi", 1.48);
        machine.addItem(coke, "B");

        assertThrows(VendingMachineException.class, () -> machine.addItem(pepsi, "B"));
        //this is to make sure that the item in the slot isnt replaced for whatever reason
        assertSame(coke, machine.getItem("B"));
    }

    @Test
    void testGetItem(){
        machine.addItem(coke, "A");
        VendingMachineItem r = machine.getItem("A");
        assertSame(coke, r);
    }

    @Test
    void testGetItemEmpty(){
        VendingMachineItem r = machine.getItem("D");
        assertNull(r);
    }

    @Test
    void testGetItemInvalidCode(){
        assertThrows(VendingMachineException.class, () -> machine.getItem("c"));
    }

    @Test
    void testRemoveItem() {
        machine.addItem(coke, "A");
        VendingMachineItem remove = machine.removeItem("A");

        assertSame(coke, remove);
        assertNull(machine.getItem("A"));
    }

    @Test
    void testRemoveItemEmpty(){
        assertThrows(VendingMachineException.class, () -> machine.removeItem("A"));
    }

    @Test
    void testRemoveItemInvalidCode(){
        assertThrows(VendingMachineException.class, () -> machine.removeItem("F"));
    }
}

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class VendingMachineTest {

    VendingMachine machine;

    @BeforeEach  //arrange
    void setUp(){
        machine = new VendingMachine();
    }

    @AfterEach 
    void tearDown(){
        machine = null;
    }
//ADD ITEM TESTS
    @Test
    void testAddItem() {
        //arrange: creating an item to add to the machine
        VendingMachineItem item = new VendingMachineItem("Chips",1.00);
        //act: adding the item to slot A
        machine.addItem(item, "A");
        //assert:checkong that slot A now contains the item that was added
        assertEquals(item, machine.getItem("A"));
    }

    @Test 
    void testAddItemInvalidCode(){
        //arrange
        VendingMachineItem item = new VendingMachineItem("Chips", 1.00);

        //act+assert: adding an item to invalid slot E should throw exception
        assertThrows(VendingMachineException.class, ()-> machine.addItem(item,"E"));
    }


    @Test 
    void testAddItemOccupiedSlot(){
        //arrange: creating 2 items 
        VendingMachineItem item1 = new VendingMachineItem("Chips",1.00);
        VendingMachineItem item2 = new VendingMachineItem("Soda",1.25);
        machine.addItem(item1, "A"); //adding the chips to slot A

        //act+assert: adding item2 to slot A that is occupied (should throw exception)
        assertThrows(VendingMachineException.class, ()-> machine.addItem(item2,"A"));
    }

//GET BALANCE TESTS
    @Test
    void testGetBalance() {

    }

    @Test
    void testGetBalanceAfterInsert() {

    }

//GET ITEM TESTS
    @Test
    void testGetItem() {

    }

    @Test 
    void testGetItemInvalidCode(){

    }

//INSERT MONEY TESTS
    @Test
    void testInsertMoney() {

    }

    @Test
    void testInsertMoneyNegative() {

    }
//MAKE PURCHASE TESTS
    @Test
    void testMakePurchase() {

    }

     @Test
    void testMakePurchaseNotEnoughMoney() {

    }

     @Test
    void testMakePurchaseEmptySlot() {

    }

//REMOVE ITEM TESTS
    @Test
    void testRemoveItem() {

    }

    @Test 
    void testRemoveItemEmptySlot(){

    }

    @Test 
    void testRemoveItemInvalidCode(){

    }

//RETURN CHANGE TESTS
    @Test
    void testReturnChange() {

    }

    @Test
    void testReturnChangeZeroBalance() {

    }
}

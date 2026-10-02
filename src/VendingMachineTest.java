import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class VendingMachineTest {

    VendingMachine machine;
    VendingMachineItem item;

    @BeforeEach  //arrange
    void setUp(){
        machine = new VendingMachine();
        item = new VendingMachineItem("Chips", 1.00);
    }

    @AfterEach 
    void tearDown(){
        machine = null;
        item=null;
    }
//ADD ITEM TESTS
    @Test
    void testAddItem() {
        //act: adding the item to slot A
        machine.addItem(item, "A");
        //assert:checkong that slot A now contains the item that was added
        assertEquals(item, machine.getItem("A"));
    }

    @Test 
    void testAddItemInvalidCode(){

        //act+assert: adding an item to invalid slot E should throw exception
        assertThrows(VendingMachineException.class, ()-> machine.addItem(item,"E"));
    }


    @Test 
    void testAddItemOccupiedSlot(){
        //arrange: creating second item
        VendingMachineItem item2 = new VendingMachineItem("Soda",1.25);
        machine.addItem(item, "A"); //adding the chips to slot A

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
        //arrange: adding item to slot A
        machine.addItem(item,"A");

        //Act+Assert: getting the item from slot A and checking that the same item was given
        assertEquals(item,machine.getItem("A"));
    }

    @Test 
    void testGetItemInvalidCode(){

          //act+assert: getting an item from invalid slot E should throw exception
        assertThrows(VendingMachineException.class, ()-> machine.getItem("E"));
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
        //arrange
        machine.addItem(item,"A");
        //act+assert: remove item from slot A and check it was the correct item
        assertEquals(item,machine.removeItem("A"));
    }

    @Test 
    void testRemoveItemEmptySlot(){
          //act+assert: removing an item from empty slot D should throw exception
        assertThrows(VendingMachineException.class, ()-> machine.removeItem("D"));
    }

    @Test 
    void testRemoveItemInvalidCode(){
          //act+assert: removing an item from invalid slot E should throw exception
        assertThrows(VendingMachineException.class, ()-> machine.removeItem("E"));
    }

//RETURN CHANGE TESTS
    @Test
    void testReturnChange() {

    }

    @Test
    void testReturnChangeZeroBalance() {

    }
}

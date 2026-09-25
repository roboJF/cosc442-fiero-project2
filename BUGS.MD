1. There was an off-by-one issue in the loop in the constructor for VendingMachine, the testConstructorNoBalance() test case found it.
The fault in the code was that the loop originally incremented as for (int i = 0; i <= NUM_SLOTS; i++)
Due to how indexing in the VendingMachine class is handeled, it should've been i < NUM_SLOTS instead, which was the change made, and resolved the issue entirely

2. There was a fault in insertMoney() where the minimum amount was set to amount < 1, when it was supposed to be amount < 0
What caused me to diagnose the fault was an exception being called for testInsertMoneyMultiple(), despite none of the values in it being negative, but one of the values was 0.23, which was below 1
The change made to fix this was changing amount < 1 to amount < 0, which fully resolved the issue
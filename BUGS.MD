1. There was an off-by-one issue in the loop in the constructor for VendingMachine, the testConstructorNoBalance() test case found it.
The fault in the code was that the loop originally incremented as for (int i = 0; i <= NUM_SLOTS; i++)
Due to how indexing in the VendingMachine class is handeled, it should've been i < NUM_SLOTS instead, which was the change made, and resolved the issue entirely


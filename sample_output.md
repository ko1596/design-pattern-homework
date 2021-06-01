# This is an example about how the program work.

## Run program(Main.java):

```
$ mvn exec:java -Dexec.mainClass="org.ntutssl.shop.Main"
...
// after replenishing the shop
================================================================================
ID  name                  description                             price   count 
--------------------------------------------------------------------------------
1   apple                 good apple                              0.49    100   
2   banana bag            a bag of banana                         0.29    30    
3   cat                   cute cat                                0.49    50    
4   dog                   a bag of Chihuahuas                     0.0     123   
5   egg                   cheap!                                  0.05    500   
6   fruit                 cdesc                                   6.48    300   
7   pencil                cheap pencil                            0.29    1000  
8   eraser                cheap eraser                            0.25    400   
9   pen                   cheat pen                               0.49    400   
10  stationery pack       stationery pack                         1.03    50    
11  MSI laptop            superb RGB light up your world          700.0   30    
12  MacBook Pro           Small chip. Giant leap.                 1299.0  10    
13  laptop pack           laptop pack                             799.98  5     
================================================================================
// after adding all available goods in to the shopping cart
================================================================================
ID  name                  description                             price   count 
--------------------------------------------------------------------------------
1   apple                 good apple                              0.49    3     
2   banana bag            a bag of banana                         0.29    1     
3   cat                   cute cat                                0.49    2     
4   dog                   a bag of Chihuahuas                     0.0     2     
5   egg                   cheap!                                  0.05    4     
6   fruit                 cdesc                                   6.48    1
================================================================================
// after paying for the goods in the shopping cart
================================================================================
Receipt:
name                                    price     count
apple                                   $0.49     3
banana bag                              $0.29     1
cat                                     $0.49     2
dog                                     $0.0      2
egg                                     $0.05     4
fruit                                   $6.48     1
--------------------------------------------------------------------------------
Total Price: $9.42
================================================================================
// check the stock of the shop
================================================================================
ID  name                  description                             price   count
--------------------------------------------------------------------------------
1   apple                 good apple                              0.49    97    
2   banana bag            a bag of banana                         0.29    29
3   cat                   cute cat                                0.49    48
4   dog                   a bag of Chihuahuas                     0.0     121
5   egg                   cheap!                                  0.05    496
6   fruit                 cdesc                                   6.48    299
7   pencil                cheap pencil                            0.29    1000
8   eraser                cheap eraser                            0.25    400
9   pen                   cheat pen                               0.49    400
10  stationery pack       stationery pack                         1.03    50
11  MSI laptop            superb RGB light up your world          700.0   30
12  MacBook Pro           Small chip. Giant leap.                 1299.0  10
13  laptop pack           laptop pack                             799.98  5
================================================================================
Your shopping cart is empty.
```
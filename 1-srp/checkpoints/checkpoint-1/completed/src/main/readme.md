### Build script

mvn compile

### Run tests command

mvn test

### Startup script

cd ~/workspace
mvn clean install -Dmaven.test.skip

### Tasks

In this checkpoint you will look at some code and refactor it for SRP. Let's take a look at the ```Product``` class. 
Now, take a deeper look at the ```getPrice``` getter. Although it's name suggests that it is a getter for the ```price``` 
property, it's body tells a different story. This getter also performs discounts on the original price in two situations:
- when the price is greater than $1000.00
- when it is Christmas Eve

The two ```if``` statements are also a clue that this getter is doing more than it should do. If a discount rule changes in the future,
then the getter will also change. This is a violation of the SRP.

>✔️  There are many ways to refactor this code, but in this checkpoint, simply create a new method to handle the price discounts and
> leave the price getter to return its backing field only

###### Open Product class and create a new method

Go to ```src/main/java/Product.java```
Create a new method called ```getDiscountPrice``` which should return a double;

> Validation ```mvn test -Dtest=ClassTests#getDiscountPriceMethodExists```


###### Move discount code to new method

Move all the discount logic to the ```getDiscountPrice``` method and delete that code from the ```getPrice``` getter. At this point,
the getter should only return the ```price``` field and all the discount logic should be in the new method.

> Validation ```mvn test```


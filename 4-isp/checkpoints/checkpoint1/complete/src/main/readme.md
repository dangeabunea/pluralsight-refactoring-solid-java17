### Build script

mvn compile

### Run tests command

mvn test

### Startup script

cd ~/workspace
mvn clean install -Dmaven.test.skip

### Tasks

In this checkpoint, you will see an interface that violates the ISP, and then you will refactor the code to
respect this principle.

Take a look at the ```PaymentService``` interface. It has three methods that manages online payments

Then, take a look at the ```OnlineStorePaymentService``` class. If you take a close look at the ```payUsingPayPal``` method,
you will notice that the method throws an exception. 

> ✔️ This is a clear indication that maybe the interface is too fat.  Let's go ahead and make the interface lean.

###### Refactor PaymentService interface

Go to ```src/main/java/PaymentService.java``` and delete the ```payUsingPayPal()``` method.
We will move it to a new interface later.

> Validation ```mvn test -Dtest=PaymentServiceTests#payUsingPayPalNotExists```

###### Refactor OnlineStorePaymentService class

Open the ```OnlineStorePaymentService``` and remove the method that throws the exception: ```payUsingPayPal```

> Validation ```mvn test -Dtest=PaymentServiceTests```

###### Create new interface for Pay Pal payments

Create a new interface called ```PayPalPaymentService.java``` and add the following method to it ```payUsingPayPal```. It is the method we removed
from the original interface during the refactoring process.

```
public interface PayPalPaymentService {
    void payUsingPayPal(double amount, String accountName);
}
```

> Validation ```mvn test```


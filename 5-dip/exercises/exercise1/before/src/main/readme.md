### Build script

mvn compile

### Run tests command

mvn test

### Startup script

cd ~/workspace
mvn clean install -Dmaven.test.skip

### Tasks

In this exercise, you will refactor a high level component (MoneyTransferService) that depends on a low level
component (ConsoleMoneyTransferAuditor).

Open ```MoneyTransferService.java```. You will see that this class depends on the ```ConsoleMoneyTransferAuditor.java```.
The dependency is declared inside the ```transfer``` method.

```
// Dependency on low level component
ConsoleMoneyTransferAuditor auditor = new ConsoleMoneyTransferAuditor();
```

> ⚠️ This is a poor implementation. The high level component depends directly on a low level component. To make matters
> worse, that concrete low-level class is not even declared in the constructor. There is no way to test the ```trasnfer```
> method and to mock the ```ConsoleMoneyTransferAuditor``` class. Any change to the ```ConsoleMoneyTransferAuditor```
> has the potential to break the ```MoneyTransferService```.

###### Extract interface for the auditor class

Right now, we are using an auditor class that writes money transfer audit messages to the console. In a real banking 
system there can be many auditors, some for internal use, other for external verification. So, it is a great idea to
extract the auditor capabilities in an abstraction (interface).

Create a new interface called ```MoneyTransferAuditor.java```.

```
public interface MoneyTransferAuditor{
    
}
```

> Validation ```mvn test -Dtest=FileTests#auditorInterfaceShouldExist```

###### Add methods to interface

Open the ```MoneyTransferAuditor.java``` interface and add the two methods we are currently using: 
```logTransfer(BankAccount from, BankAccount to, double amount)``` and ```void logInsufficientFunds(BankAccount from, double amount)```.
Since this is an interface, we are just adding the method signatures. The code should look like this:

```java
public interface MoneyTransferAuditor {
    void logTransfer(BankAccount from, BankAccount to, double amount);
    void logInsufficientFunds(BankAccount from, double amount);
}

```

> Validation ```mvn test -Dtest=FileTests#auditorInterfaceHasTwoMethods```

###### Make low-level class implement interface

Open ```ConsoleMoneyTransferAuditor.java``` and make it implement the ```MoneyTransferAuditor``` interface. 

> Validation REGEX ```implements MoneyTransferAuditor```

###### Declare auditor abstraction as a field in the high level component

Open ```MoneyTransferService.java``` and create a new private field called ```auditor``` of type ```MoneyTransferAuditor```;

```
private MoneyTransferAuditor auditor;
```

> Validation ```mvn test -Dtest=FileTests#moneyTransferServiceShouldHaveAuditorField```

###### Instantiate low-level dependency from the constructor

Open ```MoneyTransferService.java``` and create a new constructor. The constructor will receive a single parameter
in order to instantiate the ```auditor``` field. 

```
public MoneyTransferService(MoneyTransferAuditor auditor) {
    this.auditor = auditor;
}
```

> Validation ```mvn test -Dtest=FileTests#moneyTransferServiceShouldDeclareDepInConstructor```

###### Replace concrete low-level dependency with the abstraction

Open ```MoneyTransferService.java```. You can now modify the ```trasnfer``` method and remove the line of code where the
auditor gets instantiated. 

```
ConsoleMoneyTransferAuditor auditor = new ConsoleMoneyTransferAuditor();
```

The transfer service will now use the auditor abstraction defined as a class field. The coupling
between the low-level and high-level components has been removed. On top of that, you can now mock the ```auditor```
dependency and write unit tests for the ```MoneyTransferService```.

> Validation ```mvn test```
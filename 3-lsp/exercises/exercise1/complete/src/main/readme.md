### Build script

mvn compile

### Run tests command

mvn test

### Startup script

cd ~/workspace
mvn clean install -Dmaven.test.skip

### Run Script

mvn install  exec:java -Dexec.mainClass=Main -Dmaven.test.skip

### Context

In this exercise, you will look at a violation of the Liskov Substitution Principle.
You are going to refactor a system that calculates employee time off. In this system:
```Employee``` is a base class, common to all employee types
```FullTimeEmployee``` extends ```Employee``` and represents a standard 40 hour a week employee
```Contractor``` also extends ```Employee``` is used to model professionals that are project based. They do not have
time off, since they are not hired by the company and thus, do not have all the benefits. 

Take a look at the ```calculateRemainingTimeOff``` method. For a full
time employee, it has a correct implementation. But for a contractor it returns 0, since contractors have no time off.

The ```TimeOffCalculator``` class is responsible for calculating the average remaining time off per employee. This is
useful for HR and Management. Take a close look at the implementation of the ```calculateAvgRemainingTimeOffPerEmployee```
method. At first glance you would say that it looks ok, but does it return a correct result? 

Example:

Full time employee 1 has 10 days of time off left.
Full time employee 2 has 20 days left.
A contractor has 0.
When we compute the average remaining time off, the result will be 10 ((20+10+0) / 3). 

> ⚠️️ This is not correct. Because contractors have no days off, they should not be part of the statistic. The fact that
> they can be, will cause this calculator to yield incorrect results. In fact, if we take only people who are eligible for
> time off, then the average remaining time off per employee is 15 (20 + 10 / 2)


> ✔️ It turns out that a Contractor can not fully substitute an Employee while keeping the correctness of the program.
> Let's go ahead and refactor this code for LSP

###### Refactor Main class

Go to ```src/main/java/Main.java```
The first thing we can do is acknowledge that contractrs are not employees, so we have to remove them from the list of 
employees that gets passed to the ```calculateAvgRemainingTimeOffPerEmployee``` method. Remove this line of code 
```var contractorDude = new ExternalContractor("Contractor Dude", 30, LocalDate.now().plusYears(1));``` and then
remove the ```contractorDude``` from the list.

> Validation REGEX ```List<Employee> employees = List.of(annaSmith, johnDoe, contractorDude)```

###### Fix inheritance

Open the ```ExternalContractor.java``` class and remove the inheritance relationship. This class should no longer
extend ```Employee```. 

> Validation REGEX ```extends Employee```

###### Remove call to the base class constructor

Since this class does not extend ```Employee```, we can not call it's base constructor. So, remove this line of code
```super(name, age);```

> Validation REGEX ```super(name, age)```

###### Add name and age fields and getters

Because we do not extend ```Employee```, you need to add the name and age fields and initialize them from the
constructor. Add a String field called ```name``` and one integer field called ```age```. Then, initialize them using
the constructor arguments.

```
    private LocalDate contractExpirationDate;
    private String name;
    private int age;

    public ExternalContractor(String name, int age, LocalDate contractExpirationDate) {
        this.contractExpirationDate = contractExpirationDate;
        this.name = name;
        this.age = age;
    }
```
> Validation ```mvn test -Dtest=ExternalContractorTests#shouldHaveNameAndAgeFields```

###### Remove unnecessary method

While at it, make sure to remove the ```calculateRemainingTimeOff``` method from this class
because it is not needed. A contractor has no time off, so this method is incorrect.

> Validation ```mvn test```

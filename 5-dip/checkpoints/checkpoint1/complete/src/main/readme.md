### Build script

mvn compile

### Run tests command

mvn test

### Startup script

cd ~/workspace
mvn clean install -Dmaven.test.skip

### Tasks

In this checkpoint, you will refactor a high level component (EmployeeIncomeCalculator) that depends on a low level
component (EmployeeRestApiService). 

Open ```EmployeeIncomeCalculator.java```. You will see that this class depends on the ```EmployeeRestApiService.java```.
The dependency is declared in the constructor, which is a good practice. But instead of using abstractions, a concrete class
is passed as a parameter.


> ✔️ Although this is not the worst implementation, it is still not a good practice because there is coupling between a
> business logic class and an infrastructure class. Let's go ahead and apply the DIP.

###### Extract interface for the employee API service

Create a new interface called ```EmployeeApi.java```. This interface will become our abstraction. 

> Validation ```mvn test -Dtest=FileTests```

###### Add method to interface

Open the ```EmployeeApiService.java``` interface and add the ```List<Employee> findAll()``` method. 

> Validation REGEX ```findAll()```

###### Make low level class implement interface

Open ```EmployeeRestApi.java``` and make it implement the ```EmployeeApi``` interface. Don't forget about the
imports: ```import java.util.List;```

> Validation REGEX ```implements EmployeeApi```

###### Make high level class depend on an abstraction

Open ```EmployeeIncomeCalculator.java``` and change the type of its dependency. The ```employeeApiService``` field can now
use the interface type ```EmployeeApi`` instead of a concrete class type. Make sure to change that in the constructor as 
well. The parameter needs to be of type ```EmployeeApi```

> Validation REGEX ```EmployeeApi```
> Validation ```mvn test```

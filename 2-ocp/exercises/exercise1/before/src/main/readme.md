### Build script

mvn compile

### Run tests command

mvn test

### Startup script

cd ~/workspace
mvn clean install -Dmaven.test.skip

### Tasks

In this checkpoint you will look at a violation of the OCP. Let's start by opening the ```TaxCalculator.java``` class.
This class is responsible for computing the taxes for all the employees of a company. The taxes increase with the
income of an employee
- If the employee earns less than $10000, the taxes are 10%
- If the employee earns between $10000 - $50000, the taxes are 25%
- Else, the taxes are 35%

As a developer, you need to implement a new business rule. For some reporting situations, you also need to take into account
the nationality of the employee. If the employee is not a US citizen, another 10% need to be withdrawn from their
income. Eventually, this will be the standard way to do taxes.

> ⚠️ One approach could be to modify the ```calculateTotalTaxes``` and add the nationality into consideration
> 
```
 double calculateTotalTaxes(List<Employee> employees) {
        var taxes = 0.0;
        for (var e : employees) {
            var tax =  calculateTaxForEmployee(e);
            if(!e.getNationality().equals("USA")){
               tax += e.getIncome() * 0.1;
            }
            taxes += tax;
        }

        return taxes;
}
```
> ⚠️This is not a good ideea, because now everyone who uses this method will be affected. You risk breaking up the correct
> functionality of other systems.
> You could add a boolean flag and apply the nationality tax based in that flag, but then all the clients need to change because
> the signature of the original method has changed.

> ✔️ A better (but probably short term) approach would be to create a new method that takes nationality into consideration
> when calculating taxes and leave the existing one in place. This is the simplest form of applying the OCP in this scenario
> and it eliminates the risks associated with changing code.

###### Create new method for calculating taxes using the nationality field

Go to ```src/main/java/TaxCalculator.java```

Create a new method called ```calculateTotalTaxesWithNationalityDetails()```. The method receives the list of employees as an argument
and returns a double. Inside the body, check the nationality. If it is not "USA", then add another 10% to the employee taxes.

The code should look like this:

```
    public double calculateTotalTaxesWithNationalityDetails(List<Employee> employees){
        var taxes = 0.0;

        for (var e : employees) {
            var tax =  calculateTaxForEmployee(e);

            // take nationality into consideration
            if(!e.getNationality().equals("USA")){
                tax += e.getIncome() * 0.1;
            }

            taxes += tax;
        }

        return taxes;
    }
```

> Validation ```mvn test```

###### Mark the original method as deprecated

If the original method will become obsolete, you must also alert users of this before removing it. The first step
was to create an alternative method, which we did in the previous step. Now, we can add the ```@Deprecated()``` annotation
to the ```calculateTotalTaxes``` method.

> Validation REGEX ```@Deprecated()```
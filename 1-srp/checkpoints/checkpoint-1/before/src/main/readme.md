### Build script

mvn compile

### Run command

mvn -q exec:java

### Startup script

cd ~/workspace

### Tasks

In this exercise you will look at some code and refactor it for SRP. The focus of this checkpoint is the Constants 
class which contains all the constants in the application. The constants defined here
are used by the ```PasswordChecker``` and ```UnitConverter``` classes. This
indication alone tells us that maybe the general constants class is doing more
than it should. 

>✔️  Instead of a potential god class, a better approach would be to have dedicated
classes for storing constants, based on their responsibility. 

###### Open Constants class.

Go to ```src/main/java/Constants.java```
Take a minute to look at the code. Can you see why this class breaks the Single Responsibility Principle?


###### Create a new class for conversion constants

Create a new class called ```UnitConversionConstants```

> Validation: ```mvn test -Dtest=FileTest#UnitConversionClassConstantsExists```

###### Move unit conversion constants to specialized class

Add the two unit conversion constants to the ```UnitConversionConstants``` class

> Validation ```mvn test -Dtest=CodeTest#UnitConversionConstantsShouldStaticFields```

###### Create a new class for password related constants

Create a new class called ```PasswordConstants```

> Validation: ```mvn test -Dtest=FileTest#PasswordConstantsClassExists```

###### Move password related constants to specialized class

Add the two password related constants to the ```PasswordConstants``` class

>Validation: ```mvn test -Dtest=CodeTest#PasswordConstantsShouldStaticFields```

###### Delete Constants class

At this point, we no longer need the ```Constants``` class, so we can remove it. After you remove it,
you will likely get some compilation errors. Let's go ahead and fix those

> Validation ```mvn test -Dtest=FileTest#ConstantsClassWasRemoved```

###### Refactor code in dependent classes

Instead of using the ```Constants``` class that we just deleted, you need to reference ```UnitConversionConstants```
and ```PasswordConstants``` in order to access the public static fields. 

> Validation ```mvn test```


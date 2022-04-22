### Build script

mvn compile

### Run tests command

mvn test

### Startup script

cd ~/workspace
mvn clean install -Dmaven.test.skip

### Tasks

In this checkpoint, you will look at a violation of the "Tell, Don't Ask" principle.
This example models the building blocks of a task management system.
```Task``` is the base class
```Feature``` extends Task and is concerned with new development activities
```Bug``` also extends Task and is concerned with handling issues raised by clients

Take a look at the ```TaskManager``` class. It has a method that should close all the tasks. However,
a bug can only be closed if it is verified by the customer. To accomadate this use case, typechecking
and casting have been used.

```
if (task instanceof Bug) {
    if (((Bug) task).isVerifiedByCustomer()) {
        task.close();
    }
}
```

This breaks the "Tell, Don't Ask" principle and the LSP because it appears that the type ```Bug``` can not fully
substitute the type "Task".

> ✔️ This is a happy scenario. Actually, we can fix the LSP by removing the type checking. In this checkpoint you are
> going to apply the "Tell, Dont' Ask" principle to
> refactor the code.

###### Refactor Bug class

Go to ```src/main/java/Bug.java```
Override the ```close``` method and implement the customer verification logic inside it.

The code should look like this:

```
@Override
    public void close() {
        if(isVerifiedByCustomer()) {
            super.close();
        }
    }
```

> Validation ```mvn test -Dtest=BugTests#containsOverrideCloseMethod```

###### Remove type checking and casting from the TestManager class

Open the ```TaskManager``` class and modify the ```closeAll``` method to simply call ```close``` on all tasks;
You will get rid of the type checking and casting;

```
for (var task : tasks) {
    task.close();
}
```

> Validation REGEX ```task instanceof Bug```
> Validation REGEX ```\(\(Bug\).*?task\).isVerifiedByCustomer\(\)```
> Validation ```mvn test```


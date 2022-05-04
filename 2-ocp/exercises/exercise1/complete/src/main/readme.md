### Build script

mvn compile

### Run tests command

mvn test

### Startup script

cd ~/workspace
mvn clean install -Dmaven.test.skip

### Tasks

In this exercise you will refactor code that violates the Open-Closed Principle. Let's start by looking at the 
```PointInsideAreasCalculator.java``` class. This class contains a method called ```isPointInsideAreas``` which is
used to determine if a coordinate is withing a collection of geometric shapes.

The logic for determining this depends on the shape type. So, we iterate over each shape, cast it to its concrete type
and then perform the logic of checking if a point is within the area of that shape. 

> ⚠️ This code breaks the Open-Closed Principle, as well as the Single Responsibility Principle. For each new shape
> that will appear in the future you also need to modify the ```isPointInsideAreas``` method. So, this approach is not
> scalable at all.

> ✔️ A better solution is to define the logic for determining if a point is within a shape are to the concrete shape 
> types. Using this approach, the ```isPointInsideAreas``` will never change, regardless of how many shape types will
> exist in the future. Let's go and refactor this code.

###### Create new method for calculating if a point is within an area

##### 1. Go to ```src/main/java/Shape.java``` and add a new abstract method called ```isPointInsideArea(int x, int y)```

```
public abstract class Shape {
    public abstract boolean isPointInsideArea(int x, int y);
}
```

Because ```Shape``` is extended by all shape types and the method that we just created is abstract, we also need to provide implementations
in the ```Circle``` and ```Rectangle``` classes;

##### 2. Go to ```src/main/java/Cirle.java``` and add implement the ```isPointInsideArea``` method. We will return false
for now. We just need to get the compilation to work, and we will come back for the implementation later;

```
    @Override
    public boolean isPointInsideArea(int x, int y) {
        return false;
    }
```

##### 3. Go to ```src/main/java/Rectangle.java``` and add implement the ```isPointInsideArea``` method. We will return false
for now. We just need to get the compilation to work, and we will come back for the implementation later;

```
    @Override
    public boolean isPointInsideArea(int x, int y) {
        return false;
    }
```

> Validation ```mvn test -Dtest=FileTests#allShapesShouldHaveIsPointInsideMethod```

###### Implement logic for determining if a coordinate is within a circle

Go to ```src/main/java/Cirle.java``` and add implement the ```isPointInsideArea``` method. You can use the implementation
from the ```PointInsideAreasCalculator.java``` as a reference. The final code should look like this:

```
    @Override
    public boolean isPointInsideArea(int x, int y) {
        var distToOrigin = Math.sqrt(
                (getyOrigin() - y) * (getyOrigin() - y) +
                        (getxOrigin() - x) * (getxOrigin() - x)
        );
        return distToOrigin <= getRadius();
    }
```

###### Implement logic for determining if a coordinate is within a rectangle

Go to ```src/main/java/Rectangle.java``` and add implement the ```isPointInsideArea``` method. You can use the implementation
from the ```PointInsideAreasCalculator.java``` as a reference. The final code should look like this:

```
    @Override
    public boolean isPointInsideArea(int x, int y) {
        return x <= getMaxX() &&
                x >= getMinX() &&
                y >= getMinY() &&
                y <= getMaxY();
    }
```

###### Refactor ```PointInsideAreaCalculator``` and make it respect the OCP

You can now remove the logic for determining if a point is within a particular area from this method and call
the methods on the shape classes to determine the result. Iterate over each shape and call the ```isPointInsideArea```
method. The code should be similar to this:

```
    public boolean isPointInsideAreas(int x, int y, List<Shape> shapes) {
        for (var s : shapes) {
            if(s.isPointInsideArea(x, y)){
                return true;
            }
        }
        return false;
    }
```

No matter how many shape types will appear in the future, you will not need to modify the calculator class. This program
is now scalable thanks to the correct application of the OCP.

> Validation REGEX ```mvn test```
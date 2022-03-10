import java.util.ArrayList;
import java.util.List;

public record ValidationResult(List<String> errors){
    public ValidationResult(){
        this(new ArrayList<>());
    }

    public boolean isValid(){
        return errors.size() == 0;
    }
}

import java.util.function.*;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.TextFormatter;
import java.util.regex.Pattern;

/* Used with a text field to make sure it accepts only integers
 */
public class IntegerFilter implements UnaryOperator<TextFormatter.Change> {
    private final static Pattern DIGIT_PATTERN = Pattern.compile("\\d*");

    @Override
    public Change apply(TextFormatter.Change aT) {
        return DIGIT_PATTERN.matcher(aT.getText()).matches() ? aT : null;
    }
}
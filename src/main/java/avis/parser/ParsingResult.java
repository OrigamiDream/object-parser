package avis.parser;

public class ParsingResult {

    Object value;
    boolean error = true;
    Class<? extends ReturnTypeParser> redirectTo;

    Object[] conditions = new Object[0];

    ParsingResult() {
    }

}

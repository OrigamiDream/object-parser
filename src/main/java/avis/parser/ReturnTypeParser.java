package avis.parser;

public interface ReturnTypeParser<T> {

    static <T> T parseTo(Class<T> parseTo, Object inputValue, Object... conditions) {
        ParsingResult result = new ParsingResult();
        result.conditions = conditions;

        boolean start = false;
        Class<? extends ReturnTypeParser> redirectTo = null;
        for(ReturnTypeParser parser : ParserRegistry.PARSERS) {
            if(redirectTo != null && redirectTo != parser.getClass()) {
                continue;
            }
            if(redirectTo != null) {
                result.redirectTo = null;
                redirectTo = null;
            }
            for(Class type : parser.toTypes()) {
                if(parseTo == type) {
                    start = true;
                    break;
                }
            }

            if(start) {
                result = parser.parse(parseTo, result, inputValue);
            }
            if(result.error) {
                if(result.redirectTo != null) {
                    redirectTo = result.redirectTo;
                }
            } else {
                break;
            }
        }
        if(!start) {
            result.value = inputValue;
        }
        return (T) result.value;
    }

    default Class<T> toType() {
        return null;
    }

    default Class[] toTypes() {
        return new Class[] { toType() };
    }

    default ParsingResult parse(ParsingResult result, Object value) {
        return null;
    }

    default ParsingResult parse(Class parseTo, ParsingResult result, Object value) {
        return parse(result, value);
    }

}

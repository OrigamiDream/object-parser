package avis.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserRegistry {

    /**
     * Sequence-sensitive parsers
     */
    static final List<ReturnTypeParser> PARSERS = new ArrayList<>();
    static {
        initialize(new DetailedDateParser(),
                   new DateParser(){},
                   new BigIntegerParser(),
                   new BigDecimalParser(),
                   new BooleanParser(),
                   new IntegerParser(),
                   new LongParser(),
                   new FloatParser(),
                   new DoubleParser(),
                   new StringParser());
    }

    public static void initialize(ReturnTypeParser... parsers) {
        PARSERS.clear();
        PARSERS.addAll(new ArrayList<>(Arrays.asList(parsers)));
    }

}

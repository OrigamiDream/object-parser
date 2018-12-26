package avis.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface DateParser extends ReturnTypeParser<Date> {

    @Override
    default Class<Date> toType() {
        return Date.class;
    }

    default String defaultPattern() {
        return "yyyy-MM-dd";
    }

    /**
     *
     * Date date = ReturnTypeParser.parseTo(Date.class, "2018-12-25", "yyyy-MM-dd")
     *
     * @param result
     * @param value
     * @return
     */
    @Override
    default ParsingResult parse(ParsingResult result, Object value) {
        if(value == null) {
            result.value = null;
            result.error = false;
            return result;
        }
        if(value instanceof Date) {
            result.value = value;
            result.error = false;
        } else {
            String pattern;
            if(result.conditions == null || result.conditions.length != 1) {
                pattern = "yyyy-MM-dd";
            } else {
                pattern = ReturnTypeParser.parseTo(String.class, result.conditions[0]);
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            try {
                result.value = format.parse(ReturnTypeParser.parseTo(String.class, value));
                result.error = false;
            } catch (ParseException e) {
                result.value = null;
                result.error = true;
            }
        }
        return result;
    }
}

package avis.parser.test;

import avis.parser.ReturnTypeParser;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ParsingTest {

    @Test
    public void parse() {
        assertEquals(new BigInteger("100"), ReturnTypeParser.parseTo(BigInteger.class, 100));
        assertEquals(new BigInteger("100"), ReturnTypeParser.parseTo(BigInteger.class, "100"));
        assertEquals(new BigDecimal("27.874"), ReturnTypeParser.parseTo(BigDecimal.class, 27.874));
        assertEquals(new BigDecimal("27.874"), ReturnTypeParser.parseTo(BigDecimal.class, "27.874"));
        assertEquals(62.4d, ReturnTypeParser.parseTo(double.class, new BigDecimal("62.4")), 0);
        assertEquals(false, ReturnTypeParser.parseTo(Boolean.class, "false"));
        assertEquals(true, ReturnTypeParser.parseTo(boolean.class, "true"));
        assertEquals((long) 25, (long) ReturnTypeParser.parseTo(Integer.class, 25));
        assertEquals(42L, (long) ReturnTypeParser.parseTo(Long.class, "42"));

        Object helloWorld = "hello world";

        assertEquals("hello world", ReturnTypeParser.parseTo(String.class, helloWorld));

        String pattern = "yyyy/MM/dd";

        SimpleDateFormat format = new SimpleDateFormat(pattern);

        try {
            assertEquals(format.parse("2018/12/25"), ReturnTypeParser.parseTo(Date.class, "2018/12/25", pattern));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

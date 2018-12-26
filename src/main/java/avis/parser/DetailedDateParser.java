package avis.parser;

public class DetailedDateParser implements DateParser {

    @Override
    public String defaultPattern() {
        return "yyyy-MM-dd hh:mm:ss";
    }
}

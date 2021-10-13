package m04strings.samples;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpSample {
    public static void main(String arg[]){
        Pattern addressPattern = Pattern.compile("^([а-яА-Я\\\\.\\d\\s]*)\\s(\\d*)-(\\d*)$");
        checkRegExp(addressPattern, "ул. Конева 10");
        checkRegExp(addressPattern, "ул. Конева 10-104");
    }

    private static void checkRegExp(Pattern pattern, String source) {
        Matcher matcher = pattern.matcher(source);
        System.out.println("Соответствует шаблону = " + matcher.matches());
        matcher.reset();    // перезапустить поиск
        while (matcher.find()) {
            System.out.println(String.format("index=[%d,%d] result=%s",
                    matcher.start(), matcher.end(), matcher.group()));
            for(int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println(String.format("groupIndex=%d group=%s", i, matcher.group(i)));
            }
        }
    }
}

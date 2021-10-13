package m04strings.tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
//исопльзовать regex101
    //инфа есть в презентации
    /**
     *На вход подается строка, необходимо проверить , соот-ет ли строка номеру телефона
     *  * Номер начинается с о знака "+" и имеет 11 цифр ( вид +7(903)-807-0896)
     *  * При выводе на экран возращаем номер по оператору свзяи
     *  * (920) - Мегафон
     *  * (903) - Билайн
     *  * (910) - МТС
     *  * (904) - Теле2
     *  *
     *  * если оператор не определен то выводим фразу : "оператор неизвестен"
     * @param phoneNumber
     * @return
     */
    public String getPhoneOperator(String phoneNumber) {
        Pattern pattern =
                Pattern.compile("\\+7-\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            pattern = Pattern.compile("\\((920|903|910|904)\\)");
            matcher = pattern.matcher(phoneNumber);
            if (matcher.find()) {
                switch (matcher.group()) {
                    case "(920)":
                        return "Megafon";
                    case "(910)":
                        return "MTS";
                    case "(903)":
                        return "Beeline";
                    case "(904)":
                        return "Tele2";
                }
            }else {
                return "Unknown operator";
            }
        }
        throw new IllegalArgumentException();
    }
}

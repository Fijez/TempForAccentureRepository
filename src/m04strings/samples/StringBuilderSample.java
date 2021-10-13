package m04strings.samples;

import java.time.LocalDate;

public class StringBuilderSample {

	public static void main(String arg[]){
		stringBuilderApi();
		testStringBuilderPerformance(20);
	}

	private static void stringBuilderApi() {
		StringBuilder sb = new StringBuilder("Java ");
		sb.append("is ");
		sb.append("the ")
			.append("best ")
		  	.append("language");
		System.out.println(sb.toString());

		sb.append(" in ").append(LocalDate.now().getYear());
		System.out.println(sb);

		sb.replace(0, 4, "C++");
		System.out.println(sb);

		sb.insert(11,"OOP ");
		System.out.println(sb);
	}

	private static void testStringBuilderPerformance(int count) {
		long startTime = System.currentTimeMillis();
		String result1 = concatNumbers(count);
		System.out.println(String.format("Время конкатенации: %dмс", System.currentTimeMillis() - startTime));
		System.out.println("Длина результирующей строки1 = " + result1.length());


		startTime = System.currentTimeMillis();
		String result2 = concatNumbersWithStringBuilder(count);
		System.out.println(String.format("Время конкатенации: %dмс", System.currentTimeMillis() - startTime));
		System.out.println("Длина результирующей строки2 = " + result2.length());

	}


	private static String concatNumbers(int count) {
		String result = "";
		for(int i = 0; i < count; i++) {
			result += i;
		}
		return result;
	}

	private static String concatNumbersWithStringBuilder(int count) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			sb.append(i);
		}
		return sb.toString();
	}
}

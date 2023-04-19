package sk.itlearning.java4.a.abc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

public class DateTime {

	// Date-Time package, java.time, introduced in the Java SE 8 release

	// The Date-Time API uses the calendar system defined in ISO-8601 as the default
	// calendar.

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		System.out.println(today);

		LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
		System.out.println(payday);

		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);

		LocalDateTime today2 = LocalDateTime.now();
		System.out.println(today2);

		LocalDateTime yesterday = today2.minusDays(1);
		System.out.println(yesterday);

		LocalDate dateOfBirth = LocalDate.of(2012, Month.MAY, 14);
		System.out.println(dateOfBirth);

		LocalDate firstBirthday = dateOfBirth.plusYears(1);
		System.out.println(firstBirthday);

		LocalDateTime db = LocalDateTime.now(ZoneId.of("Europe/Bratislava"));
		LocalDateTime dn = LocalDateTime.now(ZoneId.of("America/New_York"));

		System.out.println(db);
		System.out.println(dn);

		System.out.println(today);
		System.out.println(tomorrow);
		System.out.println(yesterday);

		System.out.println(today.format(DateTimeFormatter.ofPattern("E - ('e':e) : d MMMM yyyy", new Locale("sk", "SK"))));

		LocalTime lt = LocalTime.now(ZoneId.of("Europe/Bratislava"));
		System.out.println(lt);

		// Konverzia LocalDate alebo LocalDateTime na Date
		Date d = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

	}

}

package edu.meninocoiso.oop.projects.project3.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Mentoring extends Content {
	private LocalDate date;
	
	public Mentoring(String title, String description, LocalDate date) {
		super(title, description);
		this.date = date;
	}
	
	@Override
	public double calculateXp() {
		return DEFAULT_XP + 20d;
	}
	
	private LocalDate getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		Locale locale = Locale.forLanguageTag("pt");
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(locale);
		
		return "Mentoria:\n".concat(super.toString()).concat("\n| Data: " + getDate().format(formatter));
	}
}

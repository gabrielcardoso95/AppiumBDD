package br.com.rsinet.hub_bdd.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Generator {

	private static final Date date = new Date();

	public static String horas() {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy-HH-mm-ss");
		return dateFormat.format(date);
	}

}
package de.jbollacke.lib.Nachtlager;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sendung {
	private Date datum;
	private String thema;

	protected String formatDate() {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(datum);
	}

	public URL getUrl(boolean lowQuality) throws MalformedURLException {
		String quality = "hq";

		if (lowQuality) {
			quality = "lq";
		}

		return new URL("http", "cache.domianarchiv.de", "/Domian_"
				+ formatDate() + "." + quality + ".mp3");
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getThema() {
		return this.thema;
	}

	@Override
	public String toString() {
		return "Sendung [Datum=" + formatDate() + ", Thema=" + thema + "]";
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public Sendung(Date datum, String thema) {
		this.datum = datum;
		this.thema = thema;
	}
}

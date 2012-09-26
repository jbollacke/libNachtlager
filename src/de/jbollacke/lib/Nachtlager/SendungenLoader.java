package de.jbollacke.lib.Nachtlager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SendungenLoader {
	public List<Sendung> load() throws IOException, ParseException {
		return load(0);
	}

	public List<Sendung> load(int page) throws IOException, ParseException {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		List<Sendung> sendungen = new ArrayList<Sendung>();

		// do not waste resources on pages out of bounds
		if (page < 0) {
			return sendungen;
		}

		Document doc = Jsoup.connect(
				"http://www.nachtlager.de/go/de/archiv/index?page="
						+ (page + 1)).get();
		Elements elements = doc
				.select("div#main table.archiv")
				.first()
				.select("tr:not(.last) td.datum, tr:not(.last) td.titel"); // , tr:not(.last) td.mp3 a

		Iterator<Element> it = elements.iterator();
		while (it.hasNext()) {
			String datum = it.next().ownText();
			String thema = it.next().ownText();

			sendungen.add(new Sendung(dateFormat.parse(datum), thema));
		}

		return sendungen;
	}
}

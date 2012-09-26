package de.jbollacke.lib.Nachtlager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

public class SendungenLoaderTest {

	@Test
	public void testLoad() throws IOException, ParseException {
		SendungenLoader loader = new SendungenLoader();
		assertFalse("No Sendungen loaded", loader.load().isEmpty());
		assertTrue("Loaded Sendungen off a page out of bounds", loader.load(-1)
				.isEmpty());
	}

}

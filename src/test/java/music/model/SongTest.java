// package;
package music.model;

// imports
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

	// test no args constructor
	@Test
	void testNoArgsConstructor() {
		// Arrange
		Song song = new Song();

		// Assert
		assertEquals(0, song.getId());
		assertNull(song.getTitle());
		assertNull(song.getArtist());
		assertEquals("", song.getGenres());
		assertNull(song.getAlbum());
		assertNull(song.getLanguage());
		assertNull(song.getDuration());
		assertEquals(0, song.getReleaseYear());
		assertEquals(1, song.getBpm());
		assertFalse(song.isExplicit());
		assertNull(song.getPlaylist());
	}

	// test song constructor
	@Test
	void testConstructorWithTitle() {
		// Arrange
		String title = "MySong";

		// Act
		Song song = new Song(title);

		// Assert
		assertEquals(0, song.getId());
		assertEquals(title, song.getTitle());
		assertNull(song.getArtist());
		assertEquals("", song.getGenres());
		assertNull(song.getAlbum());
		assertNull(song.getLanguage());
		assertNull(song.getDuration());
		assertEquals(0, song.getReleaseYear());
		assertEquals(1, song.getBpm());
		assertFalse(song.isExplicit());
		assertNull(song.getPlaylist());
	}

	// test artist constructor
	@Test
	void testConstructorWithTitleAndArtist() {
		// Arrange
		String title = "MySong";
		String artist = "MyArtist";

		// Act
		Song song = new Song(title, artist);

		// Assert
		assertEquals(0, song.getId());
		assertEquals(title, song.getTitle());
		assertEquals(artist, song.getArtist());
		assertEquals("", song.getGenres());
		assertNull(song.getAlbum());
		assertNull(song.getLanguage());
		assertNull(song.getDuration());
		assertEquals(0, song.getReleaseYear());
		assertEquals(1, song.getBpm());
		assertFalse(song.isExplicit());
		assertNull(song.getPlaylist());
	}

	// test constructor with title, artist, album, duration, releaseYear, bpm, and
	// explicit
	@Test
	void testConstructorWithAllArgs() {
		// Arrange
		String title = "MySong";
		String artist = "MyArtist";
		String genres = "Rock";
		String language = "English";
		String album = "MyAlbum";
		double duration = 3.5;
		int releaseYear = 2022;
		int bpm = 120;
		boolean explicit = false;

		// Act
		Song song = new Song(title, artist, genres, language, album, duration, releaseYear, bpm, explicit);

		// Assert
		assertEquals(0, song.getId());
		assertEquals(title, song.getTitle());
		assertEquals(artist, song.getArtist());
		assertEquals(genres, song.getGenres());
		assertEquals(album, song.getAlbum());
		assertEquals(language, song.getLanguage());
		assertEquals(duration, song.getDuration());
		assertEquals(releaseYear, song.getReleaseYear());
		assertEquals(bpm, song.getBpm());
		assertEquals(explicit, song.isExplicit());
		assertNull(song.getPlaylist());
	}

	// test setters and getters
	@Test
	void testSettersAndGetters() {
		// Arrange
		Song song = new Song();

		// Act
		song.setId(1);
		song.setTitle("NewTitle");
		song.setArtist("NewArtist");
		song.setGenres("NewGenres");
		song.setAlbum("NewAlbum");
		song.setLanguage("NewLanguage");
		song.setDuration(4.2);
		song.setReleaseYear(2023);
		song.setBpm(130);
		song.setExplicit(true);

		// Assert
		assertEquals(1, song.getId());
		assertEquals("NewTitle", song.getTitle());
		assertEquals("NewArtist", song.getArtist());
		assertEquals("NewGenres", song.getGenres());
		assertEquals("NewAlbum", song.getAlbum());
		assertEquals("NewLanguage", song.getLanguage());
		assertEquals(4.2, song.getDuration());
		assertEquals(2023, song.getReleaseYear());
		assertEquals(130, song.getBpm());
		assertTrue(song.isExplicit());
		assertNull(song.getPlaylist());
	}

	// test to string
	@Test
	void testToString() {
		// Arrange
		Song song = new Song("MySong", "MyArtist", "Rock", "English", "MyAlbum", 3.5, 2022, 120, false);

		// Act
		String toStringResult = song.toString();

		// Assert
		assertEquals(
				"Songs[songId=0, title=MySong, artist=MyArtist, genres=Rock, album=MyAlbum, language=English, duration=3.5, releaseYear=2022, bpm=120, explicit=false]",
				toStringResult);
	}
}

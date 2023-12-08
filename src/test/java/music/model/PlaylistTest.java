//package
package music.model;

//imports
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
// tests constructor with names
	@Test
	void testConstructorWithName() {
		// Arrange
		String playlistName = "MyPlaylist";

		// Act
		Playlist playlist = new Playlist(playlistName);

		// Assert
		assertEquals(0, playlist.getPId());
		assertEquals(playlistName, playlist.getName());
		assertEquals(" ", playlist.getMainGenre());
		assertEquals(0, playlist.getNumberOfSongs());
		assertNotNull(playlist.getSongs());
		assertTrue(playlist.getSongs().isEmpty());
	}

	// tests constructor with names and main genre
	@Test
	void testConstructorWithNameAndMainGenre() {
		// Arrange
		String playlistName = "MyPlaylist";
		String mainGenre = "Rock";

		// Act
		Playlist playlist = new Playlist(playlistName, mainGenre);

		// Assert
		assertEquals(0, playlist.getPId());
		assertEquals(playlistName, playlist.getName());
		assertEquals(mainGenre, playlist.getMainGenre());
		assertEquals(0, playlist.getNumberOfSongs());
		assertNotNull(playlist.getSongs());
		assertTrue(playlist.getSongs().isEmpty());
	}

	// tests full constructor
	@Test
	void testConstructorWithNameMainGenreAndNumberOfSongs() {
		// Arrange
		String playlistName = "MyPlaylist";
		String mainGenre = "Rock";
		int numberOfSongs = 5;

		// Act
		Playlist playlist = new Playlist(playlistName, mainGenre, numberOfSongs);

		// Assert
		assertEquals(0, playlist.getPId());
		assertEquals(playlistName, playlist.getName());
		assertEquals(mainGenre, playlist.getMainGenre());
		assertEquals(numberOfSongs, playlist.getNumberOfSongs());
		assertNotNull(playlist.getSongs());
		assertTrue(playlist.getSongs().isEmpty());
	}

	// tests getters and setters
	@Test
	void testSettersAndGetters() {
		// Arrange
		Playlist playlist = new Playlist();

		// Act
		playlist.setPId(1L);
		playlist.setName("MyPlaylist");
		playlist.setMainGenre("Rock");
		playlist.setNumberOfSongs(5);

		// Assert
		assertEquals(1L, playlist.getPId());
		assertEquals("MyPlaylist", playlist.getName());
		assertEquals("Rock", playlist.getMainGenre());
		assertEquals(5, playlist.getNumberOfSongs());
		assertNotNull(playlist.getSongs());
		assertTrue(playlist.getSongs().isEmpty());
	}

	// tests add song
	@Test
	void testAddSong() {
		// Arrange
		Playlist playlist = new Playlist();
		Song song = new Song("Song1", "Artist1");

		// Act
		playlist.getSongs().add(song);

		// Assert
		assertEquals(1, playlist.getSongs().size());
		assertTrue(playlist.getSongs().contains(song));
	}

	// tests to string
	@Test
	void testToString() {
		// Arrange
		Playlist playlist = new Playlist("MyPlaylist", "Rock", 5);

		// Act
		String toStringResult = playlist.toString();

		// Assert
		assertEquals("Playlist [pId=0, name=MyPlaylist, mainGenre=Rock, numberOfSongs=5]", toStringResult);
	}
}

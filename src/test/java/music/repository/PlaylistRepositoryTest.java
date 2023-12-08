// package
package music.repository;

// imports
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// imports for project
import music.model.Playlist;

// makes it so it will know its a JPA test
@DataJpaTest
public class PlaylistRepositoryTest {

	// connects playlist repository
	@Autowired
	private PlaylistRepository playlistRepository;

	// tests find by name
	@Test
	void testFindByName() {
		// Arrange
		Playlist playlist = new Playlist("TestPlaylist");
		playlistRepository.save(playlist);

		// Act
		Playlist foundPlaylist = playlistRepository.findByName("TestPlaylist");

		// Assert
		assertNotNull(foundPlaylist);
		assertEquals("TestPlaylist", foundPlaylist.getName());
	}

	// tests find all
	@Test
	void testFindAll() {
		// Arrange
		Playlist playlist1 = new Playlist("Playlist1");
		Playlist playlist2 = new Playlist("Playlist2");
		playlistRepository.saveAll(List.of(playlist1, playlist2));

		// Act
		List<Playlist> playlists = playlistRepository.findAll();

		// Assert
		assertNotNull(playlists);
		assertEquals(2, playlists.size());
	}

	// tests save function
	@Test
	void testSave() {
		// Arrange
		Playlist playlist = new Playlist("NewPlaylist");

		// Act
		Playlist savedPlaylist = playlistRepository.save(playlist);

		// Assert
		assertNotNull(savedPlaylist);
		assertNotNull(savedPlaylist.getPId());
		assertEquals("NewPlaylist", savedPlaylist.getName());
	}

	// tests find by id
	@Test
	void testFindById() {
		// Arrange
		Playlist playlist = new Playlist("TestPlaylist");
		playlistRepository.save(playlist);

		// Act
		Optional<Playlist> foundPlaylistOptional = playlistRepository.findById(playlist.getPId());

		// Assert
		assertTrue(foundPlaylistOptional.isPresent());
		Playlist foundPlaylist = foundPlaylistOptional.get();
		assertEquals("TestPlaylist", foundPlaylist.getName());
	}

	// tests delete function
	@Test
	void testDelete() {
		// Arrange
		Playlist playlist = new Playlist("PlaylistToDelete");
		playlistRepository.save(playlist);

		// Act
		playlistRepository.deleteById(playlist.getPId());

		// Assert
		assertFalse(playlistRepository.findById(playlist.getPId()).isPresent());
	}
}

// package
package music.repository;

//import
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import from project
import music.model.Song;

// lets spring know it's a jpa test
@DataJpaTest
public class SongsRepositoryTest {

	// connects song repository
	@Autowired
	private SongsRepository songsRepository;

	// tests find by title and artist
	@Test
	void testFindByTitleAndArtist() {
		// Arrange
		Song song = new Song("TestTitle", "TestArtist");
		songsRepository.save(song);

		// Act
		Song foundSong = songsRepository.findByTitleAndArtist("TestTitle", "TestArtist");

		// Assert
		assertNotNull(foundSong);
		assertEquals("TestTitle", foundSong.getTitle());
		assertEquals("TestArtist", foundSong.getArtist());
	}

	// tests find all
	@Test
	void testFindAll() {
		// Arrange
		Song song1 = new Song("Song1", "Artist1");
		Song song2 = new Song("Song2", "Artist2");
		songsRepository.saveAll(List.of(song1, song2));

		// Act
		List<Song> songs = songsRepository.findAll();

		// Assert
		assertNotNull(songs);
		assertEquals(2, songs.size());
	}

	// tests save feature
	@Test
	void testSave() {
		// Arrange
		Song song = new Song("NewSong", "NewArtist");

		// Act
		Song savedSong = songsRepository.save(song);

		// Assert
		assertNotNull(savedSong);
		assertNotNull(savedSong.getId());
		assertEquals("NewSong", savedSong.getTitle());
		assertEquals("NewArtist", savedSong.getArtist());
	}

	// tests find by id
	@Test
	void testFindById() {
		// Arrange
		Song song = new Song("TestSong", "TestArtist");
		songsRepository.save(song);

		// Act
		Song foundSong = songsRepository.findById(song.getId()).orElse(null);

		// Assert
		assertNotNull(foundSong);
		assertEquals("TestSong", foundSong.getTitle());
		assertEquals("TestArtist", foundSong.getArtist());
	}

	// test delete feature
	@Test
	void testDelete() {
		// Arrange
		Song song = new Song("SongToDelete", "ArtistToDelete");
		songsRepository.save(song);

		// Act
		songsRepository.deleteById(song.getId());

		// Assert
		assertFalse(songsRepository.findById(song.getId()).isPresent());
	}
}

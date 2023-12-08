// package
package music.service;

// imports
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
// imports from project
import music.repository.*;
import music.model.*;

// sets up for service test
@ExtendWith(MockitoExtension.class)
class MusicLibraryServiceTest {

	// sets up connections needed for the service test
	@Mock
	private SongsRepository songRepository;

	@Mock
	private PlaylistRepository playlistRepository;

	@InjectMocks
	private MusicLibraryService musicLibraryService;

	// tests get all titles
	@Test
    void testGetAllTitles() {
        // Arrange
        when(songRepository.findAll()).thenReturn(Arrays.asList(new Song("Song1"), new Song("Song2")));

        // Act
        List<String> titles = musicLibraryService.getAllTitles();

        // Assert
        assertEquals(Arrays.asList("Song1", "Song2"), titles);
    }

	// tests get all artists
	@Test
    void testGetAllArtists() {
        // Arrange
        when(songRepository.findAll()).thenReturn(Arrays.asList(new Song("Song1", "Artist1"), new Song("Song2", "Artist2")));

        // Act
        List<String> artists = musicLibraryService.getAllArtists();

        // Assert
        assertEquals(Arrays.asList("Artist1", "Artist2"), artists);
    }

	// tests get all songs
	@Test
    void testGetAllSongs() {
        // Arrange
        when(songRepository.findAll(any(Sort.class)))
                .thenReturn(Arrays.asList(new Song("Song1", "Artist1"), new Song("Song2", "Artist2")));

        // Act
        List<Song> songs = musicLibraryService.getAllSongs("title", "asc");

        // Assert
        assertEquals(Arrays.asList(new Song("Song1", "Artist1"), new Song("Song2", "Artist2")), songs);
    }

	// tests add songs
	@Test
	void testAddSong() {
		// Arrange
		Song validSong = new Song("ValidTitle", "ValidArtist");
		doNothing().when(songRepository).save(validSong);

		// Act and Assert
		assertDoesNotThrow(() -> musicLibraryService.addSong(validSong));
	}

	// tests add song with invalid title
	@Test
	void testAddSongInvalidTitle() {
		// Arrange
		Song invalidSong = new Song("", "ValidArtist");

		// Act and Assert
		assertThrows(IllegalArgumentException.class, () -> musicLibraryService.addSong(invalidSong));
	}

	// tests update song
	@Test
	void testUpdateSong() {
		// Arrange
		Song existingSong = new Song("ExistingSong", "ExistingArtist");
		when(songRepository.findById(1L)).thenReturn(java.util.Optional.of(existingSong));
		doNothing().when(songRepository).save(existingSong);

		// Act and Assert
		assertDoesNotThrow(() -> musicLibraryService.updateSong(existingSong));
	}

	// tests update song not found
	@Test
	void testUpdateSongNotFound() {
		// Arrange
		Song nonExistingSong = new Song("NonExistingSong", "NonExistingArtist");
		when(songRepository.findById(1L)).thenReturn(java.util.Optional.empty());

		// Act and Assert
		assertThrows(IllegalArgumentException.class, () -> musicLibraryService.updateSong(nonExistingSong));
	}

	// tests delete song
	@Test
	void testDeleteSong() {
		// Arrange
		Song existingSong = new Song("ExistingSong", "ExistingArtist");
		when(songRepository.findById(1L)).thenReturn(java.util.Optional.of(existingSong));
		doNothing().when(songRepository).delete(existingSong);

		// Act and Assert
		assertDoesNotThrow(() -> musicLibraryService.deleteSong(1L));
	}

	// tests delete song not found
	@Test
    void testDeleteSongNotFound() {
        // Arrange
        when(songRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> musicLibraryService.deleteSong(1L));
    }

	// tests get all names
	@Test
    void testGetAllNames() {
        // Arrange
        when(playlistRepository.findAll()).thenReturn(Arrays.asList(new Playlist("Playlist1"), new Playlist("Playlist2")));

        // Act
        List<String> names = musicLibraryService.getAllNames();

        // Assert
        assertEquals(Arrays.asList("Playlist1", "Playlist2"), names);
    }

	// tests add playlist
	@Test
	void testAddPlaylist() {
		// Arrange
		Playlist validPlaylist = new Playlist("ValidPlaylist");
		doNothing().when(playlistRepository).save(validPlaylist);

		// Act and Assert
		assertDoesNotThrow(() -> musicLibraryService.addPlaylist(validPlaylist));
	}

	// tests add playlist with an invalid name
	@Test
	void testAddPlaylistInvalidName() {
		// Arrange
		Playlist invalidPlaylist = new Playlist("");

		// Act and Assert
		assertThrows(IllegalArgumentException.class, () -> musicLibraryService.addPlaylist(invalidPlaylist));
	}

	// tets update playlist
	@Test
	void testUpdatePlaylist() {
		// Arrange
		Playlist existingPlaylist = new Playlist("ExistingPlaylist");
		when(playlistRepository.findById(1L)).thenReturn(java.util.Optional.of(existingPlaylist));
		doNothing().when(playlistRepository).save(existingPlaylist);

		// Act and Assert
		assertDoesNotThrow(() -> musicLibraryService.updatePlaylist(existingPlaylist));
	}

	// tests update playlist not found
	@Test
	void testUpdatePlaylistNotFound() {
		// Arrange
		Playlist nonExistingPlaylist = new Playlist("NonExistingPlaylist");
		when(playlistRepository.findById(1L)).thenReturn(java.util.Optional.empty());

		// Act and Assert
		assertThrows(IllegalArgumentException.class, () -> musicLibraryService.updatePlaylist(nonExistingPlaylist));
	}

	// tests delete playlist
	@Test
	void testDeletePlaylist() {
		// Arrange
		Playlist existingPlaylist = new Playlist("ExistingPlaylist");
		when(playlistRepository.findById(1L)).thenReturn(java.util.Optional.of(existingPlaylist));
		doNothing().when(playlistRepository).delete(existingPlaylist);

		// Act and Assert
		assertDoesNotThrow(() -> musicLibraryService.deletePlaylist(1L));
	}

	// tests playlist not found
	@Test
    void testDeletePlaylistNotFound() {
        // Arrange
        when(playlistRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> musicLibraryService.deletePlaylist(1L));
    }

	// tests add sogns to playlist
	@Test
	void testAddSongToPlaylist() {
		// Arrange
		Song existingSong = new Song("Song1", "Artist1");
		Playlist existingPlaylist = new Playlist("Playlist1");

		when(songRepository.findByTitleAndArtist("Song1", "Artist1")).thenReturn(existingSong);
		when(playlistRepository.findByName("Playlist1")).thenReturn(existingPlaylist);

		// Act
		musicLibraryService.addSongToPlaylist("Song1", "Artist1", "Playlist1");

		// Assert
		assertEquals(1, existingPlaylist.getNumberOfSongs());
		assertTrue(existingPlaylist.getSongs().contains(existingSong));
	}

}

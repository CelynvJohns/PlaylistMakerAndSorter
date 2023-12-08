// package
package music.controller;

//imports
import music.model.Playlist;
import music.model.Song;
import music.service.MusicLibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

// sets for end to end testing
@SpringBootTest
class WebControllerTest {

	// sets up services that are needed
	@Mock
	private MusicLibraryService musicLibraryService;

	@Mock
	private Model model;

	// sets up webcontroller
	@InjectMocks
	private WebController webController;

	// sets up before each
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	// sets up test view all songs
	@Test
	void testViewAllSongs() {
		// Arrange
		List<Song> songs = Arrays.asList(new Song("Song1"), new Song("Song2"));
		when(musicLibraryService.getAllSongs(anyString(), anyString())).thenReturn(songs);

		// Act
		String result = webController.viewAllSongs(model, "title", "asc");

		// Assert
		assertEquals("songResults", result);
		verify(model).addAttribute("songs", songs);
	}

	// sets up test add new songs
	@Test
	void testAddNewSongs() {
		// Act
		String result = webController.addNewSongs(model);

		// Assert
		assertEquals("songsInput", result);
		verify(model).addAttribute("newSongs", new Song());
	}

	// set up test show update songs
	@Test
	void testShowUpdateSongs() {
		// Arrange
		Song song = new Song("Song1");
		when(musicLibraryService.getSongById(1L)).thenReturn(song);

		// Act
		String result = webController.showUpdateSongs(1L, model);

		// Assert
		assertEquals("songsInput", result);
		verify(model).addAttribute("newSongs", song);
	}

	// tests revise songs
	@Test
	void testReviseSongs() {
		// Arrange
		Song song = new Song("Song1");

		// Act
		String result = webController.reviseSongs(song, model);

		// Assert
		assertEquals("redirect:/viewAllSongs", result);
		verify(musicLibraryService).updateSong(song);
	}

	// tests delete songs
	@Test
	void testDeleteSong() {
		// Act
		String result = webController.deleteSong(1L, model);

		// Assert
		assertEquals("redirect:/viewAllSongs", result);
		verify(musicLibraryService).deleteSong(1L);
	}

	// tests view all plalists
	@Test
	void testViewAllPlaylists() {
		// Arrange
		List<Playlist> playlists = Arrays.asList(new Playlist("Playlist1"), new Playlist("Playlist2"));
		when(musicLibraryService.getAllPlaylists(anyString(), anyString())).thenReturn(playlists);

		// Act
		String result = webController.viewAllPlaylists("pId", "asc", model);

		// Assert
		assertEquals("playlistResults", result);
		verify(model).addAttribute("playlists", playlists);
	}

	// tests add new playlists
	@Test
	void testAddNewPlaylists() {
		// Act
		String result = webController.addNewPlaylists(model);

		// Assert
		assertEquals("playlistInput", result);
		verify(model).addAttribute("newPlaylists", new Playlist());
	}

	// tests show update playlist
	@Test
	void testShowUpdatePlaylists() {
		// Arrange
		Playlist playlist = new Playlist("Playlist1");
		when(musicLibraryService.getPlaylistById(1L)).thenReturn(playlist);

		// Act
		String result = webController.showUpdatePlaylists(1L, model);

		// Assert
		assertEquals("playlistInput", result);
		verify(model).addAttribute("newPlaylists", playlist);
	}

	// tests revise playlist
	@Test
	void testRevisePlaylists() {
		// Arrange
		Playlist playlist = new Playlist("Playlist1");

		// Act
		String result = webController.revisePlaylists(playlist, model);

		// Assert
		assertEquals("redirect:/viewAllPlaylists", result);
		verify(musicLibraryService).updatePlaylist(playlist);
	}

	// tests delete playlist
	@Test
	void testDeletePlaylist() {
		// Act
		String result = webController.deletePlaylist(1L, model);

		// Assert
		assertEquals("redirect:/viewAllPlaylists", result);
		verify(musicLibraryService).deletePlaylist(1L);
	}

	// test get names and titles
	@Test
	void testGetNamesAndTitles() {
		// Arrange
		Map<String, List<String>> data = new HashMap<>();
		data.put("names", Arrays.asList("Playlist1", "Playlist2"));
		data.put("titles", Arrays.asList("Song1", "Song2"));
		data.put("artists", Arrays.asList("Artist1", "Artist2"));
		when(musicLibraryService.getAllNames()).thenReturn(Arrays.asList("Playlist1", "Playlist2"));
		when(musicLibraryService.getAllTitles()).thenReturn(Arrays.asList("Song1", "Song2"));
		when(musicLibraryService.getAllArtists()).thenReturn(Arrays.asList("Artist1", "Artist2"));

		// Act
		ResponseEntity<Map<String, List<String>>> responseEntity = webController.getNamesAndTitles();

		// Assert
		assertEquals(200, responseEntity.getStatusCodeValue());
		Map<String, List<String>> responseData = responseEntity.getBody();
		assertTrue(responseData.containsKey("names"));
		assertTrue(responseData.containsKey("titles"));
		assertTrue(responseData.containsKey("artists"));
		assertEquals(Arrays.asList("Playlist1", "Playlist2"), responseData.get("names"));
		assertEquals(Arrays.asList("Song1", "Song2"), responseData.get("titles"));
		assertEquals(Arrays.asList("Artist1", "Artist2"), responseData.get("artists"));
	}

	// tests add song to playlist
	@Test
	void testAddSongToPlaylist() {
		// Act
		webController.addSongToPlaylist("Song1", "Artist1", "Playlist1");

		// Assert
		verify(musicLibraryService).addSongToPlaylist("Song1", "Artist1", "Playlist1");
	}
}

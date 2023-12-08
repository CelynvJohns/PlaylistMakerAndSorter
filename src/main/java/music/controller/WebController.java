// package
package music.controller;

/// imports for utilities
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
// imports from the project
import music.model.Playlist;
import music.model.Song;
import music.service.MusicLibraryService;

@Controller
public class WebController {

	// setting up music library service to allow it for implementation
	@Autowired
	private MusicLibraryService musicLibraryService;

	// view the index
	/**
	 * @return index
	 */
	@GetMapping({ "/", "/index" })
	public String index() {
		return "index";
	}

	// Mapping for viewing all songs
	/**
	 * @param model
	 * @param sortBy
	 * @param sortOrder
	 * @return song results
	 */
	@GetMapping("/viewAllSongs")
	public String viewAllSongs(Model model, @RequestParam(required = false, defaultValue = "title") String sortBy,
			@RequestParam(required = false, defaultValue = "asc") String sortOrder) {
		List<Song> songs = musicLibraryService.getAllSongs(sortBy, sortOrder);
		model.addAttribute("songs", songs);
		return "songResults";
	}

	// Mapping for adding a new song
	/**
	 * @param model
	 * @return songs input
	 */
	@GetMapping("/inputSongs")
	public String addNewSongs(Model model) {
	    Song song = new Song();
	    model.addAttribute("newSongs", song);
	    return "songsInput";
	}

	// Mapping for editing a song
	/**
	 * @param id
	 * @param model
	 * @return songs input
	 */
	@GetMapping("/edit/{id}")
	public String showUpdateSongs(@PathVariable("id") long id, Model model) {
		Song song = musicLibraryService.getSongById(id);
		model.addAttribute("newSongs", song);
		return "songsInput";
	}

	// Post mapping for editing a song
	/**
	 * @param song
	 * @param model
	 * @return view all songs
	 */
	@PostMapping("/update/{id}")
	public String reviseSongs(@ModelAttribute("newSongs") Song song, Model model) {
		musicLibraryService.updateSong(song);
		return "redirect:/viewAllSongs";
	}

	// mapping for deleting a song
	/**
	 * @param id
	 * @param model
	 * @return view all songs
	 */
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") long id, Model model) {
		musicLibraryService.deleteSong(id);
		return "redirect:/viewAllSongs";
	}

	// Mapping for viewing all playlists
	/**
	 * @param sortBy
	 * @param sortOrder
	 * @param model
	 * @return playlist results
	 */
	@GetMapping("/viewAllPlaylists")
	public String viewAllPlaylists(@RequestParam(name = "sortBy", defaultValue = "pId") String sortBy,
			@RequestParam(name = "sortOrder", defaultValue = "asc") String sortOrder, Model model) {
		List<Playlist> playlists = musicLibraryService.getAllPlaylists(sortBy, sortOrder);
		model.addAttribute("playlists", playlists);
		return "playlistResults";
	}

	// Mapping for adding a new playlist
	/**
	 * @param model
	 * @return playlist input
	 */
	@GetMapping("/inputPlaylists")
	public String addNewPlaylists(Model model) {
		Playlist playlist = new Playlist();
		model.addAttribute("newPlaylists", playlist);
		return "playlistInput";
	}

	// Mapping for editing a playlist
	/**
	 * @param id
	 * @param model
	 * @return playlist input
	 */
	@GetMapping("/editPlaylist/{pId}")
	public String showUpdatePlaylists(@PathVariable("pId") long id, Model model) {
		Playlist playlist = musicLibraryService.getPlaylistById(id);
		model.addAttribute("newPlaylists", playlist);
		return "playlistInput";
	}

	// mapping for updating a playlist
	/**
	 * @param playlist
	 * @param model
	 * @return view all playlists
	 */
	@PostMapping("/updatePlaylist/{pId}")
	public String revisePlaylists(@ModelAttribute("newPlaylists") Playlist playlist, Model model) {
		musicLibraryService.updatePlaylist(playlist);
		return "redirect:/viewAllPlaylists";
	}

	// mappign for deleing a playlist
	/**
	 * @param id
	 * @param model
	 * @return view all playlists
	 */
	@GetMapping("/deletePlaylist/{pId}")
	public String deletePlaylist(@PathVariable("pId") long id, Model model) {
		musicLibraryService.deletePlaylist(id);
		return "redirect:/viewAllPlaylists";
	}

	// mapping for getting the names and titles as well as artist
	/**
	 * @return data
	 */
	@GetMapping("/getNamesAndTitles")
	public ResponseEntity<Map<String, List<String>>> getNamesAndTitles() {
		Map<String, List<String>> data = new HashMap<>();
		data.put("names", musicLibraryService.getAllNames());
		data.put("titles", musicLibraryService.getAllTitles());
		data.put("artists", musicLibraryService.getAllArtists());
		return ResponseEntity.ok(data);
	}

	// post mapping for getting the names, titles,and artists
	/**
	 * @param title
	 * @param artist
	 * @param name
	 */
	@PostMapping("/addSongToPlaylist")
	public void addSongToPlaylist(@RequestParam String title, @RequestParam String artist, @RequestParam String name) {
		musicLibraryService.addSongToPlaylist(title, artist, name);
	}

}

// package
package music.service;

// imports from java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// imports from the project
import music.model.*;
import music.repository.*;

// allows spring to recognize this as a service
@Service
public class MusicLibraryService {

	// sets up song repository
	@Autowired
	private SongsRepository songRepository;

	// sets up playlist repository
	@Autowired
	private PlaylistRepository playlistRepository;

	// gets all the titles from the song database
	/**
	 * @return title
	 */
	public List<String> getAllTitles() {
		List<Song> allSongs = songRepository.findAll();
		return allSongs.stream().map(Song::getTitle).collect(Collectors.toCollection(LinkedList::new));
	}

	// gets all the artists from the song database
	/**
	 * @return artist
	 */
	public List<String> getAllArtists() {
		List<Song> allSongs = songRepository.findAll();
		return allSongs.stream().map(Song::getArtist).collect(Collectors.toCollection(LinkedList::new));
	}

	// gets all the names from the playlist database
	/**
	 * @return name
	 */
	public List<String> getAllNames() {
		// Use findAll to get all playlists and then extract names
		List<Playlist> allPlaylists = playlistRepository.findAll();
		return allPlaylists.stream().map(Playlist::getName).collect(Collectors.toCollection(LinkedList::new));
	}

	// gets all the songs from the song database and allows it to be sorted
	/**
	 * @param sortBy
	 * @param sortOrder
	 * @return all of the songs sorted
	 */
	public List<Song> getAllSongs(String sortBy, String sortOrder) {
		// Validate the sortBy parameter to prevent potential issues
		String[] allowedFields = { "id", "title", "artist", "genres", "album", "language", "duration", "releaseYear",
				"bpm", "explicit" };
		if (!Arrays.asList(allowedFields).contains(sortBy)) {
			// Handle invalid sortBy values, you might throw an exception or use a default
			// value
			throw new IllegalArgumentException("Invalid sortBy parameter");
		}

		// Default sorting order is ascending, change to descending if sortOrder is
		// "desc"
		Sort.Order order = sortOrder.equalsIgnoreCase("desc") ? Sort.Order.desc(sortBy) : Sort.Order.asc(sortBy);

		Sort sort = Sort.by(order);

		return songRepository.findAll(sort);
	}

	// allows songs to be added
	/**
	 * @param song
	 */
	public void addSong(Song song) {
		songRepository.save(song);
	}

	// gets songs by Id
	/**
	 * @param id
	 * @return song repository's id
	 */
	public Song getSongById(long id) {
		return songRepository.findById(id).orElse(null);
	}

	// allows songs to be updated
	/**
	 * @param song
	 */
	public void updateSong(Song song) {
		songRepository.save(song);
	}

	// allows songs to be deleted
	/**
	 * @param id
	 */
	public void deleteSong(long id) {
		Song song = songRepository.findById(id).orElse(null);
		if (song != null) {
			songRepository.delete(song);
		}
	}

	// adds songs to playlist
	/**
	 * @param title
	 * @param artist
	 * @param name
	 */
	public void addSongToPlaylist(String title, String artist, String name) {
		// Check if the song exists in the database
		Song song = songRepository.findByTitleAndArtist(title, artist);

		// If the song doesn't exist, you can add it to the database
		if (song == null) {
			song = new Song(title, artist);
			songRepository.save(song);
		}

		// Check if the playlist exists in the database
		Playlist playlist = playlistRepository.findByName(name);

		// If the playlist doesn't exist, you can add it to the database
		if (playlist == null) {
			playlist = new Playlist(name);
			playlistRepository.save(playlist);
		}

		// Add the song to the playlist
		playlist.getSongs().add(song);
		playlist.setNumberOfSongs(playlist.getNumberOfSongs() + 1);
		playlistRepository.save(playlist);
	}

	// gets all the information from playlist and sorts it
	/**
	 * @param sortBy
	 * @param sortOrder
	 * @return sorted playlist
	 */
	public List<Playlist> getAllPlaylists(String sortBy, String sortOrder) {
		// Validate the sortBy parameter to prevent potential issues
		String[] allowedFields = { "pId", "name", "mainGenre", "numberOfSongs" };
		if (!Arrays.asList(allowedFields).contains(sortBy)) {
			// Handle invalid sortBy values, you might throw an exception or use a default
			// value
			throw new IllegalArgumentException("Invalid sortBy parameter");
		}

		// sets desc order as main order
		Sort.Order order = sortOrder.equalsIgnoreCase("asc") ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy);
		Sort sort = Sort.by(order);

		return playlistRepository.findAll(sort);
	}

	// allows playlists to be added
	/**
	 * @param playlist
	 */
	public void addPlaylist(Playlist playlist) {
		playlistRepository.save(playlist);
	}

	// gets playlist Id
	/**
	 * @param pId
	 * @return playlist's id
	 */
	public Playlist getPlaylistById(long pId) {
		return playlistRepository.findById(pId).orElse(null);
	}

	// allows playlists to be updated
	/**
	 * @param playlist
	 */
	public void updatePlaylist(Playlist playlist) {
		playlistRepository.save(playlist);
	}

	// allows for playlists to be deleted
	/**
	 * @param pId
	 */
	public void deletePlaylist(long pId) {
		Playlist playlist = playlistRepository.findById(pId).orElse(null);
		if (playlist != null) {
			playlistRepository.delete(playlist);
		}
	}

}

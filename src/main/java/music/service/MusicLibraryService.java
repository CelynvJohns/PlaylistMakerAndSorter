package music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import music.model.Playlist;
import music.model.Song;
import music.repository.*;

import java.util.Arrays;
import java.util.List;

@Service
public class MusicLibraryService {

    @Autowired
    private SongsRepository songRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Song> getAllSongs(String sortBy, String sortOrder) {
        // Validate the sortBy parameter to prevent potential issues
        String[] allowedFields = {"id", "title", "artist", "genres", "album", "language", "duration", "releaseYear", "bpm", "explicit"};
        if (!Arrays.asList(allowedFields).contains(sortBy)) {
            // Handle invalid sortBy values, you might throw an exception or use a default value
            throw new IllegalArgumentException("Invalid sortBy parameter");
        }

        // Default sorting order is ascending, change to descending if sortOrder is "desc"
        Sort.Order order = sortOrder.equalsIgnoreCase("desc") ? Sort.Order.desc(sortBy) : Sort.Order.asc(sortBy);

        Sort sort = Sort.by(order);
        
        return songRepository.findAll(sort);
    }

    public void addSong(Song song) {
        songRepository.save(song);
    }

    public Song getSongById(long id) {
        return songRepository.findById(id).orElse(null);
    }

    public void updateSong(Song song) {
        songRepository.save(song);
    }

    public void deleteSong(long id) {
        Song song = songRepository.findById(id).orElse(null);
        if (song != null) {
            songRepository.delete(song);
        }
    }

    // More methods for managing songs...

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public void addPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    public Playlist getPlaylistById(long p_id) {
        return playlistRepository.findById(p_id).orElse(null);
    }

    public void updatePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    public void deletePlaylist(long p_id) {
        Playlist playlist = playlistRepository.findById(p_id).orElse(null);
        if (playlist != null) {
            playlistRepository.delete(playlist);
        }
    }

    // More methods for managing playlists...
}

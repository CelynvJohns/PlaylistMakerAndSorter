package music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.model.Playlist;
import music.model.Song;
import music.repository.*;

import java.util.List;

@Service
public class MusicLibraryService {

    @Autowired
    private SongsRepository songRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
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

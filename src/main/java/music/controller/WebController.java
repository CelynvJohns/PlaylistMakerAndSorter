package music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import music.model.Playlist;
import music.model.Song;
import music.service.MusicLibraryService;

@Controller
public class WebController {

    @Autowired
    private MusicLibraryService musicLibraryService;

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
    
    // Mapping for viewing all songs
    @GetMapping("/viewAllSongs")
    public String viewAllSongs(Model model) {
        model.addAttribute("songs", musicLibraryService.getAllSongs());
        return "songResults";
    }

    // Mapping for adding a new song
    @GetMapping("/inputSongs")
    public String addNewSongs(Model model) {
        Song song = new Song();
        model.addAttribute("newSongs", song);
        return "songsInput";
    }

    // Mapping for editing a song
    @GetMapping("/edit/{id}")
    public String showUpdateSongs(@PathVariable("id") long id, Model model) {
        Song song = musicLibraryService.getSongById(id);
        model.addAttribute("newSongs", song);
        return "songsInput";
    }

    @PostMapping("/update/{id}")
    public String reviseSongs(@ModelAttribute("newSongs") Song song, Model model) {
        musicLibraryService.updateSong(song);
        return "redirect:/viewAllSongs";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") long id, Model model) {
        musicLibraryService.deleteSong(id);
        return "redirect:/viewAllSongs";
    }

 // Mapping for viewing all playlists
    @GetMapping("/viewAllPlaylists")
    public String viewAllPlaylists(Model model) {
        List<Playlist> playlists = musicLibraryService.getAllPlaylists();
        model.addAttribute("playlists", playlists);
        return "playlistResults";
    }

    // Mapping for adding a new playlist
    @GetMapping("/inputPlaylists")
    public String addNewPlaylists(Model model) {
        Playlist playlist = new Playlist();
        model.addAttribute("newPlaylists", playlist);
        return "playlistInput";
    }

    // Mapping for editing a playlist
    @GetMapping("/editPlaylist/{p_id}")
    public String showUpdatePlaylists(@PathVariable("p_id") long id, Model model) {
        Playlist playlist = musicLibraryService.getPlaylistById(id);
        model.addAttribute("newPlaylists", playlist);
        return "playlistInput";
    }

    @PostMapping("/updatePlaylist/{p_id}")
    public String revisePlaylists(@ModelAttribute("newPlaylists") Playlist playlist, Model model) {
        musicLibraryService.updatePlaylist(playlist);
        return "redirect:/viewAllPlaylists";
    }

    @GetMapping("/deletePlaylist/{p_id}")
    public String deletePlaylist(@PathVariable("p_id") long id, Model model) {
        musicLibraryService.deletePlaylist(id);
        return "redirect:/viewAllPlaylists";
    }

    // ... (other mappings)
}

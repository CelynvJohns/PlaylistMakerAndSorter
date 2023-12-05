package music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import music.model.*;
import music.repository.*;

@Controller
public class WebController {
	// Song Repository
	@Autowired
	SongsRepository repo;
	
	//Playlist Repository
	@Autowired
	PlaylistRepository play;
	
	// Start of Song Mapping

	// allows you to view all the songs and if there are none redirects you to add a song
	/**
	 * @param model
	 * @return add song or song results
	 */
	@GetMapping({ "viewAllSongs" })
	public String viewAllSongs(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewSongs(model);
		}

		model.addAttribute("Songs", repo.findAll());
		return "songResults";
	}

	// allows you to input a song
	/**
	 * @param model
	 * @return song input
	 */
	@GetMapping("/inputSongs")
	public String addNewSongs(Model model) {
	    Song s = new Song();
	    model.addAttribute("newSongs", s);
	    return "songsInput";
	}

	// allows to got to the editing area
	/**
	 * @param id
	 * @param model
	 * @return song input
	 */
	@GetMapping("/edit/{id}")
	public String showUpdateSongs(@PathVariable("id") long id, Model model) {
		Song s = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + s.toString());
		model.addAttribute("newSongs", s);
		return "songsInput";
	}

	// updates song
	/**
	 * @param r
	 * @param model
	 * @return song input
	 */
	@PostMapping("/update/{id}")
	public String reviseSongs(Song s, Model model) {
		repo.save(s);
		return viewAllSongs(model);
	}

	// deletes the song if wanted
	/**
	 * @param id
	 * @param model
	 * @return view all songs
	 */
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") long id, Model model) {
		Song s = repo.findById(id).orElse(null);
		repo.delete(s);
		return viewAllSongs(model);
	}
	
	// Start of Playlist Mapping
	// allows you to view all the Playlists and if there are none redirects you to add a Playlist
		/**
		 * @param model
		 * @return add Playlist or Playlist results
		 */
		@GetMapping({ "viewAllPlaylists" })
		public String viewAllPlaylists(Model model) {
			if (play.findAll().isEmpty()) {
				return addNewPlaylists(model);
			}

			model.addAttribute("Playlists", play.findAll());
			return "playlistResults";
		}

		// allows you to input a Playlist
		/**
		 * @param model
		 * @return Playlist input
		 */
		@GetMapping("/inputPlaylists")
		public String addNewPlaylists(Model model) {
		    Playlist s = new Playlist();
		    model.addAttribute("newPlaylists", s);
		    return "playlistInput";
		}


		// allows to got to the editing area
		/**
		 * @param id
		 * @param model
		 * @return Playlist input
		 */
		@GetMapping("/editPlaylist/{id}")
		public String showUpdatePlaylists(@PathVariable("id") long id, Model model) {
			Playlist p = play.findById(id).orElse(null);
			System.out.println("ITEM TO EDIT: " + p.toString());
			model.addAttribute("newPlaylists", p);
			return "playlistInput";
		}

		// updates Playlist
		/**
		 * @param r
		 * @param model
		 * @return Playlist input
		 */
		@PostMapping("/updatePlaylist/{id}")
		public String revisePlaylists(Playlist p, Model model) {
		    System.out.println("Updating Playlist: " + p.toString());
		    play.save(p);
		    return viewAllPlaylists(model);
		}


		// deletes the Playlist if wanted
		/**
		 * @param id
		 * @param model
		 * @return view all Playlists
		 */
		@GetMapping("/deletePlaylists/{id}")
		public String deletePlaylist(@PathVariable("id") long id, Model model) {
			Playlist p = play.findById(id).orElse(null);
			play.delete(p);
			return viewAllPlaylists(model);
		}
	
}
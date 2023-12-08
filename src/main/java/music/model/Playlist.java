// package
package music.model;

// imports
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// sets up the table
@Table(name = "playlist")
@Entity(name = "playlist")
public class Playlist {
	// variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pId;
	@NotNull
	private String name = " ";
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Main genre must contain only letters")
	@NotNull
	private String mainGenre = " ";
	private Integer numberOfSongs = 0;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "playlist_id")
	private List<Song> songs = new ArrayList<>();

	// no args constructor
	public Playlist() {
		super();
	}

	// name of playlist constructor
	/**
	 * @param name
	 */
	public Playlist(String name) {
		super();
		this.name = name;
	}

	// name and main genre constructor
	/**
	 * @param name
	 * @param mainGenre
	 */
	public Playlist(String name, String mainGenre) {
		super();
		this.name = name;
		this.mainGenre = mainGenre;
	}

	// name, main genre, and number of songs constructor
	/**
	 * @param name
	 * @param mainGenre
	 * @param numberOfSongs
	 */
	public Playlist(String name, String mainGenre, Integer numberOfSongs) {
		super();
		this.name = name;
		this.mainGenre = mainGenre;
		this.numberOfSongs = numberOfSongs;
	}

	/**
	 * @return pId
	 */
	public long getPId() {
		return pId;
	}

	/**
	 * @param pId
	 */
	public void setPId(long pId) {
		this.pId = pId;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return mainGenre
	 */
	public String getMainGenre() {
		return mainGenre;
	}

	/**
	 * @param mainGenre
	 */
	public void setMainGenre(String mainGenre) {
		this.mainGenre = mainGenre;
	}

	/**
	 * @return numberOfSongs
	 */
	public Integer getNumberOfSongs() {
		return numberOfSongs;
	}

	/**
	 * @param numberOfSongs
	 */
	public void setNumberOfSongs(Integer numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}

	/**
	 * @return songs
	 */
	public List<Song> getSongs() {
		return songs;
	}

	/**
	 * @param songs
	 */
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	// To String
	@Override
	public String toString() {
		return "Playlist [pId=" + pId + ", name=" + name + ", mainGenre=" + mainGenre + ", numberOfSongs="
				+ numberOfSongs + "]";
	}
}

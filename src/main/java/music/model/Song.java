package music.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Table(name = "song")
@Entity(name = "song")
public class Song {
    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String artist;
    private String genres;
    private String album;
    private String language;
    private Double duration;
    private int releaseYear;
    private int bpm;
    private boolean explicit;

    // no args Constructor
    public Song() {
    	super();
    }
    
    // Title and Artist constructor
    /**
     * @param title
     * @param artist
     */
    public Song(String title, String artist) {
        super();
        this.artist = artist;
        this.title = title;
    }

    // Title, artist, album constructor
    /**
     * @param title
     * @param artist
     * @param genres
     */
    public Song(String title, String artist, String genres) {
        super();
        this.artist = artist;
        this.title = title;
        this.genres = genres;
    }

    // All args -songId constructor
    /**
     * @param title
     * @param artist
     * @param genres
     * @param language
     * @param album
     * @param dateAdded
     * @param duration
     * @param releaseYear
     * @param bpm
     * @param explicit
     */
    public Song(String title, String artist, String genres, String language, String album,
            double duration, int releaseYear, int bpm, boolean explicit) {
        super();
        this.artist = artist;
        this.title = title;
        this.genres = genres;
        this.album = album;
        this.bpm = bpm;
        this.duration = duration;
        this.explicit = explicit;
        this.releaseYear = releaseYear;
        this.language = language;
    }
    

    // getters and setters
    /**
     * @return songId
     */
    public long id() {
        return id;
    }

    /**
     * @param songId
     */
    public void setsId(long id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return genres
     */
    public String getGenres() {
        return genres;
    }

    /**
     * @param genres
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * @return album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return duration
     */
    public Double getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    /**
     * @return releaseYear
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * @param releaseYear
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * @return bpm
     */
    public int getBpm() {
        return bpm;
    }

    /**
     * @param bpm
     */
    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    /**
     * @return explicit
     */
    public boolean isExplicit() {
        return explicit;
    }

    /**
     * @param explicit
     */
    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    // to string
	@Override
	public String toString() {
		return "Songs[songId=" + id + ", title=" + title + ", artist=" + artist + ", genres=" + genres
				+ ", album=" + album + ", language=" + language + ", duration=" + duration
				+ ", releaseYear=" + releaseYear + ", bpm=" + bpm + ", explicit=" + explicit + "]";
	}
    
    
}

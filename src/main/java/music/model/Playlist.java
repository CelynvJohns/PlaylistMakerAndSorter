package music.model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "playlist")
@Entity(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String mainGenre;
    private int numberOfSongs;


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
    public Playlist(String name, String mainGenre, int numberOfSongs) {
        super();
        this.name = name;
        this.mainGenre = mainGenre;
        this.numberOfSongs = numberOfSongs;
    }

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(long id) {
        this.id = id;
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
    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    /**
     * @param numberOfSongs
     */
    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }


    // To String
    @Override
    public String toString() {
        return "Playlist [id=" + id + ", name=" + name + ", mainGenre=" + mainGenre + ", numberOfSongs="
                + numberOfSongs + "]";
    }
}

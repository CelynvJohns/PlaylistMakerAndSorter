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
    private long p_id;

    private String name;
    private String mainGenre;
    private Integer numberOfSongs;


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

    public long getP_id() {
        return p_id;
    }

    /**
     * @param p_id
     */
    public void setP_id(long p_id) {
        this.p_id = p_id;
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


    // To String
    @Override
    public String toString() {
        return "Playlist [p_id=" + p_id + ", name=" + name + ", mainGenre=" + mainGenre + ", numberOfSongs="
                + numberOfSongs + "]";
    }
}

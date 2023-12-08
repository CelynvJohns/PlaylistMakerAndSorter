// package
package music.repository;

// imports
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// imports from program
import music.model.Song;

// allows spring to know this is a repository
@Repository
public interface SongsRepository extends JpaRepository<Song, Long> {

	// finds song by title and aritst
	Song findByTitleAndArtist(String title, String artist);

	// finds all aspect of the song
	List<Song> findAll();

}

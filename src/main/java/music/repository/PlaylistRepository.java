// package
package music.repository;

// imports from java
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// imports from program
import music.model.Playlist;

// lets spring know it is a repository
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

	// finds playlist by the name of the playlist
	Playlist findByName(String name);

	// finds all the data in the playlist
	List<Playlist> findAll();

}
package music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import music.model.Song;

@Repository
public interface SongsRepository extends JpaRepository<Song, Long> {

}

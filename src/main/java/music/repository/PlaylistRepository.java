package music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import music.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

}
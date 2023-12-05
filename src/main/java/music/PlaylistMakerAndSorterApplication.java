package music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "music.model")
public class PlaylistMakerAndSorterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistMakerAndSorterApplication.class, args);
	}

}

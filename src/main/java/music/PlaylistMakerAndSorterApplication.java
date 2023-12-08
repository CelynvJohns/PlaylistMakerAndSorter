// package
package music;

// imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// allows for spring to recognize this as the application runner 
@SpringBootApplication
// makes sure spring reads music.model
@EntityScan(basePackages = "music.model")
public class PlaylistMakerAndSorterApplication {

	// allows for application to be run
	public static void main(String[] args) {
		SpringApplication.run(PlaylistMakerAndSorterApplication.class, args);
	}

}

// package
package music;

/** Name : PlaylistMakerAndSorter
 *  Created: 11/27/2023
 *  Course: CIS 152 - Data Structure
 *  Version: 1.0
 *  OS: Windows 11
 *  IDE: eclipse
 *  Copyright : This is my own original work
 *  based on specifications issued by our instructor
 *  Description : An app that makes a music sorter, it allows for songs and playlists to be added, deleted, shown, and updated.
 *  			Input: song data or playlist data
 *  			Output: all songs, all playlists
 *
 *  Academic Honesty: I attest that this is my original work.
 *  I have not used unauthorized source code, either modified or
 *  unmodified. I have not given other fellow student(s) access
 *  to my program.
 *  
 */


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

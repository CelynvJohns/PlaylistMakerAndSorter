// package
package music.controller;

//imports
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// sets as a springboot test for end to end testing
@SpringBootTest
public class AddSongRequestTest {

	// testing get set title
	@Test
	void testGetSetTitle() {
		// Arrange
		AddSongRequest addSongRequest = new AddSongRequest();
		addSongRequest.setTitle("TestTitle");

		// Act
		String title = addSongRequest.getTitle();

		// Assert
		assertEquals("TestTitle", title);
	}

	// testing get set artist
	@Test
	void testGetSetArtist() {
		// Arrange
		AddSongRequest addSongRequest = new AddSongRequest();
		addSongRequest.setArtist("TestArtist");

		// Act
		String artist = addSongRequest.getArtist();

		// Assert
		assertEquals("TestArtist", artist);
	}

	// testing get set name
	@Test
	void testGetSetName() {
		// Arrange
		AddSongRequest addSongRequest = new AddSongRequest();
		addSongRequest.setName("TestName");

		// Act
		String name = addSongRequest.getName();

		// Assert
		assertEquals("TestName", name);
	}

	// testing no args constructor
	@Test
	void testNoArgsConstructor() {
		// Arrange and Act
		AddSongRequest addSongRequest = new AddSongRequest();

		// Assert
		assertNotNull(addSongRequest);
	}
}

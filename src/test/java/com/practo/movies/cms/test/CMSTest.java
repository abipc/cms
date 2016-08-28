package com.practo.movies.cms.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.practo.movies.cms.constants.MovieType;


public class CMSTest {

	@Test
	public void test() {
		assertEquals("Test Result for Get All Different Movie Types", 
				MovieType.getAllMovieType(), 4);
	}

}

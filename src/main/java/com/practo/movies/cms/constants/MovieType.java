package com.practo.movies.cms.constants;

public enum MovieType {
	FILM(),
	DOCUMENTARY(),
	TV_SERIES();
	
	public static int getAllMovieType() {
		return MovieType.values().length;
	}

}

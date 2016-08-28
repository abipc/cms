package com.practo.movies.cms.manager;

import java.util.List;
import java.util.Map;

import com.practo.movies.cms.models.request.MovieSearchRequestModel;
import com.practo.movies.cms.models.request.MovieUpsertRequestModel;
import com.practo.movies.cms.utils.HTTPUtil;

public class CMSManager {
	
	public static Map<String, Object> searchMovie(Map<String, Object> query) {
		/**
		 * Search Service SOLR returns search results
		 */
		Map<String, Object> result = HTTPUtil.httpPOST(query);
		return result;
	}

	public static Map<String, Object> searchMovie(MovieSearchRequestModel searchMovie) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void upsertMovie(MovieUpsertRequestModel data) {
		// TODO Auto-generated method stub
		
	}


	public static void deleteMovie(List<String> data) {
		// TODO Auto-generated method stub
		
	}
}

package com.practo.movies.cms.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.practo.movies.cms.manager.CMSManager;
import com.practo.movies.cms.models.request.MovieSearchRequestModel;
import com.practo.movies.cms.models.request.MovieUpsertRequestModel;
import com.practo.movies.cms.utils.ObjMapperFactory;

/**
 * 
 * @author dell
 *
 * RESTful APIs for Movie CRUD
 * Search has 2 APIs - GET and POST to handle query params more than
 * 256 length
 * Search requests are served by Search Service - SOLR
 */

@Controller
@RequestMapping("/")
public class CMSController {
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/movie", method = RequestMethod.GET)
    public @ResponseBody String getMovieDetails(HttpServletRequest request,
    		HttpServletResponse response) throws Exception {
    	Map<String, Object> query = ObjMapperFactory.getQueryParams(request);
    	Map<String, Object> data = CMSManager.searchMovie(query);  		
    	return ObjMapperFactory.getMovieResponse(data);
    }
    
    /**
     * 
     * @param searchMovie
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/movie/search", method = RequestMethod.POST)
    public @ResponseBody String searchMovie(@RequestBody MovieSearchRequestModel 
    		searchMovie)  throws Exception {
    	Map<String, Object> data = CMSManager.searchMovie(searchMovie);  		
    	return ObjMapperFactory.getMovieResponse(data);
    }    
   
    /**
     * 
     * @param data
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/movie", method = RequestMethod.POST)
    public @ResponseBody String upsertMovie(@RequestBody MovieUpsertRequestModel data)  
    		throws Exception{
    	CMSManager.upsertMovie(data);
    	return ObjMapperFactory.getSuccessData();
    }
	
	/**
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/movie", method = RequestMethod.DELETE)
    public @ResponseBody String deleteMovie(@RequestBody List<String> data)  throws Exception{
    	CMSManager.deleteMovie(data);
    	return ObjMapperFactory.getSuccessData();
    }	

}

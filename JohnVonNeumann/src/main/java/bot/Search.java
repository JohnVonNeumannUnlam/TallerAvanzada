package bot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;


public class Search extends Application{

	  private static String PROPERTIES_FILENAME = "youtube.properties";

	  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	  private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	  private static final long NUMBER_OF_VIDEOS_RETURNED = 1;

	  private static YouTube youtube;

	  
	  public String resolver(String query) throws IOException {
		  
	    Properties properties = new Properties();
	    try {
	      InputStream in = Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
	      properties.load(in);

	    } catch (IOException e) {
	      System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
	          + " : " + e.getMessage());
	      System.exit(1);
	    }

	    String result = null;
	    
	      youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
	        public void initialize(HttpRequest request) throws IOException {}
	      }).setApplicationName("youtube-cmdline-search-sample").build();
	      
	      YouTube.Search.List search = youtube.search().list("id,snippet");
	      String apiKey = properties.getProperty("youtube.apikey");
	      search.setKey(apiKey);
	      search.setQ(query);
	      search.setType("video");
	      search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
	      search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
	      SearchListResponse searchResponse = search.execute();
	      
	      List<SearchResult> searchResultList = searchResponse.getItems();
      
	      if (searchResultList != null) 
	      
    	 result= prettyPrint(searchResultList.iterator(), query);
		 return result;
	    
  }


  public String prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {

	  String video =null;

    if (iteratorSearchResults.hasNext()) {

      SearchResult singleVideo = iteratorSearchResults.next();
      ResourceId rId = singleVideo.getId();
     
      if (rId.getKind().equals("youtube#video")) {
          
          video =rId.getVideoId();  
      
     }
    }
    
	return video;
	
	
  }
  
  
  public static void main(String[] args) throws IOException {
	
	  //Search s = new Search();
	 // String a =s.resolver();
	  //System.out.println(a);
	  launch(args);
	  
//	  Search sh = new Search();
//	  sh.resolver("duki");
	  
}


public void start(Stage primaryStage) throws Exception {
	
	 Search a = new Search();
	 String vi=a.resolver("duki");
	 String content_Url = "<iframe width=\"560\" height=\"315\" src=\"http://www.youtube.com/embed/"+vi+"\" frameborder=\"0\" allowfullscreen></iframe>";
	  
	    WebView webView = new WebView();
     WebEngine webEngine = webView.getEngine();
     webEngine.loadContent(content_Url);

     StackPane root = new StackPane();
     root.getChildren().add(webView);

     Scene scene = new Scene(root, 600, 450);

     primaryStage.setTitle("Video");
     primaryStage.setScene(scene);
     primaryStage.show();
}
}
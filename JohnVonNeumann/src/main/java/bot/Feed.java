package bot;

import java.util.ArrayList;
import java.util.List;

public class Feed {
	
    final String title;
    final String link;

    final List<FeedMessage> entries = new ArrayList<FeedMessage>();

    public Feed(String title, String link) {
        this.title = title;
        this.link = link;

    }

    public List<FeedMessage> getMessages() {
       
		return entries;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Link=" + link +", Title=" + title;
    }


}
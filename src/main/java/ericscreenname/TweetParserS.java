package ericscreenname;

import org.apache.htrace.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import org.apache.htrace.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetParserS {
    String screen_name_text = "";
    String user_text ="";

    public TweetParserS(){

    }

    @SuppressWarnings("unchecked")
    @JsonProperty("user")
    private void helper(Map<String,Object> user_text) {
        this.user_text = (String)user_text.get("screen_name");

    }

    public String geScreenName() {
        return user_text;
    }
}

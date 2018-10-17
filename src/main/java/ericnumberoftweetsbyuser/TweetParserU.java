package ericnumberoftweetsbyuser;


import org.apache.htrace.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import org.apache.htrace.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class TweetParserU {
    String id_str = "";
    String screen_name ="";


    public TweetParserU(){

    }

    @SuppressWarnings("unchecked")
    @JsonProperty("user")
    private void helper(Map<String,Object> user_text) {
        this.screen_name = (String)user_text.get("screen_name");

    }

    public String getUser_name() {
        return screen_name;
    }

    public String getId_str() {
        return id_str;
    }

}

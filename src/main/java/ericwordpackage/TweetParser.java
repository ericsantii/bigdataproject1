package ericwordpackage;

import org.apache.htrace.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import org.apache.htrace.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetParser {
    String text = "";
    String ex_tweet ="";

    public TweetParser(){

    }

    @SuppressWarnings("unchecked")
    @JsonProperty("extended_tweet")
    private void helper(Map<String,Object> extended_tweet) {
        this.ex_tweet = (String)extended_tweet.get("full_text");

    }

    public String getExtendedTweet() {
        return ex_tweet;
    }
}

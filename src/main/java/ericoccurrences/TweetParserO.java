package ericoccurrences;

import org.apache.htrace.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import org.apache.htrace.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetParserO {
    String text = "";
    String extended_tweet_text ="";

    public TweetParserO(){

    }

    @SuppressWarnings("unchecked")
    @JsonProperty("extended_tweet")
    private void helper(Map<String,Object> extended_tweet) {
        this.extended_tweet_text = (String)extended_tweet.get("full_text");

    }

    public String getText() {
        return text;
    }

    public String getExtended_tweet_text() {
        return extended_tweet_text;
    }
}

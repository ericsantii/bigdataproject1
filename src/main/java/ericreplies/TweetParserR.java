package ericreplies;


import org.apache.htrace.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetParserR {
    String in_reply_to_status_id_str;
    String id_str;

    public TweetParserR(){

    }

    public String getIn_reply_to_status_id_str() {
        return in_reply_to_status_id_str;
    }

    public String getId_str() {
        return id_str;
    }
}

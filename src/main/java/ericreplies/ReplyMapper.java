package ericreplies;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ReplyMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        TweetParserR tweet = mapper.readValue(value.toString(), TweetParserR.class);
        if(tweet.getIn_reply_to_status_id_str()!= null) {
            context.write(new Text(tweet.getIn_reply_to_status_id_str()), new Text(tweet.getId_str()));
        }

    }
}

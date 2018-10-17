package ericnumberoftweetsbyuser;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


public class NumTUserMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        TweetParserU tweet = mapper.readValue(value.toString(), TweetParserU.class);
            context.write(new Text(tweet.getUser_name()), new Text(tweet.getId_str()));


    }
}

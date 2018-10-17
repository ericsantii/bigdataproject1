package ericscreenname;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ScreenMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        TweetParserS tweet = mapper.readValue(value.toString(), TweetParserS.class);
        context.write(new Text(tweet.geScreenName()), new IntWritable(1));

    }
}

package ericreplies;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
public class ReplyReducer extends Reducer<Text, Text, Text, Text>{
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        String replies = "";


        for (Text reply : values) {
            replies += reply.toString()+" ";
        }
        context.write(key, new Text(replies));
    }
}

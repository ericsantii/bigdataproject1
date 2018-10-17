package ericreplies;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class ReplyMapperTwo extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String ids[] = value.toString().split("\\s+");

        context.write(new Text(ids[0]), new IntWritable(ids.length-1));

    }
}

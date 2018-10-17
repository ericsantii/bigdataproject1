package ericnumberoftweetsbyuser;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.IntWritable;

public class NumTUserDriver {
    public static void main(String[] args) throws Exception {

        if (args.length != 3) {
            System.out.println(args.length);
            System.err.println("Usage: NumTUserDriver <input path> <output path> <temp path>");
            System.exit(-1);
        }

        Job findJob = new Job();
        findJob.setJarByClass(NumTUserDriver.class);
        findJob.setJobName("Part1:Find tweets by user");

        FileInputFormat.addInputPath(findJob, new Path(args[0]));
        FileOutputFormat.setOutputPath(findJob, new Path(args[2]));

        findJob.setMapperClass(NumTUserMapper.class);
        findJob.setReducerClass(NumTUserReducer.class);

        findJob.setOutputKeyClass(Text.class);
        findJob.setOutputValueClass(Text.class);

        findJob.waitForCompletion(true);

        Job countJob = new Job();
        countJob.setJarByClass(NumTUserDriver.class);
        countJob.setJobName("Count up tweets by user");

        FileInputFormat.addInputPath(countJob, new Path(args[2]+"/part-r-00000"));
        FileOutputFormat.setOutputPath(countJob, new Path(args[1]));

        countJob.setMapperClass(MapperTwo.class);
        countJob.setReducerClass(ReducerTwo.class);

        countJob.setOutputKeyClass(Text.class);
        countJob.setOutputValueClass(IntWritable.class);

        System.exit(countJob.waitForCompletion(true) ? 0 : 1);
    }
}

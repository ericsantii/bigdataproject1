package ericwordpackage;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        TweetParser tweet = mapper.readValue(value.toString(), TweetParser.class);
        List<String> words = new ArrayList<>(Arrays.asList(tweet.getExtendedTweet().split("\\s")));
        String stopwords[] = {"i", "it's", "i’m", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its", "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that", "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while", "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than", "too", "very", "s", "t", "can", "will", "just", "don", "should", "now"};

        List<String> stopwordslist = new ArrayList<>(Arrays.asList(stopwords));

        for(String word: words){
            String curr = word.toLowerCase().trim().replaceAll("[^a-zA-Z]+$", "").replaceFirst("^[^a-zA-Z]+", "");
            if (!stopwordslist.contains(curr)){
                context.write(new Text(curr), new IntWritable(1));
            }
        }

    }

}


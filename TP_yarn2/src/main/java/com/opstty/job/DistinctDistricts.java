package com.opstty.job;
import com.opstty.mapper.TreesMapper;
import com.opstty.reducer.TreesReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistinctDistricts {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: distinctDistricts <in> [<in>...] <out>");
            System.exit(2);
        }
            Job job = Job.getInstance(conf, "distinctDistricts");
            job.setJarByClass(DistinctDistricts.class);
            job.setMapperClass(TreesMapper.class);
            job.setCombinerClass(TreesReducer.class);
            job.setReducerClass(TreesReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(NullWritable.class);

        }
    }

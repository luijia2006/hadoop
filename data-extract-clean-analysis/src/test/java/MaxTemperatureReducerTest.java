import cn.xpleaf.dataClean.mr.reducer.MaxTemperatureReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
 
public class MaxTemperatureReducerTest {
	@Test
	public void testRetrunsMaximumIntegerValues() throws IOException {
		new ReduceDriver<Text, IntWritable, Text, IntWritable>()
				//设置Reducer
				.withReducer(new MaxTemperatureReducer())
				//设置输入key和List
				.withInput(new Text("1950"),  Arrays.asList(new IntWritable(10), new IntWritable(5)))
				//设置期望输出
				.withOutput(new Text("1950"), new IntWritable(10))
				//运行测试
				.runTest();
	}
}

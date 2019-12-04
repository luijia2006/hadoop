import java.io.IOException;

import cn.xpleaf.dataClean.mr.mapper.MaxTemperatureMapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Test;
 

public class MaxTemperatureMapperTest {
	@Test
	public void testParsesValidRecord() throws IOException {
		Text value = new Text("0043011990999991950051518004+68750+023550FM-12+0382" +
		// ++++++++++++++++++++++++++++++year ^^^^
				"99999V0203201N00261220001CN9999999N9-00111+99999999999");
		// ++++++++++++++++++++++++++++++temperature ^^^^^
		// 由于测试的mapper，所以适用MRUnit的MapDriver
		new MapDriver<LongWritable, Text, Text, IntWritable>()
				// 配置mapper
				.withMapper(new MaxTemperatureMapper())
				// 设置输入值
				.withInput(new LongWritable(0), value)
				// 设置期望输出：key和value
				.withOutput(new Text("1950"), new IntWritable(-11)).runTest();
	}
 
	@Test
	public void testParseMissingTemperature() throws IOException {
		// 根据withOutput()被调用的次数， MapDriver能用来检查0、1或多个输出记录。
		// 在这个测试中由于缺失的温度记录已经被过滤，保证对这种特定输入不产生任何输出
		Text value = new Text("0043011990999991950051518004+68750+023550FM-12+0382" +
		// ++++++++++++++++++++++++++++++Year ^^^^
				"99999V0203201N00261220001CN9999999N9+99991+99999999999");
		// ++++++++++++++++++++++++++++++Temperature ^^^^^
		new MapDriver<LongWritable, Text, Text, IntWritable>()
				.withMapper(new MaxTemperatureMapper())
				.withInput(new LongWritable(0), value)
				.runTest();
	}
}

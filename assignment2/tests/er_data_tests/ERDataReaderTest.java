package er_data_tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import er_data.ERDataReader;

public class ERDataReaderTest {
	private static final int DEFAULT_WEEKS = 4;
	private static final int DEFAULT_DAYS = 7;
	private static final int DEFAULT_HOURS = 24;

	// Data file containing the same values generated by generateTestData()
	private static final String TEST_DATA_FILE = "data/test_data.txt"; 
	
	private static int[][][] generateTestData() {
		int[][][] data = new int[DEFAULT_WEEKS][DEFAULT_DAYS][DEFAULT_HOURS];
		
		for (int week = 0; week < DEFAULT_WEEKS; week++) {
			for (int day = 0; day < DEFAULT_DAYS; day++) {
				for (int hour = 0; hour < DEFAULT_HOURS; hour++) {
					data[week][day][hour] = week + day + hour;
				}
			}
		}
		return data;
	}
	
	/*
	 * Tests the ERDataReader.readData() function. We read values from the "data/test_data.txt" file,
	 * then compare those values with the values from the generateTestData() function.  The values should be the same.
	 * Remember, your readData method must read from the file indicated by the dataFile parameter. If your
	 * readData method has been hard-coded to read from a specific file, your test will fail.  
	 */
	@Test
	public void testReadData() 
			throws FileNotFoundException, NoSuchElementException, IllegalStateException, IOException, Exception {
		
		int[][][] expecteds = generateTestData();
		int[][][] actuals = ERDataReader.readData(TEST_DATA_FILE);
		
		assertArrayEquals(expecteds, actuals);
	}

}

package org.hcl.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RemoveDuplicatesFromExcel {

	private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";

	private static final String EXCEL_PATH = RESOURCE_PATH + "/excel/testData.xlsx";

	public static String getExcelPath() {
		return EXCEL_PATH;
	}

	public static void main(String[] args) throws IOException {

		Object[] arrayOfHashMap = getData();
		Set<Map<String, Object>> uniqueElements = new HashSet<>();

		System.out.println("==============befor removing duplicates=============");
		for (Object element : arrayOfHashMap) {
			// Check if the element is a HashMap
			if (element instanceof HashMap) {
				// Extract data from the HashMap
				Map<String, Object> hashMap = (HashMap<String, Object>) element;
				System.out.println(hashMap);
			}
		}

		// Iterate over the Object[] array
		for (Object element : arrayOfHashMap) {
			// Check if the element is a HashMap
			if (element instanceof HashMap) {
				// Add the HashMap to the Set (duplicates will be automatically removed)
				uniqueElements.add((HashMap<String, Object>) element);
			}
		}

		System.out.println("=============after removing duplicates=================");
		uniqueElements.stream().forEach(a -> System.out.println(a));

	}

	public static Object[] getData() throws IOException {

		FileInputStream fis = new FileInputStream(new File(getExcelPath()));

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rowNumber = sheet.getLastRowNum();

		int columnNumber = sheet.getRow(0).getLastCellNum();

		Object[] data = new Object[rowNumber];// array of objects[list/hashmap..etc]
		Map<String, String> map;// store [header +row] as a map 1
		for (int i = 1; i <= rowNumber; i++) {
			map = new HashMap<>();
			for (int j = 0; j < columnNumber; j++) {

				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i - 1] = map; // map1 in array[0]

			}

		}
		wb.close();
		fis.close();

		return data;// return array of hashmap
	}

}

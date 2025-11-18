package utillity;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
	
	@DataProvider(name="logindata")
	public String[][] setdata() throws IOException {
		
		String path="C:\\Users\\M MAHESH NAIK\\eclipse-workspace\\bts\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility utils=new ExcelUtility(path);
		int rowcount = utils.getRowCount("Sheet1");
		int cellcount = utils.getCellCount("Sheet1", 1);
		
		String inputdata[][]=new String[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<cellcount;j++) {
				
				inputdata[i-1][j]=utils.getCellData("Sheet1", i, j);
				
			}
		}
		return inputdata;
		
	}

}

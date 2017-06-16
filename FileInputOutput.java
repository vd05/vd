package com.nu.FileInputOutput;

import java.io.*;

import com.nu.ValidationFunction.*;

public class FileInputOutput {
	public static void main(String[] args) throws IOException {
		DataTypeValidation type = new DataTypeValidation();
		DataLengthValidation len = new DataLengthValidation();
		SpecialCharactersValidation specialChar = new SpecialCharactersValidation();
		DomainValueValidation domain = new DomainValueValidation();
		EmailValidation email = new EmailValidation();
		FormatValidation format = new FormatValidation();
		int flag=1;
		String recordValidvalues[]={"N","M","D","A","R"};
		String flagValues[]={"A","I"};
		BufferedReader br = null;
		boolean result1=true,result2=true;

		try {
			br = new BufferedReader(new FileReader("D:\\File2.txt"));
			String contentLine = br.readLine();
			while (contentLine != null) {
				
				String[] line = contentLine.split("~");
				boolean dataType[] = { type.dTV(line[0], "ALPHANUMERIC"),
						type.dTV(line[1], "ALPHANUMERIC"),
						type.dTV(line[2], "CHAR"),
						type.dTV(line[3], "CHAR"),
						type.dTV(line[4], "INTEGER"),
						email.emailValidation(line[5]),
						type.dTV(line[6], "INTEGER"),
						type.dTV(line[7], "ALPHANUMERIC"),
						domain.domainValueValidation(line[8], recordValidvalues),
						domain.domainValueValidation(line[9], flagValues),
						format.formatValidation(line[10], "dd/mm/yyyy"),
						type.dTV(line[11], "ALPHANUMERIC") };
				boolean length[] = { len.dLV(line[0], 10),
						len.dLV(line[1], 30), len.dLV(line[2], 100),
						len.dLV(line[3], 100), len.dLV(line[4], 6),
						len.dLV(line[5], 100), len.dLV(line[6], 20),
						len.dLV(line[7], 100), len.dLV(line[8], 1),
						len.dLV(line[9], 1), len.dLV(line[10], 12),
						len.dLV(line[11], 30) };
			
      for(int j=0;j<(line.length-3);j++){
		result1= dataType[j];
    	  result2=length[j];
    	  
      if(result1==false)
		  System.out.println("issue in data type of record no:"+flag+"  field no:"+(j+1));
	  if(result2==false)
		  System.out.println("issue in lemgth of record no:"+flag+"  field no:"+(j+1));
			
      }
      
      flag++;
      contentLine = br.readLine();	
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
				System.out.println("Error in closing the BufferedReader");
			}
		}
	}
}

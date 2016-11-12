package br.com.ufc.quixada.dbscan.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.dbscan.model.Point;
import br.com.ufc.quixada.dbscan.utils.Utils;

public class RetrieveData {
	
	public List<Point> getDataSetFromFile(String pathCSV) throws IOException {
		Utils utils = new Utils();
		String csvFile = pathCSV;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		String[] result = null;

		List<Point> dataSet = new ArrayList<>();
		Point point = null;
		try {

			br = new BufferedReader(new FileReader(csvFile));
			int i = 1;
			while ((line = br.readLine()) != null) {
				result = line.split(cvsSplitBy);
				
				if (result[0] == null || result[0].equals(""))
					continue;

				Integer idTaxi = Integer.valueOf(result[0]);
				Timestamp time = utils.getTime(result[1]);
				BigDecimal latitude = new BigDecimal(result[2]);
				BigDecimal longitude = new BigDecimal(result[3]);

				point = new Point();
				point.setIdTaxi(idTaxi);
				point.setTime(time);
				point.setLatitude(latitude);
				point.setLongitude(longitude);
				point.setIdPonto(i);

				dataSet.add(point);
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return dataSet;
	}


}

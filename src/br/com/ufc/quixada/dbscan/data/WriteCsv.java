package br.com.ufc.quixada.dbscan.data;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.ufc.quixada.dbscan.model.Point;

public class WriteCsv {
	
String outputPath= "/home/lionel/Dropbox/Topicos/Clusters/SegundaTesteEPSMenor/segunda";
	
	
    private static final String CSV_SEPARATOR = ";";
       
    public  void writeToCSV(List<Point> points, Integer idCluster){
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath + "_" + idCluster+".csv"), "UTF-8"));
            for (Point point : points){
                StringBuffer oneLine = new StringBuffer();
                            
                oneLine.append(point.getIdTaxi());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.getTime());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.getLongitude());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.getLatitude());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.getIdPonto());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.getIdCluster());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.getDist());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.isCore());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.isNoise());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(point.isVisit());
                
                System.out.println(oneLine);
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }


}

package br.com.ufc.quixada.dbscan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.quixada.dbscan.data.RetrieveData;
import br.com.ufc.quixada.dbscan.data.WriteCsv;
import br.com.ufc.quixada.dbscan.model.Cluster;
import br.com.ufc.quixada.dbscan.model.Point;
import br.com.ufc.quixada.dbscan.utils.Utils;

public class Dbscan {
	
	public static void main(String[] args) throws Exception {
		/*String path = "/home/lionel/Dropbox/Topicos/segunda.csv";*/
		/*String path = "/home/lionel/Dropbox/Topicos/SegundaConjuntoTeste.csv";*/
		/*String path = "/home/lionel/Dropbox/Topicos/tdriveQuintaLimpo.csv";*/
		/*String path = "/home/lionel/Dropbox/Topicos/SegundaConjuntoTeste3.csv";*/
		/*String path = "/home/lionel/Dropbox/Topicos/segundaReduzido.csv";*/
		String path = "/home/lionel/Dropbox/Topicos/segundaFinal.csv";
		
		try {
			List<Point> dataSet = new RetrieveData().getDataSetFromFile(path);
			/*runDBscan(dataSet, 0.001, 50); Primeiro teste; segundo: 300 */
			/*runDBscan(dataSet, 0.001, 300); */
			runDBscan(dataSet, 0.0001, 300);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void runDBscan(List<Point> dataSet, double eps, int minPts) throws Exception{
		Utils utils = new Utils();
		ExpandCluster expandCluster = new ExpandCluster();
		WriteCsv ws= new WriteCsv();
		Cluster cluster = null;
		Cluster clusterResult = new Cluster();
		List<Point> neighborPts = new ArrayList<>();
		List<Cluster> clusters = new ArrayList<>();
		
		int i = 1;
		for (Point point : dataSet) {
			if (!point.isVisit()) {
				point.setVisit(true);
				
				neighborPts = utils.regionQuery(eps, point, dataSet);
				
				
				if (neighborPts.size()  < minPts) {
					point.setNoise(true);
				} else {
					cluster = new Cluster();
					point.setCore(true);
					cluster.setIdCluster(i);
					clusterResult = expandCluster.expandCluster(point, neighborPts, cluster, eps, minPts, dataSet);										
				}
			}
			i++;
			clusters.add(clusterResult);
		}
				System.out.println();
				
		for (Cluster c : clusters) {				
			if(c.getPoints().size() >= minPts){
				ws.writeToCSV(c.getPoints(), c.getIdCluster());
			}
		}						
	} 


}

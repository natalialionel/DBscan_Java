package br.com.ufc.quixada.dbscan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.ufc.quixada.dbscan.model.Cluster;
import br.com.ufc.quixada.dbscan.model.Point;
import br.com.ufc.quixada.dbscan.utils.Utils;

public class ExpandCluster {
	
public Cluster expandCluster(Point point, List<Point> neighborPts, Cluster cluster, double eps, int minPts, List<Point> dataSet) throws Exception{
		
		Utils utils = new Utils();
		List<Point> neighborPtsAUX = new ArrayList<>();		
		
		Cluster clusterResult = cluster;
		
		point.setIdCluster(clusterResult.getIdCluster());
		clusterResult.getPoints().add(point);		
		
		for (Point p : neighborPts) {
			
			if (!p.isVisit()) {
				p.setVisit(true);
				neighborPtsAUX = utils.regionQuery(eps, p, dataSet);
				
				if (neighborPtsAUX.size() >= minPts) {
					neighborPts = union(neighborPts, neighborPtsAUX);
				}
			}
			if (p.getIdCluster() == 0) {
				p.setVisit(true);
				p.setIdCluster(clusterResult.getIdCluster());
				clusterResult.getPoints().add(p);
			}			
		}			
		return clusterResult;
	}
		
	public <T> List<T> union(List<T> list1, List<T> list2) {
		Set<T> set = new HashSet<T>();

		set.addAll(list1);
		set.addAll(list2);

		return new ArrayList<T>(set);
	}
	


}

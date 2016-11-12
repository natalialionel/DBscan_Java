package br.com.ufc.quixada.dbscan.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.ufc.quixada.dbscan.model.Point;

public class Utils {
	
	public Timestamp getTime(String time){
		Timestamp timestamp = null;
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    Date parsedDate = dateFormat.parse(time);
		    timestamp = new java.sql.Timestamp(parsedDate.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return timestamp;
	}
	
	public List<Point> regionQuery(double eps, Point point, List<Point> dataSet) {
		
		List<Point> neighborPts = new ArrayList<>();
		double longitudePoint = point.getLongitude().doubleValue();
		double latitudePoint = point.getLatitude().doubleValue();
		
		for (Point p : dataSet) {
			
			double longitudeOther = p.getLongitude().doubleValue();
			double latitudeOther = p.getLatitude().doubleValue();

			double euclideanDist = getEuclidean(longitudePoint, latitudePoint, longitudeOther, latitudeOther);
			point.setDist(euclideanDist);
			neighborPts.add(point);
			
			if (point.getIdPonto() != p.getIdPonto() && euclideanDist <= eps) {
				
				neighborPts.add(p);
			}

		}
		neighborPts = removeDuplicates(neighborPts);  
		
		//printNeighbors(point, neighborPts);		

		return neighborPts;
	}
	
	public double getEuclidean(double longitudePoint, double latitudePoint, double longitudeOther, double latitudeOther){
		double euclidean = 0.0;
		double  xDiff = longitudePoint - longitudeOther;
	    double  xSqr  = Math.pow(xDiff, 2);

		double yDiff = latitudePoint - latitudeOther;
		double ySqr = Math.pow(yDiff, 2);

		euclidean  = Math.sqrt(xSqr + ySqr);
		return euclidean;
	}
	
	public void printNeighbors(Point point, List<Point> dataSet){
		for (int i = 0; i < dataSet.size(); i++) {
			System.out.println("o ponto é = " + point.getIdPonto() +
					" o seu vizinho é o ponto com o id = " + dataSet.get(i).getIdPonto());
		}
	}
	
	public List<Point> removeDuplicates(List<Point> neighborPts) {
		Set<Point> set = new HashSet<Point>();
		
		set.addAll(neighborPts);
		
		return new ArrayList<Point>(set);
	}

}

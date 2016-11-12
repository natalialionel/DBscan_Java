package br.com.ufc.quixada.dbscan.model;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
	
	private Integer idCluster;
	private List<Point> points;
	
	public Cluster(){
		this.points = new ArrayList<>();
	}

	public Integer getIdCluster() {
		return idCluster;
	}

	public void setIdCluster(Integer idCluster) {
		this.idCluster = idCluster;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Cluster [idCluster=" + idCluster + ", points=" + points + "]";
	}


}

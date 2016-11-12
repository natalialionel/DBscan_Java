package br.com.ufc.quixada.dbscan.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Point {
	private static final long serialVersionUID = -3559249782205050662L;
	private Integer idPonto;
	private Integer idTaxi;
	private Integer idCluster;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private boolean isNoise;
	private boolean isCore;
	private Timestamp time;
	private Double dist;
	private boolean visit;
	
	public Point(){
		this.idCluster = 0;
		this.visit = false;
		this.dist = 0.0;
	}

	public Integer getIdPonto() {
		return idPonto;
	}

	public void setIdPonto(Integer idPonto) {
		this.idPonto = idPonto;
	}

	public Integer getIdTaxi() {
		return idTaxi;
	}

	public void setIdTaxi(Integer idTaxi) {
		this.idTaxi = idTaxi;
	}

	public Integer getIdCluster() {
		return idCluster;
	}

	public void setIdCluster(Integer idCluster) {
		this.idCluster = idCluster;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public boolean isNoise() {
		return isNoise;
	}

	public void setNoise(boolean isNoise) {
		this.isNoise = isNoise;
	}

	public boolean isCore() {
		return isCore;
	}

	public void setCore(boolean isCore) {
		this.isCore = isCore;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Double getDist() {
		return dist;
	}

	public void setDist(Double dist) {
		this.dist = dist;
	}

	public boolean isVisit() {
		return visit;
	}

	public void setVisit(boolean visit) {
		this.visit = visit;
	}

/*	@Override
	public String toString() {
		return "[ " + idPonto +  " ]";
	}
*/	

	 @Override public String toString() { return "Point [idPonto=" + idPonto +
	 ", idTaxi=" + idTaxi + ", idCluster=" + idCluster + ", longitude=" +
	 longitude + ", latitude=" + latitude + ", isNoise=" + isNoise +
	 ", isCore=" + isCore + ", time=" + time + ", dist=" + dist + ", visit=" +
	 visit + "]\n"; }


}

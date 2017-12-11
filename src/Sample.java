package src;

import java.util.ArrayList;

/**
 * Date: 23-11-2017 This class represents a sample of all the WiFiNetworks
 * scanned at the same time , in the same location and by the same device. This
 * sample contains all the WiFiNetworks in an ArrayList.
 * 
 * @author Kineret Ruth Nahary & Yakir Amar
 *
 */
public class Sample implements Comparable<Sample> {

	private String ID, Time, LAT, LON, ALT;
	private double PI;
	private ArrayList<WiFiNetwork> commonNetworks;
	private int commonNetworksSize;

	/**
	 * Default constructor
	 */
	public Sample() {
		this.ID = "";
		this.Time = "";
		this.LAT = "";
		this.LON = "";
		this.ALT = "";
		this.PI = 0;
		this.commonNetworks = new ArrayList<WiFiNetwork>();
		this.commonNetworksSize = 0;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param ID
	 * @param Time
	 * @param LAT
	 * @param LON
	 * @param ALT
	 */
	public Sample(String ID, String Time, String LAT, String LON, String ALT, double IP) {
		this.ID = ID;
		this.Time = Time;
		TimeCorrector tc = new TimeCorrector();
		tc.correctAndSetTime(this.Time);
		this.LAT = LAT;
		this.LON = LON;
		this.ALT = ALT;
		this.PI = IP;
		this.commonNetworks = new ArrayList<WiFiNetwork>();
		this.commonNetworksSize = this.commonNetworks.size();
	}

	public Sample(Sample s) {
		this.ID = s.getID();
		this.Time = s.getTime();
		this.LAT = s.getLAT();
		this.LON = s.getLON();
		this.ALT = s.getALT();
		this.commonNetworks = s.getCommonNetworks();
		this.commonNetworksSize = s.getNetworksAmount();
	}

	/**
	 * This function adds a given network to this Sample.
	 * 
	 * @param network
	 *            a given WiFiNetwork.
	 */
	public void addNetwork(WiFiNetwork network) {
		this.commonNetworks.add(network);
	}

	/**
	 * 
	 * @return this Sample's ID.
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * 
	 * @return this Sample's Time.
	 */
	public String getTime() {
		return this.Time;
	}

	/**
	 * 
	 * @return this Sample's latitude.
	 */
	public String getLAT() {
		return this.LAT;
	}

	/**
	 * 
	 * @return this Sample's longitude.
	 */
	public String getLON() {
		return this.LON;
	}

	/**
	 * 
	 * @return this Sample's altitude.
	 */
	public String getALT() {
		return this.ALT;
	}

	public double getPI() {
		return this.PI;
	}

	public void setPI(double PI) {
		this.PI = PI;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public void setTime(String time) {
		this.Time = time;
	}

	public void setLAT(String lAT) {
		this.LAT = lAT;
	}

	public void setLON(String lON) {
		this.LON = lON;
	}

	public void setALT(String aLT) {
		this.ALT = aLT;
	}

	/**
	 * 
	 * @return this Sample's WiFiNetworks.
	 */
	public ArrayList<WiFiNetwork> getCommonNetworks() {
		return this.commonNetworks;
	}

	/**
	 * This function sets this commonNetworks ArrayList with a given
	 * WiFiNetwork's ArrayList.
	 * 
	 * @param commonNetworks
	 *            a given WiFiNetwork's ArrayList.
	 */
	public void setCommonNetworks(ArrayList<WiFiNetwork> commonNetworks) {
		this.commonNetworks = commonNetworks;
	}

	/**
	 * 
	 * @return this commonNetworks' ArrayList size.
	 */
	public int getNetworksAmount() {
		return this.commonNetworks.size();
	}

	public void setNetworksAmount(int size) {
		this.commonNetworksSize = size;
	}

	/**
	 * 
	 * @return prints this Sample information with this commonNetworks'
	 *         ArrayList size.
	 */
	public String printSampleInfo() {
		return this.Time + "," + this.ID + "," + this.LAT + "," + this.LON + "," + this.ALT + "," + getNetworksAmount();
	}

	/**
	 * This function compares the given parameters with this Sample parameters
	 * to check if they are equal.
	 * 
	 * @param Time
	 *            a given time.
	 * @param LAT
	 *            a given latitude.
	 * @param LON
	 *            a given longitude.
	 * @param ALT
	 *            a given altitude.
	 * @return true if this Time & LAT & LON & ALT are equal to the given
	 *         parameters, false if not.
	 */
	public String getTimeInKML() {
		TimeCorrector tc = new TimeCorrector();
		return tc.setTimeKMLFormat(this.Time);
	}

	/**
	 * This function checks if a given WiFi network is to be added to a specific
	 * sample.
	 * 
	 * @param Time
	 *            a giver time.
	 * @param LAT
	 *            a given latitude.
	 * @param LON
	 *            a given longitude.
	 * @param ALT
	 *            a given altitude.
	 * @return true if it belongs to the same sample- all params are equal.
	 */
	public boolean checkToAddToSample(String Time, String LAT, String LON, String ALT) {
		return compareTime(Time) && compareLAT(LAT) && compareLON(LON) && compareALT(ALT);
	}

	// /**
	// * This function checks if a given mac appears in a specific sample, if so
	// it returns the Wifi network,
	// * @param mac a given mac.
	// * @return a WiFi network that has the same mac.
	// */
	// public WiFiNetwork ifContainMac(String mac){
	// for(WiFiNetwork wn : this.commonNetworks){ //run over all networks in
	// sample
	// if(wn.getMAC()==mac)
	// return wn;
	// break;
	// }
	// return new WiFiNetwork(); //need to always check if the returned sample
	// is empty, if so don't add to the new array.
	// }
	/**
	 * A function of Comparable. This function compares IPs of the current
	 * Sample and another Sample.
	 * 
	 * @return returns 1\0\-1 if the current Sample's IP is bigger\equal\smaller
	 *         than the other.
	 */
	public int compareTo(Sample s) {

		return (this.getPI() + "").compareTo((s.getPI() + ""));
	}

	// ***************************PRIVATE*****************************
	/**
	 * 
	 * @param Time
	 *            a given time.
	 * @return true if this Time and the given time are equal, false if not.
	 */
	private boolean compareTime(String Time) {
		return this.Time.equals(Time);
	}

	/**
	 * 
	 * @param LAT
	 *            a given latitude.
	 * @return true if this LAT and the given latitude are equal, false if not.
	 */
	private boolean compareLAT(String LAT) {
		return this.LAT.equals(LAT);
	}

	/**
	 * 
	 * @param LON
	 *            a given longitude.
	 * @return true if this LON and the given longitude are equal, false if not.
	 */
	private boolean compareLON(String LON) {
		return this.LON.equals(LON);
	}

	/**
	 * 
	 * @param ALT
	 *            a given altitude.
	 * @return true if this ALT and the given altitude are equal, false if not.
	 */
	private boolean compareALT(String ALT) {
		return this.ALT.equals(ALT);
	}

}

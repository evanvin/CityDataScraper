import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class CityData {

	public static void main(String[] args) throws IOException {
		
		//C:\Users\evinciguerra\Desktop\tests.csv
		
		String filename = JOptionPane.showInputDialog(null, "Where would you like to save the file? format: /asdf/asdf/x.csv",
				"Enter a filename and location", JOptionPane.QUESTION_MESSAGE);
		
		int pageStart = Integer.parseInt(JOptionPane.showInputDialog(null, "What page would you like to start on?",
				"Starting Page", JOptionPane.QUESTION_MESSAGE));
		
		String url = "http://www.city-data.com/zipDir.html";
		
		
		
		
		Field[] attr = Zip.class.getDeclaredFields();
		String columns = "";
		for(int i = 0; i < attr.length; i++){
			if(i == attr.length-1)
				columns += attr[i].getName();
			else
				columns += attr[i].getName() + ",";
		}
		FileWriter writer = new FileWriter(filename);
		writer.append(columns + "\n");
		writer.flush();
		
		Connection c = Jsoup.connect(url);		
		Document doc = c.get();
		Elements zips = doc.select(".list-group-item.col-lg-3.col-sm-4.col-xs-6");
		List<Zip> zc = new ArrayList<Zip>();
		String[] proxies = {"182.254.208.116","202.166.205.85","122.193.14.106","222.54.130.156","182.48.113.11","115.182.15.27","119.6.136.122","223.16.237.185","219.73.51.248","209.141.54.254","112.226.254.225","113.31.46.205","58.59.18.88","117.169.4.42","200.26.134.235","39.82.106.45","185.5.64.70","31.29.62.106","112.232.114.207","117.169.4.43","123.126.32.102","1.33.205.107","119.202.173.240","203.88.172.70","195.46.25.226","120.198.248.97","112.252.97.205","95.24.130.71","31.210.45.151","70.248.28.13","222.161.209.164","112.85.115.89","139.59.212.212","209.242.141.60","120.198.248.96","49.51.8.149","58.59.8.72","185.50.215.146","117.135.250.88","151.80.64.100","223.19.177.238","111.13.136.46","123.170.240.25","202.103.215.23","47.89.45.51","109.196.127.35","175.2.154.216","124.133.240.88","113.204.136.50","122.7.156.193","122.195.181.46","59.127.154.78","222.170.17.74","46.101.7.133","122.13.214.134","80.113.251.2","111.56.49.30","117.169.4.156","123.173.37.94","113.31.46.206","196.15.141.27","222.133.31.130","61.78.133.143","122.96.59.102","91.134.230.98","41.33.242.141","119.90.57.114","61.5.207.102","167.88.40.226","122.96.59.102","122.193.14.106","200.43.65.91","124.244.77.129","190.29.22.247","27.216.85.140","124.88.67.9","63.150.152.151","139.162.182.113","111.11.122.7","40.113.118.174","222.122.9.46","79.129.56.159","84.22.35.37","123.57.207.137","122.96.59.102","221.237.154.57","132.248.14.196","51.254.106.79","194.102.229.246","106.38.251.62","188.214.23.9","121.199.178.247","202.53.168.125","89.175.96.74","139.59.8.208","122.147.24.103","202.43.190.20","121.12.149.18","119.29.119.49","116.226.166.2","124.133.230.254","115.28.37.153","178.62.118.19","124.88.67.9","51.254.106.72","101.99.22.40","109.207.61.218","31.146.182.122","184.155.18.163","117.169.4.45","212.175.249.171","124.88.67.30","51.254.106.64","120.236.148.199","179.108.32.193","117.169.4.40","202.77.57.124","128.199.88.117","218.56.132.155","124.88.67.30","120.28.45.202","202.164.38.11","59.148.118.3","62.45.248.11","221.10.126.191","47.88.195.233","47.89.41.25","108.61.167.117","5.45.64.97","190.121.158.114","124.206.133.227","91.202.199.15","169.50.87.249","120.131.128.211","219.141.225.107","120.25.171.183","212.68.227.166","177.207.234.14","189.85.20.21","148.251.51.213","69.70.183.110","122.193.14.106","106.37.181.74","190.75.96.224","186.94.221.82","200.26.134.234","124.88.67.30","122.96.59.102","51.255.172.122","117.171.136.123","122.96.59.106","117.169.4.136","177.190.209.10","121.14.36.38","113.31.46.205","121.199.251.236","178.238.229.236","51.254.106.69","119.37.193.77","87.99.101.22","190.202.217.64","86.109.100.80","117.158.1.210","111.13.136.36","41.188.49.210","46.101.3.43","94.136.95.150","36.81.2.206","94.181.34.64","190.104.245.39","77.223.144.191","82.139.70.104","121.15.137.75","41.79.60.202","178.62.54.134","122.96.59.105","201.55.46.6","118.98.216.44","85.143.24.70","182.253.35.115","109.207.61.57","88.159.172.245","177.234.12.202","183.239.167.122","122.96.59.105","136.243.4.136","202.147.206.114","60.191.163.147","45.62.246.212","188.132.226.242","84.26.93.234","41.71.112.22","200.61.47.14","218.191.247.51"};
		Integer[] ports = {8080,8080,80,2226,8088,8080,80,8080,1234,8080,8888,83,8080,81,8080,81,8080,80,8080,80,8080,8118,80,81,80,80,8888,8888,3128,8080,8102,10000,8080,8080,80,8080,8080,8080,80,8080,80,80,8888,2226,8088,8888,2226,8080,8080,8888,8888,80,2226,8118,8080,8080,8118,80,8888,80,8080,2226,8080,82,80,8080,8080,80,8118,81,81,8080,80,8080,8888,80,3128,80,80,8146,80,8080,3129,7777,843,9999,8080,80,80,8088,80,443,8080,3128,80,8080,8118,2226,80,81,80,8081,8118,81,80,3128,8090,443,3128,80,80,83,80,2226,8080,843,3128,8080,8080,843,8090,8080,80,80,2226,3128,81,8118,3128,8080,80,4444,80,80,80,8080,80,80,8080,10000,80,83,8118,8080,8080,8080,81,80,80,8123,843,80,8080,8080,80,80,80,80,7777,8080,8080,8080,9797,80,8080,8118,8080,31281,80,8080,8080,80,808,8080,8118,83,80,80,80,8080,8090,80,3128,8080,81,10000,8080,3128,8080,3128,80,3128,3128,80};
		int proxyIndex = 0;
		
		
		
		for(int j = pageStart-1; j < zips.size(); j++){
			long start = System.currentTimeMillis();
			System.out.print("Page " + (j+1) + "/" + zips.size() + " | ");
			while(true){
				if(proxyIndex > proxies.length-1)
					proxyIndex = 0;
				
				try{
					System.setProperty("http.proxyHost", proxies[proxyIndex]);
					System.setProperty("http.proxyPort", "" + ports[proxyIndex]);
					System.setProperty("https.proxyHost", proxies[proxyIndex]);
					System.setProperty("https.proxyPort", "" + ports[proxyIndex]);
					c = Jsoup.connect(zips.get(j).absUrl("href"));
					c.proxy(proxies[proxyIndex], ports[proxyIndex]);
					doc = c.get();
					proxyIndex++;
					break;
				}catch(Exception ex){
					proxyIndex++;
				}
			}
			
			Elements zipsInside = doc.select(".list-group-item.col-lg-3.col-sm-4.col-xs-6");
			Pattern pattern = Pattern.compile("/zips/(.*?).html");
			
			
			
			
			
			
			for(int i = 0; i < zipsInside.size(); i++){
				//inside for loop
				Zip z = new Zip();
				Matcher matcher = pattern.matcher(zipsInside.get(i).attr("href"));
				if (matcher.find())
				    z.setZip(matcher.group(1));											//1 - ZIP
				
				boolean firstIter = true;
				while(true){
					if(proxyIndex > proxies.length-1)
						proxyIndex = 0;
					
			
					
					try{
						c = Jsoup.connect(zipsInside.get(i).absUrl("href"));
						c.proxy(proxies[proxyIndex], ports[proxyIndex]);
						doc = c.get();
						break;
					}catch(Exception ex){
						proxyIndex++;
						if(proxyIndex > proxies.length-1)
							proxyIndex = 0;
						System.setProperty("http.proxyHost", proxies[proxyIndex]);
						System.setProperty("http.proxyPort", "" + ports[proxyIndex]);
						System.setProperty("https.proxyHost", proxies[proxyIndex]);
						System.setProperty("https.proxyPort", "" + ports[proxyIndex]);
						c = Jsoup.connect(zipsInside.get(i).absUrl("href"));
						c.proxy(proxies[proxyIndex], ports[proxyIndex]);
					}
				}
					
				
				Elements body = doc.select("#body");
				
				
				try{
					Element city = body.select("a").first();									//2 - CITY
					z.setCity(city.text());
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setCity("N/A");
				}
				
				
				if(z.getCity() != "N/A" && z.getCity() != null){							//2.5 - STATE
					z.setState(z.getCity().substring(z.getCity().indexOf(", ")+2));			
					z.setCity(z.getCity().substring(0, z.getCity().indexOf(",")));
				}
				else{
					z.setState("N/A");
				}
				
							
				Elements e = null;
				
				try{
					e = body.select("b:contains(Estimated zip code population in)");		//3 - POPULATION
					z.setPopulation(e.get(0).nextSibling().toString().replaceAll("[^0-9]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setPopulation("N/A");
				}
				
				try{
					e = body.select("b:contains(Houses and condos:)");			//4 - HOUSES
					z.setHouses(e.get(0).nextSibling().toString().replaceAll("[^0-9]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setHouses("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Renter-occupied apartments:)");			//5 - RENTERS
					z.setRenters(e.get(0).nextSibling().toString().replaceAll("[^0-9]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setRenters("N/A");
				}
				
				
				
				try{
					e = body.select(".hgraph").first().select(".h");			//6 - % OF RENTERS
					z.setPercentOfRenters(e.get(0).nextSibling().toString().replaceAll("[^0-9]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setPercentOfRenters("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(cost of living index in zip code)");			//7 - COST OF LIVING INDEX
					z.setCostOfLivingIndex(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setCostOfLivingIndex("N/A");
				}
				
				
				try{
					e = body.select("b:contains(Land area)");			//8 - LAND
					z.setLand(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setLand("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Water area)");			//9 - WATER
					z.setWater(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setWater("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Real estate property taxes paid for housing units in)").first().nextElementSibling().nextElementSibling().select("p.h");			//10 - REAL ESTATE TAXES
					z.setRealEstateTaxes(e.get(0).nextSibling().toString().replaceAll("[^0-9.%$\\s]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setRealEstateTaxes("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Males:)");			//11 - MEN
					z.setMen(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setMen("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Females:)");			//12 - WOMEN
					z.setWomen(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setWomen("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(High school or higher:)");			//13 - HIGH SCHOOL PERCENTAGE
					z.setHighSchoolPercentage(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setHighSchoolPercentage("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Bachelor's degree or higher:)");			//14 - BACHELORS PERCENTAGE
					z.setBachelorsPercentage(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setBachelorsPercentage("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Graduate or professional degree:)");			//15 - GRADUATES PERCENTAGE
					z.setGraduatesPercentage(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setGraduatesPercentage("N/A");
				}
				
		
				
				try{
					e = body.select("b:contains(Unemployed:)");			//16 - UNEMPLOYMENT
					z.setUnemployed(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setUnemployed("N/A");
				}
				
		
				
				try{
					e = body.select("b:contains(travel time to work)");			//17 - TRAVEL TIME
					z.setAvgCommute(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setAvgCommute("N/A");
				}
		
				
				
				try{
					e = body.select("b:contains(Estimated median house/condo value)");			//18 - AVG HOUSE VALUE
					z.setAvgHouseValue(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setAvgHouseValue("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Estimated median household income)").first().nextElementSibling().select("p.h");			//18 - AVG HOUSEHOLD INCOME
					z.setAvgHouseholdIncome(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setAvgHouseholdIncome("N/A");
				}
				
				
				
				try{
					e = body.select("b:contains(Residents with income below the poverty level)").first().nextElementSibling().nextElementSibling().select("p.h");			//19 - BELOW POVERTY LEVEL
					z.setBelowPoverty(e.get(0).nextSibling().toString().replaceAll("[^0-9.]",""));
				}catch(NullPointerException | IndexOutOfBoundsException exception){
					z.setBelowPoverty("N/A");
				}
				
				updateProgressBar(zipsInside.size(), i);
				writer.append(z.csvString()+ "\n");
				writer.flush();
				
				zc.add(z);
			
			}
			System.out.print(" | " + ((System.currentTimeMillis()-start)/1000) + " seconds");
			System.out.println();
		}
		
		
		
		
		
		
		writer.flush();
		writer.close();
		
		
		
		
		
	}

	private static void updateProgressBar(int pageSize, int currentZipIndex) {
		int modNum = pageSize/15;
		if(currentZipIndex%modNum == 0 && currentZipIndex != 0)
			System.out.print("#");
		
	}
	
	
	
	
	
	
	
}








class Zip{
	String zip;
	String city;
	String population;
	String houses;
	String renters;
	String percentOfRenters;
	String costOfLivingIndex;
	String land;
	String water;
	String realEstateTaxes;
	String men;
	String women;
	String highSchoolPercentage;
	String bachelorsPercentage;
	String graduatesPercentage;
	String unemployed;
	String avgCommute;
	String avgHouseValue;
	String avgHouseholdIncome;
	String belowPoverty;
	String state;

	public Zip(){}
	
	


	@Override
	public String toString() {
		return "Zip [zip=" + zip + ", city=" + city + ", population="
				+ population + ", houses=" + houses + ", renters=" + renters
				+ ", percentOfRenters=" + percentOfRenters
				+ ", costOfLivingIndex=" + costOfLivingIndex + ", land=" + land
				+ ", water=" + water + ", realEstateTaxes=" + realEstateTaxes
				+ ", men=" + men + ", women=" + women
				+ ", highSchoolPercentage=" + highSchoolPercentage
				+ ", bachelorsPercentage=" + bachelorsPercentage
				+ ", graduatesPercentage=" + graduatesPercentage
				+ ", unemployed=" + unemployed + ", avgCommute=" + avgCommute
				+ ", avgHouseValue=" + avgHouseValue + ", avgHouseholdIncome="
				+ avgHouseholdIncome + ", belowPoverty=" + belowPoverty
				+ ", state=" + state + "]";
	}
	
	public String csvString() {
		return zip + "," + city + ","
				+ population + "," + houses + "," + renters
				+ "," + percentOfRenters
				+ "," + costOfLivingIndex + "," + land
				+ "," + water + "," + realEstateTaxes
				+ "," + men + "," + women
				+ "," + highSchoolPercentage
				+ "," + bachelorsPercentage
				+ "," + graduatesPercentage
				+ "," + unemployed + "," + avgCommute
				+ "," + avgHouseValue + ","
				+ avgHouseholdIncome + "," + belowPoverty
				+ "," + state;
	}




	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
	public String getGraduatesPercentage() {
		return graduatesPercentage;
	}
	public void setGraduatesPercentage(String graduatesPercentage) {
		this.graduatesPercentage = graduatesPercentage;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getHouses() {
		return houses;
	}
	public void setHouses(String houses) {
		this.houses = houses;
	}
	public String getRenters() {
		return renters;
	}
	public void setRenters(String renters) {
		this.renters = renters;
	}
	public String getPercentOfRenters() {
		return percentOfRenters;
	}
	public void setPercentOfRenters(String percentOfRenters) {
		this.percentOfRenters = percentOfRenters;
	}
	public String getCostOfLivingIndex() {
		return costOfLivingIndex;
	}
	public void setCostOfLivingIndex(String costOfLivingIndex) {
		this.costOfLivingIndex = costOfLivingIndex;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public String getRealEstateTaxes() {
		return realEstateTaxes;
	}
	public void setRealEstateTaxes(String realEstateTaxes) {
		this.realEstateTaxes = realEstateTaxes;
	}
	public String getMen() {
		return men;
	}
	public void setMen(String men) {
		this.men = men;
	}
	public String getWomen() {
		return women;
	}
	public void setWomen(String women) {
		this.women = women;
	}
	public String getHighSchoolPercentage() {
		return highSchoolPercentage;
	}
	public void setHighSchoolPercentage(String highSchoolPercentage) {
		this.highSchoolPercentage = highSchoolPercentage;
	}
	public String getBachelorsPercentage() {
		return bachelorsPercentage;
	}
	public void setBachelorsPercentage(String bachelorsPercentage) {
		this.bachelorsPercentage = bachelorsPercentage;
	}
	public String getUnemployed() {
		return unemployed;
	}
	public void setUnemployed(String unemployed) {
		this.unemployed = unemployed;
	}
	public String getAvgCommute() {
		return avgCommute;
	}
	public void setAvgCommute(String avgCommute) {
		this.avgCommute = avgCommute;
	}
	public String getAvgHouseValue() {
		return avgHouseValue;
	}
	public void setAvgHouseValue(String avgHouseValue) {
		this.avgHouseValue = avgHouseValue;
	}
	public String getAvgHouseholdIncome() {
		return avgHouseholdIncome;
	}
	public void setAvgHouseholdIncome(String avgHouseholdIncome) {
		this.avgHouseholdIncome = avgHouseholdIncome;
	}
	public String getBelowPoverty() {
		return belowPoverty;
	}
	public void setBelowPoverty(String belowPoverty) {
		this.belowPoverty = belowPoverty;
	}
	
	
	
}

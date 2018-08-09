/**
 * @author dell
 *
 */
public class Caldistance {

	private static double EARTH_RADIUS = 6371.393;  
    private static double rad(double d)  
    {  
       return d * Math.PI / 180.0;  
    }  
  
    /** 
     * 计算两个经纬度之间的距离 (米)
     * @param lat1 
     * @param lng1 
     * @param lat2 
     * @param lng2 
     * @return 
     */  
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2)  
    {  
       double radLat1 = rad(lat1);  
       double radLat2 = rad(lat2);  
       double a = radLat1 - radLat2;      
       double b = rad(lng1) - rad(lng2);  
       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +   
       Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
       s = s * EARTH_RADIUS;  
       s = Math.round(s * 1000);  
       return s;  
    }
    
    /** 
     * 计算两个公里标之间的距离 (米)
     * @param kilo1 
     * @param kilo2
     * @return 
     */  
    public static int GetKiloDistance(String kilo1, String kilo2)  
    {  
    	int result=0;
    	double res1;
    	double res2;
    	String Int1="";
    	String Int2="";
    	String Dec1="";
    	String Dec2="";
    	int beginindex1;
    	int endindex1;
    	int beginindex2;
    	int endindex2;
    	beginindex1=1;
    	endindex1=kilo1.indexOf("+");
    	if(endindex1==-1){
    		endindex1=kilo1.length();
    	}
    	else{
    		Dec1=kilo1.substring(endindex1+1,kilo1.length());
    	}
    	beginindex2=1;
    	endindex2=kilo2.indexOf("+");
    	if(endindex2==-1){
    		endindex2=kilo2.length();
    	}
    	else{
    		Dec2=kilo2.substring(endindex2+1,kilo2.length());
    	}
    	Int1=kilo1.substring(beginindex1,endindex1);
    	Int2=kilo2.substring(beginindex2,endindex2);
    	if (!Dec1.equals("")){
    		res1=Double.parseDouble(Int1)*1000+Double.parseDouble(Dec1);
    	}
    	else{
    		res1=Double.parseDouble(Int1);
    	}
    	if (!Dec2.equals("")){
    		res2=Double.parseDouble(Int2)*1000+Double.parseDouble(Dec2);
    	}
    	else{
    		res2=Double.parseDouble(Int2);
    	}
    	result=(int)Math.abs((res1-res2));
        return result;  
    }
    
    
      
      
      
    public static void main(String[] args) { 
    	//A点经纬度
    	double lon1=111.798333;
    	double lat1=27.605;
    	//B点经纬度
    	double lon2=111.7722217;
    	double lat2=27.60527667;
    	//C点经纬度
    	double lon3=111.74861145;
    	double lat3=27.62539864;
    	//A点公里标
    	String kilo1="K1230+800";
    	//D点公里标
    	String kilo2="K1232+897";
    	double AB=GetDistance(lat1,lon1,lat2,lon2);
    	double AC=GetDistance(lat1,lon1,lat3,lon3);
    	double BC=GetDistance(lat3,lon3,lat2,lon2);
    	double cos_θ=(Math.pow(AB, 2)+Math.pow(AC, 2)-Math.pow(BC, 2))/(2*AB*AC);
    	double AD=GetKiloDistance(kilo1,kilo2);
    	double CD=Math.pow(AC, 2)+Math.pow(AD, 2)-2*AD*AC*cos_θ;
        double result=Math.sqrt(CD);
        System.out.println("距离:"+result+" 米"); 
    }  

}

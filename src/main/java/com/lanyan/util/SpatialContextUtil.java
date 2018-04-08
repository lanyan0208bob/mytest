package com.lanyan.util;

import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.io.GeohashUtils;
import com.spatial4j.core.shape.Rectangle;

import ch.hsr.geohash.GeoHash;

/**
 * 
* @ClassName: SpatialContextUtil 地图相关
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author 王继波 
* @date 2018年4月4日 下午4:51:09 
*
 */
public class SpatialContextUtil {

	/**
	 * 
	* @Title: getRectangle  获取经纬度范围
	* @Description: 获取经纬度范围 
	* @param  lon 经度
	* @param  lat 纬度
	* @param radius 距离
	* @param     Rectangle
	* @return Rectangle    返回类型 
	* @throws 
	* @author 王继波
	* @date 2018年4月4日 下午4:55:47
	 */
	public static Rectangle getRectangle(double lon,double lat,double radius){
		SpatialContext geo = SpatialContext.GEO;  
		Rectangle rectangle = geo.getDistCalc().calcBoxByDistFromPt(  
		        geo.makePoint(lon, lat), radius * DistanceUtils.KM_TO_DEG, geo, null);  
//		System.out.println(rectangle.getMinX() + "-" + rectangle.getMaxX());// 经度范围  
//		System.out.println(rectangle.getMinY() + "-" + rectangle.getMaxY());// 纬度范围 
		
		return rectangle;
	}
	/**
	 * 
	* @Title: getEncodeLatLon 获取geohash编码
	* @Description: geohash
	* @param lon 经度
	* @param lat 纬度
	* @param precision 经度等级
	* @param    设定文件 
	* @return String    返回类型 
	* @throws 
	* @author 王继波
	* @date 2018年4月4日 下午5:27:34
	 */
	public static String getEncodeLatLon(double lon,double lat,int precision){
		return GeohashUtils.encodeLatLon(lat, lon,precision);
	} 
	
	
	/**
	 * 
	* @Title: getGeoHashs   由于getEncodeLatLon  存在临界问题，就是坐标点位于边界附近，被搜索的坐标点位于另一个区域，这时查不到，
	* 需用周围八个网格模糊匹配 ，用or
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param lon 经度
	* @param lat 纬度
	* @param precision 精度
	* @param    设定文件 
	* @return GeoHash[]    返回类型 
	* @throws 
	* @author 王继波
	* @date 2018年4月8日 下午5:29:17
	 */
	public static  GeoHash[] getGeoHashs(double lon,double lat,int precision){
		GeoHash geoHash = GeoHash.withCharacterPrecision(lat, lon, precision);
		GeoHash[] adjacent = geoHash.getAdjacent();
//		for (GeoHash hash : adjacent) {
//		    System.out.println(hash.toBase32());
//		}
		return adjacent;
	}
	/**]
	 * 
	* @Title: getDistance 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param  lon 经度
	* @param  lat 纬度
	* @param  tolon 目标经度
	* @param tolat 目标纬度
	* @param   设定文件 
	* @return double    返回类型  距离 单位km
	* @throws 
	* @author 王继波
	* @date 2018年4月4日 下午5:46:03
	 */
	public static double getDistance(double lon,double lat,double tolon,double tolat){
		SpatialContext geo = SpatialContext.GEO;  
		return geo.calcDistance(geo.makePoint(lon, lat), geo.makePoint(tolon, tolat)) * DistanceUtils.DEG_TO_KM;  
	}  

	public static void main(String[] args) {
		System.out.println(getEncodeLatLon(116.175,40.242,12));
//		getEncodeLatLon(116.900,40.900,12);
//		getaa(116.174,40.241,4);
//		getaa(116.17,40.24,1);
//		getaa(116.1,40.2,9);
//		getaa(1240,116);
//		getEncodeLatLon(116.175,40.242,4);
//		getEncodeLatLon(116.900,40.900,4);
//		System.out.println(getGeoHashs(116.175,40.242,12),10);
		System.out.println(getDistance(116.175,40.242,116.900,40.900));
	}
}

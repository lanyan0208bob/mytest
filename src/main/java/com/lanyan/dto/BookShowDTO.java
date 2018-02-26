package com.lanyan.dto;


/**
 * 
* @ClassName: BookShowDTO 
* @Description: 书单列表查询返回
* @author 王继波 
* @date 2018年2月27日 上午10:01:11 
*
 */
public class BookShowDTO {

	private String bookName;//书名
	
	private String bookAuthor;//作者
	
	private String bookVersion;//版本
	private double bookDiscount;//折扣 比如0.2 2折 二成新
	private double bookDeposit;//押金
	private String stationAddress;// 地址
	private String stationLeader;// 联系人
	private String stationName;//  站点名称
	
	private String stationPhone;// 联系电话
	private String fromDate;//起始日期
	private String endDate;// 结束日期
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the bookAuthor
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}
	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	/**
	 * @return the bookVersion
	 */
	public String getBookVersion() {
		return bookVersion;
	}
	/**
	 * @param bookVersion the bookVersion to set
	 */
	public void setBookVersion(String bookVersion) {
		this.bookVersion = bookVersion;
	}
	/**
	 * @return the bookDiscount
	 */
	public double getBookDiscount() {
		return bookDiscount;
	}
	/**
	 * @param bookDiscount the bookDiscount to set
	 */
	public void setBookDiscount(double bookDiscount) {
		this.bookDiscount = bookDiscount;
	}
	/**
	 * @return the bookDeposit
	 */
	public double getBookDeposit() {
		return bookDeposit;
	}
	/**
	 * @param bookDeposit the bookDeposit to set
	 */
	public void setBookDeposit(double bookDeposit) {
		this.bookDeposit = bookDeposit;
	}
	/**
	 * @return the stationAddress
	 */
	public String getStationAddress() {
		return stationAddress;
	}
	/**
	 * @param stationAddress the stationAddress to set
	 */
	public void setStationAddress(String stationAddress) {
		this.stationAddress = stationAddress;
	}
	/**
	 * @return the stationLeader
	 */
	public String getStationLeader() {
		return stationLeader;
	}
	/**
	 * @param stationLeader the stationLeader to set
	 */
	public void setStationLeader(String stationLeader) {
		this.stationLeader = stationLeader;
	}
	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}
	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	/**
	 * @return the stationPhone
	 */
	public String getStationPhone() {
		return stationPhone;
	}
	/**
	 * @param stationPhone the stationPhone to set
	 */
	public void setStationPhone(String stationPhone) {
		this.stationPhone = stationPhone;
	}
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}

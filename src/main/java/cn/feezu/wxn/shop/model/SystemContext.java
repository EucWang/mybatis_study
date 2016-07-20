package cn.feezu.wxn.shop.model;

public class SystemContext {

	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
	
	/**
	 * 升序还是降序
	 */
	private static ThreadLocal<String> order = new ThreadLocal<String>();
	
	/**
	 * 根据那个字段排序
	 */
	private static ThreadLocal<String> sort = new ThreadLocal<String>();
	
	
	public static void removeOrder(){
		order.remove();
	}
	
	public static void removeSort(){
		sort.remove();
	}
	
	public static void setOrder(String _order) {
		order.set(_order);
	}
	
	public static String getOrder(){
		return order.get();
	}
	
	
	public static void setSort(String _sort) {
		sort.set(_sort);
	}
	
	public static String getSort(){
		return sort.get();
	}
	
	public static int getPageOffset(){
		return pageOffset.get();
	}
	
	public static void setPageOffset(int _pageOffset){
		pageOffset.set(_pageOffset);
	}
	
	public static int getPageIndex(){
		return pageIndex.get();
	}
	
	public static void setPageIndex(int _pageIndex){
		pageIndex.set(_pageIndex);
	}
	
	public static int getPageSize(){
		return pageSize.get();
	}
	
	public static void setPageSize(int _pageSize){
		pageSize.set(_pageSize);
	}
	

}

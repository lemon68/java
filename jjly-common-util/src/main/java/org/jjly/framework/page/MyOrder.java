package org.jjly.framework.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;


/**
 * <p>数据库排序字段 </p>
 * @Package org.jjly.framework.page
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/8 20:41
 * @version V1.0
 */
public class MyOrder implements Serializable {

    private static final long serialVersionUID = 8138022018100161833L;
    private Direction direction;
    private String property;
    private String orderExpr;

    /**
     * 
     * @param property 实体映射类的属性名，如userName.该参数会存在sql注入风险，请注意参数输入检查
     * @param direction 升序或降序排序 {@link Direction} 
     * @param orderExpr
     */
    public MyOrder(String property, Direction direction, String orderExpr){
        this.direction = direction;
        this.property = property;
        this.orderExpr = orderExpr;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getProperty() {
        return property;
    }

    public String getOrderExpr() {
        return orderExpr;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setOrderExpr(String orderExpr) {
        this.orderExpr = orderExpr;
    }

	private static String INJECTION_REGEX = "[A-Za-z0-9\\_\\-\\+\\.]+";
    public static boolean isSQLInjection(String str){
        return !Pattern.matches(INJECTION_REGEX, str);
    }

    @Override
    public String toString() {
        if(isSQLInjection(property)){
            throw new IllegalArgumentException("SQLInjection property: "+property);
        }
        if(orderExpr != null && orderExpr.indexOf("?") != -1){
            String[] exprs = orderExpr.split("\\?");
            if(exprs.length == 2){
                return String.format(orderExpr.replaceAll("\\?","%s"), property) + (direction == null ? "" : " " + direction.name());
            }
            return String.format(orderExpr.replaceAll("\\?","%s"), property ,direction == null ? "" : " " + direction.name());
        }
        return property + (direction == null ? "" : " " + direction.name());
    }



    public static List<MyOrder> formString(String orderSegment){
        return formString(orderSegment, null);
    }

    /**
     * @param orderSegment  ex: "id.asc,code.desc" or "code.desc"
     */
    public static List<MyOrder> formString(String orderSegment,String orderExpr){
        if(orderSegment == null || orderSegment.trim().equals("")) {
            return new ArrayList<MyOrder>(0);
        }

        List<MyOrder> results = new ArrayList<MyOrder>();
        String[] orderSegments = orderSegment.trim().split(",");
        for(int i = 0; i < orderSegments.length; i++) {
            String sortSegment = orderSegments[i];
            MyOrder order = _formString(sortSegment, orderExpr);
            if(order != null){
                results.add(order);
            }
        }
        return results;
    }


    private static MyOrder _formString(String orderSegment, String orderExpr){

        if(orderSegment == null || orderSegment.trim().equals("") ||
                orderSegment.startsWith("null.") ||  orderSegment.startsWith(".")){
            return null;
        }

        String[] array = orderSegment.trim().split("\\.");
        if(array.length != 1 && array.length != 2){
            throw new IllegalArgumentException("orderSegment pattern must be {property}.{direction}, input is: "+orderSegment);
        }

        return create(array[0], array.length == 2 ? array[1] : "asc", orderExpr);
    }

    public static MyOrder create(String property, String direction){
        return create(property, direction,null);
    }

    /**
     *
     * @param property
     * @param direction
     * @param orderExpr  placeholder is "?", in oracle like: "nlssort( ? ,'NLS_SORT=SCHINESE_PINYIN_M')".
     *                   Warning: you must prevent orderExpr SQL injection.
     * @return
     */
    public static MyOrder create(String property, String direction, String orderExpr){
        return new MyOrder(property, Direction.fromString(direction),orderExpr);
    }


    /**
     * PropertyPath implements the pairing of an {@link Direction} and a property. It is used to provide input for
     *
     * @author Oliver Gierke
     */
    public static enum Direction {
    	/**
    	 * 升序排序
    	 */
        ASC, 
        /**
         * 降序排序
         */
        DESC;
        public static Direction fromString(String value) {
            try {
                return Direction.valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e) {
                return ASC;
            }
        }
    }
}

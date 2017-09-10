package org.jjly.framework.orm;

/**
 * <p>Mybatis操作枚举类 </p>
 *
 * @author Steven
 * @version V1.0
 * @Package org.jjly.framework.orm
 * @e-mail 47121494@qq.com
 * @date 2017/9/921:24
 */
public enum  OperatorEnum {
    NQ("!="), EQ("="), LIKE("LIKE"), GT(">"), LT("<"), GTE(">="), LTE("<="), LTD("<="), GTD(">="),OR("OR"), NLIKE("NOT LIKE");
    private OperatorEnum(String str){
        op=str;
    }
    private String op;
    public String getOp() {
        return op;
    }
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * <p>
     *	说明：生成查询列名和查询方式用下划线“_”分隔的字符串：如LIKE.op("name")-->"LIEK_name"
     *	</p>
     * @return 返回查询列名和查询方式用下划线“_”分隔的字符串：如LIKE.op("name")-->"LIEK_name"
     * @author Steven
     */
    public String op(String str) {
        return this.toString()+"_"+str;
    }
}

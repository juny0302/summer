package org.ssm.summer.sequence;
/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午2:32:10
 * @since   
 */
public class CheckSumExpression implements Expression {

    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.Expression#maxLength()
     */
    @Override
    public int maxLength() {
        return 1;
    }

    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.Expression#eval(org.ssm.summer.sequence.GenContext)
     */
    @Override
    public Object eval(GenContext context) {
        Long newId = (Long) context.get("sequence");
        if (newId == null) {
            throw new RuntimeException("sequence can not be null when calculate checksum");
        }
        
        //id<< 2 | table_index
        return newId * 9 % 31 % 10;
    }

    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.Expression#executeOrder()
     */
    @Override
    public ExecuteOrder executeOrder() {
        return ExecuteOrder.AfterNormal;
    }
    
    public static void main(String[] args) {
        System.out.println(1 << 2 | 0);
        System.out.println(1 << 2 | 1);
        System.out.println(1 << 2 | 2);
        System.out.println(1 << 2 | 3);
    }

}

package org.ssm.summer.sequence;
/** 
 * 根据序列业务类型生成新序列的接口 <p>
 * 生成序列是大致递增的
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午2:16:08
 * @since 0.1  
 */
public interface SequenceGen {

    /**
     * 生成序列
     * @param ownerKey 序列业务key
     * @return 新序列值
     */
    Long gen(String ownerKey);
}

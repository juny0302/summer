package org.ssm.summer.sequence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ssm.summer.entity.OrderCode;
import org.ssm.summer.mapper.OrderCodeMapper;

/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午4:39:40
 * @since   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-sequence.xml"})
public class AutoIncrementTablesSequenceGenTest {
    private final String  OWNERKEY = "order";
    @Autowired
    private SequenceGen tableGen;
    @Autowired
    private OrderCodeMapper orderCodeMapper;
    
    /**
     * Test method for {@link org.ssm.summer.sequence.AutoIncrementTablesSequenceGen#gen(java.lang.String)}.
     */
    @Test
    public void testGen() {
        OrderCode orderCode = new OrderCode();
        
        Long id = orderCodeMapper.insertOrderCode(orderCode);
        System.out.println("id : " + orderCode.getId());
        System.out.println(OWNERKEY + " : " +tableGen.gen(OWNERKEY));
    }

}

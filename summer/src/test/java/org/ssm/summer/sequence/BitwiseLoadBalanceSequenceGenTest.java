package org.ssm.summer.sequence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午4:34:32
 * @since   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-sequence.xml","classpath:spring-mybatis.xml"})
public class BitwiseLoadBalanceSequenceGenTest {
    
    @Autowired
    private BitwiseLoadBalanceSequenceGen highAvailableSequenceGen;

    /**
     * Test method for {@link org.ssm.summer.sequence.BitwiseLoadBalanceSequenceGen#gen(java.lang.String)}.
     */
    @Test
    public void testGen() {
        System.out.println(highAvailableSequenceGen.gen("aaa"));
    }

}

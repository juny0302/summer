package org.ssm.summer.sequence;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午4:39:40
 * @since   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-sequence.xml","classpath:spring-mybatis.xml"})
public class AutoIncrementTablesSequenceGenTest {

    /**
     * Test method for {@link org.ssm.summer.sequence.AutoIncrementTablesSequenceGen#gen(java.lang.String)}.
     */
    @Test
    public void testGen() {
        fail("Not yet implemented");
    }

}

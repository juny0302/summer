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
 * @date 2017年7月27日 下午4:39:40
 * @since   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-jdbc.xml","classpath:spring-sequence.xml"})
public class AutoIncrementTablesSequenceGenTest {
    private final String  OWNERKEY = "order";
    @Autowired
    AutoIncrementTablesSequenceGen gen;
    
    @Autowired
    private SmartSNGen snGen;
    /**
     * Test method for {@link org.ssm.summer.sequence.AutoIncrementTablesSequenceGen#gen(java.lang.String)}.
     */
    @Test
    public void testGen() {
        System.out.println(gen.gen(OWNERKEY));  
        System.out.println(snGen.getFormat());
        System.out.println(snGen.getInterpreter());
    }

}

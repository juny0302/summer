package org.ssm.summer.sequence;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午4:09:51
 * @since   
 */
@Component
public class BitwiseLoadBalanceSequenceGen implements SequenceGen {
    private final Logger LOGGER = LoggerFactory.getLogger(BitwiseLoadBalanceSequenceGen.class); 

    /**
     * 将timeout判断的阈值设置为一个很大的值， 避免timeout应用error的情况发生
     */
    private Integer timeoutThresholdInMilliseconds;
    /**
     * 超时多少次后会移出可用列表 
     */
    private Integer timeoutEventCountThreshold;
    
    /**
     * 计算超时异常的时间周期， 以秒为单位
     */
    private Integer timeoutTimeThresholdInSeconds;
    
    /**
     * 移到不可用队列多长时间后会被重新放入可用队列
     */
    private Integer onErrorRescueThresholdInSeconds;

    private Integer leftShiftCount;
    
    
    

    //availablePartitionIndices
    private Map<Integer, SequenceGen> innerSequences;
    
    private Set<Integer> availablePartitionIndices;
    
    public BitwiseLoadBalanceSequenceGen(Integer arg0, Map<Integer, SequenceGen> arg1) {
        this.leftShiftCount = arg0;
        this.innerSequences = arg1;
        this.availablePartitionIndices = arg1.keySet();
    }
    
    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.ISequenceGen#gen(java.lang.String)
     */
    @Override
    public Long gen(String ownerKey) {
        long sequence=0;
        int currentPartitionIndex=-1;
        SequenceGen innerGen=null;
        do{
            long startTime=System.currentTimeMillis();
            boolean hasError=false;
            try{
                currentPartitionIndex = getCurrentPartitionIndex();
                LOGGER.trace("current partition index {}",currentPartitionIndex);
                innerGen = innerSequences.get(currentPartitionIndex);
                if(innerGen==SkipSequence.INSTANCE){
                    LOGGER.warn("current partition index {} is skipped",currentPartitionIndex);
                    if(availablePartitionIndices.contains(currentPartitionIndex)){
                        LOGGER.warn("current partition index {} is skipped, remove it",currentPartitionIndex);
                        availablePartitionIndices.remove(Integer.valueOf(currentPartitionIndex));
                    }

                    continue;
                }

                //HighAvailablePartitionHolder.setPartition(currentPartitionIndex);
                sequence=innerGen.gen(ownerKey);
                onGenNewId(ownerKey,currentPartitionIndex,sequence);
                LOGGER.trace("genNewId {} with inner {}",sequence,currentPartitionIndex);
                break;
            }catch(SequenceOutOfRangeException ex){
                LOGGER.error("gen error SequenceOutOfRangeException index {} total available {}",
                        currentPartitionIndex,
                        availablePartitionIndices.size());
                hasError=true;

                LOGGER.error("set {} to SKIP",currentPartitionIndex);
                this.innerSequences.put(Integer.valueOf(currentPartitionIndex),SkipSequence.INSTANCE);
                onError(ownerKey,currentPartitionIndex,innerGen,ex);
                LOGGER.error("after onError total available {}/{}",currentPartitionIndex,
                        availablePartitionIndices.size());

            }catch(Exception ex){
                LOGGER.error("gen error index {} total available {}",currentPartitionIndex,
                        availablePartitionIndices.size());
                LOGGER.error("gen error ",ex);
                hasError=true;
                onError(ownerKey,currentPartitionIndex,innerGen,ex);
                LOGGER.error("after onError total available {}/{}",currentPartitionIndex,
                        availablePartitionIndices.size());
            }finally{
                long usedTime=System.currentTimeMillis()-startTime;
                boolean isTimeout=usedTime>timeoutThresholdInMilliseconds;
                if(!hasError&&isTimeout){
                    onTimeout(currentPartitionIndex,innerGen,usedTime);
                }
                
                LOGGER.trace("gen usedTime {}",usedTime);
            }
        }while(true);
        return sequence;
    }


    /**
    * @param currentPartitionIndex
    * @param innerGen
    * @param usedTime
    */
    private void onTimeout(int currentPartitionIndex, SequenceGen innerGen, long usedTime) {
        // TODO Auto-generated method stub
        
    }

    /**
    * @param ownerKey
    * @param currentPartitionIndex
    * @param innerGen
    * @param ex
    */
    private void onError(String ownerKey, int currentPartitionIndex, SequenceGen innerGen, Exception ex) {
        // TODO Auto-generated method stub
        
    }

    /**
    * @param ownerKey
    * @param currentPartitionIndex
    * @param sequence
    */
    private void onGenNewId(String ownerKey, int currentPartitionIndex, long sequence) {
        // TODO Auto-generated method stub
        
    }

    /**
    * @param ownerKey
    * @return
    */
    private int getCurrentPartitionIndex() throws SequenceOutOfRangeException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * @return the timeoutThresholdInMilliseconds
     */
    public Integer getTimeoutThresholdInMilliseconds() {
        return timeoutThresholdInMilliseconds;
    }


    /**
     * @param timeoutThresholdInMilliseconds the timeoutThresholdInMilliseconds to set
     */
    public void setTimeoutThresholdInMilliseconds(Integer timeoutThresholdInMilliseconds) {
        this.timeoutThresholdInMilliseconds = timeoutThresholdInMilliseconds;
    }


    /**
     * @return the timeoutEventCountThreshold
     */
    public Integer getTimeoutEventCountThreshold() {
        return timeoutEventCountThreshold;
    }


    /**
     * @param timeoutEventCountThreshold the timeoutEventCountThreshold to set
     */
    public void setTimeoutEventCountThreshold(Integer timeoutEventCountThreshold) {
        this.timeoutEventCountThreshold = timeoutEventCountThreshold;
    }


    /**
     * @return the timeoutTimeThresholdInSeconds
     */
    public Integer getTimeoutTimeThresholdInSeconds() {
        return timeoutTimeThresholdInSeconds;
    }


    /**
     * @param timeoutTimeThresholdInSeconds the timeoutTimeThresholdInSeconds to set
     */
    public void setTimeoutTimeThresholdInSeconds(Integer timeoutTimeThresholdInSeconds) {
        this.timeoutTimeThresholdInSeconds = timeoutTimeThresholdInSeconds;
    }


    /**
     * @return the onErrorRescueThresholdInSeconds
     */
    public Integer getOnErrorRescueThresholdInSeconds() {
        return onErrorRescueThresholdInSeconds;
    }


    /**
     * @param onErrorRescueThresholdInSeconds the onErrorRescueThresholdInSeconds to set
     */
    public void setOnErrorRescueThresholdInSeconds(Integer onErrorRescueThresholdInSeconds) {
        this.onErrorRescueThresholdInSeconds = onErrorRescueThresholdInSeconds;
    }
    
    
    
    
}

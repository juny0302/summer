package org.ssm.summer.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author June
 * @since 2017-07-27
 */
@TableName("sys_log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户ID
     */
	private Long uid;
    /**
     * 日志内容
     */
	private String content;
    /**
     * 用户操作
     */
	private String operation;
    /**
     * 创建时间
     */
	private Date crTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getCrTime() {
		return crTime;
	}

	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Log{" 
		+ "id=" + id 
		+ ", uid=" + uid 
		+ ", content=" + content 
		+ ", operation=" + operation 
		+ ", crTime=" + crTime 
		+ "}";
	}
}

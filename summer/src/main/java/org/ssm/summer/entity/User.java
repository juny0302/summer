package org.ssm.summer.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author June
 * @since 2017-07-27
 */
@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 登录账号
     */
	private String account;
    /**
     * 密码
     */
	private String password;
    /**
     * 用户类型,1:超级用户,0:普通用户
     */
	@TableField("user_type")
	private Integer userType;
    /**
     * 删除标记 0未删除 1删除
     */
	@TableField("is_deleted")
	private Integer isDeleted;
    /**
     * 创建时间
     */
	@TableField("gmt_create")
	private Date gmtCreate;
    /**
     * 修改时间
     */
	@TableField("gmt_modified")
	private Date gmtModified;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" 
		+ "id=" + id 
		+ ", userName=" + userName 
		+ ", account=" + account 
		+ ", password=" + password 
		+ ", userType=" + userType 
		+ ", isDeleted=" + isDeleted 
		+ ", gmtCreate=" + gmtCreate 
		+ ", gmtModified=" + gmtModified 
		+ "}";
	}
}

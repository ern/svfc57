package org.svfc57.entities;

import java.util.Date;

public class Post {

	public long id;
	public Date createDate;
	public Date modifiedDate;
	public long createdBy;
	public String title;
	public String content;
	public boolean visible;
	public Date visibleAfter;
	public Date visibleBefore;
	public boolean deleted;
}

package com.yc.bean;

import java.io.Serializable;

public class Favorite implements Serializable {
	private static final long serialVersionUID = 5168141800845369640L;
	
	private Integer fid;
	private String flabel;
	private String furl;
	private String fdesc;
	
	
	
	private String ftags="";  //界面录入标签     "体育,娱乐"
	private String tname;   // 根据 tname来查询 favorite

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Favorite [fdesc=" + fdesc + ", fid=" + fid + ", flabel="
				+ flabel + ", ftags=" + ftags + ", furl=" + furl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fdesc == null) ? 0 : fdesc.hashCode());
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
		result = prime * result + ((flabel == null) ? 0 : flabel.hashCode());
		result = prime * result + ((ftags == null) ? 0 : ftags.hashCode());
		result = prime * result + ((furl == null) ? 0 : furl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorite other = (Favorite) obj;
		if (fdesc == null) {
			if (other.fdesc != null)
				return false;
		} else if (!fdesc.equals(other.fdesc))
			return false;
		if (fid == null) {
			if (other.fid != null)
				return false;
		} else if (!fid.equals(other.fid))
			return false;
		if (flabel == null) {
			if (other.flabel != null)
				return false;
		} else if (!flabel.equals(other.flabel))
			return false;
		if (ftags == null) {
			if (other.ftags != null)
				return false;
		} else if (!ftags.equals(other.ftags))
			return false;
		if (furl == null) {
			if (other.furl != null)
				return false;
		} else if (!furl.equals(other.furl))
			return false;
		return true;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFlabel() {
		return flabel;
	}

	public void setFlabel(String flabel) {
		this.flabel = flabel;
	}

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getFtags() {
		return ftags;
	}

	public void setFtags(String ftags) {
		this.ftags = ftags;
	}

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}

}

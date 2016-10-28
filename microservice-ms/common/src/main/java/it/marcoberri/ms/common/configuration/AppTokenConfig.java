package it.marcoberri.ms.common.configuration;

public class AppTokenConfig {
	private String url;
	private Boolean enable = false;
	private String tokenfiled = "token";
	private String PathPatterns = "/**";
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public String getTokenfiled() {
		return tokenfiled;
	}
	public void setTokenfiled(String tokenfiled) {
		this.tokenfiled = tokenfiled;
	}
	public String getPathPatterns() {
		return PathPatterns;
	}
	public void setPathPatterns(String pathPatterns) {
		PathPatterns = pathPatterns;
	}
	

}

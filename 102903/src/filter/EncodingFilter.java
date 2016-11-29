package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤：为所有的JSP或Servlet统一设置编码(编码需要在web.xml中配置)
 */
public class EncodingFilter implements Filter {
	private String charset;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	request.setCharacterEncoding(charset);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	this.charset=fConfig.getInitParameter("charset");
	
	}

}

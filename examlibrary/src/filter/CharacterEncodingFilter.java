/**  
 * 
 * @Title:  CharacterEncodingFilter.java   
 * @Package filter   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: CuiYuanGeng    
 * @date://2021/09/29 14:02:36
 * @version V1.0 
 * 
 * 
 */
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author 10217
 *
 */
public class CharacterEncodingFilter implements Filter {
	String bianma = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String r = request.getCharacterEncoding();
		String son = response.getCharacterEncoding();
		if(r==null) {
			request.setCharacterEncoding(bianma);
		}
		if(son==null) {
			response.setCharacterEncoding(bianma);
		}
		response.setContentType("text/html;charset="+bianma);
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		 bianma = filterConfig.getInitParameter("encode");
	}

}

package com.wow.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//모든 경로의 요청에 대해서 필터를 거쳐간다.
@WebFilter("/*")
public class EncodeFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터왔음!!");
		request.setCharacterEncoding("UTF-8");
		//chain : 다음으로 보내줄 수 있다.
		chain.doFilter(request, response);
		System.out.println("필터 다시 나갈게요~~");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

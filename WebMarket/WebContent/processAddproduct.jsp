<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="com.oreilly.servlet.MultipartRequest" %>
<%@ page import ="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import ="java.util.*" %>
<%@ page import="web.bean.vo.Product"%>
<%@ page import="web.bean.dao.ProductRepository"%>

	<%
		request.setCharacterEncoding("UTF-8");//post방식 한글처리
		String saveDir =  request.getRealPath("resources//images//");//파일 저장경로
		int maxSize =1024*1024*10;//10M 업로드 최대크기
		String enc = "UTF-8";//파일명 한글 인코딩
		DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();//파일명 중복방지
		MultipartRequest mr = new MultipartRequest(request,saveDir,maxSize,enc,dp);//멀티파트 객체생성
		
		String type = mr.getContentType("productImage");
		String [] t = type.split("/");
		if(t[0].equals("image")){
			//사진파일
			Product vo = new Product();
			vo.setProductId(mr.getParameter("ProductId"));
			vo.setPname(mr.getParameter("name"));
			vo.setUnitPrice(Integer.parseInt(mr.getParameter("unitPrice")));
			vo.setManufacturer(mr.getParameter("Manufacturer"));
			vo.setDescription(mr.getParameter("description"));
			vo.setCategory(mr.getParameter("category"));
			vo.setUnitsInStock(Integer.parseInt(mr.getParameter("unitsInStock")));
			vo.setCondition(mr.getParameter("condition"));
			vo.setFilename(mr.getFilesystemName("productImage"));
			
			ProductRepository pr = ProductRepository.getInstance();
			
			pr.addProduct(vo);
			
			response.sendRedirect("./products.jsp");
			
			
		}else{%>
			<script>
				alert("사진파일만 업로드 가능합니다!!");
				hisrory.go(-1);
			</script>
			<%} %>
			
	
	<%-- 
		String productId = mr.getParameter("productId");
		String pname = mr.getParameter("name");
		String unitPrice = mr.getParameter("unitPrice");
		String description = mr.getParameter("description");
		String manufacturer = mr.getParameter("manufacturer");
		String category = mr.getParameter("category");
		String unitsInStock = mr.getParameter("unitsInStock");
		String condition = mr.getParameter("condition");
		
		Integer price;
		
		if(unitPrice.isEmpty())
			price = 0;
		else
			price = Integer.valueOf(unitPrice);
		
		long stock;
		
		if(unitsInstock.isEmpty())
			stock = 0;
		else
			stock = Long.valueOf(unitsInStock);
		
		Enumeration files = mr.getFileNames();
		String fname = (String)files.nextElement();
		String fileName = mr.getFilesystemName(fname);
		
		ProductRepository dao = ProductRepository.getInstance();
	
		
		Product newProduct = new Product();
		newProduct.setProductId(productId);
		newProduct.setPname(pname);
		newProduct.setUnitPrice(Price);
		newProduct.setDescription(description);
		newProduct.setManufacturer(manufacturer);
		newProduct.setCategory(category);
		newProduct.setUnitsInstock(stock);
		newProduct.setCondition(condition);
		newProduct.setFilename(productImage);
		
		dao.addProduct(newProduct);
		
		response.sendRedirect("products.jsp");
		
		
	--%>

	


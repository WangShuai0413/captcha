<%@ page language="java" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>��֤��ҳ��</title>
<script type="text/javascript">
		function reloadCode(){
			var time = new Date().getTime();
			document.getElementById("imagecode").src="<%=request.getContextPath() %>/servlet/ImageServlet?d="+time;
		}
</script>
</head>
<body>
	<form action="<%=request.getContextPath() %>/servlet/LoginServlet" method="get">
    	��֤�룺<input type="text" name="checkcode"/>
    	<img alt="��֤��" id="imagecode" src="<%=request.getContextPath() %>/servlet/ImageServlet"/>
    	<a href="javascript: reloadCode();">�������</a><br>
    	<input type="submit" value="�ύ">
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upload_file_page</title>
</head>
<body>
		<form action="/zf-web/ui/upload" enctype="multipart/form-data" method="post">
			文件：<input type="file" name="file"/>
			</br>
			<input type="submit" value="点击上传">
		
		</form>

</body>
</html>
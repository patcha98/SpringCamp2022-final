
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<html>
<head>

	

	<title>Home</title>
	<style>
		body { 
		    background-color:#F6F6F6;
		    margin: 0;
		}
	</style>
</head>
<body>

	

	
	<table  width="70%" cellpadding="2" style="background-color:white; text-align: center; border: 1px solid black; padding : 8px; border-radius: 5px; margin-left:auto; margin-right:auto;">
	<tr><th style="border: 1px solid black;">Id</th><th style="border: 1px solid black;">User_ip</th><th  style="border: 1px solid black;">Youtube Link</th><th style="border: 1px solid black;">Date</th><th style="border: 1px solid black;">Edit</th><th style="border: 1px solid black;">Delete</th></tr style="border: 1px solid black;">
   	<div style="text-align: center; margin-left:auto; margin-bottom:30px;margin-right:auto;">
	    <h3 style="margin-top:30px">파일을 다운받을 준비가 완료되었습니다.</h3>
	    <div style="margin-bottom:30px;">
	    <iframe id="video" width="65%" height="45%" src="https://www.youtube.com/embed/${key}" frameborder="0" allow="encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

	    </div >
	    
	    <a href="${downloadURL}" target='_blank' style="color: white; text-decoration: none text; border-radius: 5px; background-color:rgb(253, 70, 70); padding:10px;">영상 파일 다운로드</a>
    </div>
    <hr style="margin-bottom:30px">
    
    <h1 style=" margin-top:20px; text-align: center; margin-left:auto; margin-right:auto;">Download List</h1>
    <c:forEach var="download" items="${list}"> 
    <tr >
    <td style="border: 1px solid black;">${download.id}</td>
    <td style="border: 1px solid black;">${download.user_ip}</td>
    <td style="border: 1px solid black;">${download.yt_link}</td>
    <td style="border: 1px solid black;">${download.date}</td>
    <td style="border-radius: 5px; background-color:rgb(253, 70, 70); "><a href="editdownload/${download.id}" style="color: white; text-decoration: none;">Edit</a></td>
    <td style="border-radius: 5px; background-color:#0080FF; "><a href="deletedownload/${download.id}" style="color: white; text-decoration: none;">Delete</a></td>
    
    </tr>
    </c:forEach>
	    
    </table>
    	
    <br/>
    <div style="text-align: center; margin-left:auto; margin-right:auto; margin-bottom:30px">
	    <a href="/" style="border-radius: 5px; padding:5px; background-color:rgb(253, 70, 70); color: white; text-decoration: none;">Download New Video</a>
	</div>
    
</body>
</html>
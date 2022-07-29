<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Employee</h1>
       <form:form method="POST" action="/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>Link : </td> 
          <td><form:input path="yt_link"  /></td>
         </tr>  
         <tr>  
          <td>User IP :</td>  
          <td><form:input path="user_ip" /></td>
         </tr> 
         <tr>  
          <td>Date :</td>  
          <td><form:input path="date" /></td>
         </tr> 

         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  

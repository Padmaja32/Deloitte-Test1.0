<%@page isELIgnored="false" %>
<html>
<body>
<form action="bCRUD">
<table align=center width=50%>
<tr>
<th>Book Id</th>
<td><input type=text name=id value=${b.id }></td>
</tr>
<tr>
<th>Book Tittle</th>
<td><input type=text name=tittle value=${b.tittle }></td>
</tr>
<tr>
<th>Book Author</th>
<td><input type=text name=author value=${b.author }></td>
</tr>
<tr>
<th>Book Price</th>
<td><input type=text name=price value=${b.price }></td>
</tr>
<tr>
<td><input type=submit value="Add_Book" name="sub"></td>
<td><input type=submit value="Del_Book" name="sub"></td>
<td><input type=submit value="Modify_Book" name="sub"></td>
<td><input type=submit value="Get_Book" name="sub"></td>
</table>
</form>
</body>
</html>
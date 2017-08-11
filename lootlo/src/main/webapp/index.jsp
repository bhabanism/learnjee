<body>
<%@ page import="com.bsm.app.Howler" %>
<%@ page import="com.bsm.app.DerbyJDBCQueryDemo" %>
<%=Howler.sayHello()%></br>
<% for(String junk : DerbyJDBCQueryDemo.getDerbyData()) {

    %><%=junk%></br><%

} %>
</body>
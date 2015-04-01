<%@ page import="edu.etu.web.Item" %>
<%@ page import="java.util.ResourceBundle" %>
<jsp:useBean id="items" class="edu.etu.web.Items" scope="application"/>
<%
    ResourceBundle internationalization = (ResourceBundle) request.getAttribute("internationalization");
    Item item = (Item) request.getAttribute("item");
%>
<div class="well">
    <h4><a href="/items?id=<%=item.id%>"><%=item.title%></a> <small><%=item.price%>$</small></h4>
    <div class="row">
        <div class="col-xs-12 col-md-3">
            <div class="text-center">
                <img class="item img-responsive img-thumbnail" src="/assets/images/items/<%=item.id%>.jpg" alt=""/>
            </div>
            <br/>
            <button type="button" class="btn btn-block btn-primary"><%=internationalization.getString("buy")%></button>
        </div>
        <div class="col-xs-12 col-md-9">
            <%=item.briefDescription%>
        </div>
    </div>
</div>
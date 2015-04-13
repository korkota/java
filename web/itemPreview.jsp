<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="well">
    <h4><a href="/items?id=${item.id}">${item.title}</a> <small>${item.price}$</small></h4>
    <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="text-center">
                <img class="item img-responsive img-thumbnail" src="/assets/images/items/${item.id}.jpg" alt=""/>
            </div>
            <br/>
            <form class="form-inline" action="/add-item-to-cart" method="POST">
                <div class="form-group">
                    <input type="hidden" class="form-control" name="id" value="${item.id}"/>
                </div>
                <div class="form-group col-xs-8">
                    <input type="text" name="count" class="form-control bfh-number" data-min="1" data-max="25">
                </div>
                <div class="form-group col-xs-4">
                    <fmt:message key="buy" var="buy"/>
                    <input type="submit" class="form-control btn btn-primary" value="${buy}" />
                </div>
            </form>
        </div>
        <div class="col-xs-12 col-md-8">
            ${item.briefDescription}
        </div>
    </div>
</div>

<%@ include file="/partials/header.jsp"%>

<c:if test="${empty listsach1}" >
    <h1>Ko co sach</h1>
    <a href="index.jsp">Return to Login</a>
</c:if>
<c:forEach var = "s" items="${listsach1}" >

<div class="col-md-3 col-sm-6">
    <div class="product-grid3">
        <div class="product-image3">
            <a href="#">
                <img class="pic-1" src="${s.getDuongdananh()}" alt="Lamp">
            </a>
        </div>
        <div class="product-content">
            <h3 class="title"><a href="#">${s.getTen()}</a></h3>
            <div class="price">
                    ${s.getGiaban()}
            </div>
        </div>
    </div>
</div>
</c:forEach>
</body>
</html>

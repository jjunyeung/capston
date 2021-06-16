<!DOCTYPE html>
<%@ page contentType = "text/html;charset=utf-8" %>

<%@ include file="../layout/header.jsp"%>
<div class="container">

<form action="/auth/loginProc" method="post">
  <div class="form-group">
    <label for="username">ID:</label>
    <input type="username" name="username" class="form-control" placeholder="Enter ID" id="username">
  </div>

  <div class="form-group">
    <label for="password">PW:</label>
    <input type="password" name="password"class="form-control" placeholder="Enter PW" id="password">
  </div>
  
  <button id="btn-login" class="btn btn-primary">로그인</button>
</form>


</div>

<%@ include file="../layout/footer.jsp"%>





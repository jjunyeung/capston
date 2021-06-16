<!DOCTYPE html>
<%@ page contentType = "text/html;charset=utf-8" %>

<%@ include file="../layout/header.jsp"%>
<div class="container">

<form>
  <div class="form-group">
    <label for="username">ID:</label>
    <input type="username" class="form-control" placeholder="Enter ID" id="username">
  </div>

  <div class="form-group">
    <label for="password">PW:</label>
    <input type="password" class="form-control" placeholder="Enter PW" id="password">
  </div>

  <div class="form-group">
    <label for="email">Email:</label>
    <input type="email" class="form-control" placeholder="Enter email" id="email">
  </div>
  
  



</form>

<button id = "btn-save" class="btn btn-primary">회원가입</button>

</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>





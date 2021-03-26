<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container" style="margin-top: 50px;">
	<h2>팀 등록</h2>
	<form action="/team" method="post">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="팀이름" name="teamName">
		</div>
		<button class="btn btn-primary">등록하기</button>
	</form>
</div>

</body>
</html>

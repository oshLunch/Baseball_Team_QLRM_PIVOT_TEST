<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="margin-top: 50px;">
	<h2>포지션별 팀의 야구 선수 페이지</h2>
	<table class="table">
		<thead>
			<tr>
				<th>포지션</th>
				<th>롯데자이언츠</th>
				<th>삼성라이언즈</th>
				<th>기아타이거즈</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${dtos}">
				<tr>
					<td>${dto.position}</td>
					<td>${dto.lotte}</td>
					<td>${dto.samsung}</td>
					<td>${dto.kia}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

</body>
</html>

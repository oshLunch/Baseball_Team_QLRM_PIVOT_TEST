<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="margin-top: 50px;">
	<h2>야구팀 목록 보기 및 삭제페이지</h2>
	<table class="table">
		<thead>
			<tr>
				<th>NO</th>
				<th>팀 이름</th>
				<th>홈 구장</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teams}">
				<tr>
					<td>${team.id}</td>
					<td>${team.teamName}</td>
					<td>${team.stadium.stadiumName}</td>
					<td><button type="button" onClick="mDelete(${team.id})" class="btn btn-danger">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	function mDelete(id) {
		$.ajax({
			method:"DELETE",
			url:"http://localhost:8080/team/"+id,
		}).done((res)=>{
			if(res==="ok"){
				alert("삭제 성공");
				location.href="/team";
			} else {
				alert("삭제 실패");
				location.href="/team";
			}
		});
	};
</script>

</body>
</html>

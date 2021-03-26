<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="margin-top: 50px;">
	<h2>선수 목록 보기 및 삭제페이지</h2>
	<table class="table">
		<thead>
			<tr>
				<th>NO</th>
				<th>이름</th>
				<th>포지션</th>
				<th>소속 팀</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${players}">
				<tr>
					<td>${player.id}</td>
					<td>${player.name}</td>
					<td>${player.position}</td>
					<td>${player.team.teamName}</td>
					<td><button type="button" onClick="mDelete(${player.id});" class="btn btn-danger">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	function mDelete(id) {
		$.ajax({
			method:"DELETE",
			url:"http://localhost:8080/player/"+id,
		}).done((res)=>{
			if(res==="ok"){
				alert("삭제 성공");
				location.href="/player";
			} else {
				alert("삭제 실패");
				location.href="/player";
			}
		});
	};
	
</script>

</body>
</html>

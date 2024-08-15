<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link href="<c:url value='/resources/css/board/list.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="../include/header.jsp"/>
	<jsp:include page="../include/nav.jsp"/>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>게시글 목록</h3>
			</div><br>
			<div class="book_list">
				<table>
					<colgroup>
						<col width="10%">
						<col width="40%">
						<col width="20%">
						<col width="20%">
						<col width="10%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일자</th>
							<th>상세</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty resultList }">
								<tr>
									<td colspan="5">게시글이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${resultList }" var="b" varStatus="status">
									<tr>
										<td><c:out value="${status.count }"/></td>
										<td><c:out value="${b.board_title }"/></td>
										<td><c:out value="${b.board_content }"/></td>
										<td><fmt:formatDate pattern="yy-MM-dd" value="${b.reg_date }"/></td>
										<td>
											<a href="/board/${b.board_no }">상세</a>
										</td>
									</tr>
									
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<div class="button_wrap">
            		<input type="button" value="등록" class="register_button">
        		</div>
			</div>
		</div>
	</section>	
</body>
</html>
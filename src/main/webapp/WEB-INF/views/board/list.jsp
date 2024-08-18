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
<link href='<c:url value="/resources/css/include/paging.css"/>' rel="stylesheet" type="text/css" />
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
						<col width="30%">
						<col width="30%">
						<col width="15%">
						<col width="10%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성일자</th>
							<th>작성자</th>
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
									<tr data-no="${b.board_no }">
										<td><c:out value="${paging.numPerPage*(paging.nowPage-1)+status.count }"/></td>
										<td><a href="/board/${b.board_no }"><c:out value="${b.board_title }"/></a></td>
										<td><c:out value="${b.board_content }"/></td>
										<td><fmt:formatDate pattern="yy-MM-dd" value="${b.reg_date }"/></td>
										<td><c:out value="${b.board_writer }"/></td>
									</tr>
									
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<c:if test="${not empty paging }">
					<div class="center">
	  					<div class="pagination">
	  						<c:if test="${paging.prev}">
	  							<a href="<c:url value='/board?nowPage=${paging.pageBarStart-1}&search_type=${paging.search_type}&search_text=${paging.search_text}'/>">&laquo;</a>
	  						</c:if>
	  						<c:forEach begin="${paging.pageBarStart}" end="${paging.pageBarEnd}" var="idx">
	  							<a href="<c:url value='/board?nowPage=${idx}&search_type=${paging.search_type}&search_text=${paging.search_text}'/>" <c:out value="&{paging.nowPage == idx ? 'class=active' : '' }"/>>${idx}</a>
	  						</c:forEach>
								<c:if test="${paging.next}">
		  							<a href="<c:url value='/board?nowPage=${paging.pageBarEnd+1}&search_type=${paging.search_type}&search_text=${paging.search_text}'/>">&raquo;</a>
								</c:if>
	  					</div>
					</div>
				</c:if>
				<div class="button_wrap">
            		<input type="button" value="등록" class="register_button" onclick="location.href='<c:url value='/board/create'/>';">
        		</div>
			</div>
		</div>
	</section>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<link href='<c:url value="/resources/css/include/nav.css"/>' rel="stylesheet" type="text/css">
<nav>
    <div id="nav_wrap">
        <!-- 로그인 및 회원가입 메뉴 -->
        <div class="menu">
            <ul>
                <li><a href="#">로그인</a></li>
                <li><a href="#">회원가입</a></li>
            </ul>
        </div>
        <!-- 검색창 -->
        <div class="search-container">
            <form>
                <input type="text" name="search" placeholder="검색어를 입력하세요">
                <input type="submit" value="검색">
            </form>
        </div>
    </div>
</nav>


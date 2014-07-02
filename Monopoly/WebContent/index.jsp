<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>Monopoly</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Monopoly/stylealt1.css">
</head>
<body>
	<div id="login"> <!-- Beginn rechte Dialogbox -->
		<img src="img/logo.png" id="logo">
			<div id="new" class="textbg">
			<h1>Herzlich Willkommen!</h1>
			<form method="post" id="form" action="initGameAction">
				<input name="usr" placeholder="Benutzername" autofocus="autofocus"/> <br><br>
					Rot: <input type="radio" name="icon" value="rot" checked="checked"/>
					Gr&uuml;n: <input type="radio" name="icon" value="gruen"/>
					Blau: <input type="radio" name="icon" value="blau"/>
					Gelb: <input type="radio" name="icon" value="gelb"/><br><br>
					<input
					name="newgame" id="newgame" type="submit" class="button"
					value="Neues Spiel er&ouml;ffnen"/>
			</form>
			<a href="impressum.html" target="_blank">Impressum</a><br>
			<a href="hilfe.html" target="_blank">Hilfe</a>
			</div>
			</div><!-- Ende rechte Dialogbox -->
			
			<div id="submit" class="textbg"><!-- Beginn linke Dialogbox -->
				<h2 class="left">Spiel beitreten: </h2>
				<form id="join" method="post" action="joinGameAction">
					<input type="text" placeholder="Benutzername" name="playerName" class="left">
					<ul>
						<c:forEach items="${gameList}" var="game" varStatus="status">
							<c:if test="${not game.value.isRunning}">
								<li>
			  						<span>Spiel ID: <c:out value="${game.value.id}"/> </span>
			  						<span>Anzahl Spieler:  ${fn:length(game.value.players)} / 4 </span>
			  						<span><input name="whichgame" value="${game.value.id}" type="radio"/> </span>
		  						</li>
	  						</c:if>
						</c:forEach> 
					</ul>
				<input name="joingame" type="submit"
					value="Spiel beitreten" class="button left"/>
			</form> 
			</div><!-- Ende linke Dialogbox -->
		</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>Monopoly</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylealt1.css"
	title="Standart">
</head>
<body>
	<div id="login">
		<img src="img/dialogbg.png">
			<div id="new">
			Herzlich Willkommen!<br>
			<form method="post" id="form" action="initGameAction">
				<input name="usr" placeholder="Benutzername" /> 
					Rot: <input type="radio" name="icon" value="rot">
					Gr&uuml;n: <input type="radio" name="icon" value="gruen">
					Blau: <input type="radio" name="icon" value="blau">
					Gelb: <input type="radio" name="icon" value="gelb">
					<input
					name="newgame" id="newgame" type="submit"
					value="Neues Spiel er&ouml;ffnen"/>
			</form>
			</div>
			</div>
			
			<div id="submit">
			<img src="img/menurechts.png">
				<form id="join" method="post" action="joinGameAction">
					<ul>
						<c:forEach items="${gameList}" var="game" varStatus="status">
							<li>
		  						<span>Spiel ID: <c:out value="${game.value.id}"/> </span>
		  						<span>Anzahl Spieler:  ${fn:length(game.value.players)} / 4 </span>
		  						<span><input name="whichgame" value="${game.value.id}" type="radio"/> </span>
	  						</li>
						</c:forEach> 
					</ul>
				<input name="joingame" id="joingame" type="submit"
					value="Spiel beitreten"/>
			</form>
			</div>
		</div>
		</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
{ 	"player": {
  		"name": "${name}",
  		"guthaben": "${guthaben}",
  		"position": "${position}",
  		"icon" : "${icon}",
  		"userState": "${userState}",
  		"hasLost" : ${hasLost},
  		"hasWon" : ${hasWon},
  		"isAdmin" : ${isAdmin},
  		"streetOwnList": [ 
  			<c:forEach var="street" varStatus="status" items="${streetOwnList}" >
				${not status.first ? ',' : ''} 
				{ "id" :  "${street.id}", 
				  "name" : "${street.name}"}
			</c:forEach>
						]
			},
	"otherPlayers": [
			<c:forEach var="player" varStatus="status" items="${otherPlayers}" >
				${not status.first ? ',' : ''} 
				{ 
					"name": "${player.name}",
			  		"guthaben": "${player.guthaben}",
			  		"icon" : "${player.icon}",
			  		"position": "${player.position}",
			  		"hasLost" : "${player.hasLost}",
			  		"streetOwnList": [ 
			  			<c:forEach var="street" varStatus="status" items="${player.ownedStreets}" >
							${not status.first ? ',' : ''} 
							{ "id" :  "${street.id}", 
				  			"name" : "${street.name}"}
						</c:forEach>
									]
				}
			</c:forEach>
					],
	"fields" : [
		<c:forEach var="field" varStatus="status" items="${fields}" >
			${not status.first ? ',' : ''} 
			{
				"name" : "${field.name}",
				"typ" : "${field.typ}",
				"id" : "${field.id}",
				"owner" : "",
				"miete" : ""
 			}
		</c:forEach>	
		<c:forEach var="street" varStatus="status" items="${streets}" >
			,
			{
				"name" : "${street.name}",
				"typ" : "${street.typ}",
				"id" : "${street.id}",
				"owner" : "${street.owner.name}",
				"miete" : "${street.currentMiete}"
			}
		</c:forEach>								
			]
}
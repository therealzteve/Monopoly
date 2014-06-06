<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
{ 	"player": {
  		"name": "${name}",
  		"guthaben": "${guthaben}",
  		"position": "${position}",
  		"icon" : "${icon}",
  		"userState": "${userState}",
  		"isAdmin" : ${isAdmin},
  		"streetOwnList": [ 
  			<c:forEach var="street" varStatus="status" items="${streetOwnList}" >
				${not status.first ? ',' : ''} "${street.name}"
			</c:forEach>
						]
			},
	"otherPlayers": [
			<c:forEach var="player" varStatus="status" items="${otherPlayers}" >
				${not status.first ? ',' : ''} 
				{ 
					"name": "${player.name}",
			  		"guthaben": "${player.guthaben}",
			  		"position": "${player.position}",
			  		"streetOwnList": [ 
			  			<c:forEach var="street" varStatus="status" items="${player.streetOwnList}" >
							${not status.first ? ',' : ''} "${street}"
						</c:forEach>
									]
				}
			</c:forEach>
					]			
			
}
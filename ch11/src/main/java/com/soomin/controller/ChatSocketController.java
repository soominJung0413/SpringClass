package com.soomin.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatSocketController extends TextWebSocketHandler{
	private Map<String, WebSocketSession> users = new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//채팅에 연결 된 후 : 사용자 정보 저장
		users.put(session.getId(), session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 채팅 연결이 끊긴 후 : 자원 해체
		users.remove(session.getId());
		
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//문자로 메시지가 왔을 때 : 모든 사용자에게 메세지 전송
		Collection<WebSocketSession> sessions = users.values(); // 모든 사용자 정보 추출
		for ( WebSocketSession ws : sessions ) {
			ws.sendMessage(message);//메세지를 보냄
		}
	}
}

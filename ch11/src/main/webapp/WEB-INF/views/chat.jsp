<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@include file="./header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
table {
	height: 450px; 
	border: 2px solid green;
	table-layout:fixed;
	overflow:hidden;
}
#chatMessage {
		height:400px;
		overflow:scroll;
	}
</style>
	<script type="text/javascript">
		let websocket;//웹소켓변수
		$(function(){
			$('#enterBtn').on('click', function(){
				connect();
			});
			$('#exitBtn').on('click',function(){
				disconnect();
			});
			$('#sendBtn').on('click', function(){
				send();
			});
			$('#message').on('keypress',function(event){
				const keycode = event.keyCode?event.keyCode:event.which;
				if(keycode == 13){
					send();
				}
				event.stopPropagation();
			});
			
		});
			function connect(){
				websocket = new WebSocket("ws://172.30.1.15:8888/ch11/chat-ws.do");//JS 내장 객체	servletContext.xml에 있는 경로와 맞아야함
				websocket.onopen = onOpen;
				websocket.onmessage = onMessage;
				websocket.onclose = onClose;
			}	
			function onOpen(){
				const nickname = $('#nickname').val();
				appendMessage(`${nickname} 님이 입장하였습니다.`);
			}
			function onMessage(event){
				const msg = event.data;
				appendMessage(msg);
			}
			function onClose(){
				const nickname = $('#nickname').val();
				appendMessage(`${nickname} 님이 퇴장하셨습니다.`);
			}
			function appendMessage(nickname){
				$('#chatMessage').append(`${nickname} <br/>`);
				//스크롤 바를 자동으로 내리자.
				const objDiv = document.getElementById('chatMessage');
				objDiv.scrollTop = objDiv.scrollHeight;
			}
			function disconnect(){
				websocket.close();
			}
			function send(){
				const nickname = $('#nickname').val();
				const msg = $('#message').val();
				websocket.send(`${nickname} => ${msg}`);
				$('#message').val('');
			}
	</script>
	
	<div class="container">
		<table class="table table-hover">
			<tr>
				<td>
					별명
				</td>
				<td>
					<input type="text" id="nickname"/>
					<input type="button" id="enterBtn" value="입장" class="btn btn-sm btn-info"/>
					<input type="button" id="exitBtn" value="퇴장" class="btn btn-sm btn-warning"/>
				</td>
			</tr>
			<tr>
				<td>
					메시지
				</td>
				<td>
					<input type="text" id="message"/>
					<input type="button" id="sendBtn" value="전송" class="btn btn-success btn-sm" />
				</td>
			</tr>
			<tr>
				<td>
					대화영역
				</td>
				<td>
					<div id="chatMessage">
					
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
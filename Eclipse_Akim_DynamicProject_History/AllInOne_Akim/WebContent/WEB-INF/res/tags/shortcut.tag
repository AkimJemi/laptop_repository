<script type="text/javascript">
//메인 단축키
var key = new Array();
key['w'] = "/admin/entry/post/";
key['e'] = "/admin/skin/edit/";
key['r'] = "/admin/plugin/refererUrlLog/";
key['h'] = "https://akim.tistory.com/";
// 로그인
key['1'] = "<%=request.getContextPath()%>/res/admin/main.do";
// 관리자 페이지
key['2'] = "<%=request.getContextPath()%>/res/admin/book/list.do";
// 회원 명단
key['3'] = "<%=request.getContextPath()%>/res/admin/member/list.do";
key['4'] = "<%=request.getContextPath()%>/res/product.do";
key['5'] = "<%=request.getContextPath()%>/res/admin/main.do";
key['0'] = "login.do?id=admin&password=admin";
function getKey(keyStroke) {
	if ((event.srcElement.tagName != 'INPUT') && (event.srcElement.tagName != 'TEXTAREA')){
		isNetscape=(document.layers);
		eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
		which = String.fromCharCode(eventChooser).toLowerCase();
		for (var i in key)
			if (which == i) window.location = key[i];
	}
}
document.onkeypress = getKey;
</script>
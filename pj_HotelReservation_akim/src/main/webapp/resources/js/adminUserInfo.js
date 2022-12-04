function paging(val) {
	$('#currentPage').val(val);
	document.getElementById('userSearch').submit();
}
function passwordReset(val, id) {
	alert(val + '로 재설정 비밀번호를 보냅니다.');
	$.ajax({ // ajax 기본형태
		//////////////////// send(가는것)
		url: "/admin/userInfo/passwordReset/" + id,
		type: "get",
		//	data : "t1=XYZ&t2=자차카", // 넘겨주는 데이터
		datatype: "text", //위와동일
		data: { email: val },
		//////////////////// recv
		success: function(data) {
			alert(data);
		}
	});
};
function deleteUser(val) {
	if (confirm('No : ' + val + '(을)를 삭제하시겠습니까')) {
		var searchType = $('#searchType').val();
		var searchKeyword = $('#searchKeyword').val();
		var currentPage = $('#currentPage').val();
		location.href = "delete/" + val + "?searchType=" + searchType + "&searchKeyword=" + searchKeyword + "&currentPage=" + currentPage;
	}
};
function showMessage(val) {
	const message = val;
	if (message.trim()) {
		alert(message);
	}
};
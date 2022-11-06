function adminBookListPaging(val) {
	$('#currentPage').val(val);
	document.getElementById('adminBookListForm').submit();
}
function adminBookDetailUpdate(val) {
	location.href = "/admin/book/update/" + val;
}
function adminBookDetailCancel(val) {
	if (confirm('예약정보를 취소하시겠습니가?')) {
		location.href = "/admin/book/delete/" + val;
	}
}
function adminHomePaging(val){
	$('#currentPage').val(val); 
	document.getElementById('adminHomeListForm').submit();
}

function confirmLogout(url) {

	if (window.confirm("ログアウトします。よろしいですか？")) {
		location.href = url;
	}
}

function confirmDelete(url) {

	if (window.confirm("削除します。よろしいですか？")) {
		location.href = url;
	}
}

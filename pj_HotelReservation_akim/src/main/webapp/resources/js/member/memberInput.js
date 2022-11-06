/**
 * 
 */
var emailMinLength = 8;
var emailMaxLength = 30;
$(document).ready(function(){
    $('#email').on('keydown keyup', function(){
    	emailCheckBool = false;
        var charLength = $(this).val().length;
        if(charLength < emailMinLength){
			$('#submit').css('color', 'red');
			$('#email-warning-message').text('이메일 주소는 최소 ' + emailMinLength + ' 글자여야 합니다.');
			$('#submit').attr('disabled', true);
							}else if(charLength > emailMaxLength){										
			$('#email-warning-message').text('이메일 주소는' + emailMaxLength + '글자 미만이어야 합니다.');
			$('#submit').css('color', 'red');
			$('#submit').attr('disabled', true);
							}else{	
			$('#email-warning-message').text('');
			$('#submit').css('color', 'black');
			$('#submit').attr('disabled', false);
        }
    });
})

$(document).ready(function(){
    $('#password').on('keydown keyup change', function(){
		var pswMinLength = 8;
		var pswMaxLength = 16;
        var charLength = $(this).val().length;
        if(charLength < pswMinLength){
			$('#submit').css('color', 'red');
			$('#password-warning-message').text('비밀번호는 최소 ' + pswMinLength + ' 글자여야 합니다. ');
			$('#submit').attr('disabled', true);
							}else if(charLength > pswMaxLength){										
			$('#password-warning-message').text('비밀번호는 최대 ' + pswMaxLength + ' 글자 미만이어야 합니다. ');
			$('#submit').css('color', 'red');
			$('#submit').attr('disabled', true);
							}else{	
			$('#password-warning-message').text('');
			$('#submit').css('color', 'black');
			$('#submit').attr('disabled', false);
        }
    });
});

$(document).ready(function(){
    $('#confirmPassword').on('keydown keyup change', function(){
        var char = $(this).val();
        var pswChar = $('#password').val();
        if(char == pswChar){
			$('#submit').css('color', 'black');
			$('#confirm-password-warning-message').text('패스워드가 일치합니다.')
			$('#submit').attr('disabled', false);
							}else{	
			$('#confirm-password-warning-message').text('패스워드가 일치하지 않습니다.');
			$('#submit').css('color', 'red');
			$('#submit').attr('disabled', true);
        }
    });
});

$(document).ready(function(){
    $('#name').on('keydown keyup', function(){
		var nameMinLength = 2;
		var nameMaxLength = 20;
        var charLength = $(this).val().length;
        if(charLength < nameMinLength){
			$('#submit').css('color', 'red');
			$('#name-warning-message').text('이름은 최소한  ' + nameMinLength + ' 글자여야 합니다.');
			$('#submit').attr('disabled', true);
							}else if(charLength > nameMaxLength){										
			$('#name-warning-message').text('이름은 최대 ' + nameMaxLength + '글자여야 합니다.');
			$('#submit').css('color', 'red');
			$('#submit').attr('disabled', true);
							}else{	
			$('#name-warning-message').text('');
			$('#submit').css('color', 'black');
			$('#submit').attr('disabled', false);
        }
    });
});

function emailCheck(){
	$.ajax({
		url: "/user/emailCheck",
		type: "POST",
		data: {email: $('#email').val()},
		success: function(data){
			if(data == 1){
					$('#submit').attr('disabled', true);
					$('#email-overlapse-message').text('이미 사용중인 이메일 주소입니다.')
			}else{
				$('#submit').attr('disabled', false);
				$('#email-overlapse-message').text('')
			}
		}
	})
}

function phoneCheck(){
	$.ajax({
		url: "/phoneCheck",
		type: "POST",
		data: {phone: $('#phone').val()},
		success: function(data){
			if(data == 1){
					$('#submit').attr('disabled', true);
					$('#phone-overlapse-message').text('이미 사용중인 휴대폰 번호입니다.')
			}else{
				$('#submit').attr('disabled', false);
				$('#phone-overlapse-message').text('')
			}
		}
	})
}

$(document).ready(function(){
    $('#phone').on('keydown keyup change', function(){
    	phoneCheckBool = false;
		var phoneMinLength = 11;
		var phoneMaxLength = 13;
        var charLength = $(this).val().length;
        if(charLength < phoneMinLength){
			$('#submit').css('color', 'red');
			$('#phone-warning-message').text('Phone must be at least ' + phoneMinLength + ' characters long');
			$('#submit').attr('disabled', true);
							}else if(charLength > phoneMaxLength){										
			$('#phone-warning-message').text('Phone must be less than ' + phoneMaxLength + ' characters long');
			$('#submit').css('color', 'red');
			$('#submit').attr('disabled', true);
							}else{	
			//$('#phone-warning-message').text('OK');
			$('#submit').css('color', 'black');
			$('#submit').attr('disabled', false);
        }
    });

	$('#phone').on('keydown keyup change', function(){
		var char = $(this).val();
		var charLength = $(this).val().length;
		if(charLength > 0){
			$('#submit').attr('disabled', false);
			var char = $(this).val();
			var charLength = $(this).val().length;
			var char = char.replace(/[^0-9]/g, '');
			$(this).val(char);
		}
	});

})


$(document).ready(function(){
	$('#email').on('keydown keyup change', function(){
		var emailMinLength = 8;
		var emailMaxLength = 30;
		var charLength = $(this).val().length;
		if(charLength < emailMinLength){
			$('#submit').attr('disabled', true);
		}else if(charLength > emailMaxLength){										
			$('#submit').attr('disabled', true);
		}else{	
			$('#submit').css('color', 'black');
			$('#submit').attr('disabled', false);
		}
	});
});

$(document).ready(function(){
	$('#phone').on('keydown keyup change', function(){
		var phoneMinLength = 11;
		var phoneMaxLength = 11;
		var charLength = $(this).val().length;
		if(charLength < phoneMinLength){
			$('#submit').attr('disabled', true);
		}else if(charLength > phoneMaxLength){										
			$('#submit').attr('disabled', true);
		}else{	
			$('#submit').css('color', 'black');
			$('#submit').attr('disabled', false);
		}
	});
});

function cancelCheck(){
	let isCancel = confirm('Are you sure you want to cancel?');
	if(isCancel){
		location.href = '/';
	}
}

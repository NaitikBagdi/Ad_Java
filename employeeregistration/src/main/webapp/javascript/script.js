// Start ajax validation
// Call the toggleSubmitButton function on page load
$(document).ready(function() {
	// Username validation
	$('#username').blur(function() {
		var username = $('#username').val();
		if (username == '') {
			$('#user-message').html('<span style="color:red;">Username is required</span>');
			return;
		}
		$.ajax({
			type: "POST",
			url: "EmployeeServlet",
			data: { username: username },
			dataType: "html",
			success: function(result) {
				console.log(result);
				if (result == 'exist') {
					$('#user-message').html('<span style="color:red;">User alredy exist</span>');
				} else {
					$('#user-message').html('');
				}
			}
		});
	});

	// Contact number validation
	$('#contactnumber').blur(function() {
		var contactnumber = $('#contactnumber').val();
		if (contactnumber === '') {
			$('#contact-message').html('<span style="color:red;">Contact number is required</span>');
			return;
		}
		$.ajax({
			type: "POST",
			url: "EmployeeServlet",
			data: { contactnumber: contactnumber },
			dataType: "html",
			success: function(result) {
				if (result === 'exist') {
					$('#contact-message').html('<span style="color:red;">Contact number alredy exist</span>');
				} else {
					$('#contact-message').html('');
				}
			}
		});
	});

	$('#formId').submit(function(event) {
		// Prevent the default form submission
		event.preventDefault();
		var formData = $('#formId').serialize();
		$.ajax({
			type: "POST",
			url: "EmployeeServlet",
			data: formData,
			dataType: "html",
		}).done(function(result) {
			if (result == 'success') {
				$('#formId')[0].reset();
				// Reset validation messages
				showPopupMessage("Registration successful", "success");
			} else {
				// Display error pop-up
				showPopupMessage("Registration unsuccessful", "error");
			}
		});
	});
	
	function showPopupMessage(message, type) {
        var popup = $('<div class="popup ' + type + '">' + message + '</div>');
        $('body').append(popup);
        setTimeout(function() {
            popup.remove();
        }, 3000); // Adjust the timeout as needed
    }
});

// End ajax validation
//---------------------------------------------------------------------------------------------------------
// On input first name validation
function validateTextField() {
	var firstNameInput = document.getElementById("firstname");
	// Get the input value
	var firstName = firstNameInput.value;

	// Regular expression to match only letters
	var lettersRegex = /^[A-Za-z]+$/;

	if (firstName.length < 2) {
		$('#firstname-message').html('<span style="color:red;">First name minimum 2 character</span>');
	} else if (firstName.length > 30) {
		$('#firstname-message').html('<span style="color:red;">First name maximum 30 character</span>');
	} else if (!lettersRegex.test(firstName)) {
		$('#firstname-message').html('<span style="color:red;">First name must contain only letters</span>');
	} else {
		$('#firstname-message').html('');
	}
}

// On input first name validation
function validateTextField() {
	var lastNameInput = document.getElementById("lastname");
	// Get the input value
	var lastName = lastNameInput.value;

	// Regular expression to match only letters
	var lettersRegex = /^[A-Za-z]+$/;

	if (lastName.length < 2) {
		$('#lastname-message').html('<span style="color:red;">Last name minimum 2 character</span>');
	} else if (lastName.length > 30) {
		$('#lastname-message').html('<span style="color:red;">Last name maximum 30 character</span>');
	} else if (!lettersRegex.test(lastName)) {
		$('#lastname-message').html('<span style="color:red;">Last name must contain only letters</span>');
	} else {
		$('#lastname-message').html('');
	}
}

// On input password validation
function validatePasswordField() {
	var passwordInput = document.getElementById("password");
	var password = passwordInput.value;
	//var passwordMessage = document.getElementById("password-message");

	var capitalRegex = /[A-Z]/;
	var smallRegex = /[a-z]/;
	var specialRegex = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/;

	if (password.length < 10 || !capitalRegex.test(password) || !smallRegex.test(password) || !specialRegex.test(password)) {
		//   passwordMessage.textContent = "Password must contain at least 1 capital letter, 1 small letter, 1 special character, and be at least 10 characters long.";
		$('#password-message').html('<span style="color:red;">Password must contain at least 1 capital letter, 1 small letter, 1 special character, and be at least 10 characters long.</span>');
	} else {
		$('#password-message').html('');
	}
}


//---------------------------------------------------------------------------------------------------------
// Password icon validation
const passwordField = document.getElementById("password");
const togglePassword = document.querySelector(".password-toggle-icon i");
togglePassword.addEventListener("click", function() {
	if (passwordField.type === "password") {
		passwordField.type = "text";
		togglePassword.classList.remove("fa-eye");
		togglePassword.classList.add("fa-eye-slash");
	} else {
		passwordField.type = "password";
		togglePassword.classList.remove("fa-eye-slash");
		togglePassword.classList.add("fa-eye");
	}
});

//---------------------------------------------------------------------------------------------------------
// Submit button enable disable validation
document.addEventListener('DOMContentLoaded', function() {
	var form = document.getElementById('formId');
	var inputs = form.querySelectorAll('input');

	inputs.forEach(function(input) {
		input.addEventListener('input', function(event) {
			var firstName = document.getElementById("firstname").value;
			var lastName = document.getElementById("lastname").value;
			var userName = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var contactNumber = document.getElementById("contactnumber").value;
			var address = document.getElementById("address").value;
			var submit = document.getElementById("registerButton");
			if (firstName == "" || lastName == "" || userName == "" || password == ""
				|| contactNumber == "" || address == "") {
				submit.disabled = true;
			} else {
				submit.disabled = false;
			}
		});
	});
});

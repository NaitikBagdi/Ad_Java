function validateContactNumber(input) {
	// Get the input value
	var contactNumber = input.value;
	// Regular expression to match only digits
	var digitsRegex = /^[0-9]*$/;

	// Test if the input contains only digits
	if (!digitsRegex.test(contactNumber)) {
		// If the input contains non-digit characters, display an error message
		$('#contact-message').html('<span style="color:red;">Contact number should contain only digits</span>');
		// Clear the input value
		input.value = contactNumber.replace(/\D/g, '');
	} else {
		// If the input is valid, clear any error message
		$('#contact-message').html('');
	}
}

function validateTextField(input, filedName) {
	// Get the input value
	var name = input.value;

	// Regular expression to match only letters
	var lettersRegex = /^[A-Za-z]+$/;

	// Test if the input contains only letters
	if (!lettersRegex.test(name)) {
		// If the input contains non-letter characters, display an error message
		$('#' + filedName + '-message').html('<span style="color:red;">' + filedName + ' should contain only letters</span>');
		// Clear the input value
		input.value = name.replace(/[^A-Za-z]/g, '');
	} else {
		// If the input is valid, clear any error message
		$('#' + filedName + '-message').html('');
	}
}

function validatePasswordField(input) {
	// Get the input value
	var password = input.value;

	// Regular expression to match password requirements
	var passwordRegex = /^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;

	// Test if the input matches the password requirements
	if (!passwordRegex.test(password)) {
		// If the input does not meet the requirements, display an error message
		$('#password-message').html('<span style="color:red;">Password should contain at least one uppercase letter, one digit, and one special character. It must be between 6 and 16 characters long.</span>');
		// Clear the input value
		input.value = '';
	} else {
		// If the input is valid, clear any error message
		$('#password-message').html('');
	}
}


// Call the toggleSubmitButton function on page load
$(document).ready(function() {
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
				if (result == 'exist') {
					$('#user-message').html('<span style="color:red;">User alredy exist</span>');
				} else {
					$('#user-message').html('<span style="color:green;">User available </span>');
				}
			}
		});
	});

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
					$('#contact-message').html('<span style="color:green;">Contact number Available </span>');
				}
			}
		});
	});

	$('#formId').submit(function(event) {
		// Prevent the default form submission
		event.preventDefault();

		var formData = $('#formId').serialize();
		var firstName = $('#firstname').val();
		var lastName = $('#lastname').val();
		var userName = $('#username').val();
		var password = $('#password').val();
		var contactNumber = $('#contactnumber').val();
		var address = $('#address').val();
		var isValid = true;

		// Validation for first Name
		if (firstName == '') {
			$('#firstname-message').html('<span style="color:red;">First name is required</span>');
			isValid = false;
		} else if (firstName.length <= 2 || firstName.length >= 30) {
			$('#firstname-message').html('<span style="color:red;">First name should be with in the 2 to 30</span>');
			isValid = false;
			return;
		} else if (/\s/.test(firstName)) {
			$('#firstname-message').html('<span style="color:red;">Spaces are not allowed in the first name</span>');
			isValid = false;
			return;
		} else {
			$('#firstname-message').html('');
		}

		// Validation for lastName
		if (lastName == '') {
			$('#lastname-message').html('<span style="color:red;">Last name is required</span>');
			isValid = false;
		} else if (lastName.length <= 2 || lastName.length >= 30) {
			$('#lastname-message').html('<span style="color:red;">Last name should be with in the 2 to 30</span>');
			isValid = false;
			return;
		} else if (/\s/.test(lastName)) {
			$('#lastName-message').html('<span style="color:red;">Spaces are not allowed in the last name</span>');
			isValid = false;
			return;
		} else {
			$('#lastname-message').html('');
		}

		// Validation for userName
		if (userName == '') {
			$('#user-message').html('<span style="color:red;">User name is required</span>');
			isValid = false;
			return;
		} else if (userName.length <= 2 || userName.length >= 30) {
			$('#user-message').html('<span style="color:red;">User name should be with in the 2 to 30</span>');
			isValid = false;
			return;
		} else if (/\s/.test(userName)) {
			$('#user-message').html('<span style="color:red;">Spaces are not allowed in the user name</span>');
			isValid = false;
			return;
		} else {
			// Automatically convert uppercase letters to lowercase
			userName = userName.toLowerCase();
			$('#user-message').html('');
		}

		// Validation for password
		if (password == '') {
			$('#password-message').html('<span style="color:red;">Password is required</span>');
			isValid = false;
			return;
		} else if (/\s/.test(password)) {
			$('#password-message').html('<span style="color:red;">Spaces are not allowed in the password</span>');
			isValid = false;
			return;
		} else {
			$('#password-message').html('');
		}

		// Validation for contactNumber
		if (contactNumber == '') {
			$('#contact-message').html('<span style="color:red;">Contact number is required</span>');
			isValid = false;
			return;
		} else if (contactNumber.length <= 10 || contactNumber.length >= 17) {
			$('#contact-message').html('<span style="color:red;">Contact number should be with in the 10 to 17</span>');
			isValid = false;
			return;
		} else if (/[^0-9]/.test(contactNumber)) {
			$('#contact-message').html('<span style="color:red;">Contact number should contain only digits</span>');
			isValid = false;
			return;
		} else if (/\s/.test(contactNumber)) {
			$('#contact-message').html('<span style="color:red;">Spaces are not allowed in the contact</span>');
			isValid = false;
			return;
		} else {
			$('#contact-message').html('');
		}

		// Validation address
		if (address == '') {
			$('#address-message').html('<span style="color:red;">address is required</span>');
			isValid = false;
			return;
		} else if (address.length <= 2 || address.length >= 70) {
			$('#address-message').html('<span style="color:red;">Address should be with in the 2 to 30</span>');
			isValid = false;
			return;
		} else if (/\s/.test(address)) {
			$('#address-message').html('<span style="color:red;">Spaces are not allowed in the address</span>');
			isValid = false;
			return;
		} else {
			$('#address-message').html('');
		}

		$.ajax({
			type: "POST",
			url: "EmployeeServlet",
			data: formData,
			dataType: "html",
		}).done(function(result) {
			if (result === 'success') {
				$('#required-message').html('<span style="color:green;">Registration successful</span>');
			} else {
				$('#required-message').html('<span style="color:red;">Registration unsuccessful</span>');
			}
		});
	});
});
$('#register').on('click', function (event) {
    event.preventDefault();
    register($('#password')[0].value);
});


function register(password) {
    var buildRequest = {
        type: 'POST',
        url: '/api/register',
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify({
            userDTO: createUser(),
            password: password
        }),
        success: function (response) {
            console.log('Registered new user', response.status);
            sessionStorage.accessToken = response.token;

            window.location.href = "/business-planer/main"
        },
        error: function (error) {
            console.error('Error register user', error);
        }
    };
    $.ajax(buildRequest);
}

function createUser() {
    return {
        firstName: $("#first_name").val(),
        lastName: $("#last_name").val(),
        age: $("#age").val(),
        sex: $("#sex").val(),
        email: $("#email").val()
    };
}
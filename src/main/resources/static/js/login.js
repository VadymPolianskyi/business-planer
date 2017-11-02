$('#login_btn').on('click', function (event) {
    event.preventDefault();
   login($('#email')[0].value, $('#password')[0].value);

});


function login(login, password) {
    $.ajax({
        type: 'post',
        url: '/api/login',
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify({
            login: login,
            password: password
        }),
        success: function (response) {
            console.log('Login user', response);
            sessionStorage.accessToken = response.token;

            window.location.href = "/business-planer/main"
        },
        error: function (error) {
            console.error('Error get user info', error);
            location.reload();
        }
    })
}

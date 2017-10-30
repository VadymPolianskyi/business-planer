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
            var token = response.token;
            sessionStorage.accessToken = token;

            response.set({
                'Authorization': 'bearer ' + token
            });
            response.redirect('/business-planer/main');


        },
        error: function (error) {
            console.error('Error get user info', error);
            // location.reload();
        }
    })
}

// var request = {
//     url: '/business-planer/main',
//     headers: { 'Authorization': 'bearer ' + token },
//     success: function (data) {
//     }
// };
// console.log(request);
// $.ajax(request);
$(function() {

    var buildRequest = {
        type: 'get',
        url: '/api/question/types',
        dataType: 'json',
        contentType: "application/json",
        headers: {
            Authorization: "bearer" + sessionStorage.accessToken
        },
        success: function (response) {
            var types = response.types;
            console.log('Got question types', types);

            for(let i = 1; i < types.length; i++) {
                let parsePattern = '#' + String(i);
                $(parsePattern)[0].innerHTML = types[i];
            }
        },
        error: function (error) {
            console.error('Error get user info', error);
            window.location.href = "/business-planer/login"
        }
    };

    $.ajax(buildRequest);

});
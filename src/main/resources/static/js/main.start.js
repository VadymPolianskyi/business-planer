$(function() {
    var plansDiv = $(".plans");

    if (sessionStorage.accessToken === undefined || sessionStorage.accessToken === ""){
        window.location.href = "/business-planer/login"
    }

    var buildRequest = {
        type: 'get',
            url: '/api/business-plan/all',
            dataType: 'json',
            contentType: "application/json",
            headers: {
            Authorization: "bearer" + sessionStorage.accessToken
        },
        success: function (response) {
            console.log('Got businessPlans', response.businessPlans);

            var usersPlans = response.businessPlans;
            for (var i = 0; i < usersPlans.length; i++) {
                var plan = usersPlans[i];
                console.log(i);
                plansDiv.append(createPlanDiv(plan.name, plan.description, plan.id));
            }
        },
        error: function (error) {
            console.error('Error get user info', error);
            window.location.href = "/business-planer/login"
        }
    };

    $.ajax(buildRequest);

});

function createPlanDiv(name, description, id) {
    return $(
        '<div class="col-sm-2 plan">\n' +
        '                <div class="card">\n' +
        '                    <div class="card-body">\n' +
        '                        <h4 class="card-title">' + name + '</h4>\n' +
        '                        <p class="card-text"> ' + description + '</p>\n' +
        '                        <div class="card-action">\n' +
        '                            <a href="business-plan/update/' + id + '">Edit</a>\n' +
        '                            <a href="business-plan/' + id + '">Show</a>\n' +
        '                        </div>\n' +
        '                    </div>\n' +
        '                </div>\n' +
        '            </div>'
    );
}

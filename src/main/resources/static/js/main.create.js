$('#create-business-btn').on('click', function (event) {
   event.preventDefault();

    var buildRequest = {
        type: 'POST',
        url: '/api/business-plan',
        dataType: 'json',
        contentType: "application/json",
        headers: {Authorization: "bearer " + sessionStorage.accessToken},

        data: JSON.stringify({businessPlan: createBusinessPlan()}),

        success: function (response) {
            console.log('Created BP', response.status);
            location.reload();
        },
        error: function (error) {
            console.error('Error get user info', error);
        }
    };

    console.log(buildRequest);
    $.ajax(buildRequest);

});


function createBusinessPlan() {
    return {
        name: $("#business_name").val(),
        description: $("#description").val(),
        owner: owner,
        questions: createQuestions()
    };

}


function createQuestions() {
    var respQuestions = [];
    $(".question").each(function () {
        var question = createQuestion($(this));
        respQuestions.push(question);
    });
    return respQuestions;
}

function createQuestion(element) {
    var type = $(element).find('.step-header').text();
    type = type.substr(0, 1);
    var ansverPattern = '#' + type;
    return {
        priority: parseInt(type),
        answer: $(element).find(ansverPattern).val(),
        type: parseInt(type)
    };

}


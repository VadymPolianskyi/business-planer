$(function () {
    if (sessionStorage.accessToken === undefined || sessionStorage.accessToken === ""){
        window.location.href = "/business-planer/login"
    }
});
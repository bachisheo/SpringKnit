/**
 * jQuery controller module consumed the REST service.
 * Get HTML form, convert the search criteria into JSON format
 * via JSON.stringify, and send POST request via jQuery.ajax
 */

$(document).ready(function () {

    $("#search-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        ajax_search();
    });
    $("#button-search").click(function (event) {
        event.preventDefault();
        ajax_search();
    });


});

function deleteProduct(id, oldName) {
    if (confirm("Удалить объявление \"" + oldName + "\"?")) {
        $.ajax({
            type: "GET",
            url: "/delete/" + id,
            success: function (data) {
                $('#products_monitor_container').html(data);
                console.log("SUCCESS : ", data);
            },
            error: function (e) {alert("Товар " + oldName + " не удалось удалить!");}});
        txt = "Объявление \"" + oldName + "\" удалено";
    }


};
function ajax_search() {
    var b = $("#title").val();

    var a = $("#productName").val();
    if(a != null) {
        $.ajax({
            type: "GET",
            url: "/search/" + a,
            success: function (data) {
                $('#products_container').html(data);
                $('#products_monitor_container').html(data);
                console.log("SUCCESS : ", data);
            },
            error: function (e) {

            }
        });
    }

}
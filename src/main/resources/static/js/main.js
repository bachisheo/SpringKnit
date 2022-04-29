/**
 * jQuery controller module consumed the REST service.
 * Get HTML form, convert the search criteria into JSON format
 * via JSON.stringify, and send POST request via jQuery.ajax
 */

$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        fire_ajax_submit();
    });
    $("#")
});

function deleteProduct(id, oldName) {
    var oname = oldName;
    $.ajax({
        type: "GET",
        url: "/delete/" + id,
        success: function (data) {
            $('#products_monitor_container').html(data);
            alert("Товар" + oname + " успешно удален!");
            console.log("SUCCESS : ", data);

        },
    error: function (e) {alert("Товар " + oname + " не удалось удалить!");}});

};
function fire_ajax_submit() {
        $("#btn-search").prop("disabled", true);
    $.ajax({
        type: "POST",
        url: "/api/search",
        data: {productName : $("#productName").val()},
        success: function (data) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";

            $('#products_container').html(data);
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}
// Call the dataTables jQuery plugin
$(document).ready(function () {
    $.extend($.fn.dataTable.defaults, {
        language: {
            url: "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Korean.json",
        },
    });
    $("#dataTable").DataTable();
});

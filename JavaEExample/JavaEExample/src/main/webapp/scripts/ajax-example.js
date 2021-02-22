
/**
 * Creates an {@code AjaxOperation} object.
 */
function AjaxOperation() {
    
}

/**
 * Submits a request to the {@code AjaxExample} servlet.
 * @returns Places the message from the servlet in a defined {@code div} tag.
 */
AjaxOperation.prototype.callServlet = function() {
    var url = "ajax-action";
    $.get(url, 
        function(data, status) {
            $("#messageOutput").text(data);
        }
    );
}

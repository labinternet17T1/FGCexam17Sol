var counter = 1;
var limit = 8;
function addInput(divName){
    if (counter == limit)  {
        alert("You have reached the limit of adding " + counter + " inputs");
    }
    else {
        var newdiv = document.createElement('div');
        newdiv.innerHTML =
            "Day: " + "<select name='startList[" + counter +"].dayOfWeek'>"
            + "<option value='Sunday'>Sunday</option>"
            + "<option value='Monday'>Monday</option>"
            + "<option value='Tuesday'>Tuesday</option>"
            + "<option value='Wednesday'>Wednesday</option>"
            + "<option value='Thursday'>Thursday</option>"
            + "<option value='Friday'>Friday</option>"
            + "<option value='Saturday'>Saturday</option>"
            + "</select>"
            + "Time (hh:mm): " + "<input type='text' name='startList[" + counter + "].begin' />"
        document.getElementById(divName).appendChild(newdiv);
        counter++;
    }
}

$(document).ready(function(){
    resizeField();
    $(document).resize(resizeField());
})
var newData;
var game = true;
	function touchField (location) {
	    $.get("do-xando.xml", {hw: location ,newGame:"no",response_type:"json"},
	        function(data){
	            newData = data
	            });
	   // alert(fuckenData.test)
		if (game) {
			document.getElementById(location).src = "img/X.png";
			document.getElementById(location).alt = "X";
			game = false;
			} else {
			document.getElementById(location).src = "img/O.png";
			document.getElementById(location).alt = "O";
			game = true;
			}
		//��������� ������� ���
		if ((document.getElementById("11").alt == "X") && (document.getElementById("21").alt == "X") && (document.getElementById("31").alt == "X"))  {
			document.getElementById("11").src = "img/X_win.png";
			document.getElementById("21").src = "img/X_win.png";
			document.getElementById("31").src = "img/X_win.png";
			}
		}
	function resetField() {
		document.location.href="";
		}
	function resizeField() {
		var client = document.body.clientHeight;
		document.getElementById("11").height = (client-100)*0.25;
		document.getElementById("13").height = (client-100)*0.25;
		document.getElementById("12").height = (client-100)*0.25;
		document.getElementById("21").height = (client-100)*0.25;
		document.getElementById("22").height = (client-100)*0.25;
		document.getElementById("23").height = (client-100)*0.25;
		document.getElementById("33").height = (client-100)*0.25;
		document.getElementById("31").height = (client-100)*0.25;
		document.getElementById("32").height = (client-100)*0.25;
		}
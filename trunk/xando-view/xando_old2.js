$(document).ready (function() {
	resizeField();
	newGame(); 
});
$(window).resize(function() {
resizeField();
 });
 function newGame() {
 $.get("do-xando.xml", {hw: "00" , newGame:"yes", response_type:"json"});
 }
var game = true, err = true;
	function whoWin (status) {
		if (status!=0) {
		game = false;
			if (status != 2) {
				if ((document.getElementById("11").alt == "X") && (document.getElementById("21").alt == "X") && (document.getElementById("31").alt == "X"))  {
					document.getElementById("11").src = "img/X_win.png";
					document.getElementById("21").src = "img/X_win.png";
					document.getElementById("31").src = "img/X_win.png";
					}
				if ((document.getElementById("12").alt == "X") && (document.getElementById("22").alt == "X") && (document.getElementById("32").alt == "X"))  {
					document.getElementById("12").src = "img/X_win.png";
					document.getElementById("22").src = "img/X_win.png";
					document.getElementById("32").src = "img/X_win.png";
				}
				if ((document.getElementById("13").alt == "X") && (document.getElementById("23").alt == "X") && (document.getElementById("33").alt == "X"))  {
					document.getElementById("13").src = "img/X_win.png";
					document.getElementById("23").src = "img/X_win.png";
					document.getElementById("33").src = "img/X_win.png";
				}
				if ((document.getElementById("11").alt == "X") && (document.getElementById("12").alt == "X") && (document.getElementById("13").alt == "X"))  {
					document.getElementById("11").src = "img/X_win.png";
					document.getElementById("12").src = "img/X_win.png";
					document.getElementById("13").src = "img/X_win.png";
					}
				if ((document.getElementById("21").alt == "X") && (document.getElementById("22").alt == "X") && (document.getElementById("23").alt == "X"))  {
					document.getElementById("21").src = "img/X_win.png";
					document.getElementById("22").src = "img/X_win.png";
					document.getElementById("23").src = "img/X_win.png";
				}
				if ((document.getElementById("31").alt == "X") && (document.getElementById("32").alt == "X") && (document.getElementById("33").alt == "X"))  {
					document.getElementById("31").src = "img/X_win.png";
					document.getElementById("32").src = "img/X_win.png";
					document.getElementById("33").src = "img/X_win.png";
				}
				if ((document.getElementById("11").alt == "X") && (document.getElementById("22").alt == "X") && (document.getElementById("33").alt == "X"))  {
					document.getElementById("11").src = "img/X_win.png";
					document.getElementById("22").src = "img/X_win.png";
					document.getElementById("33").src = "img/X_win.png";
				}
				if ((document.getElementById("31").alt == "X") && (document.getElementById("22").alt == "X") && (document.getElementById("13").alt == "X"))  {
					document.getElementById("31").src = "img/X_win.png";
					document.getElementById("22").src = "img/X_win.png";
					document.getElementById("13").src = "img/X_win.png";
				}
                setTimeout(function(){alert("Вы победили!")},2000);

			}
			if (status != 1) {
				if ((document.getElementById("11").alt == "O") && (document.getElementById("21").alt == "O") && (document.getElementById("31").alt == "O"))  {
					document.getElementById("11").src = "img/O_win.png";
					document.getElementById("21").src = "img/O_win.png";
					document.getElementById("31").src = "img/O_win.png";
					}
				if ((document.getElementById("12").alt == "O") && (document.getElementById("22").alt == "O") && (document.getElementById("32").alt == "O"))  {
					document.getElementById("12").src = "img/O_win.png";
					document.getElementById("22").src = "img/O_win.png";
					document.getElementById("32").src = "img/O_win.png";
				}
				if ((document.getElementById("13").alt == "O") && (document.getElementById("23").alt == "O") && (document.getElementById("33").alt == "O"))  {
					document.getElementById("13").src = "img/O_win.png";
					document.getElementById("23").src = "img/O_win.png";
					document.getElementById("33").src = "img/O_win.png";
				}
				if ((document.getElementById("11").alt == "O") && (document.getElementById("12").alt == "O") && (document.getElementById("13").alt == "O"))  {
					document.getElementById("11").src = "img/O_win.png";
					document.getElementById("12").src = "img/O_win.png";
					document.getElementById("13").src = "img/O_win.png";
					}
				if ((document.getElementById("21").alt == "O") && (document.getElementById("22").alt == "O") && (document.getElementById("23").alt == "O"))  {
					document.getElementById("21").src = "img/O_win.png";
					document.getElementById("22").src = "img/O_win.png";
					document.getElementById("23").src = "img/O_win.png";
				}
				if ((document.getElementById("31").alt == "O") && (document.getElementById("32").alt == "O") && (document.getElementById("33").alt == "O"))  {
					document.getElementById("31").src = "img/O_win.png";
					document.getElementById("32").src = "img/O_win.png";
					document.getElementById("33").src = "img/O_win.png";
				}
				if ((document.getElementById("11").alt == "O") && (document.getElementById("22").alt == "O") && (document.getElementById("33").alt == "O"))  {
					document.getElementById("11").src = "img/O_win.png";
					document.getElementById("22").src = "img/O_win.png";
					document.getElementById("33").src = "img/O_win.png";
				}
				if ((document.getElementById("31").alt == "O") && (document.getElementById("22").alt == "O") && (document.getElementById("13").alt == "O"))  {
					document.getElementById("31").src = "img/O_win.png";
					document.getElementById("22").src = "img/O_win.png";
					document.getElementById("13").src = "img/O_win.png";
				}
            setTimeout(function(){alert("Нолики победили!")},2000);
			}
		}
	}
				
			
				
	function touchField (location) {
		if (game) {
			if ((document.getElementById(location).alt == "X") || (document.getElementById(location).alt == "O")) {
				err = false;
				alert("Нельзя сюда поставить елемент");
			}
			if (err) {	
				document.getElementById(location).src = "img/X.png";
				document.getElementById(location).alt = "X";
				$.get("do-xando.xml", {hw: location ,newGame:"no",response_type:"json"},
					function(data){
					//Протестировать данные сервера, уберите if
					if (data.status==null) {
						$('body').append('<p style="color:red">Error: data=' + data.status + '</p> ');
						}
						if (data.status == 0) {
						document.getElementById(data.hw).src = "img/O.png";
						document.getElementById(data.hw).alt = "O";
						}
						whoWin(data.status);
					},"json");
				}
			err = true;
		}
	}
	function resetField() {
		newGame();
		document.location.href="";
		}
	function resizeField() {
		var client = document.body.clientHeight;
		if (!document.body.clientHeight) {
			$('body').append('<p style="color:red">Error: client-size' + document.body.clientHeight + '</p> ');
			client = 700;
			}
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
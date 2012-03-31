var game = true;
$(document).ready(function(){

})
function newGame(){
    $.get("do-xando.xml", {hw: "00" , newGame:"yes", response_type:"json"},function(data){},"json");
    document.location.href=""
}
function touchField(elem){
    if (($('#'+ elem).attr('alt') != "X") && ($('#'+ elem).attr('alt') != "O") && game){
        $.get("do-xando.xml", {hw: elem ,newGame:"no",response_type:"json"},function(data){
   	        $('#'+elem).attr({
                src: "img/X.png",
                alt: "X",
            });

   	        $('#'+data.hw).attr({
   	            src: "img/O.png",
   	            alt: "O",
   	        });

   	        if (data.status != 0){
   	            game = false;
   	            win(data.status);
   	        }
   	},"json");}
}
function win(st){
    if (st == 1){
        line("X");
        setTimeout(function(){
                    alert("You WIN! Congratulations!");
                                },1000);

    }
    if (st == 2){
        line("O");
        setTimeout(function(){
                    alert("You LOSE! Sorry!");
                                },1000);
    }
    if (st == 3){
            setTimeout(function(){
                        alert("No Winners, no Losers");
                                    },1000);
    }
    //newGame();

}
function line(char){ //функция которая зачеркивает пять в ряд элементов char
    var flag = false;
        for(var i = 0; i < 5; i++){
            flag = true;
            for(var j = 0; j < 5; j++){
                if ($("#"+i+""+j).attr('alt') != char){
                    flag = false;
                    break
                }
            }
            if (flag){
                for(var j = 0 ; j < 5; j++) {
                    $("#"+i+""+j).attr({
                        src :"img/"+char+"_win.png",
                        alt : char
                    });
                }
                return;
            }
        }
        for(var i = 0 ; i < 5; i++){
            flag = true;
            for(var j = 0 ; j < 5; j++){
                if ($("#"+j+""+i).attr('alt') != char){
                    flag = false;
                    break
                }
            }
            if (flag){
                for(var j = 0 ; j < 5; j++) {
                    $("#"+j+""+i).attr({
                        src :"img/"+char+"_win.png",
                        alt : char
                    });
                }
                return;
            }
        }

        flag = true;
        for (var i = 0; i < 5 ; i++){
            if ($("#"+i+""+i).attr('alt') != char){
                flag = false;
                break
            }
        }
        if (flag){
            for(var j = 0 ; j < 5; j++) {
                $("#"+j+""+j).attr({
                    src :"img/"+char+"_win.png",
                    alt : char
                });
            }
        }

        flag = true;
        for (var i = 0; i < 5 ; i++){
            if ($("#"+ (4-i) +""+i).attr('alt') != char){
                flag = false;
                break
            }
        }
        if (flag){
            for(var j = 0 ; j < 5; j++) {
                $("#"+(4-j)+""+j).attr({
                    src :"img/"+char+"_win.png",
                    alt : char
                });
            }
        }

}
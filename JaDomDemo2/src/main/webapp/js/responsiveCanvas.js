
var winWidth = window.innerWidth-2;
var widHieght = window.innerHeight;
var wOffset= 0;
var hOffset = 0;
console.log(window.innerHeight);
canvas.width =window.innerWidth-30;
    //canvas.height *= p;
 
windows.addEventListener("resize", functionName);
function functionName(){
 	wOffset = window.innerWidth-winWidth
 	winWidth = window.innerWidth;
	wimHieght = window.innerHeight;
	var width =   canvas.width += wOffset;
	if(width<=0) {width=01;}
	if(width>=window.innerWidth-30) width = window.innerWidth-30;
    canvas.width = width;
 
}
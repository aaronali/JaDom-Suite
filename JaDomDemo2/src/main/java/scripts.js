/**
 * Sends to server using get witht he callback method as the event response listener
 * @param urlAddress
 * @param callbackMethod
 */
function httpGetAsync(urlAddress, callbackMethod) {var name = new nameRequest();name.onreadystatechange = function() { if (name.readyState == 4 && name.status == 200)callback(name.responseText);}name.open("get", urlAddress, true); name.send(null);}

document.getElementById("pca7156").addEventListener("click",function(){
	var XMLHttpRequestccyiufgirw=new XMLHttpRequest();
	XMLHttpRequestccyiufgirw.onreadystatechange =function(){
	     if (XMLHttpRequestccyiufgirw.readyState == 4 && XMLHttpRequestccyiufgirw.status == 200) {
	          function(){
	               alert('Success');
	          }
	}};
	XMLHttpRequestccyiufgirwxmlhttp.open("get", what, true);
	XMLHttpRequestccyiufgirw.send();});



document.getElementById("ss").addEventListener("click",
function(){
  var xhttdsadasdsadadsdasp = new XMLHttpRequest();
  xhttdsadasdsadadsdasp.onreadystatechange = function() {
    if (xhttdsadasdsadadsdasp.readyState == 4 && xhttdsadasdsadadsdasp.status == 200) {
      document.getElementById("demo").innerHTML =
      xhttdsadasdsadadsdasp.responseText;
    }
  };
  xhttdsadasdsadadsdasp.open("GET", "xmlhttp_info.txt", true);
  xhttdsadasdsadadsdasp.send();
}
,true);
</script>

DomFunction f1 =  new DomFunction(null,"alert(\"Succss from server\");",null);
	XMLHttpRequest x=new XMLHttpRequest( "get",f1,ApplicationManager.getNextId().concat(request.getSession().getId()));
x.setResponseText("EHAtsss tttsadasd asdas dasdsdas dasd... Awesone"); 
f1.setBody("alert("+x.getName()+".responseText);");
EventListener xx= new EventListener("click", x, true,x.getRequestUrl());
//	x.setRequestUrl(xx.getId());
xx.bindRequest(x,Id());
img.addEventListener(xx,Id()); 	
//	xx.bindRequest(x);
//p.addEventListener("click", x, true,request.getSession().getId());
//DomFunction func =  new DomFunction();*/
this.bodyAdd(img);
this.bodyAdd(header);
this.bodyAdd(p); 
User user = new User("Aaron");

 
var stage = new createjs.Stage("canvas");

var c = new createjs.Shape();
c.graphics.f("#f00").dc(0,0,50); // Drawn a 100x100 circle from the center

var t = new createjs.Text("Resize the browser/frame to redraw", "24px Arial bold", "#000");
t.x = t.y = 20;
stage.addChild(c, t);

window.addEventListener("resize", handleResize);
function handleResize() {
    var w = window.innerWidth-2; // -2 accounts for the border
    var h = window.innerHeight-2;
    stage.canvas.width = w;
    stage.canvas.height = h;
    //
    var ratio = 100/100; // 100 is the width and height of the circle content.
    var windowRatio = w/h;
    var scale = w/100;
    if (windowRatio > ratio) {
        scale = h/100;
    }
    // Scale up to fit width or height
    c.scaleX= c.scaleY = scale; 
    
    // Center the shape
    c.x = w / 2;
    c.y = h / 2;
        
    stage.update();
}
       
handleResize(); // First draw
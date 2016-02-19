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
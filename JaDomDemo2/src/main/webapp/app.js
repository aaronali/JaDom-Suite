var fs= require('fs');

fs.writeFileSync("node.text","What up");
console.log(fs.readFileSync("node.text").toString());

console.log("nodejs");

	
	function placeOrder(number){ 
		
		console.log(number);
		deliver(function(){
			console.log("Delivered |", number);
		});
	}
	 
	
	function deliver(callback){
		setTimeout(callback,5000);
	}
	var aaron = {
			name :"aaron",
			movie :"movie"
	};
	console.log(aaron);
	var P=   aaron;
	P.name="what";
	console.log(aaron);
	
	placeOrder(1);

	placeOrder(2);

	placeOrder(3);

	placeOrder(4);

	placeOrder(5);

	placeOrder(6);

	placeOrder(7);
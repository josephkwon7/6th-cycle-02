$(".answer-write input[type=submit]").click(addAnswer);

function addAnswer(e) {
	e.preventDefault();
	console.log("click me");
	
	var queryString = $(".answer-write").serialize();
	console.log("query : " + queryString);
	var url = $(".answer-write").attr("action");
	console.log("url : " + url);
	$.ajax({
			type : "post",
			url : url,
			data : queryString,
			dataType : 'json',
			error : onError,
			success : onSuccess
	});
	
	function onError() {
		console.log("ajax failed!!!");
	}

	function onSuccess(data, status) {
		console.log("ajax success!!!");
		console.log(data);
		console.log(status);
	}
}

//String.prototype.format = function() {
//  var args = arguments;
//  return this.replace(/{(\d+)}/g, function(match, number) {
//    return typeof args[number] != 'undefined'
//        ? args[number]
//        : match
//        ;
//  });
//};

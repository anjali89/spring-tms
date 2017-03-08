$(function(){
	$("#editButton").click(function(){
		$("#status").prop("disabled", false);
		$(this).hide();
		$("#cancelButton").show();
	});
	$("#cancelButton").click(function(){
		$("#status").prop("disabled", false);
	});
});
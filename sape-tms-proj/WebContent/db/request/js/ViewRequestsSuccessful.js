$(function(){
	$("#editButton").click(function(){
		$("select").prop("disabled", false);
		$(this).hide();
		$("#submitButton").show();
		$("#cancelButton").show();
	});
	$("#cancelButton").click(function(){
		$("select").prop("disabled", true);
		$(this).hide();
		$("#submitButton").hide();
		$("#editButton").show();
	});
	$("#cancelButton").hide();
	$("#submitButton").hide();
	$("select").prop("disabled", true);
});
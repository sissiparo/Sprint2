function userStory4() {
	body = document.getElementById("body4");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory4/"
						+ document.getElementById('imsi4').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Event ID</td><td>Cause Code</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										+ '</td><td>' + resp[i][1]
										+ '</td><td>' + resp[i][2]
										+ '</td><td>' + resp[i][3]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results4").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table4");
					tbl.setAttribute("class", "table");
					$('#imsi4').val('');
					alert("story 4");
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function userStory5() {
	body = document.getElementById("body5");
	var tbl;
	var tblBody;

	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory5/"
						+ document.getElementById('imsi5').value + "/" +
						document.getElementById('startDate5').value + "/" +
						document.getElementById('endDate5').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody).append("<p>The Count of failures for IMSI "+ document.getElementById('imsi5').value +" is "+resp[0]+"</p>");
					
					$(tbl).append(tblBody);
					$("#results5").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table5");
					tbl.setAttribute("class", "table");
					$('#imsi5').val('');
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};


function userStory6() {
	body = document.getElementById("body6");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory6/"
						+ document.getElementById('imsi6').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>imsi</td><td>Event ID</td><td>Event Cause Code</td><td>Cause Code</td><td>Cause Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
								+ '</td><td>' + resp[i][1]
								+ '</td><td>' + resp[i][2]
								+ '</td><td>' + resp[i][3]
								+ '</td><td>' + resp[i][4]
								+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results6").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table6");
					tbl.setAttribute("class", "table");
					$('#imsi6').val('');
			
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function userStory7() {
	body = document.getElementById("body7");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory7/"
					+ 
					document.getElementById('startDate7').value + "/" +
					document.getElementById('endDate7').value,
						
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
				
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>date</td><td>imsi</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
								
								+ '</td><td>' + resp[i][1]
								
								+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results7").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table7");
					tbl.setAttribute("class", "table");
					$('#startDate7').val('');
					$('#endDate7').val('');
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};


function userStory8() {
	body = document.getElementById("body8");
	var tbl;
	var tblBody;

	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory8/"
						+ document.getElementById('tac8').value + "/" +
						document.getElementById('startDate8').value + "/" +
						document.getElementById('endDate8').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody).append("<p>The Count of failures for TAC "+document.getElementById('tac8').value+" is "+ resp[0]+".</p>");
					
					
					$(tbl).append(tblBody);
					$("#results8").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table8");
					tbl.setAttribute("class", "table");
					$('#tac8').val('');
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};


function userStory9() {
	body = document.getElementById("body9");
	var tbl;
	var tblBody;

	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory9/"
						+ document.getElementById('startDate9').value + "/" +
						document.getElementById('endDate9').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
				alert("Count of first: "+resp[0][4]);
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>IMSI<td>TAC</td><td>MCC</td><td>MNC</td><td>Total Duration</td><td>Number of Failures</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
										+ '</td><td>' + resp[i][1]
										+ '</td><td>' + resp[i][2]
										+ '</td><td>' + resp[i][3]
										+ '</td><td>' + resp[i][4]
										+ '</td><td>' + resp[i][5]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					
					$("#results9").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table9");
					tbl.setAttribute("class", "table");
					$('#tac9').val('');
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function userStory10() {
	body = document.getElementById("body10");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory10/"
						+ document.getElementById('TAC').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results10").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>'  + resp[i][0]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results10").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table10");
					tbl.setAttribute("class", "table");
					tacval = document.getElementById('TAC').value;
					$('#TAC').val(tacval);
					alert("story 10");
				},
				error : function(e) {
					alert("Insufficient info");
				}
			});
	return false;
};
function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};

function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory11/"
					+document.getElementById('startDate11').value
					+"/"+ document.getElementById('endDate11').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results11").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results11").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');
					alert("story 11");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};

function userStory14() {
	body = document.getElementById("body14");
	//mydiv = body.getElementById("explanation");
	//if (mydiv != null) {
		//mydiv.innerHTML = "";//refresh so that if multiple queries are run the previous results disappear
	//}
	//body.getElementById("#results14").innerHTML = "";//refresh so that if multiple queries are run the previous results disappear
	//body.getElementByTag("table").innerHTML = "";//refresh so that if multiple queries are run the previous results disappear
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "rest/basedata/userStory14/"
						+ document.getElementById('failureClassID').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results14").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results14").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table14");
					tbl.setAttribute("class", "table");
					$('#imsi14').val('');
					alert("story 14");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};
function convertLongToDate(longinteger){
	d = new Date(longinteger);
	stringOfD="";
	stringOfD += d.getFullYear() + "-";
	stringOfD += twoDigitDateOrMonth(d.getMonth()) + "-";
	stringOfD += twoDigitDateOrMonth(d.getDate()) + " ";
	stringOfD += twoDigitDateOrMonth(d.getHours()) + ":";
	stringOfD += twoDigitDateOrMonth(d.getMinutes()) + ":";
	stringOfD += twoDigitDateOrMonth(d.getSeconds());
	//getFullYear() -getMonth()- getDate() getHours():getMinutes():getSeconds()
	return stringOfD;
}

function twoDigitDateOrMonth(PossiblySingleDigitNumber){
	if (PossiblySingleDigitNumber>9){
		return PossiblySingleDigitNumber;
	} else {
		return "0"+PossiblySingleDigitNumber;
	}	
}

function populateFailuresDDL() {
	body = document.getElementById("selectid");
	body.innerHTML="hi there you";
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/failure/all/",
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
				
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i] +i
										   + '</td><td>' + resp[i][1]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results14").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table14");
					tbl.setAttribute("class", "table");
					$('#imsi14').val('');
					alert("story 14");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
	/*var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory14/"
						+ document.getElementById('failureClassID').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					//USE THE FOLLOWING TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					explanationdiv=document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br=document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents=document.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
							+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results14").append(explanationdiv);
					//USE THE ABOVE TO GIVE TABLES A HEADER DESCRIPTION INCLUDING THE INPUT DATA
					
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					//DATE STILL RETURNED AS a Long
					$(tblBody)
							.append(
							'<tr class="child"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + convertLongToDate(resp[i][0])
										   + '</td><td>' + resp[i][1]
										  + '</td><td>' + resp[i][2]
								 			+ '</td><td>' + resp[i][3]
										  // + '</td><td>' + resp[i][4]
										   + '</td></tr>');
					}
					//$(tbl).text("");
					$(tbl).append(tblBody);
					$("#results14").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table14");
					tbl.setAttribute("class", "table");
					$('#imsi14').val('');
					alert("story 14");
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;*/
};
function userStory5() {
	body = document.getElementById("body5");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory5/"
						+ document.getElementById('imsi5').value + "/" +
						document.getElementById('startDate5').value + "/" +
						document.getElementById('endDate5').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					alert(resp);
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>count</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results5").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table5");
					tbl.setAttribute("class", "table");
					$('#imsi5').val('');
					alert("story 5");
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function userStory6() {
	body = document.getElementById("body6");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory6/"
						+ document.getElementById('imsi6').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>imsi</td><td>Event ID</td><td>Event Cause Code</td><td>Cause Code</td><td>Cause Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
								+ '</td><td>' + resp[i][1]
								+ '</td><td>' + resp[i][2]
								+ '</td><td>' + resp[i][3]
								+ '</td><td>' + resp[i][4]
								+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results6").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table6");
					tbl.setAttribute("class", "table");
					$('#imsi6').val('');
					alert("story 6");
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function ericsson() {
	document.getElementById('bdy').src = 'http://www.ericsson.com/';
};

function queries() {
	if(localStorage.getItem('userLevel') === "Customer Service Rep" ){
		alert("csr");
		document.getElementById('bdy').src = 'CustRepqueries.jsp';
	}
	else if(localStorage.getItem( 'userLevel' ) === "Support Engineer"){
		alert("se");
		document.getElementById('bdy').src = 'SupEngqueries.jsp';
	}
	else if(localStorage.getItem( 'userLevel' ) === "Network Management Engineer"){
		alert("nme");
		document.getElementById('bdy').src = 'NetManqueries.jsp';
	}
	else if(localStorage.getItem( 'userLevel' ) === "System Administrator"){
		alert(localStorage.getItem( 'userLevel' ));
		document.getElementById('bdy').src = 'SysAdminqueries.jsp';
	}
	
};

function combo() {
	document.getElementById('bdy').src = 'UserStory4.html';
};

function onload() {
	alert(localStorage.getItem( 'userLevel' ));
    };
    
window.onunload = function(){
	localStorage.clear();
    alert("Are you sure?");
};

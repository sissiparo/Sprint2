function userStory4() {
	body = document.getElementById("body4");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Group5/rest/basedata/userStory4/"
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
								'<tr><td>'
										+ convertLongToDate(resp[i][0])
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
	var stDate = new Date(document.getElementById('startDate5').value + "T" + document.getElementById('startTime5').value + "Z");
    var enDate = new Date(document.getElementById('endDate5').value + "T" + document.getElementById('endTime5').value + "Z");

    if (stDate != '' && enDate != '' && stDate > enDate) {
        alert('Start Date is greater than End Date!');
        return false;
    }
    else {
       
        var today = new Date();
       
        if (enDate > today) {
            alert('End Date selected is greater than today!');
            return false;
        }
        
    }

	$.ajax({
		type : "GET",
		url : "http://localhost:8080/Group5/rest/basedata/userStory5/"
				+ document.getElementById('imsi5').value + "/"
				+ stDate + "/"
				+ enDate,
		dataType : 'json',
		headers : {
			Accept : "application/json",
			"Access-Control-Allow-Origin" : "*",
		},
		success : function(resp) {

			tbl = document.createElement("table");
			tblBody = document.createElement("tbody");

			$(tblBody).append(
					"<p>The Count of failures for IMSI "
							+ document.getElementById('imsi5').value + " is "
							+ resp[0] + "</p>");

			$(tbl).append(tblBody);
			$("#results5").html(tbl);
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
				url : "http://localhost:8080/Group5/rest/basedata/userStory6/"
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
					$("#results6").html(tbl);
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
	var stDate = new Date(document.getElementById('startDate7').value + "T" + document.getElementById('startTime7').value + "Z");
    var enDate = new Date(document.getElementById('endDate7').value + "T" + document.getElementById('endTime7').value + "Z");

    if (stDate != '' && enDate != '' && stDate > enDate) {
        alert('Start Date is greater than End Date!');
        return false;
    }
    else {
       
        var today = new Date();
       
        if (enDate > today) {
            alert('End Date selected is greater than today!');
            return false;
        }
        
    }
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/Group5/rest/basedata/userStory7/"
				+ stDate + "/"
				+ enDate,

		dataType : 'json',
		headers : {
			Accept : "application/json",
			"Access-Control-Allow-Origin" : "*",
		},
		success : function(resp) {
			tbl = document.createElement("table");
			tblBody = document.createElement("tbody");
			$(tblBody).append('<tr class="child"><td>imsi</td></tr>');
			for (var i = 0; i < resp.length; i++) {
				$(tblBody).append('<tr class="child"><td>' + resp[i][1]

				+ '</td></tr>');
			}
			$(tbl).append(tblBody);
			$("#results7").html(tbl);
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
	var stDate = new Date(document.getElementById('startDate8').value + "T" + document.getElementById('startTime8').value + "Z");
    var enDate = new Date(document.getElementById('endDate8').value + "T" + document.getElementById('endTime8').value + "Z");

    if (stDate != '' && enDate != '' && stDate > enDate) {
        alert('Start Date is greater than End Date!');
        return false;
    }
    else {
       
        var today = new Date();
       
        if (enDate > today) {
            alert('End Date selected is greater than today!');
            return false;
        }
        
    }
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/Group5/rest/basedata/userStory8/"
				+ document.getElementById('tac8').value + "/"
				+ stDate + "/"
				+ enDate,
		dataType : 'json',
		headers : {
			Accept : "application/json",
			"Access-Control-Allow-Origin" : "*",
		},
		success : function(resp) {

			tbl = document.createElement("table");
			tblBody = document.createElement("tbody");
			$(tblBody).append(
					'<p>The Count of failures for TAC '
							+ document.getElementById('tac8').value + ' is '
							+ resp[0] + '.</p>');

			$(tbl).append(tblBody);
			$("#results8").html(tbl);
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
	var stDate = new Date(document.getElementById('startDate9').value + "T" + document.getElementById('startTime9').value + "Z");
    var enDate = new Date(document.getElementById('endDate9').value + "T" + document.getElementById('endTime9').value + "Z");

    if (stDate != '' && enDate != '' && stDate > enDate) {
        alert('Start Date is greater than End Date!');
        return false;
    }
    else {
       
        var today = new Date();
       
        if (enDate > today) {
            alert('End Date selected is greater than today!');
            return false;
        }
        
    }
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Group5/rest/basedata/userStory9/"
						+ stDate
						+ "/"
						+ enDate,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					var counter = 0;
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
									'<tr class="child"><td>Date</td><td>imsi</td><td>Event ID</td><td>Cause Code</td><td>Cause Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>'
										+ convertLongToDate(resp[i][0])
										+ '</td><td>' + resp[i][1]
										+ '</td><td>' + resp[i][2]
										+ '</td><td>' + resp[i][3]
										+ '</td><td>' + resp[i][4]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results9").html(tbl);
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
				url : "http://localhost:8080/Group5/rest/basedata/userStory10/"
						+ document.getElementById('tac10').value,

				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					document.getElementById("container10").style.height = "400px";
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
									'<tr class="child"><td>EventID</td><td>CauseCode</td><td>Description</td><td>#Ocurrences</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
										+ '</td><td>' + resp[i][1]
										+ '</td><td>' + resp[i][3]
										+ '</td><td>' + resp[i][2]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results10").html(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table10");
					tbl.setAttribute("class", "table");

					var data = [];
					for (var j = 0; j < resp.length; j++) {
						data[j] = [ resp[j][0] + "/" + resp[j][1], resp[j][2] ];
					};

					RenderPieChart('container10', data);

					function RenderPieChart(elementId, dataList) {
						new Highcharts.Chart(
								{
									chart : {
										renderTo : elementId,
										plotBackgroundColor : null,
										plotBorderWidth : null,
										plotShadow : false
									},
									title : {
										text : 'Browser market shares at a specific website, 2010'
									},
									tooltip : {
										formatter : function() {
											return '<b>' + this.point.name
													+ '</b>: ' + this.point.y;
										}
									},
									plotOptions : {
										pie : {
											allowPointSelect : true,
											cursor : 'pointer',
											dataLabels : {
												enabled : true,
												color : '#000000',
												connectorColor : '#000000',
												formatter : function() {
													return '<b>'
															+ this.point.name
															+ '</b>: '
															+ this.point.y;
												}
											}
										}
									},
									series : [ {
										type : 'pie',
										name : 'Browser share',
										data : dataList
									} ]
								});
					}
					;

				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function userStory11() {
	body = document.getElementById("body11");
	var tbl;
	var tblBody;
	var stDate = new Date(document.getElementById('startDate11').value + "T" + document.getElementById('startTime11').value + "Z");
    var enDate = new Date(document.getElementById('endDate11').value + "T" + document.getElementById('endTime11').value + "Z");

    if (stDate != '' && enDate != '' && stDate > enDate) {
        alert('Start Date is greater than End Date!');
        return false;
    }
    else {
       
        var today = new Date();
       
        if (enDate > today) {
            alert('End Date selected is greater than today!');
            return false;
        }
        
    }
	$.ajax({
				type : "GET",
				url : "http://localhost:8080/Group5/rest/basedata/userStory11/"
						+ stDate
						+ "/"
						+ enDate,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					document.getElementById("container11").style.height = "400px";

					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");

					$(tblBody)
							.append(
									'<tr class="child"><td>MCC</td><td>MNC</td><td>Cell ID</td><td>Number Of Failures</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
										+ '</td><td>' + resp[i][1]
										+ '</td><td>' + resp[i][2]
										+ '</td><td>' + resp[i][3]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results11").html(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table11");
					tbl.setAttribute("class", "table");
					$('#startDate11').val('');
					$('#endDate11').val('');

					var data = [];
					if (resp.length >= 10) {
						for (var j = 0; j < 10; j++) {
							data[j] = [
									resp[j][0] + "/" + resp[j][1] + "/"
											+ resp[j][2], resp[j][3] ];
						}
					} else {
						for (var j = 0; j < resp.length; j++) {
							data[j] = [
									resp[j][0] + "/" + resp[j][1] + "/"
											+ resp[j][2], resp[j][3] ];
						}
						;
					}

					RenderPieChart('container11', data);

					function RenderPieChart(elementId, dataList) {
						new Highcharts.Chart(
								{
									chart : {
										renderTo : elementId,
										plotBackgroundColor : null,
										plotBorderWidth : null,
										plotShadow : false
									},
									title : {
										text : ' Top 10 Market/Operator/Cell ID combinations for given IMSI'
									},
									tooltip : {
										formatter : function() {
											return '<b>' + this.point.name
													+ '</b>: ' + this.point.y;
										}
									},
									plotOptions : {
										pie : {
											allowPointSelect : true,
											cursor : 'pointer',
											dataLabels : {
												enabled : true,
												color : '#000000',
												connectorColor : '#000000',
												formatter : function() {
													return '<b>'
															+ this.point.name
															+ '</b>: '
															+ this.point.y;
												}
											}
										}
									},
									series : [ {
										type : 'pie',
										name : 'Browser share',
										data : dataList
									} ]
								});
					}
					;
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};

function userStory12() {
	body = document.getElementById("body12");
	var tbl;
	var tblBody;
	var stDate = new Date(document.getElementById('startDate12').value + "T" + document.getElementById('startTime12').value + "Z");
    var enDate = new Date(document.getElementById('endDate12').value + "T" + document.getElementById('endTime12').value + "Z");

    if (stDate != '' && enDate != '' && stDate > enDate) {
        alert('Start Date is greater than End Date!');
        return false;
    }
    else {
       
        var today = new Date();
       
        if (enDate > today) {
            alert('End Date selected is greater than today!');
            return false;
        }
        
    }
	$.ajax({
				type : "GET",
				url : "http://localhost:8080/Group5/rest/basedata/userStory12/"
						+ stDate
						+ "/"
						+ enDate,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					document.getElementById("container12").style.height = "400px";
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
									'<tr class="child"><td>IMSI</td><td>TAC</td><td>MCC</td><td>MNC</td><td>Number Of Failures</td></tr>');
					for (var i = 0; i < 10; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
										+ '</td><td>' + resp[i][1]
										+ '</td><td>' + resp[i][2]
										+ '</td><td>' + resp[i][3]
										+ '</td><td>' + resp[i][4]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results12").html(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table12");
					tbl.setAttribute("class", "table");
					$('#startDate12').val('');
					$('#endDate12').val('');

					RenderPieChart('container12', [ [ 'One', resp[0][4] ],
							[ 'Two', resp[1][4] ], [ 'Three', resp[2][4] ],
							[ 'Four', resp[4][4] ], [ 'Five', resp[4][4] ],
							[ 'Six', resp[5][4] ], [ 'Seven', resp[6][4] ],
							[ 'Eight', resp[7][4] ], [ 'Nine', resp[8][4] ],
							[ 'Ten', resp[9][4] ] ]);


					RenderPieChart('container', data);

					function RenderPieChart(elementId, dataList) {
						new Highcharts.Chart({
							chart : {
								renderTo : elementId,
								plotBackgroundColor : null,
								plotBorderWidth : null,
								plotShadow : false
							},
							title : {
								text : 'Top 10 IMSIs with failures'
							},
							tooltip : {
								formatter : function() {
									return '<b>' + this.point.name + '</b>: '
											+ this.point.y;
								}
							},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										color : '#000000',
										connectorColor : '#000000',
										formatter : function() {
											return '<b>' + this.point.name
													+ '</b>: ' + this.point.y;
										}
									}
								}
							},
							series : [ {
								type : 'pie',
								name : 'Browser share',
								data : dataList
							} ]
						});
					}
					;

				},

				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};

function userStory14() {
	body = document.getElementById("body14");
	
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Group5/rest/basedata/userStory14/"
						+ document.getElementById('failureClassID').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					explanationdiv = document.createElement("div");
					explanationdiv.setAttribute("id", "explanation");
					br = document.createElement("br");
					explanationdiv.appendChild(br);
					divcontents = document
							.createTextNode("\nThe results are ordered by IMSI and DATE for Cause Class: "
									+ document.getElementById('failureClassID').value);
					explanationdiv.appendChild(divcontents);
					$("#results14").html(explanationdiv);

					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
									'<tr class="child" width="100%"><td>Date</td><td>Imsi</td><td>Event ID</td><td>Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>'
										+ convertLongToDate(resp[i][0])
										+ '</td><td>' + resp[i][1]
										+ '</td><td>' + resp[i][2]
										+ '</td><td>' + resp[i][3]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results14").html(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table14");
					tbl.setAttribute("class", "table");
					$('#imsi14').val('');
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;
};

function convertLongToDate(longinteger) {
	d = new Date(longinteger);
	stringOfD = "";
	stringOfD += d.getFullYear() + "-";
	stringOfD += twoDigitDateOrMonth(d.getMonth()) + "-";
	stringOfD += twoDigitDateOrMonth(d.getDate()) + " ";
	stringOfD += twoDigitDateOrMonth(d.getHours()) + ":";
	stringOfD += twoDigitDateOrMonth(d.getMinutes()) + ":";
	stringOfD += twoDigitDateOrMonth(d.getSeconds());
	return stringOfD;
};

function twoDigitDateOrMonth(PossiblySingleDigitNumber) {
	if (PossiblySingleDigitNumber > 9) {
		return PossiblySingleDigitNumber;
	} else {
		return "0" + PossiblySingleDigitNumber;
	}
};

function ValidateStartDate(startDate, endDate) {

    var stDate = new Date(startDate);
    var enDate = new Date(endDate);
    if (stDate != '' && enDate != '' && stDate > enDate) {
        alert('Start Date is greater than End Date!');
        return false;
    }
    else {
       
        var today = new Date();
       
        if (enDate > today) {
            alert('End Date selected is greater than today!');
            return false;
        }
        
    }
   
};

function populateFailuresDDL() {
	body = document.getElementById("selectid");
	body.innerHTML = "hi there you";
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Group5/rest/failure/all/",
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
								'<tr class="child"><td>' + resp[i] + i
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
				},
				error : function(e) {
					alert("Please select an option ");
				}
			});
	return false;

};

function ericsson() {
	document.getElementById('bdyleft').style.display = 'none';
	document.getElementById('bdyright').style.display = 'none';
	document.getElementById('bdy').style.display = 'block';
	document.getElementById('bdy').src = 'http://www.ericsson.com/';
};

function queries() {
	document.getElementById('bdyleft').style.display = 'none';
	document.getElementById('bdyright').style.display = 'none';
	document.getElementById('bdy').style.display = 'block';
	if (localStorage.getItem('userLevel') === "Customer Service Rep") {
		document.getElementById('bdy').src = 'queries/CustRepqueries.jsp';
	} else if (localStorage.getItem('userLevel') === "Support Engineer") {
		document.getElementById('bdy').src = 'queries/SupEngqueries.jsp';
	} else if (localStorage.getItem('userLevel') === "Network Management Engineer") {
		document.getElementById('bdy').src = 'queries/NetManqueries.jsp';
	} else if (localStorage.getItem('userLevel') === "System Administrator") {
		document.getElementById('bdy').src = 'queries/SysAdminqueries.jsp';
	}

};

function comboQueries() {
	document.getElementById('bdy').style.display = 'none';
	document.getElementById('bdyleft').style.display = 'block';
	document.getElementById('bdyright').style.display = 'block';
	if (localStorage.getItem('userLevel') === "Customer Service Rep") {
		document.getElementById('bdyleft').src = 'miniQueries/miniCustRepQueries.jsp';
		document.getElementById('bdyright').src = 'miniQueries/miniCustRepQueries.jsp';
	} else if (localStorage.getItem('userLevel') === "Support Engineer") {
		document.getElementById('bdyleft').src = 'miniQueries/miniSupEngQueries.jsp';
		document.getElementById('bdyright').src = 'miniQueries/miniSupEngQueries.jsp';
	} else if (localStorage.getItem('userLevel') === "Network Management Engineer") {
		document.getElementById('bdyleft').src = 'miniQueries/miniNetManQueries.jsp';
		document.getElementById('bdyright').src = 'miniQueries/miniNetManQueries.jsp';
	} else if (localStorage.getItem('userLevel') === "System Administrator") {
		document.getElementById('bdyleft').src = 'miniQueries/miniSysAdminQueries.jsp';
		document.getElementById('bdyright').src = 'miniQueries/miniSysAdminQueries.jsp';
	}
}

function logout() {
	localStorage.clear();
	window.location.href = 'index.html';
}

function clearUsers() {
	localStorage.clear();
};

function customerServiceRepLevel() {
	if (localStorage.getItem('userLevel') !== "System Administrator"
			&& localStorage.getItem('userLevel') !== "Network Management Engineer"
			&& localStorage.getItem('userLevel') !== "Support Engineer"
			&& localStorage.getItem('userLevel') !== "Customer Service Rep") {
		window.location.href = '../accessError.html';
	}
}

function supportEngineerLevel() {
	if (localStorage.getItem('userLevel') !== "System Administrator"
			&& localStorage.getItem('userLevel') !== "Network Management Engineer"
			&& localStorage.getItem('userLevel') !== "Support Engineer") {
		window.location.href = '../accessError.html';
	}
}

function networkManagementEngineerLevel() {
	if (localStorage.getItem('userLevel') !== "System Administrator"
			&& localStorage.getItem('userLevel') !== "Network Management Engineer") {
		window.location.href = '../accessError.html';
	}
}

function adminLevel() {
	if (localStorage.getItem('userLevel') !== "System Administrator") {
		window.location.href = '../accessError.html';
	}
}
function paragraphReset(){
	document.getElementById('queriesParagraph').innerHTML= "<br>Queries";
	document.getElementById('queriesParagraph1').innerHTML= "<br>Queries";
}
function hover4(){
	document.getElementById('queriesParagraph').innerHTML="<br>Display, for an IMSI,the Event ID and Cause Codes for all its failures";
}

function hover5(){
	document.getElementById('queriesParagraph').innerHTML="<br>For an IMSI, view number of failures they have had during a given time period";
}

function hover6(){
	document.getElementById('queriesParagraph').innerHTML="<br>For an IMSI, list all unique Cause Codes associated with its call failures";
}

function hover7(){
	document.getElementById('queriesParagraph').innerHTML="<br>List all IMSIs with call failures during the following time period";
}

function hover8(){
	document.getElementById('queriesParagraph').innerHTML="<br>For a given TAC, view number of failures they have had during a given time period";
}

function hover9(){
	document.getElementById('queriesParagraph').innerHTML="<br>For a given time period display the IMSI which had failures associated with them";
}

function hover10(){
	document.getElementById('queriesParagraph').innerHTML="Show, for given TAC, all unique failure Event Id and Cause Code combinations,"
		+ "<br>and the number of occurrences over a given time period";
}

function hover11(){
	document.getElementById('queriesParagraph').innerHTML="<br>Top 10 Market/Operator/Cell ID combinations that had call failures";
}

function hover12(){
	document.getElementById('queriesParagraph').innerHTML="<br>Display the Top 10 IMSIs with failures for a certain Time Period";
}

function hover14(){
	document.getElementById('queriesParagraph').innerHTML="<br>Display, for a Failure Cause Class the IMSIs that were affected";
}

function hoverReg(){
	document.getElementById('queriesParagraph').innerHTML="<br>Register a new user";
}

function hoverUp(){
	document.getElementById('queriesParagraph').innerHTML="<br>Upload a file to the Database";
}

$(function() {
    // set global ajax options:
    $.ajaxSetup({
        beforeSend: function(xhr, status) {
            // TODO: show spinner
            $('#spinner').show();
        },
        complete: function() {
            // TODO: hide spinner
            $('#spinner').hide();
        }
    });

    $('#foo').click(function() {
        // because we have overriden the global AJAX settings
        // the spinner will be shown during the request
        $('#content').load('b.php #abc');
    });
});

